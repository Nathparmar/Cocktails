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
    private String name;

    @Column
    private double measurement;

    @Column
    private double alcoholPercentage;

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

    public Ingredient( String name, double measurement, double alcoholPercentage) {
        this.id = id;
        this.name = name;
        this.measurement = measurement;
        this.alcoholPercentage = alcoholPercentage;
        this.drinks = new ArrayList<>();
    }

    public Ingredient() {
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

    public double getMeasurement() {
        return measurement;
    }

    public void setMeasurement(double measurement) {
        this.measurement = measurement;
    }

    public double getAlcoholPercentage() {
        return alcoholPercentage;
    }

    public void setAlcoholPercentage(double alcoholPercentage) {
        this.alcoholPercentage = alcoholPercentage;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public void setDrinks(List<Drink> drinks) {
        this.drinks = drinks;
    }

    public void addDrink(Drink drink){
        this.drinks.add(drink);
    }

    public void removeDrink(Drink drink){
        this.drinks.remove(drink);
    }

}
