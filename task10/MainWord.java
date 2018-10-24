package tests.task10;

//class for testing classes Word, Sentence, Paragraph and interface IWord

import java.util.Scanner;

import static tests.task10.Word.printStaticMethod;

public class MainWord {
    public static void main(String[] args) {

        //приведение типов
        String strInt = "123";
        String strDouble = "123.24";
        int x;
        double y;

        x = Integer.parseInt(strInt);
        y = Double.parseDouble(strDouble);
        System.out.println(x + y);
        strInt = String.valueOf(x + 10);
        strDouble = String.valueOf(y + 77);
        System.out.println("strInt = " + strInt);
        System.out.println("strDouble = " + strDouble);

        //Arrays
        Scanner in = new Scanner(System.in);
        System.out.println("Введите размер массива: ");
        String size = in.nextLine();
        double[] array = new double[Integer.parseInt(size)];
        //Заполнить массив числами от 1 до "размер массива"
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        //output array
        for (double anArray : array) {
            System.out.print(" " + anArray);
        }

        //object oriented programming
        System.out.println("\nFurther: Encapsulation, polymorphism, inheritance");
        Word word1 = new Word("Paragraph", "Sentence", "Word",
                22, 4);
        word1.printClassName();
        word1.printSuperClass();
        printStaticMethod();
        word1.printAllInfo();

        //comparing an object word2 with an object word1
        Word word2 = new Word("Paragraph", "Sentence", "Word",
                22, 4);
        System.out.println(word2.equals(word1));
        System.out.println(word1.hashCode());
        System.out.println(word2.hashCode());
        System.out.println(word1.toString());
        System.out.println(word2.toString());

        //count words in paragraph
        word1.countWordsInParagraph();

        //count numbers of punctuation marks
        String text1 = "Необходимо: подсчитать. колич,ество. зна,ков пре:пи:на:ния.";
        word1.countNumberOfPunctuationMarks(text1);

        //count spaces in text
        word1.countNumberOfSpace(text1);

        //replace characters in the text with a sign %
        StringBuffer text2;
        text2 = new StringBuffer("Nurmagomedov soundly defeated McGregor via fourth-round submission to " +
                                 "retain his UFC lightweight title \nwith a dominant performanc.");
        word2.replaceCharactersInText(text2);

    }

}
