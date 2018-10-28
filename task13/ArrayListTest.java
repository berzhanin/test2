package tests.task13;

import java.util.ArrayList;

public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("11");
        list.add("22");
        list.add("33");
        String result = "";
        list.stream().forEach(str ->{
            result.concat(str);
        });
        System.out.println(result);
    }
}
