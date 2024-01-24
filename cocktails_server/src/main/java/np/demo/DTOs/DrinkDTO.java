package np.demo.DTOs;

import np.demo.models.Ingredient;

import java.util.ArrayList;
import java.util.List;

public class DrinkDTO {

    private String name;

    private List<Ingredient> ingredients;

    private double totalAlcoholPercentage;

    public DrinkDTO(String name, List<Ingredient> ingredients) {
        this.name = name;
        this.ingredients = new ArrayList<Ingredient>();
        this.totalAlcoholPercentage = 0.0;
    }

    public DrinkDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public double getTotalAlcoholPercentage() {
        return totalAlcoholPercentage;
    }

    public void setTotalAlcoholPercentage(double totalAlcoholPercentage) {
        this.totalAlcoholPercentage = totalAlcoholPercentage;
    }
}
