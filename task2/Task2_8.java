package tests.task2;

public class Task2_8 {
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
        //Найти минимальный-максимальный элементы и вывести
        int max = array[0];
        int min = array[0];
        for(int i = 0; i != array.length; i ++){
            if(array[i] > max){
                max = array[i];
            }
            if(array[i] < min){
                min = array[i];
            }
        }
        System.out.println("min element: " + min);
        System.out.println("max element: " + max);
        System.out.println(" ");
    }
}
