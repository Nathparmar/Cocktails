package np.demo.controllers;

import np.demo.models.Alcohol;
import np.demo.services.AlcoholService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("alcohols")
public class AlcoholController {

    @Autowired
    AlcoholService alcoholService;

//    GET

    @GetMapping
    public ResponseEntity<List<Alcohol>> getAllAlcohols(){
        return new ResponseEntity<>(alcoholService.findAllAlcohols(), HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Alcohol> getAlcoholById(@PathVariable Long id){
        return new ResponseEntity<>(alcoholService.findAlcoholById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/random")
    public ResponseEntity<Alcohol> getRandomAlcohol(){
        return new ResponseEntity<>(alcoholService.getRandomAlcohol(),HttpStatus.OK);
    }



}
