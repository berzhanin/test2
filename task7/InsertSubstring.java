package tests.task7;
//В тексте после k-го символа вставить подстроку
import java.io.*;

public class InsertSubstring {
    public static void insertWordIntoPosition() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Ваше предложение: ");
        String text1 = reader.readLine();
        StringBuffer typedText = new StringBuffer(text1);

        System.out.println("Вы ввели: " + typedText);
        System.out.print("Какое слово вставить: ");
        String insertWord = reader.readLine();

        System.out.print("Позиция в предложении: ");
        String Num = reader.readLine();
        int NoF = Integer.parseInt(Num);

        System.out.println("Результат: " + typedText.insert(NoF, insertWord));
    }

    public static void main(String args[]) throws Exception {

        InsertSubstring.insertWordIntoPosition();
    }
}
