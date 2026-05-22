package TestJava;

import java.time.LocalDate;
import java.util.List;

public class BorrowRecord {
    private Reader reader;
    private Book book;
    private LocalDate borrowDate;
    private LocalDate returnDate;
    private BorrowStatus status;

    public BorrowRecord(Reader reader, Book book, LocalDate borrowDate, LocalDate returnDate, BorrowStatus status) {
        this.reader = reader;
        this.book = book;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.status = status;
    }

    public Reader getReader() {
        return reader;
    }

    public Book getBook() {
        return book;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public BorrowStatus getStatus() {
        return status;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public void setStatus(BorrowStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "BorrowRecord{" +
                "reader=" + reader +
                ", book=" + book +
                ", borrowDate=" + borrowDate +
                ", returnDate=" + returnDate +
                ", status=" + status +
                '}';
    }

    public static List<BorrowRecord> getOverdueList(Library library) {
        library.records.stream()
                .filter(x -> x.getBorrowDate().plusDays(14).isBefore(LocalDate.now()))
                .filter(x -> x.getStatus() == BorrowStatus.BORROWING).forEach(book -> book.setStatus(BorrowStatus.OVERDUE));

        return library.records.stream()
                .filter(x -> x.getStatus() == BorrowStatus.OVERDUE).toList();
    };
}