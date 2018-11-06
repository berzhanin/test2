package tests.task15;

import java.util.*;

public class Massive {
    private int id;
    private String name;
    private int age;
    private String sex;
    private static Map<Integer, Massive> allUsers;
    private static int countId = 0;

    //constructor
    public Massive(String name, int age, String sex) {
        if (allUsers == null) {
            allUsers = new HashMap<>();
        }
        this.name = name;
        this.age = age;
        this.sex = sex;

        if (!hasUser()) {
            countId++;
            this.id = countId;
            allUsers.put(id, this);
        }
    }

    private boolean hasUser(){
        for (Massive user : allUsers.values()){
            if (user.equals(this) && user.hashCode() == this.hashCode()){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Massive massive = (Massive) obj;
        return age == massive.age &&
                Objects.equals(name, massive.name) &&
                sex == massive.sex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, sex);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }

    //метод возвращает лист-массив всех users
    public static List<Massive> getAllUsers(){
        return new ArrayList<>(allUsers.values());
    }

    //перегруженный метод возвращает список в зависимости от пола
    public static List<Massive> getAllUsers(String sex){
        List<Massive> listAllUsers = new ArrayList<>();
        for (Massive user : allUsers.values()){
            if (user.sex == sex){
                listAllUsers.add(user);
            }
        }
        return listAllUsers;
    }

    //методы считают количество users и количество users в зависимости от пола
    public static int getHowManyUsers(){
        return allUsers.size();
    }

    public static int getHowManyUsers(String sex){
        return getAllUsers(sex).size();
    }

    //считает общую сумму по возрасту и по полу
    public static int getAllAgeUsers(){
        int countAge = 0;
        for (Massive user : allUsers.values()){
            countAge += user.age;
        }
        return countAge;
    }

    public static int getAllAgeUsers(String sex){
        int countAge = 0;
        for (Massive user : getAllUsers(sex)){
            countAge += user.age;
        }
        return countAge;
    }

    //считает средний возраст у всех и по полу
    public static int getAverageAgeOfAllUsers(){
        return getAllAgeUsers() / getHowManyUsers();
    }

    public static int getAverageAgeOfAllUsers(String sex){
        return getAllAgeUsers(sex) / getHowManyUsers(sex);
    }

    //метод создает exception
    public int[] myException(){
        int [] array = {1,2,3};
        try {
            array[array.length] = 5;
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Выход за пределы массива!!!");
        }
        return array;
    }

    public static class MassiveMain {
        public static void main(String[] args) {
            String lineDelimiter = "================================================";
            new Massive("Bob", 35, "MALE");
            new Massive("Helena", 34, "FEMALE");
            new Massive("Vladimir", 5, "MALE");
            new Massive("Sarah", 17, "FEMALE");


            System.out.println("Все пользователи:");
            getAllUsers().forEach(System.out::println);
            System.out.println("Все пользователи: MALE");
            getAllUsers("MALE").forEach(System.out::println);
            System.out.println("Все пользователи: FEMALE");
            getAllUsers("FEMALE").forEach(System.out::println);
            System.out.println(lineDelimiter);
            System.out.println("       всех пользователей: " + getHowManyUsers());
            System.out.println("  всех пользователей MALE: " + getHowManyUsers("MALE"));
            System.out.println("всех пользователей FEMALE: " + getHowManyUsers("FEMALE"));
            System.out.println(lineDelimiter);
            System.out.println("       общий возраст всех пользователей: " + getAllAgeUsers());
            System.out.println("  общий возраст всех пользователей MALE: " + getAllAgeUsers("MALE"));
            System.out.println("общий возраст всех пользователей FEMALE: " + getAllAgeUsers("FEMALE"));
            System.out.println(lineDelimiter);
            System.out.println("       средний возраст всех пользователей: " + getAverageAgeOfAllUsers());
            System.out.println("  средний возраст всех пользователей MALE: " + getAverageAgeOfAllUsers("MALE"));
            System.out.println("средний возраст всех пользователей FEMALE: " + getAverageAgeOfAllUsers("FEMALE"));
            System.out.println(lineDelimiter);
        }
    }
}
