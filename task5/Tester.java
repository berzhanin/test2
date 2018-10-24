package tests.task5;

import java.io.PrintStream;

public class Tester {
    //переменные класса
    private String name;
    private String surname;
    private int expirienceInYears;
    private String englishLevel;
    private int salary;

    //конструкторы класса
    public Tester() {
    }

    public Tester(String anyName) {
        this.name = anyName;
    }

    public Tester(String anyName, String anySurname) {
        this(anyName);
        this.surname = anySurname;
    }

    public Tester(String anyName, String anySurname, int anyExpirience) {
        this(anyName, anySurname);
        this.expirienceInYears = anyExpirience;
    }

    //Геттеры всех переменных + сеттеры для englishLevel, salary


    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getExpirienceInYears() {
        return expirienceInYears;
    }

    public String getEnglishLevel() {
        return englishLevel;
    }

    public void setEnglishLevel(String englishLevel) {
        this.englishLevel = englishLevel;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    //метод выводит информацию на экран
    public void print() {
        System.out.println(this.name + " " + this.surname + " " + this.expirienceInYears);
    }

    //статический метод
    public static double salaryWithoutTax(int anySalary){
        double realSalary = anySalary * 0.8;
        System.out.printf("Salary without Tax: " + realSalary);
        return realSalary;
    }

    //перегруженный метод
    public void personalInformationOutput(String name,String surname){
        System.out.println(name + " " + surname);
    }

    public void personalInformationOutput(String name,String surname,String englishLevel){
        System.out.println(name + " " + surname + " " +englishLevel);
    }

    public void personalInformationOutput(String name,String surname,String englishLevel,int salary){
        System.out.println(name + " " + surname + " " +englishLevel + " " + salary);
    }
}
