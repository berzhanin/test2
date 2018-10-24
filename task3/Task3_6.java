package tests.task3;

public class Task3_6 {
    public static void main(String[] args) {
        int[] array = new int[10];
        int m = 0;
        //присвоить значения массиву
        assignValuesToArray(array);

        //вывод всех элементов в обычном порядке
        outputOfArrayElements(array);

        //пройти по массиву и поменять местами каждые 2 соседних элемента
        changeArrayElements(array);
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
        for (int i = 0; i < anyArray.length-1; i++) {
            System.out.print(" " + anyArray[i]);
        }
        System.out.println("");
    }

    //пройти по массиву и поменять местами каждые 2 соседних элемента
    public static int changeArrayElements(int[] anyArray) {
        int i;
        for (i = 0; i < anyArray.length-2; i = i + 2) {
            int tmp = anyArray[i];
            anyArray[i] = anyArray[i + 1];
            anyArray[i + 1] = tmp;
            System.out.print(" " + anyArray[i]+ " " + anyArray[i+1]);
        }
        return anyArray[i];
    }
}
