package task7;
//После каждого слова текста, заканчивающегося заданной подстрокой,
// вставить указанное слово, например, !!!Go Russia!!!
public class AutoAddWordsToText {

    public static void main(String[] args) {
        StringBuffer text = new StringBuffer("Nurmagomedov soundly defeated McGregor via fourth-round submission to " +
                "retain his UFC lightweight title \nwith a dominant performance at UFC 229. After a heated lead-up to the" +
                " event, a wild post-fight melee\nbroke out immediately following Nurmagomedov’s win, as the undefeated " +
                "Dagestani scaled \nthe cage and leapt into McGregor’s corner. Chaos ensued, and afterward McGregor tweeted" +
                " that he was\nlooking forward to the rematch.");
        String insertSubstring = "!!!Go Russia!!! ";
        System.out.println(text);
        int i = 0;
        int position = 0;
        while ((position = text.indexOf("ed ", i)) != -1) {
            position += 3;
            text.insert(position, insertSubstring);
            i = position;
        }
        System.out.println("\n\n" + text);
    }
}
