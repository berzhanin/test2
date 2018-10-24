package tests.task3;

public class Task3_1 {
    public static void main(String[] args) {
        int size = 10;
        int[] array = new int[size];
        int m = 0;
        //присвоить значения массиву
        assignValuesToArray(array);

        //вывод всех элементов в обычном порядке
        outputOfArrayElements(array);

        //вывод всех элементов в обратном порядке
        outputArrayElementsReverse(array);
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

    //вывод всех элементов в обратном порядке
    public static void outputArrayElementsReverse(int[] anyArray){
        for (int j = anyArray.length - 1; j >= 0; j--) {
            System.out.print(" " + anyArray[j]);
        }
        System.out.println("");
    }
}
