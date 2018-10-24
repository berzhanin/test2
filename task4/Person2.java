package tests.task4;

public class Person2 {
    int age;
    String name;

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    int id;

    public Person2() {
    }

    public Person2(int anyId) {
        this.id = anyId;
    }

    public Person2(int anyId, String anyName) {
        this(anyId);
        this.name = anyName;
    }

    public Person2(int anyId, String anyName, int anyAge) {
        this(anyId, anyName);
        this.age = anyAge;
    }

    public void print() {
        System.out.println(this.id + " " + this.name + " " + this.age);
    }
}
