package np.demo.DTOs;

public class IngredientDTO {

    private String name;

    private double measurement;

    private double alcoholPercentage;



    public IngredientDTO(String name, double measurement, double alcoholPercentage) {
        this.name = name;
        this.measurement = measurement;
        this.alcoholPercentage = alcoholPercentage;
    }

    public IngredientDTO(){
        
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
}
