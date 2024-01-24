package np.demo.components;

import np.demo.models.Drink;
import np.demo.models.Ingredient;
import np.demo.repositories.DrinkRepository;
import np.demo.repositories.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    DrinkRepository drinkRepository;

    @Autowired
    IngredientRepository ingredientRepository;

    public DataLoader(){

    }

@Override
    public void run(ApplicationArguments args) throws Exception {



        Drink vodkaCoke = new Drink("Vodka Coke", "spirit mixer", "build in glass", 40, "spirit glass", "lemon slice" );
        drinkRepository.save(vodkaCoke);

        Drink vodkaDietCoke = new Drink("Vodka Diet Coke", "spirit mixer", "build in glass", 40, "spirit glass", "lemon slice" );
        drinkRepository.save(vodkaDietCoke);


        Ingredient vodka = new Ingredient("vodka", 50, 40);
        vodka.addDrink(vodkaCoke);
        vodka.addDrink(vodkaDietCoke);
        ingredientRepository.save(vodka);

        Ingredient coke = new Ingredient("coke", 300, 0);
        coke.addDrink(vodkaCoke);
        ingredientRepository.save(coke);

        Ingredient dietCoke = new Ingredient("diet coke", 300, 0);
        dietCoke.addDrink(vodkaDietCoke);
        ingredientRepository.save(dietCoke);






    }



}
