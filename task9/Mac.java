package task9;

import task9.Computer;

public class Mac extends Computer {
    private int macPrice = 2000;
    private String computerName = "Mac";

    public Mac(){
        //System.out.println("Mac default");
    }
    @Override //переопределение абстрактного метода
    public void printComputerName(){
        System.out.println("I`m method from Mac");

    }
    public void printMacPrice() {
        System.out.println("Mac price: " + macPrice);
    }
}
