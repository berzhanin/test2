package task14;

public class Massive {
    private String arrayName;
    private boolean isEmpty = true;
    private int countCharacter = 0;
    private double averageNumber;

    Massive(String anyArrayName) {
        this.arrayName = anyArrayName;
    }

    //проверить пустой ли массив
    public boolean arrayIsEmpty(int[] array) {
        if (array.length > 0) {
            isEmpty = false;
        }
        return isEmpty;
    }

    //Вывести название массива
    public void printArrayInfo(String arrayName) {
        System.out.println("Название: " + arrayName);
    }

    //Вывод элементов массива
    public void arrayPrint(int[] anyArray) {
        for (int i = 0; i < anyArray.length; i++) {
            System.out.print(" " + anyArray[i]);
        }
        System.out.println();
    }

    //посчитать количество элементов в массиве
    public int countElementsInArray(int[] anyArray) {
        countCharacter = 0;
        for (int i = 0; i < anyArray.length; i++) {
            countCharacter++;
        }
        return countCharacter;
    }

    //посчитать среднее число в массиве: сумму элементов делим на количество
    public double countAverageNumber(int[] anyArray, int countCharacter) {
        averageNumber = 0;
        if (countCharacter == 0) {
            return countCharacter;
        } else {
            for (int i = 0; i < anyArray.length; i++) {
                averageNumber += anyArray[i];
                countCharacter++;
            }
            return averageNumber / countCharacter;
        }

    }

}



