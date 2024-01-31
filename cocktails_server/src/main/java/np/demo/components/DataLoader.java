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


        Alcohol absolutVodka = new Alcohol("Absolut Vodka", "vodka",25, 40);
        alcoholRepository.save(absolutVodka);

        Alcohol gin = new Alcohol("Edinburgh Gin", "gin",25, 40);
        alcoholRepository.save(gin);

        Alcohol tequilaSilver = new Alcohol("Olmeca Silver Tequila", "silver tequila",25, 35);
        alcoholRepository.save(tequilaSilver);

        Alcohol bacardi = new Alcohol("Bacardi", "white rum",25, 37.5);
        alcoholRepository.save(bacardi);

        Alcohol vanillaVodka = new Alcohol("Absolut Vanilla Vodka", "vanilla vodka",25, 38);
        alcoholRepository.save(vanillaVodka);

        Alcohol passoa = new Alcohol("Passoa", " passion-fruit liquer",25, 17);
        alcoholRepository.save(passoa);

        Alcohol kahlua = new Alcohol("Kahlua", "coffee liquer", 25,  16);
        alcoholRepository.save(kahlua);

        Alcohol chambord = new Alcohol("Chambord", " French liquer", 25, 16.5);
        alcoholRepository.save(chambord);

        Alcohol peachSchnapps = new Alcohol("Archers Peach Schnapps", "peach schnapps", 25,18);
        alcoholRepository.save(peachSchnapps);

        Alcohol disaronno = new Alcohol("Disaronno", "liquer",25, 28);
        alcoholRepository.save(disaronno);

        Alcohol absolutVodka50 = new Alcohol("Absolut Vodka", "vodka",50, 40);
        alcoholRepository.save(absolutVodka50);

        Alcohol ginLongIsland = new Alcohol("Edinburgh Gin", "gin",12.5, 40);
        alcoholRepository.save(ginLongIsland);

        Alcohol tequilaSilverLongIsland = new Alcohol("Olmeca Silver Tequila", "silver tequila",12.5, 35);
        alcoholRepository.save(tequilaSilverLongIsland);

        Alcohol bacardiLongIsland = new Alcohol("Bacardi", "white rum",12.5, 37.5);
        alcoholRepository.save(bacardiLongIsland);

        Alcohol disaronno50 = new Alcohol("Disaronno", "liquer",50, 28);
        alcoholRepository.save(disaronno50);

        Alcohol bacardi50 = new Alcohol("Bacardi", "white rum",25, 37.5);
        alcoholRepository.save(bacardi50);

        Alcohol absolutVodkaLongIsland = new Alcohol("Absolut Vodka", "vodka",12.5, 40);
        alcoholRepository.save(absolutVodkaLongIsland);



//        Mixers

        Mixer coke = new Mixer("Coca Cola",150);
        mixerRepository.save(coke);

        Mixer longIslandCoke = new Mixer("Coca Cola", 100);
        mixerRepository.save(longIslandCoke);

        Mixer lemonade = new Mixer("Lemonade",100);
        mixerRepository.save(lemonade);

        Mixer sodaWater = new Mixer("Soda water",100);
        mixerRepository.save(sodaWater);

        Mixer redBull = new Mixer("Red Bull", 150);
        mixerRepository.save(redBull);

        Mixer tonic = new Mixer("Tonic Water",150);
        mixerRepository.save(tonic);

        Mixer dietCoke = new Mixer("Diet Coca Cola",150);
        mixerRepository.save(dietCoke);

        Mixer lemonJuice = new Mixer("Lemon Juice",25);
        mixerRepository.save(lemonJuice);

        Mixer sugarSyrup = new Mixer("Sugar Syrup",25);
        mixerRepository.save(sugarSyrup);

        Mixer sugarSyrup15 = new Mixer("Sugar Syrup",15);
        mixerRepository.save(sugarSyrup15);

        Mixer passionFruitPuree = new Mixer("Passion fruit puree",25);
        mixerRepository.save(passionFruitPuree);

        Mixer limeJuice15 = new Mixer("Lime Juice",15);
        mixerRepository.save(limeJuice15);

        Mixer limeJuice = new Mixer("Lime Juice",25);
        mixerRepository.save(limeJuice);

        Mixer pineappleJuice = new Mixer("Pineapple Juice",25);
        mixerRepository.save(pineappleJuice);

        Mixer pineappleJuice50 = new Mixer("Pineapple Juice", 50);
        mixerRepository.save(pineappleJuice50);

        Mixer orangeJuice50 = new Mixer("Orange Juice",50);
        mixerRepository.save(orangeJuice50);

        Mixer cranberryJuice50 = new Mixer("Cranberry Juice",50);
        mixerRepository.save(cranberryJuice50);

        Mixer appleJuice = new Mixer("Apple Juice",50);
        mixerRepository.save(appleJuice);

        Mixer strawberrySyrup = new Mixer("Strawberry Syrup",25);
        mixerRepository.save(strawberrySyrup);

        Mixer espressoCoffee = new Mixer("Espresso coffee",25);
        mixerRepository.save(espressoCoffee);
