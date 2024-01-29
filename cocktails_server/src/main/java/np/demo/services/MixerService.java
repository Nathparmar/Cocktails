package np.demo.services;

import np.demo.models.Drink;
import np.demo.models.Mixer;
import np.demo.repositories.MixerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MixerService {

    @Autowired
    MixerRepository mixerRepository;

    public void saveMixer(Mixer mixer){
         mixerRepository.save(mixer);
    }

   public List<Mixer> findAllMixers(){
      return mixerRepository.findAll();
   }

   public Mixer findMixerById(Long id){
       return mixerRepository.findById(id).get();
   }




}
