package task9;

import task9.Computer;

public class HP extends Computer {
    private boolean hasWindows = true;
    private String computerName;

    public void setComputerName(String computerName) {
        this.computerName = computerName;
    }

    public HP(){
        //System.out.println("HP default");
    }

    @Override //переопределение абстрактного метода
    public void  printComputerName() {
        System.out.println("I`m method from HP");
    }

    public void printOSDetails() {
        System.out.println("Is windows " + hasWindows);
    }

    public void printAllDetails() {
        printComputerName();
        printOSDetails();
    }
}
