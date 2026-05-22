package TestJava;

import java.util.Comparator;

public class BookComparator implements Comparator<Book> {
    @Override
    public int compare(Book book1, Book book2) {

        int authorCompare = book1.getAuthor().compareTo(book2.getAuthor());

        if (authorCompare !=0 ) {
            return authorCompare;
        }

        return book1.getTitle().compareTo(book2.getTitle());
    }
}
