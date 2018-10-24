package tests.task10;

public class Pen {
    private int price;
    private String producerName;

    public Pen(int price, String producerName){
        this.price = price;
        this.producerName = producerName;
    }

    //getters and setters
    public int getPrice() {
        return price;
    }

    public String getProducerName() {
        return producerName;
    }

    //methods class Object override: equals(), hashCode(), toString()
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        if (null == obj){
            return false;
        }
        if (getClass() != obj.getClass()){
            return false;
        }

        Pen pen = (Pen) obj;
        if (price != pen.price){
            return false;
        }
        if (null == producerName){
            return (producerName == pen.producerName);
        }
        else if(!producerName.equals(pen.producerName)){
            return false;
        }
        return true;
    }

    public int hashCode(){
        return (int) (31 * price + ((null == producerName)? 0 : producerName.hashCode()));
    }

    public String toString(){
        return getClass().getName() + "@" + "price: " + price
                + ", producerName: " + producerName;
    }
}
