package tests.task13;

import java.util.HashMap;

public class Example2 {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "Belarus");
        map.put(2, "USA");
        map.put(3, "Peru");
        System.out.println(map);

        //представление записей набора в цикле
        //for (String key: map.keySet())
        System.out.println(map.keySet());
        //получения значения по ключу
        System.out.println(map.containsKey(1));
        //проверка наличия записей
        System.out.println(map.isEmpty());
        //удаление записи
        map.remove(1);
        System.out.println("После удаления одного элемента: " + map);
        map.remove(2, "USA");
        System.out.println("После удаления еще одного элемента" + map);
    }
}
