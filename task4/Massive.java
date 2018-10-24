package tests.task4;

public class Massive {
    //метод принимает массив и печатает его в одну строку в консоли
    public void printMassiveAsLine(int[] anyMassive) {
        for (int i : anyMassive) {
            System.out.print(" " + anyMassive[i]);
        }
    }

    //метод принимает массив и печатает его в обратном порядке
    public void printReverseMassiveAsLine(int[] anyMassive) {
        for (int i = anyMassive.length - 1; i >= 0; i--) {

            System.out.print(" " + anyMassive[i]);
        }
    }

    //метод принимает массив и возвращает сумму его элементов
    public int getSumOfElements(int[] anyMassive) {
        int sum = 0;
        for (int i : anyMassive) {

            sum = sum + anyMassive[i];
        }
        System.out.println(sum);
        return sum;
    }

    //метод принимает массив, умножает каждый элемент на 3 и возвращает умноженный массив
    public int[] multiplyBy3(int[] anyMassive) {
        int i = 0;
        int multi = 0;
        for (i = 0; i < anyMassive.length - 1; i++) {
            multi = 3 * anyMassive[i];
            System.out.print(" " + multi);
        }
        return new int[i];
    }
    //метод принимает массив, умножает каждый элемент на 3 и возвращает умноженный массив
    public int[] multiplyBy3_2(int[] anyMassive) {
        int i = 0;
        int multi = 0;
        for (i = anyMassive.length - 1; i > 0 ; i--) {
            multi = 3 * anyMassive[i];
            System.out.print(" " + multi);
        }
        return new int[i];
    }
}
