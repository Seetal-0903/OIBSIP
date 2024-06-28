import java.util.ArrayList;
import java.util.List;

public class User {
    private String userId;
    private String pin;
    private double balance;
    private List<String> transactionHistory;

    public User(String userId, String pin) {
        this.userId = userId;
        this.pin = pin;
        this.balance = 5000.0;
        this.transactionHistory = new ArrayList<>();
    }

    public String getUserId() {
        return userId;
    }

    public String getPin() {
        return pin;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        transactionHistory.add("Deposited: " + amount);
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            transactionHistory.add("Withdrew: " + amount);
            return true;
        } else {
            return false;
        }
    }

    public boolean transfer(User recipient, double amount) {
        if (balance >= amount) {
            balance -= amount;
            recipient.deposit(amount);
            transactionHistory.add("Transferred: " + amount + " to " + recipient.getUserId());
            return true;
        } else {
            return false;
        }
    }

    public List<String> getTransactionHistory() {
        return transactionHistory;
    }
}
