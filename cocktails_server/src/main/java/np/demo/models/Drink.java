package np.demo.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "drink")
public class Drink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String name;

    @Column
    private String type;

//    @ManyToMany(mappedBy = "drink")
//    @JsonIgnoreProperties({"drink"})
//    private List<Ingredient> ingredients;

    @ManyToMany
    @JoinTable(
            name = "drink_ingredient",
            joinColumns = @JoinColumn(name = "drink_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id")
    )
    @JsonIgnoreProperties({"drinks"})
    private List<Ingredient> ingredients;

    @Column
    private String buildMethod;

    @Column
    private double totalAlcoholPercentage;

    @Column
    private String glassType;

    @Column
    private String garnish;

    public Drink(String name, String type, String buildMethod, double totalAlcoholPercentage, String glassType, String garnish) {
        this.name = name;
        this.type = type;
        this.ingredients = new ArrayList<Ingredient>();
        this.buildMethod = buildMethod;
        this.totalAlcoholPercentage = totalAlcoholPercentage;
        this.glassType = glassType;
        this.garnish = garnish;
    }

    public Drink() {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public String getBuildMethod() {
        return buildMethod;
    }

    public void setBuildMethod(String buildMethod) {
        this.buildMethod = buildMethod;
    }

    public double getTotalAlcoholPercentage() {
        return totalAlcoholPercentage;
    }

    public void setTotalAlcoholPercentage(double totalAlcoholPercentage) {
        this.totalAlcoholPercentage = totalAlcoholPercentage;
    }

    public String getGlassType() {
        return glassType;
    }

    public void setGlassType(String glassType) {
        this.glassType = glassType;
    }

    public String getGarnish() {
        return garnish;
    }

    public void setGarnish(String garnish) {
        this.garnish = garnish;
    }

    public void addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }

    public void removeIngredient(Ingredient ingredient){
        this.ingredients.remove(ingredient);
    }

}


