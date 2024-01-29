package np.demo.services;


import np.demo.models.Alcohol;
import np.demo.models.Drink;
import np.demo.models.Ingredient;
import np.demo.repositories.DrinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrinkService {

    @Autowired
    DrinkRepository drinkRepository;

    public void saveDrink(Drink drink){
        drinkRepository.save(drink);
    }

    public List<Drink> setEmptyIngredientsToNull(){
        List<Drink> drinks = drinkRepository.findAll();

        drinks.forEach(drink -> {
            drink.getIngredients().forEach(ingredient -> {
                if (ingredient.getMixers() != null && ingredient.getMixers().isEmpty()) {
                    ingredient.setMixers(null);
                }

                if (ingredient.getAlcohols() != null && ingredient.getAlcohols().isEmpty()) {
                    ingredient.setAlcohols(null);
                }
            });
        });

        return drinks;
    }


    public List<Drink> findAllDrinks(){
       return setEmptyIngredientsToNull();

    }


    public Drink findDrinkById(Long id) {
        List<Drink> drinks = setEmptyIngredientsToNull();

        for (Drink drink : drinks) {
            if (drink.getId().equals(id)) {
                return drink;
            }
        }

        return null;
    }


//    public void calculateTotalAlcoholPercentage(Drink drink){
//        double totalPureAlcohol = 0.0; //in ml
//        double totalVolume = 0.0; //
//
//
//        for(Ingredient ingredient : drink.getIngredients()){
//            double alcoholContent = ingredient.getMeasurement() * (ingredient.getAlcoholPercentage()/100);
//            totalPureAlcohol += alcoholContent;
//            totalVolume += ingredient.getMeasurement();
//        }
//
//        double totalAlcoholPercentage = (totalPureAlcohol/totalVolume)*100;
//        drink.setTotalAlcoholPercentage(totalAlcoholPercentage);
//    }

    public void calculateTotalAlcoholPercentage(Drink drink) {
        double totalPureAlcohol = 0.0; // in ml
        double totalVolume = 0.0;

        for (Ingredient ingredient : drink.getIngredients()) {
            if (ingredient.getAlcohols() != null && !ingredient.getAlcohols().isEmpty()) {
                // Access alcohol percentage directly from alcohol objects
                for (Alcohol alcohol : ingredient.getAlcohols()) {
                    double alcoholContent = ingredient.getMeasurement() * (alcohol.getAlcoholPercentage() / 100);
                    totalPureAlcohol += alcoholContent;
                    totalVolume += ingredient.getMeasurement();
                }
            } else if (ingredient.getMixers() != null && !ingredient.getMixers().isEmpty()) {
                // Mixers all have 0% alcohol
                totalVolume += ingredient.getMeasurement();
            }

        }

        double totalAlcoholPercentage = (totalPureAlcohol / totalVolume) * 100;
        double alcoholUnits = (totalVolume*totalAlcoholPercentage)/1000;
        drink.setTotalAlcoholPercentage(totalAlcoholPercentage);
        drink.setAlcoholUnits(alcoholUnits);
    }




}
