package TestJava;

import java.util.*;
import java.util.stream.Collectors;

public class Library {
    public HashMap<String, Book> books = new HashMap<>();
    public final List<Reader> readers = new ArrayList<>();

    public void addBook(Book book) {
        if (books.containsKey(book.getId())) {
            book.setQuantity(book.getQuantity() + 1);
        } else {
            books.put(book.getId(), book);
        }
    }


    public void removeBook(String id) {
        if (books.containsKey(id)) {
            books.get(id).setQuantity(books.get(id).getQuantity() - 1);
            System.out.println("xoa thanh cong");
        } else {
            System.out.println("xoa khong thanh cong");
        }


    }

    public Book findBookById(String id) {
        return books.get(id);
   }

   public void addReader(Reader reader) {
        if (readers.stream().anyMatch(x -> x.getReaderId().equals(reader.getReaderId()))) {
            System.out.println("Da co reader trong list");
        } else {
            readers.add(reader);
        }
   }

   public List<Book> searchByTitle(String title) {
        return books.values().stream().filter(book -> book.getTitle().equals(title)).toList();
   }

   public List<Book> searchByAuthor(String author) {
        return books.values().stream().filter(book -> book.getAuthor().equals(author)).toList();
   }


   public List<Book> getTop3MostBorrowed() {
        return books.values().stream().sorted(Comparator.comparingInt(Book::getCount).reversed()).toList();
   }
}
