package tests.task10;

public class MainPen {
    public static void main(String[] args) {
        Pen pen1 = new Pen(100, "Adidas");
        Pen pen2 = new Pen(100, "Adidas");

        //override method equals()
        System.out.println(pen1.equals(pen2));
        System.out.println(pen2.equals(pen1));

        //override method hashCode()
        System.out.println(pen1.hashCode());
        System.out.println(pen2.hashCode());

        //override method toString()
        System.out.println(pen1.getPrice() + " " + pen1.getProducerName());
        System.out.println(pen2.getPrice() + " " + pen2.getProducerName());


    }
}
