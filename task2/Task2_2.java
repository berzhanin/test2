package tests.task2;

public class Task2_2 {
    public static void main(String[] args) {
        int size = 10;
        int [] array = new int[size];
        int m=0;

        //присвоить значения массиву
        for(int i=0;i<size;i++){
            array[i]= m + (int) (Math.random()*10);
        }
        //вывод всех элементов в обычном порядке
        for (int i = 0; i < size; i++) {
            System.out.print(" " + array[i]);
        }
        System.out.println();
        //Найти произведение всех элементов
        System.out.println("Произведение всех элементов массива: ");
        int res = array[0];
        for(int i=0;i<size;i++){
            res = res * array[i];
        }
        System.out.print( " " + res);
    }
}
