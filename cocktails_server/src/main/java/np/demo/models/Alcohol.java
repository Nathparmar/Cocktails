package np.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "alcohols")
public class Alcohol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;


    @Column
    private String name;

    @Column
    private String type;

    @Column
    private String brand;

    @Column
    private double alcoholPercentage;

    @OneToOne
    @JsonIgnoreProperties({"ingredients"})
    private Ingredient ingredient;

    public Alcohol( String name, String type, String brand, double alcoholPercentage) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.brand = brand;
        this.alcoholPercentage = alcoholPercentage;
    }

    public Alcohol() {
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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getAlcoholPercentage() {
        return alcoholPercentage;
    }

    public void setAlcoholPercentage(double alcoholPercentage) {
        this.alcoholPercentage = alcoholPercentage;
    }


}
