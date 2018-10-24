package task7;
//удалить из текста его чать, заключенную между двумя символами,
// которые вводятся, напрмер между скобками (  )
public class DeleteTextBetweenTwoCharacters {
    public static void main(String[] args) {

        String testString = "Удалить из текста его часть, (заключенную между двумя символами), " +
                "которые вводятся круглыми скобками: (Между мной и тобой остается ветер!)";
        System.out.println("Изначальний текст: ");
        System.out.println(testString);
        testString = testString.replaceAll("\\(.+?\\)", "");
        System.out.println("Текст после вырезки: ");
        System.out.println(testString);
    }
}