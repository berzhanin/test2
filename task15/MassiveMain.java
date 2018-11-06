package tests.task15;

public class MassiveMain {
    public static void main(String[] args) {
        new Massive("Евгений", 35, "MALE");
        new Massive("Марина", 34, "FEMALE");
        new Massive("Алина", 7, "FEMALE");
        String lineDelimiter = "================================================";

        System.out.println("Все пользователи:");
        Massive.getAllUsers().forEach(System.out::println);
        System.out.println("Все пользователи: MALE");
        Massive.getAllUsers("MALE").forEach(System.out::println);
        System.out.println("Все пользователи: FEMALE");
        Massive.getAllUsers("FEMALE").forEach(System.out::println);
        System.out.println(lineDelimiter);
        System.out.println("       всех пользователей: " + Massive.getHowManyUsers());
        System.out.println("  всех пользователей MALE: " + Massive.getHowManyUsers("MALE"));
        System.out.println("всех пользователей FEMALE: " + Massive.getHowManyUsers("FEMALE"));
        System.out.println(lineDelimiter);
        System.out.println("       общий возраст всех пользователей: " + Massive.getAllAgeUsers());
        System.out.println("  общий возраст всех пользователей MALE: " + Massive.getAllAgeUsers("MALE"));
        System.out.println("общий возраст всех пользователей FEMALE: " + Massive.getAllAgeUsers("FEMALE"));
        System.out.println(lineDelimiter);
        System.out.println("       средний возраст всех пользователей: " + Massive.getAverageAgeOfAllUsers());
        System.out.println("  средний возраст всех пользователей MALE: " + Massive.getAverageAgeOfAllUsers("MALE"));
        System.out.println("средний возраст всех пользователей FEMALE: " + Massive.getAverageAgeOfAllUsers("FEMALE"));
        System.out.println(lineDelimiter);
    }
}