//
//
//
////     /////////////// //  Drinks /////////////////////
//
////        Vodka Coke
//
        Drink vodkaCoke = new Drink("Vodka Coke", "spirit mixer", "build in glass", "spirit glass", "Lemon slice" );
        drinkRepository.save(vodkaCoke);
        Ingredient doubleMeasureVodkaCoke = new Ingredient();
        ingredientRepository.save(doubleMeasureVodkaCoke);
        vodkaCoke.addIngredient(doubleMeasureVodkaCoke);
        doubleMeasureVodkaCoke.addAlcohol(absolutVodka50);
        doubleMeasureVodkaCoke.addMixer(coke);

//        Vodka diet Coke

        Drink vodkaDietCoke = new Drink("Vodka Diet Coke", "spirit mixer", "build in glass",  "spirit glass", "Lemon slice" );
        drinkRepository.save(vodkaDietCoke);
        Ingredient doubleMeasureVodkaDietCoke = new Ingredient();
        ingredientRepository.save(doubleMeasureVodkaDietCoke);
        vodkaDietCoke.addIngredient(doubleMeasureVodkaDietCoke);
        doubleMeasureVodkaDietCoke.addAlcohol(absolutVodka50);
        doubleMeasureVodkaDietCoke.addMixer(dietCoke);

////        Long Island

        Drink longIsland = new Drink("Long Island Iced Tea", "cocktail", "Shake all ingredients. Pour them in a glass, then top with coca cola", "High rock glass", "Lemon wheel" );
        drinkRepository.save(longIsland);
        Ingredient longIslandIngredient = new Ingredient();
        ingredientRepository.save(longIslandIngredient);
        longIsland.addIngredient(longIslandIngredient);
        longIslandIngredient.addAlcohol(bacardiLongIsland);
        longIslandIngredient.addAlcohol(absolutVodkaLongIsland);
        longIslandIngredient.addAlcohol(tequilaSilverLongIsland);
        longIslandIngredient.addAlcohol(ginLongIsland);
        longIslandIngredient.addMixer(sugarSyrup);
        longIslandIngredient.addMixer(lemonJuice);
        longIslandIngredient.addMixer(longIslandCoke);
//
////        Passion fruit martini
//
//
        Drink passionFruitMartini = new Drink("Passion fruit Martini", "cocktail", "shake and double strain", "Coupe glass", "cut in half passion fruit");
        drinkRepository.save(passionFruitMartini);
        Ingredient passionFruitMeasure = new Ingredient();
        ingredientRepository.save(passionFruitMeasure);
        passionFruitMartini.addIngredient(passionFruitMeasure);
        passionFruitMeasure.addAlcohol(passoa);
        passionFruitMeasure.addAlcohol(vanillaVodka);
        passionFruitMeasure.addMixer(pineappleJuice);
        passionFruitMeasure.addMixer(passionFruitPuree);
        passionFruitMeasure.addMixer(limeJuice15);
        passionFruitMeasure.addMixer(sugarSyrup15);

