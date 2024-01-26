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

    @OneToOne
    private Alcohol alcohol;


//    @ManyToMany
//    @JoinTable(
//            name = "drinks_ingredients",
//            joinColumns = @JoinColumn(name = "ingredient_id"),
//            inverseJoinColumns = @JoinColumn(name = "estate_id")
//    )
//    @JsonIgnoreProperties({"ingredients"})
//    private List<Drink> drinks;

    @ManyToMany(mappedBy = "ingredients")
    @JsonIgnoreProperties({"ingredients"})
    private List<Drink> drinks;

    public Ingredient( double measurement) {
        this.id = id;
        this.measurement = measurement;
        this.drinks = new ArrayList<Drink>();
        this.alcohol = new Alcohol();
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

//    public void addAlcohol(Alcohol alcohol) {
//        this.alcohols.add(alcohol);
//    }


    public Alcohol getAlcohol() {
        return alcohol;
    }

    public void setAlcohol(Alcohol alcohol) {
        this.alcohol = alcohol;
    }
}
