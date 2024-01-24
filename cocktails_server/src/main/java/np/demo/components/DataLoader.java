package np.demo.components;

import np.demo.models.Drink;
import np.demo.models.Ingredient;
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
//        Ingredients

        Ingredient vodka = new Ingredient("vodka", 50, 40);
        vodkaCoke.addIngredient(vodka);
        vodkaDietCoke.addIngredient(vodka);
        ingredientRepository.save(vodka);

        Ingredient coke = new Ingredient("coke", 150, 0);
        vodkaCoke.addIngredient(coke);
        ingredientRepository.save(coke);

        Ingredient dietCoke = new Ingredient("diet coke", 150, 0);
        vodkaDietCoke.addIngredient(dietCoke);
        ingredientRepository.save(dietCoke);

//      calculate total alcohol percentage

        drinkService.calculateTotalAlcoholPercentage(vodkaCoke);
        drinkService.calculateTotalAlcoholPercentage(vodkaDietCoke);







    }



}
