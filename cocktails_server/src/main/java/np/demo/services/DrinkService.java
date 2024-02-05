package np.demo.services;


import np.demo.DTOs.DrinkDTO;
import np.demo.DTOs.IngredientDTO;
import np.demo.models.Alcohol;
import np.demo.models.Drink;
import np.demo.models.Ingredient;
import np.demo.models.Mixer;
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


    public void calculateABV(Drink drink) {
        double totalPureAlcohol = 0.0;
        double totalAlcVolume = 0.0;
        double totalMixerVolume = 0.0;

        for (Ingredient ingredient : drink.getIngredients()) {

                for (Alcohol alcohol : ingredient.getAlcohols()) {
                    double alcoholContent = alcohol.getMeasurement() * (alcohol.getAlcoholPercentage() / 100);
                    totalPureAlcohol += alcoholContent;
                    totalAlcVolume += alcohol.getMeasurement();
                }

                for (Mixer mixer : ingredient.getMixers()) {
                    totalMixerVolume += mixer.getMeasurement();
                }
        }

        double totalVolume = totalAlcVolume + totalMixerVolume;

        double totalAlcoholPercentage = (totalPureAlcohol/totalVolume)*100;
        double alcoholUnits = (totalVolume * totalAlcoholPercentage)/1000;
        drink.setTotalAlcoholPercentage(totalAlcoholPercentage);
        drink.setAlcoholUnits(alcoholUnits);
    }


    public void postABVCalculator(DrinkDTO drinkDTO){

        double totalPureAlcohol = 0;
        double totalVolume = 0;

        for (IngredientDTO ingredientsDTO: drinkDTO.getIngredientDTOs()) {

            double alcoholContent = ingredientsDTO.getMeasurement() * (ingredientsDTO.getAlcoholPercentage()/100);
            totalPureAlcohol += alcoholContent;
            totalVolume += ingredientsDTO.getMeasurement();

        }

        double totalABV = (totalPureAlcohol/totalVolume)*100;
        double alcoholUnits = (totalVolume * totalABV)/1000;
        drinkDTO.setTotalAlcoholPercentage(totalABV);
        drinkDTO.setAlcoholUnits(alcoholUnits);
    }






}
