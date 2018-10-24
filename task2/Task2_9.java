package tests.task2;

public class Task2_9 {
    public static void main(String[] args) {
        int[] array = new int[10];
        int m = 0;
        //присвоить значения массиву
        for (int i = 0; i < array.length; i++) {
            array[i] = m + (int) (Math.random() * 10);
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(" " + array[i]);
        }
        System.out.println("");
        //найти номер минимального-максимального элементов и вывести
        int indexMax = 0;
        int indexMin = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[indexMax]) {
                indexMax = i;
            }
            else if (array[i] < array[indexMin]) {
                indexMin = i;
            }
        }
        System.out.println("Index max: " +indexMax);
        System.out.println("Index min: " + indexMin);
        System.out.println(" ");
    }
}
