package inheritance;

import java.util.Objects;

public class Truck extends Vehicle {

    //
    // INSTANCE DATA
    private Integer numAxles;
    private Double height, weight;
    private Boolean isOversize;

    public Truck(String vin, String make, String model, Integer year, Boolean is_manual, Double mileage, Integer numAxles, Double height, Double weight, Boolean isOversize) {
        super(vin, make, model, year, is_manual, mileage);
        this.numAxles = numAxles;
        this.height = height;
        this.weight = weight;
        this.isOversize = isOversize;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    @Override
    void honkHorn() {
        System.out.println("HOOOOONK");
    }
}

