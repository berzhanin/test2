package tests.task2;

//Циклически сдвинуть массив вправо на 2 элемента
public class Task2_12 {
    public static void main(String[] args) {
        int shift = 2;
        int size = 12;
        int [] mas = new int [size];
        int [] mas1 = new int [size+shift];
        System.out.println("Заполняем массив случайными числами");
        for (int i = 0; i < mas.length; i++){
            mas [i] = (int)(Math.random()*10);
            System.out.print(" "+ mas [i]);
        }
        System.out.println();
        System.out.println("Смещаем вправо на k элементов");
        for (int i = 0; i < mas.length; i++){
            mas1 [i+shift] = mas[i];
            mas[i] = mas1[i];
            System.out.print(" " + mas [i]);
        }
    }
}
