package DemoBuilder;

public class Main {
    public static void main(String[] args) {
        Student sd = new Student.Builder().id(1).name("NAME").build();
        System.out.println(sd);
    }
}
