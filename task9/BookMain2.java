package task9;

import task8.Book;

public class BookMain2 {
    public static void main(String[] args) {

        Book2 book = new Book2();
        book.setBookAutor("Tolstoy");
        book.setTitleName("Anna Karenina");
        book.setPrice(25);
        System.out.println(book.getBookAutor());
        System.out.println(book.getTitleName());
        System.out.println(book.getPrice1());

        Book book1 = new Book();
        book1.setBookAutor("Pushkin");
        book1.setTitleName("Ruslan & Ludmila");
        book1.setPrice(25);
        System.out.println(book1.getBookAutor());
        System.out.println(book1.getTitleName());
        System.out.println(book1.getPrice1());


    }
}
