package tests.task4;

public class StaticExampleMain {
    public static void main(String[] args) {
        StaticExample staticExample1 = new StaticExample();
        System.out.println(staticExample1.PI);

        StaticExample staticExample2 = new StaticExample();
        staticExample1.PI = 2;

        System.out.println(staticExample2.PI);
        System.out.println(staticExample1.PI);
    }
}