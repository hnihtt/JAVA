package TestJava;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Library thuVienTang1 = new Library();

        Book book1 = new Book("book1", "title1", "Anh", "category1", 10);
        Book book2 = new Book("book2", "title2", "Bằng", "category2", 10);
        Book book3 = new Book("book3", "title4", "Anh", "category2", 10);
        Book book4 = new Book("book4", "title3", "Bằng", "category2", 10);


        Reader rd = new Reader("readerid1", "readername", "t@gmail.com");
        Reader rd2 = new Reader("readerid2", "readername", "t@gmail.com");


        System.out.println("Thêm thử 4 sách vào thư viện:");
        thuVienTang1.addBook(book1);
        thuVienTang1.addBook(book2);
        thuVienTang1.addBook(book3);
        thuVienTang1.addBook(book4);
        System.out.println(thuVienTang1.books);
        System.out.println("----------");


        System.out.println("Cho 2 reader mượn thử");
        try {
            rd.borrow(book1, thuVienTang1);
            rd2.borrow(book2, thuVienTang1);
        } catch (BorrowLimitException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("In thông tin reader sau khi mượn:");
        System.out.println(rd);
        System.out.println("----------");
        System.out.println("Lấy danh sách sách reader đang mượn");
        rd.getBorrowedBooks().forEach(System.out::println);
        System.out.println("----------");

        //TEST VỚI PREMIUM
        PremiumReader rrd = new PremiumReader("pre-reader", "name", "t@gmail.com", LocalDate.of(2026, 11, 23));

        rd.returnBook(book1, thuVienTang1);


        //Chỗ này có khi phải handle xem reader có trong list của thư viện không rồi mới cho mượn phía trên
        thuVienTang1.addReader(rd);
        thuVienTang1.addReader(rd2);
        //xài thử Catalog<T>
        System.out.println(thuVienTang1.readersCatalog.getAll());

        System.out.println("Tìm book theo ");
        Book result = thuVienTang1.findBookById("book1");
        System.out.println(result);

        System.out.println("Tìm book theo title, author, và top 3 borrowedBooks");
        System.out.println(thuVienTang1.searchByTitle("title1"));
        System.out.println(thuVienTang1.searchByAuthor("Bằng"));
        System.out.println(thuVienTang1.getTop3MostBorrowed());
        System.out.println("Group theo category");
        System.out.println(thuVienTang1.getBooksByCategory());

        System.out.println("In thử List BorrowRecords");
        thuVienTang1.records.forEach(System.out::println);

        System.out.println("Thử sort với BookComparator");
        List<Book> sortedBooks = thuVienTang1.getSortedBooks(new BookComparator());
        sortedBooks.forEach(System.out::println);
        System.out.println("-------------");
        List<Book> sortedBooksWithLambda = thuVienTang1.books.values().stream().sorted(Comparator.comparing(Book::getAuthor).thenComparing(Book::getTitle)).toList();
        sortedBooksWithLambda.forEach(System.out::println);
        System.out.println("-------------");
        /*
        public static List<BorrowRecord> getOverdueList(Library library) {
        library.records.stream()
                .filter(x -> x.getBorrowDate().plusDays(14).isBefore(LocalDate.now()))
                .filter(x -> x.getStatus() == BorrowStatus.BORROWING).forEach(book -> book.setStatus(BorrowStatus.OVERDUE));

        return library.records.stream()
                .filter(x -> x.getStatus() == BorrowStatus.OVERDUE).toList();
        };
         */

        BorrowRecord.getOverdueList(thuVienTang1).forEach(System.out::println);
    }
}
