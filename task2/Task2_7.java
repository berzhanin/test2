package tests.task2;

//пройти по массиву и поменять местами первый и последний, второй и предпоследний и т.д.
import java.util.Scanner;
public class Task2_7{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите размерность массива ");
        int size = scan.nextInt();
        int[] array = new int[size];
        int i;
        for ( i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random() * 10);
        }
        System.out.println("Ваш исходный массив: " );
        for ( i = 0; i < array.length; i++) {
            System.out.print(" " + array[i] );
        }
        System.out.println();
        int j;
        for (i = 0, j = array.length - 1; i < array.length / 2 && j / 2 >= 0; i++, j--)
        {
            int tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
        }
        System.out.println("Ваш измененный массив: " );
        for ( i = 0; i < array.length; i++) {
            System.out.print(" " + array[i] );
        }
    }
}
