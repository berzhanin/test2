package tests.task2;

public class Task2_10 {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        for (int i = 0; i < array.length; i++) {
            System.out.print(" " + array[i]);
        }
        System.out.println("");
        //Проверить, является ли массив возрастающей последовательностью
        int j = array[0];
        boolean result;
        for(int i = 0; i < array.length-1;i++){
            if(array[i] < array[i+1]){
                result = true;
            }
            else{
                result = false;
            }
        }
        if(true){
            System.out.println("Массив возрастающий");
        }
        else {
            System.out.println("Не возраст. ");
        }
    }
}
