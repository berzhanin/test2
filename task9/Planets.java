package tests.task9;

public abstract class Planets extends StarSystem {

    private String className = "Planet";
    protected boolean suitableForLife;
    protected boolean waterAvailability;

    protected Planets() {
        System.out.println("class" + className);
    }

    //abstract methods
    public abstract void printPlanetsName();
    public abstract void printLivingConditions();

    //setters for variablen: suitableForLife and waterAvailability
    public void setSuitableForLife(boolean suitableForLife) {
        this.suitableForLife = suitableForLife;
    }

    public void setWaterAvailability(boolean waterAvailability) {
        this.waterAvailability = waterAvailability;
    }
}
