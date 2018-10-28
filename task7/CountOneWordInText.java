package tests.task7;
//Определить сколько раз встречается в тексте одно слово по заданному шаблону поиска
public class CountOneWordInText {

    public static void main(String... args) {
        String s = "This  paper  is  intended  to  highlight  the  importance  of  result  reporting  in  the  context  of  software  \n" +
                "testing.    Result  reporting  can  be  at  various  stages  of  testing  like  system,  integration  etc...  This  \n" +
                "document  addresses  some  of    the  areas  of  result  reporting  at  a  high  level  involving  independent  \n" +
                "system testing ( Black box testing) keeping in mind, the customer as one of the audience.";

        String pattern = "testing"; //образец слова, которое будем искать в тексте
        System.out.println("Подсчет слова \"" + pattern + "\"  в тексте составил: ");
        System.out.println(searchWord(s, pattern));
    }

    public static int searchWord(String message, String word) {
        message = message.toLowerCase();
        word = word.toLowerCase();
        int i = message.indexOf(word);
        int count = 0;
        while (i >= 0) {
            count++;
            i = message.indexOf(word, i + 1);
        }
        return count;
    }
}