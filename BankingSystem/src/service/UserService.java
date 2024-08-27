package service;

import dao.BankAccountDAO;
import dao.AccountTransactionDAO;
import model.BankAccount;
import model.AccountTransaction;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

public class UserService {
    private BankAccountDAO bankAccountDAO;
    private AccountTransactionDAO accountTransactionDAO;

    public UserService() {
        bankAccountDAO = new BankAccountDAO();
        accountTransactionDAO = new AccountTransactionDAO();
    }

    public void performTransfer(String fromAccountId, String toAccountId, double amount) throws SQLException {
        BankAccount fromAccount = bankAccountDAO.getBankAccountByNumber(fromAccountId);
        BankAccount toAccount = bankAccountDAO.getBankAccountByNumber(toAccountId);

        if (fromAccount != null && toAccount != null && fromAccount.getBalance() >= amount) {
            fromAccount.setBalance(fromAccount.getBalance() - amount);
            bankAccountDAO.updateBankAccount(fromAccount);

            toAccount.setBalance(toAccount.getBalance() + amount);
            bankAccountDAO.updateBankAccount(toAccount);

            AccountTransaction fromTransaction = new AccountTransaction(0, fromAccountId, -amount, "Debit",
                    new Timestamp(System.currentTimeMillis()));
            AccountTransaction toTransaction = new AccountTransaction(0, toAccountId, amount, "Credit",
                    new Timestamp(System.currentTimeMillis()));

            accountTransactionDAO.addAccountTransaction(fromTransaction);
            accountTransactionDAO.addAccountTransaction(toTransaction);
        } else {
            throw new SQLException("Transfer failed. Either accounts do not exist or insufficient funds.");
        }
    }

    public List<AccountTransaction> getTransactionHistoryForAccount(String accountId) throws SQLException {
        return accountTransactionDAO.getAccountTransactionsByAccount(accountId);
    }
}
