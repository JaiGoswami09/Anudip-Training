package Lab_2;

import java.util.Scanner;

public class EmailAccount {
    private String email;

    public void createEmail() throws InvalidEmailException {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Please Enter Your EmailID Here: ");
            String userInput = sc.next();
            if (!isValidEmail(userInput)) {
                throw new InvalidEmailException("The Given Email Is Invalid: " + userInput);
            }
            this.email = userInput;
            System.out.println("Given MailID Is Valid Your Account Is Created Successfully: " + this.email);
        } finally {
            sc.close();
        }
    }

    public boolean isValidEmail(String email) {
        return email != null && email.contains("@");
    }

    public static class InvalidEmailException extends Exception {
        public InvalidEmailException(String message) {
            super(message);
        }
    }

    public static void main(String[] args) {
        EmailAccount emailAccount = new EmailAccount();
        try {
            emailAccount.createEmail();
        } catch (InvalidEmailException e) {
            System.out.println(e.getMessage());
        }
    }
}