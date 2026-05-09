package TestJava;

public interface Borrowable {
    void borrow(Book book) throws BorrowLimitException;
    void returnBook(Book book);
}