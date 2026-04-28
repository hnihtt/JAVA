package CollectionsEx.LinkedListNQueueEx;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Queue<String> stringQueue = new LinkedList<>();
        stringQueue.offer("a");
        stringQueue.offer("b");
        stringQueue.offer("c");
        stringQueue.offer("d");

        while (!stringQueue.isEmpty()) {
            System.out.println(stringQueue.poll());
            System.out.println("Item tiep theo: " + stringQueue.peek());
        }
    }
}
