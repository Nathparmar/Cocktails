package np.demo.services;

import np.demo.models.Drink;
import np.demo.models.Mixer;
import np.demo.repositories.MixerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MixerService {

    @Autowired
    MixerRepository mixerRepository;

    public void saveMixer(Mixer mixer){
         mixerRepository.save(mixer);
    }


    public List<Mixer> findAllUniqueMixers() {
        List<Mixer> allMixers = mixerRepository.findAll();

        Map<String, Mixer> uniqueMixersMap = new HashMap<>();

        for (Mixer mixer : allMixers) {
            uniqueMixersMap.putIfAbsent(mixer.getName(), mixer);
        }

        List<Mixer> uniqueMixers = new ArrayList<>(uniqueMixersMap.values());

        System.out.println(uniqueMixers);
        return uniqueMixers;
    }

    public List<Mixer> findAllMixers(){
        return mixerRepository.findAll();
    }

   public Mixer findMixerById(Long id){
       return mixerRepository.findById(id).get();
   }




}
