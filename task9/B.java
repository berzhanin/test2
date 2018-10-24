package task9;

public class B extends A {

    B(){
        System.out.println("class B");
    }

    @Override
    public void printInfo() {
        System.out.println("ClassName: " + className);
    }
}
