package tests.task3;

    import java.util.Scanner;

    public class Task3 {
        public static void main(String[] args) {

            Scanner in = new Scanner(System.in);
            System.out.println("Введите первое целое число: ");
            int c = in.nextInt();
            Scanner in2 = new Scanner(System.in);
            System.out.println("Введите второе целое число: ");
            int d = in.nextInt();

            int result = moreLess(c, d);
            printResult("moreLess:", result);

            boolean result2 = evenOddNumber(c);
            printResult("evenOddNumber with the first number: ", result2);
            boolean result3 = evenOddNumber(d);
            printResult("evenOddNumber with the second number: ", result3);


            int result4 = squareOfNumber(c);
            printResult("squareOfNumber with the first number: ", result4);
            int result5 = squareOfNumber(d);
            printResult("squareOfNumber with the second number: ", result5);

            int result6 = cubeNumber(c);
            printResult("cubeNumber with the first number:", result6);
            int result7 = cubeNumber(d);
            printResult("cubeNumber with the second number:", result7);

        }
        //Найти минимальное число из 2 чисел, вернуть минимальное
        public static int moreLess(int a, int b) {
            if(a<b){
                return a;
            }
            else {
                return b;
            }
        }
        //Проверить четное число или нечетное, вернуть boolean результат
        public static boolean evenOddNumber(int a) {
            boolean i;
            if (a%2==0){
                i= true;
            }
            else {
                i = false;
            }
            return i;
        }

        public static int squareOfNumber(int a) {
            return a * a;
        }

        public static int cubeNumber(int a) {
            return a * a * a;
        }

        public static void printResult(String operation, boolean result) {
            System.out.println("The result of operation " + operation + " is " + result);
        }

        public static void printResult(String operation, int result) {
            System.out.println("The result of operation " + operation + " is " + result);
        }
}

