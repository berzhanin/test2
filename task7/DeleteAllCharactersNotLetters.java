package task7;
//из текста удалить все символы, кроме пробелов, не являющиеся буквами
public class DeleteAllCharactersNotLetters {
    public static void main (String... av) {
        String testString = "б12$%уквы, символ#$ы, ци*(0фры и т.д. и т0076п";

        System.out.println("Ouput result: "+deleteNotLetters(testString));
    }

    private static String deleteNotLetters (String str) {
        StringBuilder sb = new StringBuilder();
        int lettersNum=0;
        for (int i = 0; i < str.length(); i++) {
            str = str.replaceAll("[^A-Za-zА-Яа-я| ]", ""); // удалится все кроме букв и пробелов
        }
        return str.toString();
    }
}
