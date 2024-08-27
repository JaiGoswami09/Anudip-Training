package main;

import model.BankAccount;
import service.BankAccountService;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class BankAccountManager {

    private static BankAccountService bankAccountService = new BankAccountService();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bank Account Management Portal");
        while (true) {
            System.out.println("1. Create Bank Account");
            System.out.println("2. Update Bank Account");
            System.out.println("3. Delete Bank Account");
            System.out.println("4. View Bank Account Details");
            System.out.println("5. View All Bank Accounts");
            System.out.println("6. Deposit Funds");
            System.out.println("7. Withdraw Funds");
            System.out.println("8. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter Account ID: ");
                        String accountId = scanner.nextLine();
                        System.out.print("Enter Customer ID: ");
                        int customerId = scanner.nextInt();
                        System.out.print("Enter Initial Balance: ");
                        double balance = scanner.nextDouble();
                        scanner.nextLine();

                        bankAccountService.createBankAccount(new BankAccount(accountId, customerId, balance));
                        System.out.println("Bank account created successfully.");
                        break;

                    case 2:
                        System.out.print("Enter Account ID: ");
                        accountId = scanner.nextLine();
                        System.out.print("Enter New Balance: ");
                        balance = scanner.nextDouble();
                        scanner.nextLine();

                        bankAccountService.updateBankAccount(new BankAccount(accountId, 0, balance));
                        System.out.println("Bank account updated successfully.");
                        break;

                    case 3:
                        System.out.print("Enter Account ID to Delete: ");
                        accountId = scanner.nextLine();
                        bankAccountService.deleteBankAccount(accountId);
                        System.out.println("Bank account deleted successfully.");
                        break;

                    case 4:
                        System.out.print("Enter Account ID to View: ");
                        accountId = scanner.nextLine();
                        BankAccount bankAccount = bankAccountService.getBankAccountById(accountId);
                        if (bankAccount != null) {
                            System.out.println("Customer Name: " + bankAccount.getCustomerName());
                            System.out.println("Customer ID: " + bankAccount.getCustomerId());
                            System.out.println("Account ID: " + bankAccount.getAccountId());
                            System.out.println("Balance: " + bankAccount.getBalance());
                        } else {
                            System.out.println("Bank account not found.");
                        }
                        break;

                    case 5:
                        List<BankAccount> accounts = bankAccountService.getAllBankAccounts();
                        for (BankAccount acc : accounts) {
                            System.out.println("Customer Name: " + acc.getCustomerName() +
                                    ", Customer ID: " + acc.getCustomerId() +
                                    ", Account ID: " + acc.getAccountId() +
                                    ", Balance: " + acc.getBalance());
                        }
                        break;

                    case 6:
                        System.out.print("Enter Account ID: ");
                        accountId = scanner.nextLine();
                        System.out.print("Enter Deposit Amount: ");
                        double depositAmount = scanner.nextDouble();
                        scanner.nextLine();

                        bankAccountService.depositToAccount(accountId, depositAmount);
                        System.out.println("Funds deposited successfully.");
                        break;

                    case 7:
                        System.out.print("Enter Account ID: ");
                        accountId = scanner.nextLine();
                        System.out.print("Enter Withdrawal Amount: ");
                        double withdrawalAmount = scanner.nextDouble();
                        scanner.nextLine();

                        bankAccountService.withdrawFromAccount(accountId, withdrawalAmount);
                        System.out.println("Funds withdrawn successfully.");
                        break;

                    case 8:
                        System.out.println("Exiting Bank Account Management Portal...");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
