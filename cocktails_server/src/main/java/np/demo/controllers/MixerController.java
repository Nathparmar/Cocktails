package np.demo.controllers;

import np.demo.models.Mixer;
import np.demo.services.MixerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("mixers")
public class MixerController {

    @Autowired
    MixerService mixerService;

//    GET
    @GetMapping
    public ResponseEntity<List<Mixer>> getAllMixers(){
        return new ResponseEntity<>(mixerService.findAllMixers(), HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Mixer> getMixerById(@PathVariable Long id){
        return new ResponseEntity<>(mixerService.findMixerById(id), HttpStatus.OK);
    }
}
