package np.demo.services;

import np.demo.models.Ingredient;
import np.demo.repositories.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredientService {

    @Autowired
    IngredientRepository ingredientRepository;

    public void saveIngredient(Ingredient ingredient){
        ingredientRepository.save(ingredient);
    }

}
