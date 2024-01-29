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

        Alcohol absolutVodka = new Alcohol("Absolut Vodka", "vodka", 40);
        alcoholRepository.save(absolutVodka);

        Alcohol gin = new Alcohol("Edinburgh Gin", "gin", 40);
        alcoholRepository.save(gin);

        Alcohol tequilaSilver = new Alcohol("Olmeca Silver Tequila", "silver tequila", 35);
        alcoholRepository.save(tequilaSilver);

        Alcohol bacardi = new Alcohol("Bacardi", "white rum", 37.5);
        alcoholRepository.save(bacardi);

        Alcohol vanillaVodka = new Alcohol("Absolut Vanilla Vodka", "vanilla vodka", 38);
        alcoholRepository.save(vanillaVodka);

        Alcohol passoa = new Alcohol("Passoa", " passion-fruit liquer", 17);
        alcoholRepository.save(passoa);

        Alcohol kahlua = new Alcohol("Kahlua", "coffee liquer", 16);
        alcoholRepository.save(kahlua);

        Alcohol chambord = new Alcohol("Chambord", " French liquer", 16.5);
        alcoholRepository.save(chambord);

        Alcohol peachSchnapps = new Alcohol("Archers Peach Schnapps", "peach schnapps", 18);
        alcoholRepository.save(peachSchnapps);

        Alcohol disaronno = new Alcohol("Disaronno", "liquer", 28);
        alcoholRepository.save(disaronno);



//        Mixers

        Mixer coke = new Mixer("Coca Cola");
        mixerRepository.save(coke);

        Mixer lemonade = new Mixer("Lemonade");
        mixerRepository.save(lemonade);

        Mixer sodaWater = new Mixer("Soda water");
        mixerRepository.save(sodaWater);

        Mixer redBull = new Mixer("Red Bull");
        mixerRepository.save(redBull);

        Mixer tonic = new Mixer("Tonic Water");
        mixerRepository.save(tonic);

        Mixer dietCoke = new Mixer("Diet Coca Cola");
        mixerRepository.save(dietCoke);

        Mixer lemonJuice = new Mixer("Lemon Juice");
        mixerRepository.save(lemonJuice);

        Mixer sugarSyrup = new Mixer("Sugar Syrup");
        mixerRepository.save(sugarSyrup);

        Mixer passionFruitPuree = new Mixer("Passion fruit puree");
        mixerRepository.save(passionFruitPuree);

        Mixer limeJuice = new Mixer("Lime Juice");
        mixerRepository.save(limeJuice);

        Mixer pineappleJuice = new Mixer("Pineapple Juice");
        mixerRepository.save(pineappleJuice);

        Mixer orangeJuice = new Mixer("Orange Juice");
        mixerRepository.save(orangeJuice);

        Mixer cranberryJuice = new Mixer("Cranberry Juice");
        mixerRepository.save(cranberryJuice);

        Mixer appleJuice = new Mixer("Apple Juice");
        mixerRepository.save(appleJuice);

        Mixer strawberrySyrup = new Mixer("Strawberry Syrup");
        mixerRepository.save(strawberrySyrup);

        Mixer espressoCoffee = new Mixer("Espresso coffee");
        mixerRepository.save(espressoCoffee);



//     /////////////// //  Drinks /////////////////////

//        Vodka Coke

        Drink vodkaCoke = new Drink("Vodka Coke", "spirit mixer", "build in glass", "spirit glass", "Lemon slice" );
        drinkRepository.save(vodkaCoke);
        Ingredient doubleMeasureVodkaCoke = new Ingredient(50);
        ingredientRepository.save(doubleMeasureVodkaCoke);
        vodkaCoke.addIngredient(doubleMeasureVodkaCoke);
        doubleMeasureVodkaCoke.addAlcohol(absolutVodka);
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
        doubleMeasureVodkaDietCoke.addAlcohol(absolutVodka);
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
        longIslandAlcMeasure.addAlcohol(absolutVodka);
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


        Drink passionFruitMartini = new Drink("Passion fruit Martini", "cocktail", "shake and double strain", "Coupe glass", "cut in half passion fruit");
        drinkRepository.save(passionFruitMartini);
        Ingredient passionFruitMeasure = new Ingredient(25);
        ingredientRepository.save(passionFruitMeasure);
        passionFruitMartini.addIngredient(passionFruitMeasure);
        passionFruitMeasure.addAlcohol(passoa);
        passionFruitMeasure.addAlcohol(vanillaVodka);
        passionFruitMeasure.addMixer(pineappleJuice);
        passionFruitMeasure.addMixer(passionFruitPuree);
        Ingredient passionFruitMeasure2 = new Ingredient(15);
        ingredientRepository.save(passionFruitMeasure2);
        passionFruitMartini.addIngredient(passionFruitMeasure2);
        passionFruitMeasure2.addMixer(limeJuice);
        passionFruitMeasure2.addMixer(sugarSyrup);

