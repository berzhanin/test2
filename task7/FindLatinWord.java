package tests.task7;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindLatinWord {
    public static void main(String[] args) {

    }
    public static List<String> findWordsInLatin(String[] sourceWords) {
        Pattern latinPattern = Pattern.compile("[a-z]+");
        List<String> result = new ArrayList<String>();
        for (String word : sourceWords) {
            Matcher latinMatcher = latinPattern.matcher(word.toLowerCase());
            if (latinMatcher.matches()) {
                result.add(word);
            }
        }
        return result;
    }
}
