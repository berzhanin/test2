package tests.task2;

public class Task2_3 {
    public static void main(String[] args) {
        int size = 12;
        int [] array = new int[size];
        int m=0;
        //присвоить значения массиву
        for(int i=0;i<size;i++){
            array[i]= m + (int) (Math.random()*10);
        }
        //вывод всех элементов в обычном порядке
        for(int i=0;i<size;i++){
            System.out.print( " " + array[i]);
        }
        System.out.println("");
        //Каждый 3й элемент умножить на 2. Первый способ
        int multi = 0;
        for(int i=2;i<size;i=i+3){
            System.out.print("    ");
            multi = 2 * array[i];
            System.out.print( " " + multi);
        }
        System.out.println( );
        //Каждый 3й элемент умножить на 2. Второй способ
        int j=2;
        for(int i=2;i<size;i++){
            System.out.print("  ");
            j++;
            if( j%3 == 0){
                multi = 2 * array[i];
                System.out.print( " " + multi);
            }

        }

    }
}