//        Espresso Martini

        Drink espressoMartini = new Drink("Espresso Martini", "cocktail", "shake and double strain", "Coupe glass", "Coffee beans");
        drinkRepository.save(espressoMartini);
        Ingredient espressoMeasure = new Ingredient(25);
        ingredientRepository.save(espressoMeasure);
        espressoMartini.addIngredient(espressoMeasure);
        espressoMeasure.addAlcohol(absolutVodka);
        espressoMeasure.addAlcohol(kahlua);
        espressoMeasure.addMixer(espressoCoffee);
        espressoMeasure.addMixer(sugarSyrup);

//        French Martini

        Drink frenchMartini = new Drink("French Martini", "cocktail", "shake and double strain", "Coupe glass", "Lemon wheel");
        drinkRepository.save(frenchMartini);
        Ingredient frenchMeasure1 = new Ingredient(25);
        ingredientRepository.save(frenchMeasure1);
        frenchMartini.addIngredient(frenchMeasure1);
        frenchMeasure1.addAlcohol(absolutVodka);
        frenchMeasure1.addAlcohol(chambord);
        Ingredient frenchMeasure2 = new Ingredient(50);
        ingredientRepository.save(frenchMeasure2);
        frenchMartini.addIngredient(frenchMeasure2);
        frenchMeasure2.addMixer(pineappleJuice);
        Ingredient frenchMeasure3 = new Ingredient(10);
        ingredientRepository.save(frenchMeasure3);
        frenchMartini.addIngredient(frenchMeasure3);
        frenchMeasure3.addMixer(limeJuice);

//        Sex on the Beach

        Drink sexOnTheBeach = new Drink("Sex on the Beach", "cocktail", "build in glass, orange juice followed by cranberry juice", "High rock", "Orange wheel");
        drinkRepository.save(sexOnTheBeach);
        Ingredient sexOnTheBeachMeasure25 = new Ingredient(25);
        ingredientRepository.save(sexOnTheBeachMeasure25);
        sexOnTheBeach.addIngredient(sexOnTheBeachMeasure25);
        sexOnTheBeachMeasure25.addAlcohol(absolutVodka);
        sexOnTheBeachMeasure25.addAlcohol(peachSchnapps);
        Ingredient sexOnTheBeach50 = new Ingredient(50);
        ingredientRepository.save(sexOnTheBeach50);
        sexOnTheBeach.addIngredient(sexOnTheBeach50);
        sexOnTheBeach50.addMixer(orangeJuice);
        sexOnTheBeach50.addMixer(cranberryJuice);

//        Disaronno Sours

        Drink disaronnoSours = new Drink("Disaronno Sours", "cocktail", "shake and double strain", "Short rock", "Lemon wheel");
        drinkRepository.save(disaronnoSours);
        Ingredient disaronnoSours50 = new Ingredient(50);
        ingredientRepository.save(disaronnoSours50);
        disaronnoSours.addIngredient(disaronnoSours50);
        disaronnoSours50.addAlcohol(disaronno);
        Ingredient disaronnoSours25 = new Ingredient(25);
        ingredientRepository.save(disaronnoSours25);
        disaronnoSours.addIngredient(disaronnoSours25);
        disaronnoSours25.addMixer(sugarSyrup);
        disaronnoSours25.addMixer(pineappleJuice);
        disaronnoSours25.addMixer(lemonJuice);

//        Strawberry Daiquiri

        Drink strawberryDaiquiri = new Drink("Strawberry Daiquiri", "cocktail", "shake and single strain", "Coupe glass", "Strawberries");
        drinkRepository.save(strawberryDaiquiri);
        Ingredient strawberryDaiquiri50 = new Ingredient(50);
        ingredientRepository.save(strawberryDaiquiri50);
        strawberryDaiquiri.addIngredient(strawberryDaiquiri50);
        strawberryDaiquiri50.addAlcohol(bacardi);
        Ingredient strawberryDaiquiri25 = new Ingredient(25);
        ingredientRepository.save(strawberryDaiquiri25);
        strawberryDaiquiri.addIngredient(strawberryDaiquiri25);
        strawberryDaiquiri25.addMixer(sugarSyrup);
        strawberryDaiquiri25.addMixer(strawberrySyrup);
        strawberryDaiquiri25.addMixer(limeJuice);









//
//      calculate total alcohol percentage

        drinkService.calculateTotalAlcoholPercentage(vodkaCoke);
        drinkService.calculateTotalAlcoholPercentage(vodkaDietCoke);
        drinkService.calculateTotalAlcoholPercentage(longIsland);
        drinkService.calculateTotalAlcoholPercentage(passionFruitMartini);
        drinkService.calculateTotalAlcoholPercentage(espressoMartini);
        drinkService.calculateTotalAlcoholPercentage(frenchMartini);
        drinkService.calculateTotalAlcoholPercentage(sexOnTheBeach);
        drinkService.calculateTotalAlcoholPercentage(disaronnoSours);
        drinkService.calculateTotalAlcoholPercentage(strawberryDaiquiri);







    }



}
