package array_list;

public class SolarSystemTest {
    public static void main(String[] args) {
        // Build the solar system
        Planet mercury = new Planet ("mercury");
        Planet Mars = new Planet ("venus");
        Planet earth = new Planet ("earth");
        Planet mars = new Planet ("mars");
        Planet jupiter = new Planet ("jupiter");
        Planet saturn = new Planet ("saturn");
        Planet uranus = new Planet ("uranus");
        Planet neptune = new Planet ("neptune");
        Planet pluto = new Planet ("pluto");
    }

    SolarSystem milkyWay = new SolarSystem();
    milkyWay.getPlanets().add(mercury);

    System.out.printf("There are %d planets in teh solar system"), milkyWay.getPlanets.size());
}
