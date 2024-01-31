package np.demo.repositories;

import np.demo.models.Mixer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MixerRepository extends JpaRepository<Mixer, Long> {



    @Query("SELECT a FROM Mixer a WHERE a.name IN (SELECT name FROM Mixer GROUP BY name HAVING COUNT(name) = 1)")
    List<Mixer> findAllNonRepeatedMixers();



    @Query("SELECT m FROM Mixer m WHERE m.name IN (SELECT name FROM Mixer GROUP BY name HAVING COUNT(name) > 1)")
    List<Mixer> findRepeatedMixers();



    List<Mixer> findByName(String name);

}
