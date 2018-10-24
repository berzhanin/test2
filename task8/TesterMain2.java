package tests.task8;

//7. В методе main другого класса (любого), лежащего в том же пакете что и Tester,
// создать объект класса Tester, используя любой из перегруженных конструкторов.
// продемонстрировать последовательный вызов всех методов класса Tester, если это возможно

import tests.task8.Tester;

import static tests.task8.Tester.salaryWithoutTax;

public class TesterMain2 {
    public static void main(String[] args) {

        //создать объекты с помощью конструктора передать значения: name, surname, expirienceInYears
        Tester tester1 = new Tester();
        Tester tester3 = new Tester("Toskani", "Paolo");
        Tester tester4 = new Tester("Toskani", "Paolo", 5);

        //перегруженный метод
        System.out.println();
        tester1.personalInformationOutput("Boss", "Hugo");
        tester1.personalInformationOutput("Boss", "Hugo", "intermediate");
        tester1.personalInformationOutput("Boss", "Hugo", "intermediate", 2500);

        //приватный метод класса Tester: printSalaryFor2Months
        tester4.setSalary(1000);
        salaryWithoutTax();

        //метод возвращает количество опыта в месяцах
        tester4.expirienceInMonths();

        //метод выводит на экран имя и фамилию
        tester3.printNameSurname();

        //метод выводит в одну строку всю информацию о пользователе
        tester4.setEnglishLevel("Pre-Intermediate");
        tester4.printAllPersonalInfo();
    }
}
