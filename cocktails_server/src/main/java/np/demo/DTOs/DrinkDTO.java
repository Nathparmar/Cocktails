package np.demo.DTOs;

import np.demo.models.Ingredient;

import java.util.ArrayList;
import java.util.List;

public class DrinkDTO {


    private List<IngredientDTO> ingredientDTOs;

    private double totalAlcoholPercentage;


    private double alcoholUnits;

    public DrinkDTO(List<IngredientDTO> ingredientsDTOs) {
        this.ingredientDTOs = new ArrayList<IngredientDTO>();
        this.totalAlcoholPercentage = 0.0;
        this.alcoholUnits = 0.0;
    }

    public DrinkDTO() {
    }

    public List<IngredientDTO> getIngredientDTOs() {
        return ingredientDTOs;
    }

    public void setIngredientDTOs(List<IngredientDTO> ingredientDTOs) {
        this.ingredientDTOs = ingredientDTOs;
    }

    public double getAlcoholUnits() {
        return alcoholUnits;
    }

    public void setAlcoholUnits(double alcoholUnits) {
        this.alcoholUnits = alcoholUnits;
    }

    public double getTotalAlcoholPercentage() {
        return totalAlcoholPercentage;
    }

    public void setTotalAlcoholPercentage(double totalAlcoholPercentage) {
        this.totalAlcoholPercentage = totalAlcoholPercentage;
    }
}
