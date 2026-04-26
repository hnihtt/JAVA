package Threading.Theory;

import java.util.concurrent.Callable;

public class Theory {
    public static void main(String[] args) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println(i);
                }
            }
        };

        //Thread state
        //Git stash
        //Method reference


        Thread thread2 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println(i);
                }
            }
        };

        Thread thread3 = new Thread(() -> System.out.println("Hello"));

        thread.start();
        thread2.start();
        thread3.start();



        /*
        // CACH 1
        -----CREATE A THREAD-----
        Thread thread = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println(i);
                }
            }
        };

        -----RUN THAT THREAD-----
        thread.start();

        Though process:
        - Tạo 1 thread để xử lý task xyz, rồi chạy thread đó
        - Mỗi lần tạo = 1 thread mới
        - Không kiểm soát được số lượng thread -> tốn tài nguyên
        ----> Dẫn đến nhu cầu Thread Pool


        // CACH 2
        -----CREATE A TASK-----
        Runnable task = () -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(i);
            }
        };

        -----CONFIG THREAD POOL-----
        ExecutorService pool = Executors.newFixedThreadPool(3);
        -> Tạo một thread pool với 3 thread luôn sẵn sàng

        -----EXECUTE TASK-----
        pool.execute(task);
        -> Giao task cho thread pool, pool sẽ chọn 1 thread rảnh để chạy

        -----SHUTDOWN-----
        pool.shutdown(); // nên luôn gọi khi xong việc


        Though process:
        - Không tạo thread nữa
        - Chỉ tạo task (công việc)
        - Thread pool quản lý thread và phân phối task cho thread


        task -> thread pool
             -> tìm thread rảnh
                   -> có → chạy ngay
                   -> không → đưa vào queue
        Queue thường là FIFO or Priority


        task: - học thêm về 1 số loại queue (FIFO, Priority Queue, Delay Queue, Synchronous Queue)
              - Execute/Runnable và Submit/Callable/Future

              - Execute/Runnable: chỉ cần chạy task, xong là được
              - Submit/Callable/Future: cần chạy task, xong rồi quay lại lấy kết quả

              - Execute/Submit -> đều là gửi task cho thread
              - Runnable return void / Callable return value và throw exception
              - Future: Giữ kết quả

              - Thread pool internals:
              + queue
              + corePoolSize vs maxPoolSize
              - synchronized (để xử lý race condition)
        */

    }
}
