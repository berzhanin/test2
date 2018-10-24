package tests.task7;
//Определить, сколько раз в тексте встречается каждое слово
import java.util.HashMap;
import java.util.Scanner;

public class CountAllWordsInText {
    public static void main(String[] args) {
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
    }

}
