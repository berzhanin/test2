package tests.task7;

import java.io.InputStream;
import java.util.*;
import java.util.regex.*;

public class FindWordTask5_8 {
    public static void main(String[] args) {
        // Ввести n строк с консоли.
        String[] sourceStrings = readInput();
        if (sourceStrings.length == 0) {
            System.out.println("Нет строк. Программа завершена.");
            System.exit(0);
        }
        // 5. Найти количество слов, содержащих только символы латинского алфавита, а среди них –
        // количество слов с равным числом гласных и согласных букв.
        findWordsWithEqualNumberOfVowelsAndConsonantsInLatin(sourceStrings);

        // 6. Найти слово, символы в котором идут в строгом порядке возрастания
        // их кодов. Если таких слов несколько, найти первое из них.
        findFirstWordWithSymbolCodesInAsc(sourceStrings);

        // 7. Найти слово, состоящее только из различных символов. Если таких
        // слов несколько, найти первое из них.
        findWordWithOnlyDifferentSymbols(sourceStrings);

        // 8. Среди слов, состоящих только из цифр, найти слово-палиндром. Если
        // таких слов больше одного, найти второе из них.
        findFirstOrSecondNumericPalindromicWord(sourceStrings);
    }

    public static void println(Object obj) {
        System.out.println(obj);
    }

    public static void print(Object obj) {
        System.out.print(obj);
    }

    public static void println() {
        System.out.println();
    }

    public static String[] toStringArray(Collection<String> list) {
        String[] result = new String[list.size()];
        Iterator<String> it = list.iterator();
        for (int i = 0; i < list.size(); i++) {
            result[i] = it.next();
        }
        return result;
    }

    public static String[] readInput(Scanner sc) {
        List<String> input = new ArrayList<String>();
        print("Введите строки через пробел, для окончания введите q: ");
        while (sc.hasNext()) {
            String word = sc.next();
            if (word.equals("q")) {
                break;
            } else {
                input.add(word);
            }
        }
        sc.close();
        return toStringArray(input);
    }

    public static String[] readInput(InputStream is) {
        return readInput(new Scanner(is));
    }

    public static String[] readInput() {
        return readInput(System.in);
    }

    public static int[] toIntArray(Collection<Integer> list) {
        int[] result = new int[list.size()];
        Iterator<Integer> it = list.iterator();
        for (int i = 0; i < list.size(); i++) {
            result[i] = it.next();
        }
        return result;
    }


    public static void findWordsWithEqualNumberOfVowelsAndConsonantsInLatin(
            String[] sourceWords) {
        List<String> wordsInLatin = findWordsInLatin(sourceWords);
        println("Слова, содержащие только символы латинского алфавита (слов: "
                + wordsInLatin.size() + "): " + wordsInLatin);
        int vowelsCount, consonantsCount;
        print("а среди них – количество слов с равным числом гласных и согласных букв (гласных, согласных): ");
        for (String word : wordsInLatin) {
            vowelsCount = word.replaceAll("[^aeiou]", "").length();
            consonantsCount = word.replaceAll("[aeiou]", "").length();
            if (vowelsCount == consonantsCount) {
                print(word + "(" + vowelsCount + ", " + consonantsCount + "), ");
            }
        }
        println();
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

    public static void findFirstWordWithSymbolCodesInAsc(String[] sourceWords) {
        print("Слово, символы в котором идут в строгом порядке возрастания их кодов: ");
        for (String word : sourceWords) {
            if (isWordSymbolCodesInAsc(word)) {
                print(word);
                break;
            }
        }
        println();
    }

    public static boolean isWordSymbolCodesInAsc(String word) {
        char[] wordChars = word.toCharArray();
        if (wordChars.length < 2) {
            return false;
        }
        boolean result = false;
        for (int i = 0; i < wordChars.length - 1; i++) {
            if (isTwoCharSymbolCodesInAsc(wordChars[i], wordChars[i + 1])) {
                result = true;
            } else {
                return false;
            }
        }
        if (result) {
            return true;
        }
        return false;
    }

    public static boolean isTwoCharSymbolCodesInAsc(char a, char b) {
        if ((int) b - (int) a == 1) {
            return true;
        }
        return false;
    }

    public static boolean hasUniqueChars(String word) {
        HashSet<Character> uniqueChars = new HashSet<Character>();
        for (Character ch : word.toCharArray()) {
            if (!uniqueChars.add(Character.toLowerCase(ch))) {
                return false;
            }
        }
        return true;
    }

    public static void findWordWithOnlyDifferentSymbols(String[] sourceWords) {
        for (String word : sourceWords) {
            if (word.length() > 1 && hasUniqueChars(word)) {
                println("Слово, состоящее только из различных символов: "
                        + word);
                break;
            }
        }
    }

    public static void findFirstOrSecondNumericPalindromicWord(
            String[] sourceWords) {
        List<String> oneOrTwoNumericPalindromicWords = new ArrayList<String>();
        for (String word : sourceWords) {
            if (isNumericWord(word)) {
                boolean isInputPalindrome = word.equals(new StringBuilder(word)
                        .reverse().toString()) ? true : false;
                if (isInputPalindrome) {
                    oneOrTwoNumericPalindromicWords.add(word);
                }
            }
        }
        final String message = "Слово-палиндром, состоящее только из цифр: ";
        if (oneOrTwoNumericPalindromicWords.size() == 0) {
            println(message + "Нет слов");
            return;
        }
        if (oneOrTwoNumericPalindromicWords.size() == 1) {
            println(message + oneOrTwoNumericPalindromicWords.get(0));
        } else {
            println("Слов-палиндромов, состоящих только из цифр > 1. Второе из них: "
                    + oneOrTwoNumericPalindromicWords.get(1));
        }
    }

    public static boolean isNumericWord(String word) {
        Pattern numericPattern = Pattern.compile("[+-]?[0-9]+");
        Matcher numericMatcher = numericPattern.matcher(word);
        if (numericMatcher.matches()) {
            return true;
        }
        return false;
    }
}
