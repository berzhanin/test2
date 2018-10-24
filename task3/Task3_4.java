package tests.task3;

public class Task3_4 {
    public static void main(String[] args) {
        int size = 20;
        int[] array = new int[size];
        int m = 0;
        //присвоить значения массиву
        assignValuesToArray(array);

        //вывод всех элементов в обычном порядке
        outputOfArrayElements(array);

        //Найти нулевые элементы массива
        zeroArrayElements(array);
    }

    //присвоить значения массиву
    public static int assignValuesToArray(int[] anyArray) {
        int i;
        for (i = 0; i < anyArray.length-1; i++) {
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

    //Найти нулевые элементы массива
    public static int zeroArrayElements(int[] anyArray) {
        int countNull = 0;
        int i;
        for (i = 0; i < anyArray.length-1; i++) {
            if (anyArray[i] == 0) {
                countNull++;
            }
        }
        if (countNull == 0) {
            System.out.println("Нулевых элементов не обнаружено!");
        } else {
            System.out.println("Количество нулевых элементов " + countNull);
        }
        return anyArray[i];
    }


}
