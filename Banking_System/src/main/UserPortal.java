package main;

import service.UserService;
import model.BankAccount;
import model.AccountTransaction;

import java.sql.SQLException;
import java.util.Scanner;

public class UserPortal {

    private static UserService userService = new UserService();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("User Portal");
        while (true) {
            System.out.println("1. Transfer Funds");
            System.out.println("2. View Transaction History");
            System.out.println("3. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter Your Account ID: ");
                        String fromAccountId = scanner.nextLine();
                        System.out.print("Enter Recipient's Account ID: ");
                        String toAccountId = scanner.nextLine();
                        System.out.print("Enter Amount to Transfer: ");
                        double amount = scanner.nextDouble();
                        scanner.nextLine();

                        userService.performTransfer(fromAccountId, toAccountId, amount);
                        System.out.println("Transfer completed successfully.");
                        break;

                    case 2:
                        System.out.print("Enter Account ID to View Transaction History: ");
                        String accountId = scanner.nextLine();
                        userService.getTransactionHistoryForAccount(accountId).forEach(
                                transaction -> System.out.println("Transaction ID: " + transaction.getTransactionId() +
                                        ", Amount: " + transaction.getAmount() +
                                        ", Type: " + transaction.getType() +
                                        ", Date: " + transaction.getTimestamp()));
                        break;

                    case 3:
                        System.out.println("Exiting User Portal...");
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
