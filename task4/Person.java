package tests.task4;

public class Person {
    private String name;
    private String surname;
    private int age;
    private int phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    //метод выводит всю информацию о пользователе
    public void AllInformation() {
        System.out.println(getSurname() + " " + getName() + " " + getAge() + " " + getPhone());
    }

    //метод выводит только имя и фамилию пользователя
    public void OutputNameSurname() {
        System.out.println(getSurname() + " " + getName());
    }

    //возвращает значения true/false в зависимости от age объекта(>18)
    public boolean isAdult() {
        boolean i;
        if (getAge() >= 18) {
            System.out.println("Пользователь совершеннолетний");
            i = true;
        } else {
            System.out.println("Пользователь несовершеннолетний");
            i = false;
        }
        return i;
    }
}
