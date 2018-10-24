package tests.task7;
//ввести n строк с консоли, найти самую короткую и самую длинную строки.
// Вывести найденные строки и их длинну.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SearchBigShortString {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите число строк:");
        int countString = Integer.parseInt(reader.readLine());
        String shortString = null;
        String bigString = null;

        for (int i = 0; i < countString; i++) {
            System.out.println("Введите строку номер " + (i+1));
            String currentString = reader.readLine();
            //определение самой короткой строки
            if (shortString == null || currentString.length() < shortString.length()) {
                shortString = currentString;
            }
            //определение самой длинной строки
            if (bigString == null || currentString.length() > bigString.length()) {
                bigString = currentString;
            }
        }
        System.out.println("Самая короткая строка = " + shortString);
        System.out.println("Ее длина равна " + shortString.length());
        System.out.println("Самая длинная строка = " + bigString);
        System.out.println("Ее длина равна " + bigString.length());
    }
}
