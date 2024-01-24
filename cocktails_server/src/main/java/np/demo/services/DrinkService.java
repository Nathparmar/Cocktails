package np.demo.services;

import np.demo.DTOs.DrinkDTO;
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

    public List<Drink> findAllDrinks(){
        return drinkRepository.findAll();
    }

    public Drink findDrink(Long id){
        return drinkRepository.findById(id).get();
    }

    public void calculateTotalAlcoholPercentage(Drink drink){
        double totalPureAlcohol = 0.0; //in ml
        double totalVolume = 0.0; //

        for(Ingredient ingredient : drink.getIngredients()){
            double alcoholContent = ingredient.getMeasurement() * (ingredient.getAlcoholPercentage()/100);
            totalPureAlcohol += alcoholContent;
            totalVolume += ingredient.getMeasurement();
        }

        double totalAlcoholPercentage = (totalPureAlcohol/totalVolume)*100;
        drink.setTotalAlcoholPercentage(totalAlcoholPercentage);
    }

    public void calculateTotalAlcoholPercentageDTO(DrinkDTO drinkDTO){
        double totalPureAlcohol = 0.0; //in ml
        double totalVolume = 0.0; //

        for(Ingredient ingredient : drinkDTO.getIngredients()){
            double alcoholContent = ingredient.getMeasurement() * (ingredient.getAlcoholPercentage()/100);
            totalPureAlcohol += alcoholContent;
            totalVolume += ingredient.getMeasurement();
        }

        double totalAlcoholPercentage = (totalPureAlcohol/totalVolume)*100;
        drinkDTO.setTotalAlcoholPercentage(totalAlcoholPercentage);
    }



}
