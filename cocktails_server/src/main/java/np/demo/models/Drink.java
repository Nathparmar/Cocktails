package np.demo.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "drink")
public class Drink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String type;

    @OneToMany(mappedBy = "drink")
    @JsonIgnoreProperties({"drink"})
    private List<Ingredient> ingredients;

    @Column
    private String buildMethod;

    @Column
    private double totalAlcoholPercentage;

    @Column
    private String glassType;

    @Column
    private String garnish;

    public Drink(Long id, String name, String type, List<Ingredient> ingredients, String buildMethod, double totalAlcoholPercentage, String glassType, String garnish) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.ingredients = ingredients;
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
}
