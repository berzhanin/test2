package tests.task4;

public class PersonMain {
    public static void main(String[] args) {
        Person person = new Person();
        //задать значения для полей
        person.setName("Proctor");
        person.setSurname("Bob");
        person.setAge(73);
        person.setPhone(2221846);

        System.out.println("Вывести всю инф. о пользователе: ");
        person.AllInformation();

        System.out.println("Вывести только имя и фамилию: ");
        person.OutputNameSurname();

        System.out.println("Проверка на совершеннолетие: ");
        person.isAdult();

    }
}
