package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "car")
public class Car {
    @Column(name = "model")
    private String model;
    @Column(name = "series")
    private int series;

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", series=" + series +
                ", numberCar=" + numberCar +
                '}';
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numberCar;


    public Car() {
    }

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }

    public Long getNumberCar() {
        return numberCar;
    }

    public void setNumberCar(Long numberCar) {
        this.numberCar = numberCar;
    }
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

}