package Threading;

public class Main {
    public static void main(String[] args) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
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
                for (int i = 0; i < 100; i++) {
                    System.out.println(i);
                }
            }
        };

        Thread thread3 = new Thread(System.out::println);

        thread.start();
        thread2.start();
        thread3.start();
    }
}
