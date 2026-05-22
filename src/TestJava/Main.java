package TestJava;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Library thuVienTang1 = new Library();

        Book book1 = new Book("b1", "Clean Code", "Robert C. Martin", "Programming", 10);
        Book book2 = new Book("b2", "Effective Java", "Joshua Bloch", "Programming", 5);
        Book book3 = new Book("b3", "Atomic Habits", "James Clear", "Self-Help", 7);
        Book book4 = new Book("b4", "Deep Work", "Cal Newport", "Self-Help", 6);
        Book book5 = new Book("b5", "The Hobbit", "J.R.R. Tolkien", "Fantasy", 8);


        Reader reader1 = new Reader("r1", "Vo Vinh Thinh", "vvt@gmail.com");
        Reader reader2 = new Reader("r2", "Vo Vinh Binh", "vvb@gmail.com");
        Reader reader3 = new PremiumReader("r3", "Thanh Truc", "tt@gmail.com", LocalDate.of(2026, 11, 23));

        thuVienTang1.addBook(book1);
        thuVienTang1.addBook(book2);
        thuVienTang1.addBook(book3);
        thuVienTang1.addBook(book4);
        thuVienTang1.addBook(book5);
        thuVienTang1.books.values().forEach(System.out::println);
        System.out.println("----------");

        thuVienTang1.addReader(reader1);
        thuVienTang1.addReader(reader2);
        thuVienTang1.addReader(reader3);
        thuVienTang1.readersCatalog.getAll().forEach(System.out::println);
        System.out.println("----------");

        try {
            reader1.borrow(book1, thuVienTang1);
            reader2.borrow(book2, thuVienTang1);
            reader2.borrow(book5, thuVienTang1);
            reader3.borrow(book5, thuVienTang1);
            reader3.borrow(book1, thuVienTang1);
            reader3.borrow(book3, thuVienTang1);
        } catch (BorrowBookException | BorrowLimitException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("In thông tin reader sau khi mượn");
        thuVienTang1.readersCatalog.getAll().forEach(System.out::println);
        System.out.println("----------");
        System.out.println("Lấy danh sách sách reader1 đang mượn");
        reader1.getBorrowedBooks().forEach(System.out::println);
        System.out.println("----------");

        System.out.println("Cho reader1 trả và in danh sách sách đang mượn sau khi trả");
        reader1.returnBook(book1, thuVienTang1);
        System.out.println(reader1.getBorrowedBooks());
        System.out.println("----------");
        System.out.println("Group theo Category");
        thuVienTang1.getBooksByCategory().forEach((key, value) -> System.out.println(key + " -> " + value));
        System.out.println("----------");
        System.out.println("Group theo Author");
        thuVienTang1.getBooksByAuthor().forEach((key, value) -> System.out.println(key + " -> " + value));
        System.out.println("----------");
        long totalBook = thuVienTang1.getBookList().size();
        System.out.println("Tong so sach cua thu vien: " + totalBook);
        System.out.println("In id sach va so luot muon");
        thuVienTang1.getBookList().forEach(x -> System.out.println(x.getId() + " -> " + x.getBorrowCount()));
        System.out.println("----------");
        System.out.println("Reader muon sach nhieu nhat");
        thuVienTang1.readersCatalog.stream().max(Comparator.comparing(rd -> rd.getBorrowedBooks().size()))
                .ifPresent(System.out::println);


        BorrowRecord.getOverdueList(thuVienTang1).forEach(System.out::println);

        thuVienTang1.exportBooksToCSV("./src/TestJava/FileOutput/books.csv");
        thuVienTang1.getBookList().forEach(System.out::println);
        System.out.println("-------------");
        thuVienTang1.importBooksFromCSV("./src/TestJava/FileOutput/importBooksTest.csv");
        thuVienTang1.getBookList().forEach(System.out::println);
    }
}
