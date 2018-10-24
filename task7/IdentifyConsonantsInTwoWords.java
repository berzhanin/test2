package task7;

public class IdentifyConsonantsInTwoWords {
    public static final String CONSONANTS = "[BCDFGHJKLMNPQRSTVWXYZ]";
    public static final String VOWELS = "[AEIOU]"; // considering Y a consonant here
    public static final String NOT_LETTERS = "[\\W_0-9]";

    public static void main(String[] args) {
        String words = "How can I 98check how many consonants and in Java?";

        String letters = words.toUpperCase().replaceAll(NOT_LETTERS, "");
        System.out.println("Letters: " + letters.length());

        String vowels = letters.replaceAll(CONSONANTS, "");
        System.out.println("Vowels: " + vowels.length());

        String consonants = letters.replaceAll(VOWELS, "");
        System.out.println("Consonants: " + consonants.length());
    }
}
