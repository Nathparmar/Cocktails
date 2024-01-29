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

import javax.persistence.criteria.CriteriaBuilder;
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


        //        Alcohols

        Alcohol vodka = new Alcohol(" Absolut Vodka", "vodka", 40);
        alcoholRepository.save(vodka);

        Alcohol gin = new Alcohol("Edinburgh Gin", "gin", 40);
        alcoholRepository.save(gin);

        Alcohol tequilaSilver = new Alcohol("Olmeca Silver Tequila", "silver tequila", 35);
        alcoholRepository.save(tequilaSilver);

        Alcohol bacardi = new Alcohol("Bacardi", "white rum", 37.5);
        alcoholRepository.save(bacardi);




//        Mixers

        Mixer coke = new Mixer("Coca Cola");
        mixerRepository.save(coke);

        Mixer dietCoke = new Mixer("Diet Coca Cola");
        mixerRepository.save(dietCoke);

        Mixer lemonJuice = new Mixer("Lemon Juice");
        mixerRepository.save(lemonJuice);

        Mixer sugarSyrup = new Mixer("Sugar Syrup");
        mixerRepository.save(sugarSyrup);


//     /////////////// //  Drinks /////////////////////

//        Vodka Coke

        Drink vodkaCoke = new Drink("Vodka Coke", "spirit mixer", "build in glass", "spirit glass", "Lemon slice" );
        drinkRepository.save(vodkaCoke);
        Ingredient doubleMeasureVodkaCoke = new Ingredient(50);
        ingredientRepository.save(doubleMeasureVodkaCoke);
        vodkaCoke.addIngredient(doubleMeasureVodkaCoke);
        doubleMeasureVodkaCoke.addAlcohol(vodka);
        Ingredient vodkaCokeMixerMeasure = new Ingredient(150);
        ingredientRepository.save(vodkaCokeMixerMeasure);
        vodkaCoke.addIngredient(vodkaCokeMixerMeasure);
        vodkaCokeMixerMeasure.addMixer(coke);

//        Vodka diet Coke

        Drink vodkaDietCoke = new Drink("Vodka Diet Coke", "spirit mixer", "build in glass",  "spirit glass", "Lemon slice" );
        drinkRepository.save(vodkaDietCoke);
        Ingredient doubleMeasureVodkaDietCoke = new Ingredient(50);
        ingredientRepository.save(doubleMeasureVodkaDietCoke);
        vodkaDietCoke.addIngredient(doubleMeasureVodkaDietCoke);
        doubleMeasureVodkaDietCoke.addAlcohol(vodka);
        Ingredient vodkaDietCokeMixerMeasure = new Ingredient(150);
        ingredientRepository.save(vodkaDietCokeMixerMeasure);
        vodkaDietCoke.addIngredient(vodkaDietCokeMixerMeasure);
        vodkaDietCokeMixerMeasure.addMixer(dietCoke);

//        Long Island

        Drink longIsland = new Drink("Long Island Iced Tea", "cocktail", "Shake all ingredients. Pour them in a glass, then top with coca cola", "High rock glass", "Lemon wheel" );
        drinkRepository.save(longIsland);
        Ingredient longIslandAlcMeasure = new Ingredient(12.5);
        ingredientRepository.save(longIslandAlcMeasure);
        longIsland.addIngredient(longIslandAlcMeasure);
        longIslandAlcMeasure.addAlcohol(bacardi);
        longIslandAlcMeasure.addAlcohol(vodka);
        longIslandAlcMeasure.addAlcohol(tequilaSilver);
        longIslandAlcMeasure.addAlcohol(gin);
        Ingredient longIslandSyrupMeasure = new Ingredient(25);
        ingredientRepository.save(longIslandSyrupMeasure);
        longIsland.addIngredient(longIslandSyrupMeasure);
        longIslandSyrupMeasure.addMixer(sugarSyrup);
        longIslandSyrupMeasure.addMixer(lemonJuice);
        Ingredient longIslandCokeMeasure = new Ingredient(100);
        ingredientRepository.save(longIslandCokeMeasure);
        longIsland.addIngredient(longIslandCokeMeasure);
        longIslandCokeMeasure.addMixer(coke);

//        Passion fruit martini


















//
//      calculate total alcohol percentage

        drinkService.calculateTotalAlcoholPercentage(vodkaCoke);
        drinkService.calculateTotalAlcoholPercentage(vodkaDietCoke);
        drinkService.calculateTotalAlcoholPercentage(longIsland);







    }



}
