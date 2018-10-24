package tests.task8;

public class Book {

    private int price1;
    public int price2;
    String titleName;
    protected String bookAutor;

    public int getPrice1() {
        return price1;
    }

    public void setPrice1(int price1) {
        this.price1 = price1;
    }

    public int getPrice2() {
        return price2;
    }

    public void setPrice2(int price2) {
        this.price2 = price2;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public String getBookAutor() {
        return bookAutor;
    }

    public void setBookAutor(String bookAutor) {
        this.bookAutor = bookAutor;
    }

    public void setPrice() {
        setPrice();
    }

    public void setPrice(int price) {
        this.price1 = price;
    }

    public int getPrice() {
        return price1;
    }

     public void printPrice(){
        System.out.println(price2);
    }

    protected double priceWithoutRate(double anyPrice){
        anyPrice = anyPrice * 0.81;
        return anyPrice;
    }




}
