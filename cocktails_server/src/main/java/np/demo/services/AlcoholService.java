package np.demo.services;

import np.demo.models.Alcohol;
import np.demo.repositories.AlcoholRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlcoholService {

    @Autowired
    AlcoholRepository alcoholRepository;

    public List<Alcohol> findAllAlcohols(){
        return alcoholRepository.findAll();
    }

    public Alcohol findAlcoholById(Long id) {
        return alcoholRepository.findById(id).get();
    }
}
