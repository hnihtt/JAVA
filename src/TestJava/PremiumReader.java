package TestJava;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PremiumReader extends Reader {
    private LocalDate membershipExpiry;
    private final List<Book> borrowedBooks = new ArrayList<>();

    public PremiumReader(String readerId, String name, String email, LocalDate membershipExpiry) {
        super(readerId, name, email);
        this.membershipExpiry = membershipExpiry;
    }

    @Override
    public void borrow(Book book, Library library) throws BorrowLimitException {
        if (membershipExpiry.isBefore(LocalDate.now())) {
            System.out.println("Het han hoi vien");
            return;
        }

        if (borrowedBooks.size() > 10) {
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
            library.records.add(new BorrowRecord(this, book, LocalDate.now(), null, BorrowStatus.BORROWING));
            return;
        }

        System.out.println("Sach khong kha dung");
    }

    @Override
    public String toString() {
        return "PremiumReader{" +
                super.toString() + ", " +
                "membershipExpiry=" + membershipExpiry +
                '}';
    }
}
