package task9;

public class ComputerMain {
    public static void main(String[] args) {

        //Computer computer = new Computer();
        /*computer.setComputerName("Laptop");
        computer.printComputerName();*/

        HP hp = new HP();
        hp.setComputerName("HP");
        hp.printComputerName();
        hp.printOSDetails();
        hp.printAllDetails();

        Mac mac = new Mac();
        mac.printComputerName();
        mac.printMacPrice();
    }


}
