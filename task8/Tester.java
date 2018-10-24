package tests.task8;

public class Tester {
    //переменные класса, при этом использовать все изученные модификаторы
    public String name;
    public String surname;
    int expirienceInYears;
    protected String englishLevel;
    private static int salary;

    //Перегрузить в этом классе 3 конструктора
    public Tester() {
    }

    public Tester(String anyName) {
        this.name = anyName;
    }

    public Tester(String anyName, String anySurname) {
        this(anyName);
        this.surname = anySurname;
    }

    //Конструктор с наибольшим числом параметров сделать с уровнем доступа отовсюду
    public Tester(String anyName, String anySurname, int anyExpirience) {
        this(anyName, anySurname);
        this.expirienceInYears = anyExpirience;
    }

    // Геттеры всех переменных + сеттеры для englishLevel, salary
    // с уровнем доступа только внутри пакета

    void setEnglishLevel(String englishLevel) {
        this.englishLevel = englishLevel;
    }

    void setSalary(int salary) {
        this.salary = salary;
    }

    //статический метод
    public static void salaryWithoutTax() {
        double salaryWithoutTax = 0.8; // salary without tax
        double realSalary = salary * salaryWithoutTax;
        System.out.println("Salary without Tax: " + realSalary);
        System.out.println("Salary for 2 months: " + printSalaryFor2Months());
        //return realSalary;
    }

    //перегруженный метод
    public void personalInformationOutput(String name, String surname) {
        System.out.println(name + " " + surname);
    }

    public void personalInformationOutput(String name, String surname, String englishLevel) {
        System.out.println(name + " " + surname + " " + englishLevel);
    }

    public void personalInformationOutput(String name, String surname, String englishLevel, int salary) {
        System.out.println(name + " " + surname + " " + englishLevel + " " + salary);
    }

    //3. Написать метод с уровнем доступа только внутри класса, который будет возвращать salary*2
    private static int printSalaryFor2Months() {
        return salary * 2;
    }

    //4. Написать метод с уровнем доступа только внутри пакета,
    // который будет возвращать количество опыта в месяцах
    void expirienceInMonths() {
        System.out.println("Expirience in Months: " + expirienceInYears * 12);
    }

    //5. Написать метод с уровнем доступа внутри пакета и для наследников в других пакетах,
    // который выводит на экран имя и фамилию
    protected void printNameSurname() {

        System.out.println(this.name + " " + this.surname);
    }

    //6. Написать метод с уровнем доступа отовсюду, который в одну строку будет
    // выводить всю информацию о пользователе
    protected void printAllPersonalInfo() {
        System.out.println(name + " " + surname + " " + expirienceInYears + " "
                + englishLevel + " " + salary);
    }
}