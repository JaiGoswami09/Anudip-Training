package service;

import dao.BankCustomerDAO;
import model.BankCustomer;

import java.sql.SQLException;

public class AuthenticationService {
    private BankCustomerDAO bankCustomerDAO;

    public AuthenticationService() {
        bankCustomerDAO = new BankCustomerDAO();
    }

    public BankCustomer authenticate(String username, String password) throws SQLException {
        BankCustomer bankCustomer = bankCustomerDAO.getBankCustomerByUsername(username);
        if (bankCustomer != null && bankCustomer.getPassword().equals(password)) {
            return bankCustomer;
        } else {
            throw new SQLException("Invalid username or password");
        }
    }

    public void registerCustomer(BankCustomer bankCustomer) throws SQLException {
        bankCustomerDAO.addBankCustomer(bankCustomer);
    }
}
