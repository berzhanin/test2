package task13;

import java.util.List;

public class Dropdown {
    List<String> options;
    boolean isSelected;
    String name;

    //constructor
    public Dropdown(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name + "";
    }

}
