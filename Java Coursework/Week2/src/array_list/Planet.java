package array_list;

public class Planet {

    //
    // Instance data
    private String name;
    private Boolean isLivable;
    private Integer numMoons;
    private double radius;
    private double mass;

    public Planet(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Boolean getLivable() {
        return isLivable;
    }

    public Integer getNumMoons() {
        return numMoons;
    }

    public double getRadius() {
        return radius;
    }

    public double getMass() {
        return mass;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLivable(Boolean livable) {
        isLivable = livable;
    }

    public void setNumMoons(Integer numMoons) {
        this.numMoons = numMoons;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }
}
