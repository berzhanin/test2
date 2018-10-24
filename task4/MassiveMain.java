package tests.task4;

public class MassiveMain {
    public static void main(String[] args) {
        int[] array = new int[10];
        for (int i=0; i< array.length-1;i++) {
            array[i] = (int)(Math.random()*10);
        }
        Massive massive = new Massive();
        System.out.println("Вывод массива: ");
        massive.printMassiveAsLine(array);
        System.out.println();

        System.out.println("Вывод массива в обратном порядке: ");
        massive.printReverseMassiveAsLine(array);
        System.out.println();

        System.out.println("Сумма элементов массива: ");
        massive.getSumOfElements(array);
        System.out.println();

        System.out.println("Массив умноженный на три: ");
        massive.multiplyBy3(array);
        System.out.println();
        massive.multiplyBy3_2(array);
    }
}