//        Espresso Martini

        Drink espressoMartini = new Drink("Espresso Martini", "cocktail", "shake and double strain", "Coupe glass", "Coffee beans");
        drinkRepository.save(espressoMartini);
        Ingredient espressoMeasure = new Ingredient();
        ingredientRepository.save(espressoMeasure);
        espressoMartini.addIngredient(espressoMeasure);
        espressoMeasure.addAlcohol(absolutVodka);
        espressoMeasure.addAlcohol(kahlua);
        espressoMeasure.addMixer(espressoCoffee);
        espressoMeasure.addMixer(sugarSyrup);

//        French Martini

        Drink frenchMartini = new Drink("French Martini", "cocktail", "shake and double strain", "Coupe glass", "Lemon wheel");
        drinkRepository.save(frenchMartini);
        Ingredient frenchMeasure = new Ingredient();
        ingredientRepository.save(frenchMeasure);
        frenchMartini.addIngredient(frenchMeasure);
        frenchMeasure.addAlcohol(absolutVodka);
        frenchMeasure.addAlcohol(chambord);
        frenchMeasure.addMixer(pineappleJuice50);
        frenchMeasure.addMixer(limeJuice15);

//        Sex on the Beach

        Drink sexOnTheBeach = new Drink("Sex on the Beach", "cocktail", "build in glass, orange juice followed by cranberry juice", "High rock", "Orange wheel");
        drinkRepository.save(sexOnTheBeach);
        Ingredient sexOnTheBeachMeasure = new Ingredient();
        ingredientRepository.save(sexOnTheBeachMeasure);
        sexOnTheBeach.addIngredient(sexOnTheBeachMeasure);
        sexOnTheBeachMeasure.addAlcohol(absolutVodka);
        sexOnTheBeachMeasure.addAlcohol(peachSchnapps);
        sexOnTheBeachMeasure.addMixer(orangeJuice50);
        sexOnTheBeachMeasure.addMixer(cranberryJuice50);

//        Disaronno Sours

        Drink disaronnoSours = new Drink("Disaronno Sours", "cocktail", "shake and double strain", "Short rock", "Lemon wheel");
        drinkRepository.save(disaronnoSours);
        Ingredient disaronnoSoursIng = new Ingredient();
        ingredientRepository.save(disaronnoSoursIng);
        disaronnoSours.addIngredient(disaronnoSoursIng);
        disaronnoSoursIng.addAlcohol(disaronno50);
        disaronnoSoursIng.addMixer(sugarSyrup);
        disaronnoSoursIng.addMixer(pineappleJuice);
        disaronnoSoursIng.addMixer(lemonJuice);

//        Strawberry Daiquiri

        Drink strawberryDaiquiri = new Drink("Strawberry Daiquiri", "cocktail", "shake and single strain", "Coupe glass", "Strawberries");
        drinkRepository.save(strawberryDaiquiri);
        Ingredient strawberryDaiquiriIng = new Ingredient();
        ingredientRepository.save(strawberryDaiquiriIng);
        strawberryDaiquiri.addIngredient(strawberryDaiquiriIng);
        strawberryDaiquiriIng.addAlcohol(bacardi50);
        strawberryDaiquiriIng.addMixer(sugarSyrup);
        strawberryDaiquiriIng.addMixer(strawberrySyrup);
        strawberryDaiquiriIng.addMixer(limeJuice);









        drinkService.calculateABV(vodkaCoke);
        drinkService.calculateABV(vodkaDietCoke);
        drinkService.calculateABV(longIsland);
        drinkService.calculateABV(passionFruitMartini);
        drinkService.calculateABV(espressoMartini);
        drinkService.calculateABV(frenchMartini);
        drinkService.calculateABV(sexOnTheBeach);
        drinkService.calculateABV(disaronnoSours);
        drinkService.calculateABV(strawberryDaiquiri);







    }



}
