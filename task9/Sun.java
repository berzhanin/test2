package tests.task9;

public class Sun extends Stars {

    private String starsName;
    private String whatTypeOfStar;
    private double distanceToTheEarth;

    //overloaded but not related constructors
    public Sun(String starsName) {
        this.starsName = starsName;
    }

    public Sun(String starsName,String whatTypeOfStar ) {
        super();
        this.starsName = starsName;
        this.whatTypeOfStar = whatTypeOfStar;
    }

    public Sun(String starsName, String whatTypeOfStar,double distanceToTheEarth ) {
        super();
        this.starsName = starsName;
        this.whatTypeOfStar = whatTypeOfStar;
        this.distanceToTheEarth = distanceToTheEarth;
    }

    //methods of abstract classes on the inheritance chain
    @Override
    void printClassName() {
        System.out.println("ClassName: " + starsName);
    }

    @Override
    void printStarsName() {
        System.out.println("Name of stars: " + whatTypeOfStar + " " + starsName);
    }

    @Override
    void printDistanceToTheEarth() {
        System.out.println("Distance to the Earth: " + distanceToTheEarth + " million kilometers.");
    }

    //other methods
    public void printAllInfo(){
        System.out.println(starsName + " " + whatTypeOfStar + " " + distanceToTheEarth);
    }

}
