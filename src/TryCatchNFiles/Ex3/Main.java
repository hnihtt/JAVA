package TryCatchNFiles.Ex3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        //Bai 1
//        String cpuStr = "";
//
//        while (true) {
//            System.out.print("Nhap cpu: ");
//            String cpu = sc.nextLine();
//            try {
//                Computer pc = new Computer.Builder().cpu(cpu).build();
//                cpuStr = cpu;
//                break;
//            } catch (IllegalArgumentException e) {
//                System.out.println("cpu ko hop le");
//            } finally {
//                System.out.println(cpuStr);
//            }
//        }
//        Computer pc = new Computer.Builder().cpu("AMD").ram(12).gpu("AMD").build();
//        System.out.println(pc);

        //Bai 2
        BankAccount ba = new BankAccount(1200);
        System.out.print("Nhap so tien de deposit: ");
        double amountToDeposit = Double.parseDouble(sc.nextLine());
        ba.deposit(amountToDeposit);
        System.out.print("Nhap so tien de withdraw: ");
        double amountToWithdraw = Double.parseDouble(sc.nextLine());
        try {
            ba.withdraw(amountToWithdraw);
        } catch (InsufficientBalanceException ibe) {
            System.out.println(ibe.getMessage());
        }
    }
}
