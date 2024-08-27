

package dao;

import model.BankCustomer;
import util.DBConnection;

import java.sql.*;

public class BankCustomerDAO {

    public void addBankCustomer(BankCustomer bankCustomer) throws SQLException {
        Connection conn = DBConnection.getConnection();
        String query = "INSERT INTO customers (username, password, name) VALUES (?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, bankCustomer.getUsername());
        stmt.setString(2, bankCustomer.getPassword());
        stmt.setString(3, bankCustomer.getName());
        stmt.executeUpdate();
        stmt.close();
        conn.close();
    }

    public BankCustomer getBankCustomerByUsername(String username) throws SQLException {
        Connection conn = DBConnection.getConnection();
        String query = "SELECT * FROM customers WHERE username = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, username);
        ResultSet rs = stmt.executeQuery();

        BankCustomer bankCustomer = null;
        if (rs.next()) {
            bankCustomer = new BankCustomer(
                    rs.getInt("id"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("name")
            );
        }
        rs.close();
        stmt.close();
        conn.close();

        return bankCustomer;
    }
}

