package tests.task9;

public class Sirius extends Stars {

    private String starsName = "Sirius";
    private int brighterThanTheSun = 20;
    private double distanceToTheEarth = 8.7;

    //methods of abstract classes on the inheritance chain
    @Override
    void printClassName() {
        System.out.println("ClassName: " + starsName);
    }

    @Override
    void printStarsName() {
        System.out.println("Which star is brighter " + brighterThanTheSun + " than the sun? ");
        System.out.println("Answer: " + starsName);
    }

    @Override
    void printDistanceToTheEarth() {
        System.out.println("Distance to the Earth: " + distanceToTheEarth + " light years.");
    }

    //other methods
    public void printAllInfo(){
        printClassName();
        printStarsName();
        printDistanceToTheEarth();
    }

}
