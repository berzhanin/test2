package tests.task2;

public class Task2_1 {
    public static void main(String[] args) {
        int size = 10;
        int[] array = new int[size];
        int m = 0;

        //присвоить значения массиву
        for (int i = 0; i < size; i++) {
            array[i] = m + (int) (Math.random() * 10);
        }
        //вывод всех элементов в обычном порядке
        for (int i = 0; i < size; i++) {
            System.out.print(" " + array[i]);
        }
        System.out.println("");
        //вывод всех элементов в обратном порядке
        for (int j = array.length - 1; j >= 0; j--) {
            System.out.print(" " + array[j]);
        }
    }
}
