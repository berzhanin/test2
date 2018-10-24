package tests.task5;

import static tests.task5.Tester.salaryWithoutTax;

public class TesterMain {
    public static void main(String[] args) {

        //создать объекты с помощью конструктора передать значения: name, surname, expirienceInYears
        Tester tester1 = new Tester();
        Tester tester2 = new Tester("Toskani");
        Tester tester3 = new Tester("Toskani","Paolo");
        Tester tester4 = new Tester("Toskani","Paolo",12);

        //вывод на экран переданных конструктору переменных
        tester1.print();
        tester2.print();
        tester3.print();
        tester4.print();

        //static метод
        salaryWithoutTax(1000);

        //перегруженный метод
        System.out.println();
        tester1.personalInformationOutput("Boss","Hugo");
        tester1.personalInformationOutput("Boss","Hugo","intermediate");
        tester1.personalInformationOutput("Boss","Hugo","intermediate",2500);

    }
}
