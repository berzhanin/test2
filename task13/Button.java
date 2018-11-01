package task13;

public class Button {
    String name;
    String action;

    //constructor
    public Button(String name,String action) {
        this.name = name;
        this.action = action;
    }

    public boolean equals(Button button) {
        return name.equals(button.name);
    }

    @Override
    public String toString() {
        String result = "Button - " + name + "  Action - " + action;
        return result;
    }
}
