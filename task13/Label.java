package task13;

public class Label {
    String name;

    //constructor
    public Label(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        String result = "Label - " + name;
        return result;
    }
}
