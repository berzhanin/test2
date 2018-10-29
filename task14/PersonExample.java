package tests.task14;

public class PersonExample {
    public static void main(String[] args) {

        try {
            //person.setAge(100);
            Person person = new Person(0);
        }
        catch (ArithmeticException ex){
            System.out.println(ex.getMessage());
        }
        finally {
            Person person1 = new Person(20);
            System.out.println(person1.getAge());
        }
    }
}
