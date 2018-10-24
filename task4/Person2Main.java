package tests.task4;

public class Person2Main {
    public static void main(String[] args) {
        Person2 person1 = new Person2();
        Person2 person2 = new Person2(12345);
        Person2 person3 = new Person2(54321, "Bob");
        Person2 person4 = new Person2(12345, "Pamela", 18);

        person1.print();
        person2.print();
        person3.print();
        person4.print();
    }
}
