package TestJava;

import java.util.ArrayList;
import java.util.List;

public class Reader implements Borrowable{
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
    public void borrow(Book book) throws BorrowLimitException {
        if (borrowedBooks.size() > 3) {
            throw new BorrowLimitException("Vuot qua gioi han sach duoc muon");
        }

        if (book.getQuantity() > 0) {
            borrowedBooks.add(book);
            book.setQuantity(book.getQuantity() - 1);
            book.setCount((book.getCount() + 1));
            return;
        }

        System.out.println("Sach khong kha dung");
    }

    @Override
    public void returnBook(Book book) {
        if (borrowedBooks.contains(book)) {
            borrowedBooks.remove(book);
            book.setQuantity(book.getQuantity() + 1);
            book.setCount((book.getCount() - 1));
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
}
