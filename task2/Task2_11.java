package tests.task2;

//заменить все элементы массива на полусумму соседних элементов
import java.util.Scanner;
public class Task2_11{
    public static void main(String[] args) {
        System.out.println("Введите количество чисел : ");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];

        System.out.println("Введите " + n +" чисел.");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }
        for (int i = 1; i < arr.length-1; i++) {
            arr[i] = (arr[i - 1] + arr[i + 1]) / 2;
            System.out.print(" " +arr[i]);
        }
    }
}

