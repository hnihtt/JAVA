package Threading.Theory;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
    public static void main(String[] args) {
        Runnable task1 = () -> System.out.println("Task 1");
        Runnable task2 = () -> System.out.println("Task 2");
        Runnable task3 = () -> System.out.println("Task 3");

        ExecutorService pool = Executors.newFixedThreadPool(3);

        pool.execute(task1);
        pool.execute(task2);
        pool.execute(task3);
        pool.shutdown();
    }
}
