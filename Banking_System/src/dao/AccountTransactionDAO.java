package dao;

import model.AccountTransaction;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountTransactionDAO {

    public void addAccountTransaction(AccountTransaction accountTransaction) throws SQLException {
        Connection conn = DBConnection.getConnection();
        String query = "INSERT INTO transactions (account_number, amount, transaction_type, date) VALUES (?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, accountTransaction.getAccountId());
        stmt.setDouble(2, accountTransaction.getAmount());
        stmt.setString(3, accountTransaction.getType());
        stmt.setTimestamp(4, accountTransaction.getTimestamp());
        stmt.executeUpdate();
        stmt.close();
        conn.close();
    }

    public List<AccountTransaction> getAccountTransactionsByAccount(String accountId) throws SQLException {
        Connection conn = DBConnection.getConnection();
        String query = "SELECT * FROM transactions WHERE account_number = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, accountId);
        ResultSet rs = stmt.executeQuery();

        List<AccountTransaction> transactions = new ArrayList<>();
        while (rs.next()) {
            transactions.add(new AccountTransaction(
                    rs.getInt("id"),
                    rs.getString("account_number"),
                    rs.getDouble("amount"),
                    rs.getString("transaction_type"),
                    rs.getTimestamp("date")));
        }
        rs.close();
        stmt.close();
        conn.close();

        return transactions;
    }
}
