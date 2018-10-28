package tests.task9;

public class D extends C {

    int age = 199;

    D(){
        System.out.println("class D");
    }

    @Override
    public void age() {
        System.out.println("Age:" + age);
    }

    @Override
    public void printInfo() {
        System.out.println("ClassName: " + className);
    }
}
