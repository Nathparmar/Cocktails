package np.demo.components;

import np.demo.models.Alcohol;
import np.demo.models.Drink;
import np.demo.models.Ingredient;
import np.demo.repositories.AlcoholRepository;
import np.demo.repositories.DrinkRepository;
import np.demo.repositories.IngredientRepository;
import np.demo.services.DrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.beans.Transient;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    DrinkRepository drinkRepository;

    @Autowired
    IngredientRepository ingredientRepository;

    @Autowired
    AlcoholRepository alcoholRepository;

    @Autowired
    DrinkService drinkService;

    public DataLoader(){

    }

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {

//        Drinks

        Drink vodkaCoke = new Drink("Vodka Coke", "spirit mixer", "build in glass", "spirit glass", "lemon slice" );
        drinkRepository.save(vodkaCoke);

        Drink vodkaDietCoke = new Drink("Vodka Diet Coke", "spirit mixer", "build in glass",  "spirit glass", "lemon slice" );
        drinkRepository.save(vodkaDietCoke);

        Drink longIsland = new Drink("Long Island Iced Tea", "cocktail", "build in glass", "high rock glass", "lemon slice" );



//        Ingredient measurements

        Ingredient doubleMeasure = new Ingredient(50);
        ingredientRepository.save(doubleMeasure);

        Alcohol vodka = new Alcohol("Vodka", "vodka", "Absolut", 40);
        alcoholRepository.save(vodka);
        doubleMeasure.setAlcohol(vodka);

        // Add ingredients to drinks
        vodkaCoke.addIngredient(doubleMeasure);
        vodkaDietCoke.addIngredient(doubleMeasure);
        longIsland.addIngredient(doubleMeasure); // Add to other drinks as needed

        // Save drinks with associated ingredients
        drinkRepository.save(vodkaCoke);
        drinkRepository.save(vodkaDietCoke);
        drinkRepository.save(longIsland);




//      calculate total alcohol percentage
//
//        drinkService.calculateTotalAlcoholPercentage(vodkaCoke);
//        drinkService.calculateTotalAlcoholPercentage(vodkaDietCoke);







    }



}
