package tests.task2;

public class Task2_5 {
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
        //Найти нулевые элементы массива
        int countNull = 0;
        for (int i = 0; i < size; i++) {
            if(array[i] == 0){
                System.out.println("Номер нулевых элементов " + i);
                countNull ++;
            }
        }
        if(countNull==0){
            System.out.println("Нулевых элементов не обнаружено!");
        }

    }
}
