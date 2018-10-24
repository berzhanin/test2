package tests.task2;

//пройти по массиву и поменять местами каждые 2 соседних элемента
public class Task2_6 {
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
        for (int i = 0; i < array.length-1; i = i +2) {
            int tmp = array[i];
            array[i] = array[i + 1];
            array[i + 1] = tmp;
            System.out.print(" " + array[i]+ " " + array[i+1]);
        }
    }
}


