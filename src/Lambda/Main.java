package Lambda;

import java.util.ArrayList;
import java.util.List;

public class Main {

    @FunctionalInterface
    interface Calculator {
        int caculate(int x, int y);
    }

    public static void excecute(Calculator c) {
        int result = c.caculate(3, 4);
        System.out.println(result);
    }




    public static void main(String[] args) {
        excecute((x,y) -> x * y);




        Printable print1 = () -> System.out.println("print1");
        Printable print2 = () -> System.out.println("print2");
        print1.print();
        print2.print();

        List<Integer> intList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            intList.add(i);
        }


        /*
        * forEach(Consumer c)
        *
        * @FunctionalInterface
          public interface Consumer {
            void accept(T t);
        *
        * */


        intList.forEach(e -> System.out.println(e));


    }
}
