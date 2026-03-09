public class BankAccount {
    String accountName;
    int accountNumber;
    String bankName;
    double balance;
    String accountType;

    BankAccount(String accountName, int accountNumber, String bankName, double balance, String accountType)
    {
        this.accountName = accountName;
        this.accountNumber = accountNumber;
        this.bankName = bankName;
        this.balance = balance;
        this.accountType = accountType;
    }

    public void printInfo()
    {
        System.out.println("\tInformation of Bank Account");
        System.out.println("Account Name : " + accountName);
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Bank Name : " + bankName);
        System.out.println("Balance : $" + balance);
        System.out.println("Account Type : " + accountType);
        System.out.println("-".repeat(40));
    }
}