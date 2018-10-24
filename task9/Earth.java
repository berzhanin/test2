package tests.task9;

import tests.task9.Planets;

public class Earth extends Planets {

    private String planetName;
    private String colorOfThePlanet;
    private boolean presenceOfAtmosphere;
    private double averageAirTemperature;
    private double numberOfPersons;

    //setters and getters
    public String getPlanetName() {
        return planetName;
    }

    public void setPlanetName(String planetName) {
        this.planetName = planetName;
    }

    public String getColorOfThePlanet() {
        return colorOfThePlanet;
    }

    public void setColorOfThePlanet(String colorOfThePlanet) {
        this.colorOfThePlanet = colorOfThePlanet;
    }

    public boolean getPresenceOfAtmosphere() {
        return presenceOfAtmosphere;
    }

    public void setPresenceOfAtmosphere(boolean presenceOfAtmosphere) {
        this.presenceOfAtmosphere = presenceOfAtmosphere;
    }

    public double getAverageAirTemperature() {
        return averageAirTemperature;
    }

    public void setAverageAirTemperature(double averageAirTemperature) {
        this.averageAirTemperature = averageAirTemperature;
    }

    public double getNumberOfPersons() {
        return numberOfPersons;
    }

    public void setNumberOfPersons(double numberOfPersons) {
        this.numberOfPersons = numberOfPersons;
    }

    //methods of abstract classes on the inheritance chain
    @Override
    void printClassName() {
        System.out.println("className: " + planetName);
    }
    @Override
    public void printPlanetsName() {
        System.out.println("Name of planets: " + getColorOfThePlanet() + " " + getPlanetName());
    }

    @Override
    public void printLivingConditions() {
        if (presenceOfAtmosphere == true && suitableForLife == true && presenceOfAtmosphere == true) {
            System.out.println("The planet is fit for people");
        } else {
            System.out.println("Do not try to move there to live. Only for robots!!!");
        }
    }


    //other methods
    public void printBasicInformation(){
        printClassName();
        printPlanetsName();
        printLivingConditions();
    }

    public void printAllInfo(){
        System.out.println("class name: " + getClass());
        System.out.println("planet name: " + getPlanetName());
        System.out.println("color of planet: " + getColorOfThePlanet());
        System.out.println("atmosphere: " + getPresenceOfAtmosphere());
        //System.out.println("water: " + ge);
        System.out.println("number of people: " + getNumberOfPersons() + " billions");
        System.out.println("average temperature on the planet: " + getAverageAirTemperature());
    }
}
