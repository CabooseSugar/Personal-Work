package array_list;

import com.sun.javafx.UnmodifiableArrayList;

import java.util.ArrayList; // need this for ArrayList

public class SolarSystem {

    //
    // Instance data
        // private Planet[] planets - old school array
    private ArrayList<Planet> planets; // new, ArrayList method

    public SolarSystem() {
        planets = new ArrayList();
    }

    public ArrayList<Planet> getPlanets() {
        return planets;
    }
}
