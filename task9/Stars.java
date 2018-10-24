package tests.task9;

public abstract class Stars extends StarSystem {

    private String className = "Stars";
    private boolean thermonuclearFusionIsStillGoingOn;
    public double distanceToTheSun;

    abstract void printStarsName();
    abstract void printDistanceToTheEarth();

}
