package java_enums2;

public enum Planet { // notice create class dropdown is ENUMS, not normal class

    MERCURY(3.303e23, 2.4397e6),
    VENUS(4.869e24, 6.0518e6),
    EARTH(5.97e24, 6.37e6),
    MARS(6.42e23, 3.39e6),
    JUPITER(1.9e27, 7.14e7),
    SATURN(5.68e26, 6.02e7),
    URANUS(8.68e25, 2.55e7),
    NEPTUNE(1.02e26, 2.47e7),
    PLUTO(1.39e22, 1.18e6);

    //
    // INSTANCE DATA
    private final double mass; // kg
    private final double radius; // meters

    Planet(double mass, double radius) { // you can add a constructor a your enums in Java
        this.mass = mass;
        this.radius = radius;
    }

    // setting argument in args by going to dropdown in top right next to hammer, hitting
    // edit configurations, and putting something in arguments field
    //(in this case the weight of a human on Earth in pounds, like 150)
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("ARGS IS REQUIRED TO RUN!");
            System.exit(1);
        }

        //
        // get the user's weight
        Double earthWeight = Double.parseDouble(args [0]); // reads arguments line in configuration
        Double mass = earthWeight / EARTH.surfaceGravity();

        //
        // print out user's weight on each planet
        for (Planet p: Planet.values()) {
            System.out.printf("Your weight on %s is %s \n", p, p.surfaceWeight(mass));
        }
    }

    private static final double G = 6.67300E-11; // final is Java version of const

    private Double surfaceGravity() {
        return G * mass /(radius * radius);

    }

    private double surfaceWeight(Double otherMass) {
        return otherMass * surfaceGravity();
    }
}
