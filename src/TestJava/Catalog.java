package TestJava;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Catalog<T extends Comparable<T>> {
    private final List<T> items = new ArrayList<>();

    public void add(T item) {
        items.add(item);
    }

    public void remove(T item) {
        items.remove(item);
    }

    public List<T> getAll() {
        return items;
    }

    public List<T> filter(Predicate<T> condition) {

        return items.stream()
                .filter(condition)
                .collect(Collectors.toList());
    }

    public boolean contains(T item) {
        return items.contains(item);
    }

    public Stream<T> stream() {
        return items.stream();
    }
}
