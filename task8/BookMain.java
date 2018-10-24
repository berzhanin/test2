package tests.task8;

import tests.task8.Book;

public class BookMain {
    public static void main(String[] args) {

        Book book = new Book();
        //without incapsulation
        System.out.println(book.price2); //price должно быть не private
        //using incapsulation
        book.setPrice2(100);
        System.out.println(book.getPrice2());
        System.out.println(book.priceWithoutRate(100));
    }
}

