package np.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "mixers")
public class Mixer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String name;

    @Column
    private double alcoholPercentage;

    @ManyToMany(mappedBy = "mixers")
    @JsonIgnoreProperties({"mixers"})
    private List<Ingredient> ingredients;

    public Mixer(String name) {
        this.id = id;
        this.name = name;
        this.alcoholPercentage = 0;
    }

    public Mixer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAlcoholPercentage() {
        return alcoholPercentage;
    }

    public void setAlcoholPercentage(double alcoholPercentage) {
        this.alcoholPercentage = alcoholPercentage;
    }

}
