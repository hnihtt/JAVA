package Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    //1
    @FunctionalInterface
    interface Calculator {
        int cal(int x, int y);
    }

    public static void excecute(Calculator c) {
        System.out.println(c.cal(10,5));
    }

    //2
    @FunctionalInterface
    interface Checker {
        boolean check(int x);
    }

    public static void test(Checker c) {
        System.out.println(c.check(6));
    }

    //3
    @FunctionalInterface
    interface StringProcessor {
        String process(String s);
    }

    public static void handle(StringProcessor sp) {
        System.out.println(sp.process("Hello"));
    }

    //4
    @FunctionalInterface
    interface Action {
        void run(String name);
    }

    public static void doAction(Action a) {
        a.run("XXXX");
    }


    //MAIN
    public static void main(String[] args) {
        excecute((x, y) -> x + y);
        excecute((x, y) -> x * y);
        excecute((x, y) -> x - y);

        test( x -> x%2==0);
        test(x -> x>10);
        test(x -> x<0);

        handle(s -> s.toUpperCase());
        handle(s -> s.concat("!!!"));
        handle(s -> {
            char[] chars =  s.toCharArray();
            int right = 0;
            int left = chars.length-1;
            while (right < left) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                right++;
                left--;
            }
            return new String(chars);
        });

        doAction(name -> System.out.println("Hello " + name));
        doAction(name -> System.out.println(name.length()));
        doAction(name -> System.out.println(name + name));


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
