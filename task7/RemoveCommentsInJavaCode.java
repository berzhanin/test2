package tests.task7;
//Из кода Java файли sourceJava.txt удалить все комментарии
// и записать в source_noCommentsJava.txt
import java.util.*;
import java.io.File;
import java.io.*;
import java.io.FileNotFoundException;

public class RemoveCommentsInJavaCode {
    public static void main(String[] args) throws FileNotFoundException {
        String inputString = "";
        String replaseString1 = "";
        String replaseString2 = "";
        String resultString = "";
        int ifVariable = 0;
        Scanner in = new Scanner(new File("D://java_code//src//task7//sourceJava.txt"));
        PrintWriter out = new PrintWriter("D://java_code//src//task7//noCommentsJava.txt");

        while (in.hasNext()) {
            inputString += in.nextLine() + "\r\n";
        }

        replaseString1 = inputString.replaceAll("//", "\n//");

        for (int i = 0; i < replaseString1.length(); i++) {
            if ((replaseString1.charAt(i) == '/') && (replaseString1.charAt(i + 1) == '/')) {
                ifVariable = 1;
            }
            if ((ifVariable == 1) && (replaseString1.charAt(i) == '\n')) {
                ifVariable = 0;
            }
            if (ifVariable == 0) {
                replaseString2 = replaseString2 + replaseString1.charAt(i);
            }
        }

        for (int i = 0; i < replaseString2.length(); i++) {
            if ((replaseString2.charAt(i) == '/') && (replaseString2.charAt(i + 1) == '*')) {
                ifVariable = 1;
            }
            if ((ifVariable == 1) && (replaseString2.charAt(i) == '*') && (replaseString2.charAt(i + 1) == '/')) {
                ifVariable = 0;
                i = i + 2;
            }
            if (ifVariable == 0) {
                resultString = resultString + replaseString2.charAt(i);
            }
        }
        System.out.println(resultString);
        out.println(resultString);
        out.close();
        in.close();
    }
}
