package task7;

import java.util.InputMismatchException;
import java.util.Scanner;

//Ввести n строк с консоли. Вывести на консоль те строки, длинна которых меньше средней, также длиннув
public class LinesShorterThanAverage {
    public static void main(String[] args) {
        int n = 0;
        //Ввод количества строк с клавиатуры
        while (true) {
            System.out.println("Введите количество строк");
            Scanner stringCount1 = new Scanner(System.in);
            try {
                n = stringCount1.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Вы ввели не число");
            }
        }
        String[] str = new String[n];
        Scanner stringCount2 = new Scanner(System.in);

        //Инициализация массива str строками
        for (int i = 0; i < str.length; i++) {
            System.out.println("Введите строку " + (i + 1));
            str[i] = stringCount2.nextLine();
        }
        float average = 0f;
        //Считаем общую сумму длин строк
        for (String item : str) {
            average += (float) item.length();
        }
        //Считаем среднее арифметическое суммы длин этих строк
        average /= str.length;

        System.out.println("Средняя длина строки = (" + average + ")");
        //Выводим результат (выводит все строки имеющие длину ниже средней)
        for (int i = 0; i < n; i++) {
            if (str[i].length() < average) {
                System.out.println("Строка меньшая чем средняя длина: " + str[i]);
                System.out.println("Ee длина = " + str[i].length());
            }
        }
    }
}

