package tests.task3;

public class Task3_5 {
    public static void main(String[] args) {
        int size = 10;
        int[] array = new int[size];
        int m = 0;
        //присвоить значения массиву
        assignValuesToArray(array);

        //вывод всех элементов в обычном порядке
        outputOfArrayElements(array);

        //Найти индексы нулевых элементы массива
        indexesOfZeroElementsOfArray(array);

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

    //
    public static int indexesOfZeroElementsOfArray(int[] anyArray){
        int countNull = 0;
        int i;
        for (i = 0; i < anyArray.length-1; i++) {
            if(anyArray[i] == 0){
                System.out.println("Номер нулевых элементов " + i);
                countNull ++;
            }
        }
        if(countNull==0){
            System.out.println("Нулевых элементов не обнаружено!");
        }
        return anyArray[i];
    }

}
