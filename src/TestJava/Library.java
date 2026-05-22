package TestJava;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Library {
    public HashMap<String, Book> books = new HashMap<>();
    public final Catalog<Reader> readersCatalog = new Catalog<Reader>();
    public final List<BorrowRecord> records= new ArrayList<>();

    public void addBook(Book book) {
        Book existingBook = books.get(book.getId());

        if (existingBook != null) {
            existingBook.setQuantity(
                    existingBook.getQuantity() + book.getQuantity()
            );
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
        if (readersCatalog.getAll().stream().anyMatch(x -> x.getReaderId().equals(reader.getReaderId()))) {
            System.out.println("Da co reader trong list");
        } else {
            readersCatalog.add(reader);
        }
   }

   public List<Book> searchByTitle(String title) {
        return books.values().stream().filter(book -> book.getTitle().equals(title)).toList();
   }

   public List<Book> searchByAuthor(String author) {
        return books.values().stream().filter(book -> book.getAuthor().equals(author)).toList();
   }

   public Map<String, List<Book>> getBooksByCategory() {
        return books.values().stream().collect(Collectors.groupingBy(Book::getCategory));
   }

    public Map<String, List<Book>> getBooksByAuthor() {
        return books.values().stream().collect(Collectors.groupingBy(Book::getAuthor));
    }

   public List<Book> getTop3MostBorrowed() {
        return books.values().stream().sorted(Comparator.comparingInt(Book::getBorrowCount).reversed()).limit(3).toList();
   }

    public List<Book> getSortedBooks(Comparator<Book> comparator) {
        return books.values()
                .stream()
                .sorted(comparator)
                .toList();
    }

    public List<Book> getBookList() {
        return this.books.values().stream().toList();
    }

    public void exportBooksToCSV(String filePath) {
        try (BufferedWriter write = new BufferedWriter(new FileWriter(filePath))) {
            write.write("id,title,author,category,quantity");
            write.newLine();

            for (Book book : this.getBookList()) {
                String line =
                                book.getId() + "," +
                                book.getTitle() + "," +
                                book.getAuthor() + "," +
                                book.getCategory() + "," +
                                book.getQuantity();
                write.write(line);
                write.newLine();
            }
            System.out.println("Export thanh cong");
        } catch (IOException e) {
            System.out.println("Loi ghi file: " + e.getMessage());
        }
    }

    public void importBooksFromCSV(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    String[] data = line.split(",");
                    if (data.length != 5) {
                        System.out.println("Sai format dong " + line);
                        continue;
                    }
                    String id = data[0].trim();
                    String title = data[1].trim();
                    String author = data[2].trim();
                    String category = data[3].trim();
                    int quantity = Integer.parseInt(data[4].trim());

                    Book book = new Book(id, title, author, category, quantity);

                    this.addBook(book);
                } catch (NumberFormatException e) {
                    System.out.println("Loi number format o dong " + line);
                }
            }
            System.out.println("Import thanh cong");
        } catch (FileNotFoundException e) {
            System.out.println("Khong tim thay file: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Loi doc file: " + e.getMessage());
        }
    }
}