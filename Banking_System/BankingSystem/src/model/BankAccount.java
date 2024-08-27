package model;

public class BankAccount {
    private String accountId;
    private int customerId;
    private double balance;
    private String customerName;

    public BankAccount(String accountId, int customerId, double balance, String customerName) {
        this.accountId = accountId;
        this.customerId = customerId;
        this.balance = balance;
        this.customerName = customerName;
    }

    public BankAccount(String accountId, int customerId, double balance) {
        this(accountId, customerId, balance, null);
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
