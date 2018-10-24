package tests.task7;

public class CountPunktComma {
    public static void main(String[] args) {

        String text =" Необходимо: подсчитать. колич,ество. зна,ков пре:пи:на:ния.";
        int before = text.length();
        int after = text.replaceAll("[,.!:?]", "").length();
        System.out.println("Количество знаков препинания в тексте: " + (before - after));

    }
}
