package TestJava;

import java.time.LocalDate;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("book1", "title1", "author1", 10);
        Book book2 = new Book("book2", "title2", "author2", 10);


        Reader rd = new Reader("readerid", "readername", "t@gmail.com");
        Reader rd2 = new Reader("readerid", "readername", "t@gmail.com");
        try {
            rd.borrow(book1);
            rd2.borrow(book1);
        } catch (BorrowLimitException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(rd);
        rd.getBorrowedBooks().forEach(System.out::println);

        PremiumReader rrd = new PremiumReader("pre-reader", "name", "t@gmail.com", LocalDate.of(2026, 11, 23));
        System.out.println(rrd);

        Library library = new Library();
        library.addBook(book1);
        library.addBook(book2);
        System.out.println(library.books);

        library.addReader(rd);
        library.addReader(rd);
        System.out.println(library.readers);


        Book result = library.findBookById("book1");
        System.out.println(result);

        System.out.println(library.searchByTitle("title1"));
        System.out.println(library.searchByAuthor("author2"));
        System.out.println(library.getTop3MostBorrowed());
    }
}
