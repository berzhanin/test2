package tests.task2;

public class TwoDimensionalArray {
    public static void main(String[] args) {
        int m = 3;
        int n = 5;
        int [][] arr = new int[m][n];
        //заполнить массив
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++){
                arr[i][j] = i + 1;
                arr[i][j] = j + 1;
            }
        }
        System.out.println("Вывод массива в обычном порядке: ");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++){
                System.out.print(" " + arr[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("Вывод массива в обратном порядке: ");
        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--){
                System.out.print(" " + arr[i][j]);
            }
            System.out.println();
        }
        System.out.println("");

        //Найти минимальный-максимальный элементы и вывести
        int max = arr[0][0];
        int min = arr[0][0];

        for(int i = 0; i < arr.length; i ++){
            for (int j = 0; j < arr[i].length; j ++) {
                if (arr[i][j] > max) {
                    max = arr[i][j];
                }
                if (arr[i][j] < min) {
                    min = arr[i][j];
                }
            }
        }
        System.out.println("min element: " + min);
        System.out.println("max element: " + max);
    }
}
