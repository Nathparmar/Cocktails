package np.demo.services;

import np.demo.models.Drink;
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
}
