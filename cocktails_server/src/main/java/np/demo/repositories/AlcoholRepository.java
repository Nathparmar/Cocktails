package np.demo.repositories;

import np.demo.models.Alcohol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlcoholRepository extends JpaRepository<Alcohol, Long> {

    List<Alcohol> findAllByMeasurement(double measurement);
}
