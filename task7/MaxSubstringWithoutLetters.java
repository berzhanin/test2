package tests.task7;

import java.util.Arrays;

public class MaxSubstringWithoutLetters {
    public static void main(String[] args) {
        String testString = "skjssldfkjsakdfjlskdssfkjslakdfiop7%.111adfaijsldifjasdjfil8333klsasdfŞdijpfjapodifjpoaidjfpoaidjpfi9a";

        final int answer = Arrays.stream(testString.split("[a-z|A-Z]+"))
                .filter(s -> s.matches("(.+)?[0-9](.+)?"))
                .sorted((s1, s2) -> s2.length() - s1.length())
                .findFirst()
                .orElse("")
                .length();

        System.out.println("Max substring without letter:" + answer);
    }
}
