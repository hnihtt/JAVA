package TestJava;

public interface Borrowable {
    void borrow(Book book, Library library) throws BorrowLimitException;
    void returnBook(Book book, Library library);
}