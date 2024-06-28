import java.util.Scanner;

public class ATM {
    private UserManager userManager;
    private Scanner scanner;
    private User currentUser;

    public ATM() {
        userManager = new UserManager();
        scanner = new Scanner(System.in);
        initializeUsers();
    }

    private void initializeUsers() {
        // Add some users for demonstration
        userManager.addUser("user1", "1234");
        userManager.addUser("user2", "5678");
    }

    public void start() {
        System.out.println("Welcome to the ATM");

        while (true) {
            System.out.print("Enter User ID: ");
            String userId = scanner.nextLine();
            System.out.print("Enter PIN: ");
            String pin = scanner.nextLine();

            if (userManager.validateUser(userId, pin)) {
                currentUser = userManager.getUser(userId);
                System.out.println("Login successful!");
                showMenu();
            } else {
                System.out.println("Invalid User ID or PIN. Try again.");
            }
        }
    }

    private void showMenu() {
        boolean running = true;

        while (running) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Transactions History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.print("Choose an option: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    showTransactionHistory();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    deposit();
                    break;
                case 4:
                    transfer();
                    break;
                case 5:
                    running = false;
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void showTransactionHistory() {
        System.out.println("\nTransaction History:");
        for (String transaction : currentUser.getTransactionHistory()) {
            System.out.println(transaction);
        }
    }

    private void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        double amount = Double.parseDouble(scanner.nextLine());
        if (currentUser.withdraw(amount)) {
            System.out.println("Withdrawal successful. New balance: " + currentUser.getBalance());
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    private void deposit() {
        System.out.print("Enter amount to deposit: ");
        double amount = Double.parseDouble(scanner.nextLine());
        currentUser.deposit(amount);
        System.out.println("Deposit successful. New balance: " + currentUser.getBalance());
    }

    private void transfer() {
        System.out.print("Enter recipient User ID: ");
        String recipientUserId = scanner.nextLine();
        User recipient = userManager.getUser(recipientUserId);
        if (recipient == null) {
            System.out.println("Recipient not found.");
            return;
        }

        System.out.print("Enter amount to transfer: ");
        double amount = Double.parseDouble(scanner.nextLine());
        if (currentUser.transfer(recipient, amount)) {
            System.out.println("Transfer successful. New balance: " + currentUser.getBalance());
        } else {
            System.out.println("Insufficient funds.");
        }
    }
}
