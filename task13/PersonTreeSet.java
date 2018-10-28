package tests.task13;

import java.util.TreeSet;

public class PersonTreeSet {
    public static void main(String[] args) {
        Person person1 = new Person();
        Person person2 = new Person();
        Person person3 = new Person();
        person1.setName("Eva");
        person1.setAge(11);
        person2.setName("Eva");
        person2.setAge(33);
        person3.setAge(24);
        person3.setName("Constantin");
        TreeSet<Person> treeSet = new TreeSet<Person>();
        treeSet.add(person1);
        treeSet.add(person2);
        treeSet.add(person3);

        treeSet.stream().forEach(System.out::println);

        System.out.println(person1.compareTo(person2));
    }
}
