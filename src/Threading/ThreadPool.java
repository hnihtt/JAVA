package Threading;

import java.util.concurrent.*;

public class ThreadPool {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Thread task1 = new Thread(() -> System.out.println("Task1"));
        Thread task2 = new Thread(() -> System.out.println("Task2"));
        task1.start();
        task2.start();


        Runnable task3 = () -> System.out.println("Task 3");
        Runnable task4 = () -> System.out.println("Task 4");
        Runnable task5 = () -> System.out.println("Task 5");

        ExecutorService pool = Executors.newFixedThreadPool(3);

        pool.execute(() -> System.out.println("X"));
        pool.execute(task3);
        pool.execute(task4);
        pool.execute(task5);
        pool.shutdown();


        ExecutorService poolFuture = Executors.newFixedThreadPool(2);

        Callable<Integer> task = () -> {
            Thread.sleep(5000);
            return 99;
        };

        Future<Integer> future = poolFuture.submit(task);

        System.out.println("Working...");

        Integer result = future.get();

        System.out.println("Result: " + result);

        poolFuture.shutdown();

    }
}
