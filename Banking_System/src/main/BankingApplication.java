package main;

import service.AuthenticationService;
import model.BankCustomer;

import java.sql.SQLException;
import java.util.Scanner;

public class BankingApplication {

    private static AuthenticationService authService = new AuthenticationService();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Banking System");
        System.out.println("1. Login");
        System.out.println("2. Register");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            System.out.print("Enter Username: ");
            String username = scanner.nextLine();
            System.out.print("Enter Password: ");
            String password = scanner.nextLine();

            try {
                BankCustomer customer = authService.authenticate(username, password);
                if (customer != null) {
                    System.out.println("Login successful. Welcome, " + customer.getName() + "!");
                    UserPortal.main(new String[] {});
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        } else if (choice == 2) {
            System.out.print("Enter Username: ");
            String username = scanner.nextLine();
            System.out.print("Enter Password: ");
            String password = scanner.nextLine();
            System.out.print("Enter Name: ");
            String name = scanner.nextLine();

            try {
                authService.registerCustomer(new BankCustomer(0, username, password, name));
                System.out.println("Registration successful. Please login.");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        scanner.close();
    }
}
