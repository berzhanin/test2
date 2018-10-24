package tests.task3;

public class Task3_3 {
    public static void main(String[] args) {
        int size = 12;
        int[] array = new int[size];
        int m = 0;

        //присвоить значения массиву
        assignValuesToArray(array);

        //вывод всех элементов в обычном порядке
        outputOfArrayElements(array);

        //Каждый 3й элемент умножить на 2. Первый способ
        ElementOfArrayMultipliedByTwo(array);

        //Каждый 3й элемент умножить на 2. Второй способ
        ElementOfArrayMultipliedByTwo2(array);
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

    //Каждый 3й элемент умножить на 2. Первый способ
    public static int ElementOfArrayMultipliedByTwo(int[] anyArray) {
        int multi = 0;
        int i;
        for (i = 2; i < anyArray.length - 1; i = i + 3) {
            System.out.print("    ");
            multi = 2 * anyArray[i];
            System.out.print(" " + multi);
        }
        System.out.println();
        return anyArray[i];
    }

    //Каждый 3й элемент умножить на 2. Второй способ
    public static int ElementOfArrayMultipliedByTwo2(int[] anyArray) {
        int j = 2;
        int i;
        for (i = 2; i < anyArray.length - 1; i++) {
            System.out.print("  ");
            j++;
            if (j % 3 == 0) {
                int multi = 2 * anyArray[i];
                System.out.print(" " + multi);
            }
        }
        return anyArray[i];
    }
}
