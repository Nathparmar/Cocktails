package np.demo.services;

import np.demo.models.Alcohol;
import np.demo.repositories.AlcoholRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
public class AlcoholService {

    @Autowired
    AlcoholRepository alcoholRepository;

    public List<Alcohol> findAllAlcohols(){
        return alcoholRepository.findAllByMeasurement(25);
    }

    public Alcohol findAlcoholById(Long id) {
        return alcoholRepository.findById(id).get();
    }

    public Alcohol getRandomAlcohol(){
        List<Alcohol> alcohols = alcoholRepository.findAllByMeasurement(25);

        Collections.shuffle(alcohols); // Shuffle for true randomness

        int alcoholIndex = 0; // gets the first alcohol of the shuffled list
        return alcohols.subList(0, alcohols.size()).get(alcoholIndex);

    }

}
