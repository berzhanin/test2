package tests.task14;

public class TrayCatchExample {
    public static void main(String[] args) {
        int size = 4;
        int [] array = new int[size];
        try{
            System.out.println(size/0);
        }
        catch (ArrayIndexOutOfBoundsException | ArithmeticException ex){
            //System.out.println("Выход за пределы массива или");
            ex.printStackTrace();
            //System.out.println(ex.getMessage());
        }
        /*catch (ArithmeticException ex){
            System.out.println("Деление на ноль");
        }*/
        finally {
            System.out.println("Работа finally");
        }

    }
}
