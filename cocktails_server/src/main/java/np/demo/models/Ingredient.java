package np.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "ingredients")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;



    @Column
    private double measurement;

    @ManyToMany
    @JoinTable(
            name = "ingredient_alcohol",
            joinColumns = @JoinColumn(name = "ingredient_id"),
            inverseJoinColumns = @JoinColumn(name = "alcohol_id")
    )
    private List<Alcohol> alcohols;


    @ManyToMany
    @JoinTable(
            name = "ingredient_mixers",
            joinColumns = @JoinColumn(name = "ingredient_id"),
            inverseJoinColumns = @JoinColumn(name = "mixer_id")
    )
    private List<Mixer> mixers;

    @ManyToMany(mappedBy = "ingredients")
    @JsonIgnoreProperties({"ingredients"})
    private List<Drink> drinks;

    public Ingredient( double measurement) {
        this.id = id;
        this.measurement = measurement;
        this.drinks = new ArrayList<Drink>();
        this.alcohols = new ArrayList<>();
        this.mixers = new ArrayList<>();
    }

    public Ingredient() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public double getMeasurement() {
        return measurement;
    }

    public void setMeasurement(double measurement) {
        this.measurement = measurement;
    }


    public List<Drink> getDrinks() {
        return drinks;
    }

    public void setDrinks(List<Drink> drinks) {
        this.drinks = drinks;
    }

    public void addAlcohol(Alcohol alcohol) {
        this.alcohols.add(alcohol);
    }

    public void addMixer(Mixer mixer) {
        this.mixers.add(mixer);
    }


    public List<Alcohol> getAlcohols() {
        return alcohols;
    }

    public void setAlcohols(List<Alcohol> alcohols) {
        this.alcohols = alcohols;
    }

    public List<Mixer> getMixers() {
        return mixers;
    }

    public void setMixers(List<Mixer> mixers) {
        this.mixers = mixers;
    }
}
