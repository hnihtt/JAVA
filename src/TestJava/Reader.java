package TestJava;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Reader implements Borrowable, Comparable<Reader> {
    private String readerId;
    private String name;
    private String email;
    private final List<Book> borrowedBooks = new ArrayList<>();

    public Reader(String readerId, String name, String email) {
        this.readerId = readerId;
        this.name = name;
        this.email = email;
    }

    public String getReaderId() {
        return readerId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    @Override
    public void borrow(Book book, Library library) throws BorrowLimitException {
        if (borrowedBooks.size() > 3) {
            throw new BorrowLimitException("Vuot qua gioi han sach duoc muon");
        }

        if (!library.books.containsValue(book)) {
            System.out.println("Thu vien khong co sach nay");
            return;
        }

        if (book.getQuantity() > 0) {
            borrowedBooks.add(book);
            book.setQuantity(book.getQuantity() - 1);
            book.setCount((book.getBorrowCount() + 1));
            //Cai nay de test method getOverDue trong BorrowRecord
//            library.records.add(new BorrowRecord(this, book, LocalDate.now().minusDays(18), null, BorrowStatus.BORROWING));
            library.records.add(new BorrowRecord(this, book, LocalDate.now(), null, BorrowStatus.BORROWING));
            return;
        }

        System.out.println("Sach khong kha dung");
    }

    @Override
    public void returnBook(Book book, Library library) {
        if (borrowedBooks.contains(book)) {
            borrowedBooks.remove(book);
            book.setQuantity(book.getQuantity() + 1);
            book.setCount((book.getBorrowCount() - 1));

            BorrowRecord oldRecord = library.records.stream()
                    .filter(x -> x.getBook().equals(book) &&
                            x.getReader().equals(this) &&
                            x.getStatus() == BorrowStatus.BORROWING).findFirst().orElse(null);


            if (oldRecord != null) {
                oldRecord.setReturnDate(LocalDate.now());
                oldRecord.setStatus(BorrowStatus.RETURNED);
            }
            return;
        }
        System.out.println("Sach khong co trong danh sach muon");
    }

    @Override
    public String toString() {
        return "Reader{" +
                "readerId='" + readerId + '\'' +
                ", email='" + email + '\'' +
                ", borrowedBooks=" + borrowedBooks +
                '}';
    }

    @Override
    public int compareTo(Reader reader) {
        return this.getReaderId().compareTo(reader.readerId);
    }
}
