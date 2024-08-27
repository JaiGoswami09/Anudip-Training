package dao;

import util.DBConnection;
import model.BankAccount;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BankAccountDAO {

    public void addBankAccount(BankAccount bankAccount) throws SQLException {
        Connection conn = DBConnection.getConnection();
        String query = "INSERT INTO accounts (account_number, customer_id, balance) VALUES (?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, bankAccount.getAccountId());
        stmt.setInt(2, bankAccount.getCustomerId());
        stmt.setDouble(3, bankAccount.getBalance());
        stmt.executeUpdate();
        stmt.close();
        conn.close();
    }

    public void updateBankAccount(BankAccount bankAccount) throws SQLException {
        Connection conn = DBConnection.getConnection();
        String query = "UPDATE accounts SET balance = ? WHERE account_number = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setDouble(1, bankAccount.getBalance());
        stmt.setString(2, bankAccount.getAccountId());
        stmt.executeUpdate();
        stmt.close();
        conn.close();
    }

    public void deleteBankAccount(String accountId) throws SQLException {
        Connection conn = DBConnection.getConnection();
        String query = "DELETE FROM accounts WHERE account_number = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, accountId);
        stmt.executeUpdate();
        stmt.close();
        conn.close();
        conn.commit();
    }

    public BankAccount getBankAccountByNumber(String accountId) throws SQLException {
        Connection conn = DBConnection.getConnection();
        String query = "SELECT a.account_number, a.customer_id, a.balance, c.username FROM accounts a " +
                "JOIN customers c ON a.customer_id = c.id WHERE a.account_number = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, accountId);
        ResultSet rs = stmt.executeQuery();

        BankAccount bankAccount = null;
        if (rs.next()) {
            bankAccount = new BankAccount(
                    rs.getString("account_number"),
                    rs.getInt("customer_id"),
                    rs.getDouble("balance"),
                    rs.getString("username"));
        }
        rs.close();
        stmt.close();
        conn.close();

        return bankAccount;
    }

    public List<BankAccount> getAllBankAccounts() throws SQLException {
        Connection conn = DBConnection.getConnection();
        String query = "SELECT a.account_number, a.customer_id, a.balance, c.username FROM accounts a " +
                "JOIN customers c ON a.customer_id = c.id";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        List<BankAccount> bankAccounts = new ArrayList<>();
        while (rs.next()) {
            bankAccounts.add(new BankAccount(
                    rs.getString("account_number"),
                    rs.getInt("customer_id"),
                    rs.getDouble("balance"),
                    rs.getString("username")));
        }
        rs.close();
        stmt.close();
        conn.close();

        return bankAccounts;
    }
}
