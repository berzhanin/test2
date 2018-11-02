package task14;

public class MassiveExample {
    public static void main(String[] args) {

        Massive massive1 = new Massive("MyArray1");
        massive1.printArrayInfo("MyArray1");
        int[] array1 = {1, 2, 3, 4, 5};
        try {
            array1[5] = 6;
            int[] array3 = {};
            massive1.countAverageNumber(array3, array3.length);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Выход за пределы массива!");
        } catch (ArithmeticException e) {
            System.out.println("Деление на ноль!");
        }

        try {
            int[] array3 = {};
            array1[6] = 12;
            massive1.countAverageNumber(array3, array3.length);
        } catch (ArrayIndexOutOfBoundsException | ArithmeticException e) {
            System.out.println("Выход за пределы массива или деление на ноль!");
        }

        System.out.println("Массив пустой?");
        int[] array3 = {};
        System.out.println("Массив array3 " + massive1.arrayIsEmpty(array3));
        System.out.println("Массив array1 " + massive1.arrayIsEmpty(array1));
        massive1.arrayPrint(array1);
        System.out.println("Размер массива: " + massive1.countElementsInArray(array1));
        System.out.println(massive1.countAverageNumber(array1, array1.length));

        Massive massive2 = new Massive("MyArray2");
        massive2.printArrayInfo("MyArray2");
        int[] array2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        try {
            array2[11] = 11;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Выход за пределы массива!");
        } finally {
            System.out.println("Обработка кода после ошибки:");
        }

        System.out.println("Массив пустой?");
        System.out.println(massive2.arrayIsEmpty(array2));
        massive2.arrayPrint(array2);
        System.out.println("Размер массива: " + massive2.countElementsInArray(array2));
        System.out.println(massive2.countAverageNumber(array2, array2.length));
    }
}
