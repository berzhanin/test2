package tests.task9;

//Main-class for testing classes: StarSystem, Planets, Stars, Earth, Mars, Sun, Sirius

public class MainStarSystem {

    public static void main(String[] args) {

        //testing for class Earth
        Earth earth = new Earth();
        earth.setPlanetName("Earth");
        earth.setColorOfThePlanet("blue");
        earth.setPresenceOfAtmosphere(true);
        earth.setSuitableForLife(true);
        earth.setWaterAvailability(true);
        earth.setAverageAirTemperature(14.8);
        earth.setNumberOfPersons(7.6);
        earth.printBasicInformation();
        earth.printAllInfo();

        //testing for class Mars
        Mars mars = new Mars("Mars","red",false);
        mars.printBasicInformation();
        mars.printAllInfo();

        //testing for class Sun
        Sun sun1 = new Sun("Sun");
        sun1.printAllInfo();
        Sun sun2 = new Sun("Sun","yellow dwarf");
        sun2.printAllInfo();
        Sun sun3 = new Sun("Sun","yellow dwarf",149.8);
        sun3.printAllInfo();

        //testing for class Sirius
        Sirius sirius = new Sirius();
        sirius.printAllInfo();

    }
}
