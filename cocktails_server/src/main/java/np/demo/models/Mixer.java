//package np.demo.models;
//
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "mixers")
//public class Mixer {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column
//    private String name;
//
//    @Column
//    private double alcoholPercentage;
//
//    @OneToOne
//    @JsonIgnoreProperties({"ingredients"})
//    private Ingredient ingredient;
//
//    public Mixer(String name, double alcoholPercentage) {
//        this.id = id;
//        this.name = name;
//        this.alcoholPercentage = 0;
//    }
//
//    public Mixer() {
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public double getAlcoholPercentage() {
//        return alcoholPercentage;
//    }
//
//    public void setAlcoholPercentage(double alcoholPercentage) {
//        this.alcoholPercentage = alcoholPercentage;
//    }
//
//}
