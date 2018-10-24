package tests.task3;

public class Task3_2 {
    public static void main(String[] args) {
        int size = 10;
        int[] array = new int[size];
        int m = 0;

        //присвоить значения массиву
        assignValuesToArray(array);

        //вывод всех элементов в обычном порядке
        outputOfArrayElements(array);

        //Найти произведение всех элементов
        productOfArrayElements(array);
    }

    //присвоить значения массиву
    public static int assignValuesToArray(int[] anyArray) {
        int i;
        for (i = 0; i < anyArray.length - 1; i++) {
            anyArray[i] = (int) (Math.random() * 10);
        }
        return anyArray[i];
    }

    //вывод всех элементов в обычном порядке
    public static void outputOfArrayElements(int[] anyArray) {
        for (int i = 0; i < anyArray.length; i++) {
            System.out.print(" " + anyArray[i]);
        }
        System.out.println("");
    }

    //найти произведение элементов массива
    public static int productOfArrayElements(int[] anyArray) {
        System.out.println("Произведение всех элементов массива: ");
        int res = anyArray[0];
        int i;
        for (i = 0; i < anyArray.length - 1; i++) {
            res = res * anyArray[i];
        }
        System.out.print(" " + res);
        return anyArray[i];
    }
}
