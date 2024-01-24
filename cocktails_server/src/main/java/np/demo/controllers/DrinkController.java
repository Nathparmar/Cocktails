package np.demo.controllers;

import np.demo.models.Drink;
import np.demo.repositories.DrinkRepository;
import np.demo.services.DrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("drinks")
public class DrinkController {

    @Autowired
    DrinkRepository drinkRepository;

    @Autowired
    DrinkService drinkService;

//    GET
    @GetMapping
    public ResponseEntity<List<Drink>> getAllDrinks(){
        return new ResponseEntity<>(drinkRepository.findAll(), HttpStatus.OK);
    }

}
