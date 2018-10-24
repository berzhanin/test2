package tests.task9;

public class Mars extends Planets {

    private String planetName;
    private String colorOfThePlanet;
    private boolean presenceOfAtmosphere;
    private double gravityInARelationshipEarth;

    //overloaded and related constructors
    public Mars() {
    }

    public Mars(String anyPlanetName) {
        this.planetName = anyPlanetName;
    }

    public Mars(String anyPlanetName, String anyColorOfThePlanet) {
        this(anyPlanetName);
        this.colorOfThePlanet = anyColorOfThePlanet;
    }

    public Mars(String anyPlanetName, String anyColorOfThePlanet, boolean anyPresenceOfAtmosphere) {
        this(anyPlanetName, anyColorOfThePlanet);
        this.presenceOfAtmosphere = anyPresenceOfAtmosphere;

    }

    //methods of abstract classes on the inheritance chain
    @Override
    void printClassName() {
        System.out.println("className: " + planetName);

    }

    @Override
    public void printPlanetsName() {
        System.out.println("Name of planets: " + colorOfThePlanet + " " + planetName);

    }

    @Override
    public void printLivingConditions() {
        if (waterAvailability == true && suitableForLife == true && presenceOfAtmosphere == true) {
            System.out.println("The planet is fit for people");
        } else {
            System.out.println("Do not try to move there to live. Only for robots!!!");
        }
    }

    //setters and getters
    public void setPresenceOfAtmosphere(boolean presenceOfAtmosphere) {
        this.presenceOfAtmosphere = presenceOfAtmosphere;
    }

    public void setGravityInARelationshipEarth(double gravityInARelationshipEarth) {
        this.gravityInARelationshipEarth = gravityInARelationshipEarth;
    }

    //other methods
    public void printBasicInformation(){
        printClassName();
        printPlanetsName();
        printLivingConditions();
    }

    public void printAllInfo(){
        System.out.println("class name: " + getClass());
        System.out.println("planet name: " + planetName);
        System.out.println("color of planet: " + colorOfThePlanet);
        System.out.println("atmosphere: " + presenceOfAtmosphere);
   }

}
