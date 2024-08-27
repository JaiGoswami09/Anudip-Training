package service;

import dao.BankAccountDAO;
import model.BankAccount;
import java.sql.SQLException;
import java.util.List;

public class BankAccountService {
    private BankAccountDAO bankAccountDAO;

    public BankAccountService() {
        bankAccountDAO = new BankAccountDAO();
    }

    public void createBankAccount(BankAccount bankAccount) throws SQLException {
        bankAccountDAO.addBankAccount(bankAccount);
    }

    public void updateBankAccount(BankAccount bankAccount) throws SQLException {
        bankAccountDAO.updateBankAccount(bankAccount);
    }

    public void deleteBankAccount(String accountId) throws SQLException {
        bankAccountDAO.deleteBankAccount(accountId);
    }

    public BankAccount getBankAccountById(String accountId) throws SQLException {
        return bankAccountDAO.getBankAccountByNumber(accountId);
    }

    public List<BankAccount> getAllBankAccounts() throws SQLException {
        return bankAccountDAO.getAllBankAccounts();
    }

    public void depositToAccount(String accountId, double amount) throws SQLException {
        BankAccount bankAccount = bankAccountDAO.getBankAccountByNumber(accountId);
        if (bankAccount != null) {
            bankAccount.setBalance(bankAccount.getBalance() + amount);
            bankAccountDAO.updateBankAccount(bankAccount);
        }
    }

    public void withdrawFromAccount(String accountId, double amount) throws SQLException {
        BankAccount bankAccount = bankAccountDAO.getBankAccountByNumber(accountId);
        if (bankAccount != null && bankAccount.getBalance() >= amount) {
            bankAccount.setBalance(bankAccount.getBalance() - amount);
            bankAccountDAO.updateBankAccount(bankAccount);
        }
    }
}
