import java.util.ArrayList;
import java.util.Scanner;

class Account {
    private String accountID;
    private String accountHolder;
    private double balance;

    public Account(String accountID, String accountHolder, double balance) {
        this.accountID = accountID;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public String getAccountID() {
        return accountID;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    private boolean isTwoDecimal(double value) {
        return Math.round(value * 100) == value * 100;
    }

    public void deposit(double amount) throws Exception {
        if (amount <= 0 || amount > 1000) {
            throw new Exception("Deposit amount must be between 0 and 1000.");
        }

        if (!isTwoDecimal(amount)) {
            throw new Exception("Only 2 decimal points allowed.");
        }

        if (balance + amount > 100000) {
            throw new Exception("Maximum balance exceeded.");
        }

        balance += amount;

        System.out.println("Deposit successful.");
    }

    public void withdraw(double amount) throws Exception {
        if (amount <= 0) {
            throw new Exception("Invalid withdraw amount.");
        }

        if (!isTwoDecimal(amount)) {
            throw new Exception("Only 2 decimal points allowed.");
        }

        if (balance - amount < 0) {
            throw new Exception("Insufficient balance.");
        }

        balance -= amount;

        System.out.println("Withdraw successful.");
    }
}

class BankManagement {
    private ArrayList<Account> accounts = new ArrayList<>();

    public void createAccount(Scanner sc) {
        System.out.print("Enter Account ID: ");
        String id = sc.next();

        for (Account acc : accounts) {
            if (acc.getAccountID().equals(id)) {
                System.out.println("Account ID already exists.");
                return;
            }
        }

        sc.nextLine();

        System.out.print("Enter Account Holder Name: ");
        String holder = sc.nextLine();

        try {
            System.out.print("Enter Initial Balance: ");
            double balance = sc.nextDouble();

            if (balance < 0) {
                throw new Exception("Balance cannot be negative.");
            }

            if (Math.round(balance * 100) != balance * 100) {
                throw new Exception("Only 2 decimal points allowed.");
            }

            Account acc = new Account(id, holder, balance);

            accounts.add(acc);

            System.out.println("Account created successfully.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            sc.nextLine();
        }
    }

    public void showAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts found.");
            return;
        }

        System.out.println("\n:::: Account List ::::\n");

        int count = 1;

        for (Account acc : accounts) {
            System.out.println("No #" + count++);
            System.out.println("ACC_ID: " + acc.getAccountID());
            System.out.println("ACC_HOLDER: " + acc.getAccountHolder());
            System.out.printf("ACC_BALANCE: %.2f$\n", acc.getBalance());
            System.out.println();
        }
    }

    public Account findAccount(String id) {
        for (Account acc : accounts) {
            if (acc.getAccountID().equals(id)) {
                return acc;
            }
        }
        return null;
    }

    public void depositMoney(Scanner sc) {
        System.out.print("Enter Account ID: ");
        String id = sc.next();

        Account acc = findAccount(id);

        if (acc == null) {
            System.out.println("Account not found.");
            return;
        }

        try {
            System.out.print("Enter Amount: ");
            double amount = sc.nextDouble();

            acc.deposit(amount);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            sc.nextLine();
        }
    }

    public void withdrawMoney(Scanner sc) {
        System.out.print("Enter Account ID: ");
        String id = sc.next();

        Account acc = findAccount(id);

        if (acc == null) {
            System.out.println("Account not found.");
            return;
        }

        try {
            System.out.print("Enter Amount: ");
            double amount = sc.nextDouble();

            acc.withdraw(amount);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            sc.nextLine();
        }
    }

    public void transferMoney(Scanner sc) {
        System.out.print("Enter Sender Account ID: ");
        String senderID = sc.next();

        System.out.print("Enter Receiver Account ID: ");
        String receiverID = sc.next();

        Account sender = findAccount(senderID);
        Account receiver = findAccount(receiverID);

        if (sender == null || receiver == null) {
            System.out.println("Invalid account ID.");
            return;
        }

        try {
            System.out.print("Enter Amount: ");
            double amount = sc.nextDouble();

            sender.withdraw(amount);
            receiver.deposit(amount);

            System.out.println("Transfer successful.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            sc.nextLine();
        }
    }
}

public class oop82 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BankManagement bank = new BankManagement();

        while (true) {
            System.out.println("\n:::: The Bank ::::");
            System.out.println("1. Account List");
            System.out.println("2. Create an account");
            System.out.println("3. Deposit to an account");
            System.out.println("4. Withdraw from an account");
            System.out.println("5. Transfer to another account");
            System.out.println("6. Quit");

            System.out.print("Choose an option: ");

            int option;

            try {
                option = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input.");
                sc.nextLine();
                continue;
            }

            switch (option) {
                case 1:
                    bank.showAccounts();
                    break;

                case 2:
                    bank.createAccount(sc);
                    break;

                case 3:
                    bank.depositMoney(sc);
                    break;

                case 4:
                    bank.withdrawMoney(sc);
                    break;

                case 5:
                    bank.transferMoney(sc);
                    break;

                case 6:
                    System.out.println("Program terminated.");
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}