package np.demo.controllers;

import np.demo.DTOs.DrinkDTO;
import np.demo.models.Drink;
import np.demo.models.Ingredient;
import np.demo.repositories.DrinkRepository;
import np.demo.services.DrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
        return new ResponseEntity<>(drinkService.findAllDrinks(), HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Drink> getDrinkById(@PathVariable Long id){
        return new ResponseEntity<>(drinkService.findDrinkById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/random")
    public ResponseEntity<Drink> getRandomDrink(){
        return new ResponseEntity<>(drinkService.getRandomDrink(), HttpStatus.OK);
    }

//    POST
    @PostMapping
    public ResponseEntity<DrinkDTO> calculateAlcPercentageOfClientDrink(@RequestBody DrinkDTO drinkDTO){
        drinkService.postABVCalculator(drinkDTO);
        return new ResponseEntity<>(drinkDTO,HttpStatus.OK);

    }






}