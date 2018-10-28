package tests.task13;

public class Person implements Comparable<Person> {
    public String name;
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Person obj) {

        int result = this.name.compareTo(obj.name);
        if (result != 0) {
            return result;
        }
        result = this.age - obj.age;
        if (result == 0) {
            return 0;
        }
        result = result / Math.abs(result); //делить result на его модуль
        return result;

    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
