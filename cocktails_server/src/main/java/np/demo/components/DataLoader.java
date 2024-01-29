package np.demo.components;

import np.demo.models.Alcohol;
import np.demo.models.Drink;
import np.demo.models.Ingredient;
import np.demo.models.Mixer;
import np.demo.repositories.AlcoholRepository;
import np.demo.repositories.DrinkRepository;
import np.demo.repositories.IngredientRepository;
import np.demo.repositories.MixerRepository;
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
    MixerRepository mixerRepository;

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
        drinkRepository.save(longIsland);


//        Ingredient measurements

        Ingredient doubleMeasureVodkaCoke = new Ingredient(50);
        ingredientRepository.save(doubleMeasureVodkaCoke);

        Ingredient doubleMeasureVodkaDietCoke = new Ingredient(50);
        ingredientRepository.save(doubleMeasureVodkaDietCoke);



        Ingredient singleMeasure = new Ingredient(25);
        ingredientRepository.save(singleMeasure);

        Ingredient vodkaCokeMixerMeasure = new Ingredient(150);
        ingredientRepository.save(vodkaCokeMixerMeasure);

        Ingredient vodkaDietCokeMixerMeasure = new Ingredient(150);
        ingredientRepository.save(vodkaDietCokeMixerMeasure);

//        Alcohols

        Alcohol vodka = new Alcohol(" Absolut Vodka", "vodka", 40);
        alcoholRepository.save(vodka);
        doubleMeasureVodkaCoke.addAlcohol(vodka);
        doubleMeasureVodkaDietCoke.addAlcohol(vodka);

        Alcohol gin = new Alcohol("Edinburgh Gin", "gin", 40);
        alcoholRepository.save(gin);
//        doubleMeasure.addAlcohol(gin);

//        Mixers

        Mixer coke = new Mixer("Coke");
        mixerRepository.save(coke);
        vodkaCokeMixerMeasure.addMixer(coke);

        Mixer dietCoke = new Mixer("Diet Coke");
        mixerRepository.save(dietCoke);
        vodkaDietCokeMixerMeasure.addMixer(dietCoke);

        // Add ingredients to drinks
        vodkaCoke.addIngredient(doubleMeasureVodkaCoke);
//        vodkaCoke.addIngredient(doubleMeasure1);
        vodkaCoke.addIngredient(vodkaCokeMixerMeasure);
        vodkaDietCoke.addIngredient(doubleMeasureVodkaDietCoke);
        vodkaDietCoke.addIngredient(vodkaDietCokeMixerMeasure);
//        longIsland.addIngredient(doubleMeasure);

        // Save drinks with associated ingredients





//      calculate total alcohol percentage
//
//        drinkService.calculateTotalAlcoholPercentage(vodkaCoke);
//        drinkService.calculateTotalAlcoholPercentage(vodkaDietCoke);







    }



}
