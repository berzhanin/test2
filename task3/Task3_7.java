package tests.task3;

import java.util.Scanner;

public class Task3_7 {
    public static void main(String[] args) {
        //создать массив
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите размерность массива ");
        int size = scan.nextInt();
        int[] array = new int[size];

        //присвоить значения массиву
        assignValuesToArray(array);

        //вывод первоначального массива
        System.out.println("Ваш исходный массив: " );
        outputOfArrayElements(array);

        //пройти по массиву и поменять местами первый и последний, второй и предпоследний и т.д.
        changeArrayElements(array);

        //вывод измененного массива
        System.out.println("Ваш измененный массив: " );
        outputOfArrayElements(array);
    }
    //присвоить значения массиву
    public static int assignValuesToArray(int[] anyArray) {
        int i;
        for ( i = 0; i < anyArray.length-1; i++) {
            anyArray[i] = (int)(Math.random() * 10);
        }
        return anyArray[i];
    }

    //вывод всех элементов в обычном порядке
    public static void outputOfArrayElements(int[] anyArray) {
        for (int i = 0; i < anyArray.length-1; i++) {
            System.out.print(" " + anyArray[i]);
        }
        System.out.println("");
    }

    //пройти по массиву и поменять местами первый и последний, второй и предпоследний и т.д.
    public static int changeArrayElements(int[] anyArray) {
        int i;
        int j;
        for (i = 0, j = anyArray.length - 1; i < anyArray.length / 2 && j / 2 >= 0; i++, j--)
        {
            int tmp = anyArray[i];
            anyArray[i] = anyArray[j];
            anyArray[j] = tmp;
        }
        return anyArray[j];
    }
}
