package tests.task14;

public class Person {
    private int age;

    Person(int anyAge){
        this.age = 200/anyAge;
    }

    public int getAge() {
        return age;
    }
/*
    public void setAge(int age) throws NegativeAgeExeption{
        if(age < 0){
            throw new NegativeAgeExeption();
        }
        this.age = age;
    }*/
}
