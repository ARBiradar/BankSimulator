import java.util.ArrayList;
import java.util.Scanner;
public class BankSimulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter account holder name: ");
        String name = scanner.nextLine();

        Account account = new Account(name);

        boolean running = true;
        while (running) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Deposit\n2. Withdraw\n3. Check Balance\n4. Transaction History\n5. Exit");
            System.out.print("Enter choice (1-5): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ₹");
                    double depAmount = scanner.nextDouble();
                    account.deposit(depAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ₹");
                    double withAmount = scanner.nextDouble();
                    account.withdraw(withAmount);
                    break;
                case 3:
                    account.printBalance();
                    break;
                case 4:
                    account.showTransactionHistory();
                    break;
                case 5:
                    running = false;
                    System.out.println("Thank you for banking with us, " + name + "!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

        scanner.close();
    }
}

class Account {
    private String accountHolder;
    private double balance;
    private ArrayList<String> transactionHistory;

    public Account(String accountHolder) {
        this.accountHolder = accountHolder;
        this.balance = 0.0;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add("Account opened for " + accountHolder + ".");
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposited: ₹" + amount);
            System.out.println("₹" + amount + " deposited successfully.");
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrew: ₹" + amount);
            System.out.println("₹" + amount + " withdrawn successfully.");
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public void printBalance() {
        System.out.println("Current Balance: ₹" + balance);
    }

    public void showTransactionHistory() {
        System.out.println("\nTransaction History:");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }
}

