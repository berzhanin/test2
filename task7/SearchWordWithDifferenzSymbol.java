package tests.task7;
//Найти слово, в котором число различных символов минимально
public class SearchWordWithDifferenzSymbol {

    public static void main(String[] args) {
        String[] a = {"Something", "abcdefghijklmnopq", "aaaaa", "WHATEVER", "..."};
        String goal = a[0]; // искомое слово
        System.out.println("Массив: ");
        for (int i = 1; i < a.length; i++) {
            System.out.print(a[i] + ", ");
            if (diffWords(a[i]) < diffWords(goal))
                goal = a[i]; // новый мин.эл
        }
        System.out.println("");
        System.out.println("Искомое слово: " + goal + ", число разных символов: " + diffWords(goal));
    }

    private static int diffWords(String st) { // число уникальных символов
        StringBuffer u = new StringBuffer(); // строка, в которой каждый символ будет содержаться лишь однажды
        String c; // текущий символ в строке
        for (int i = 0; i < st.length(); i++) {
            c = String.valueOf(st.charAt(i)); // получить текущий символ
            if (u.indexOf(c) == -1) // символ еще не встречался
                u.append(c); // добавляем
        }

        return u.length();
    }

}