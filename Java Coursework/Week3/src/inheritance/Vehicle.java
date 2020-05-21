package inheritance;

import java.util.Objects;

abstract public class Vehicle {

    //
    // INSTANCE DATA
    protected String vin, make, model; // protected accessable in the class itself and any derived class (car and truck), could be private (accessible only in the class), that works too
    protected Integer year;
    protected Boolean is_manual;
    protected Double mileage;

    public Vehicle(){

    };

    // METHOD I WANT INVOKED IN CHILD CLASS
    abstract void honkHorn();  // abstract methods need to be defined in child classes. If you have an abstract method in a class, the class
                                // itself must be an abstract class.
        //
        // I WANT THIS OVERRIDDEN


    public Vehicle(String vin, String make, String model, Integer year, Boolean is_manual, Double mileage) {
        this.vin = vin;
        this.make = make;
        this.model = model;
        this.year = year;
        this.is_manual = is_manual;
        this.mileage = mileage;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Boolean getIs_manual() {
        return is_manual;
    }

    public void setIs_manual(Boolean is_manual) {
        this.is_manual = is_manual;
    }

    public Double getMileage() {
        return mileage;
    }

    public void setMileage(Double mileage) {
        this.mileage = mileage;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vin='" + vin + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", is_manual=" + is_manual +
                ", mileage=" + mileage +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(vin, vehicle.vin) &&
                Objects.equals(make, vehicle.make) &&
                Objects.equals(model, vehicle.model) &&
                Objects.equals(year, vehicle.year) &&
                Objects.equals(is_manual, vehicle.is_manual) &&
                Objects.equals(mileage, vehicle.mileage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vin, make, model, year, is_manual, mileage);
    }
}

