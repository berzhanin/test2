package tests.task10;

import java.util.HashMap;
import java.util.Scanner;

public class Word extends Sentence implements IWord {

    //variable
    private String className;
    private int countWords;
    private int countSentence;


    //constructors
    Word(String anyClassName, String anyName, String className, int countWords, int countSentence) {
        super(anyClassName, anyName); // вывоз конструктора одного родителя и вышестоящего родителя
        this.className = className;
        this.countWords = countWords;
        this.countSentence = countSentence;
    }

    //methods class Object override: equals(), hashCode(), toString()
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (null == obj) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }

        Word word = (Word) obj;
        if (className != word.className) {
            return false;
        }
        if (null == className) {
            return (className == word.className);
        } else if (!className.equals(word.className)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (int) (31 * countWords + ((null == className) ? 0 : className.hashCode()));
    }

    public String toString() {
        return getClass().getName() + " @" + "className: " + className;
    }

    //вывод информации, которую передаем в конструктор
    public void printAllInfo(){
        System.out.println("Superclass: " + super.paragraphClassName + "\nSubclass: " +
                super.sentenceClassName + "\nSubclass: " + this.className + "\nКоличество слов: " +
                countWords + "\nКоличество предложений: " + countSentence);
    }

    //count words in text
    public int countWordsInParagraph() {
        System.out.println("The method counts the number of words entered.\n");
        System.out.println("Введите текст: ");
        Scanner in = new Scanner(System.in);
        String string = in.nextLine();

        String[] words = string.split("\\s+");
        HashMap<String, Integer> wordToCount = new HashMap<>();
        for (String word : words) {
            if (!wordToCount.containsKey(word)) {
                wordToCount.put(word, 0);
            }
            wordToCount.put(word, wordToCount.get(word) + 1);
        }
        for (String word : wordToCount.keySet()) {
            System.out.println(word + " " + wordToCount.get(word));
        }
        return 0;
    }

    //replace characters in the text with a sign %
    public static void replaceCharactersInText(StringBuffer text2) {
        String insertSubstring = "%";
        System.out.println(text2);
        int i = 0;
        int position = 0;
        System.out.println("Введите какую буквы Вы хотите заменить на %: ");
        Scanner in = new Scanner(System.in);
        String string = in.nextLine();
        while ((position = text2.indexOf(string, i)) != -1) {
            position += 3;
            text2.insert(position, insertSubstring);
            i = position;
        }
        System.out.println("\n\n" + text2);
    }

    //static method
    public static void printStaticMethod() {
        System.out.println("Hallo. I'm static method!");
    }

    //implementation of abstracted class methods and interface
    @Override
    public void printSuperClass() {
        System.out.println("SuperClass: " + super.sentenceClassName);
    }

    @Override
    public void printClassName() {
        System.out.println("Class name: " + className);

    }

    @Override
    public int countNumberOfSpace(String text) {
        int before = text.length();
        int after = text.replaceAll("[ ]", "").length();
        System.out.println("Количество пробелов в тексте: " + (before - after));
        return 0;
    }

    @Override
    public int countNumberOfPunctuationMarks(String text) {
        int before = text.length();
        int after = text.replaceAll("[,.!:?]", "").length();
        System.out.println("Количество знаков препинания в тексте: " + (before - after));
        return 0;
    }
}
