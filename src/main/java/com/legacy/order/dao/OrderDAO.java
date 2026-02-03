package com.legacy.order.dao;

import com.legacy.order.model.Order;
import com.legacy.order.util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class OrderDAO {

    public Order fetchOrder(int id) {
        try {
            Connection conn = DBUtil.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(
                "SELECT * FROM orders WHERE id=" + id
            );

            if (rs.next()) {
                Order o = new Order();
                o.setId(rs.getInt("id"));
                o.setCustomer(rs.getString("customer"));
                o.setAmount(rs.getDouble("amount"));
                return o;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void saveOrder(Order order) {
        try {
            Connection conn = DBUtil.getConnection();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(
                "INSERT INTO orders VALUES (" +
                order.getId() + ",'" +
                order.getCustomer() + "'," +
                order.getAmount() + ")"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
