package TryCatchNFiles.Ex3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BankAccount {
    double balance;

    BankAccount(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            log("Khong deposit duoc: invalid amount - " + amount);
            throw new InvalidAmountException("Amount phai > 0");
        }
        balance += amount;
        log("Deposit thang cong: " + amount + ", so du moi: " + balance);
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            log("Khong withdraw duoc: insufficent balance - " + balance);
            throw new InsufficientBalanceException("Khong du so du");
        }
        balance -= amount;
        log("Withdraw thang cong: " + amount + ", so du moi: " + balance);
    }

    public void log(String message) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("./src/TryCatchNFiles/Ex3/transaction.log", true))) {
            writer.write(message);
            writer.newLine();
        } catch (IOException io) {
            throw new RuntimeException(io);
        }
    }
}
