package Enum;

public class Main {
    public static void main(String[] args) {
        System.out.println(AccountStatus.WAITING_TO_BE_APPROVED.getStatusCode());
        System.out.println(AccountStatus.SUSPENDED.getDesc());

        DogBreed.CORGI.sound();

        System.out.println(Operation.ADD.apply(66,33));
    }
}
