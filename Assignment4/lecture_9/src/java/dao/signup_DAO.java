/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class signup_DAO {

    public static boolean signup(String user, String password) {
        PreparedStatement ps = null;
        try {

            Connection con; //variable con of type Connection
            String dbURL = "jdbc:postgresql://127.0.0.1:5432/umt";
            String userName = "postgres";
            String Password = "zirwa";
            con = DriverManager.getConnection(dbURL, userName, Password);
            String query = "INSERT INTO student.login1(username, password) VALUES(?, ?)";
            ps = con.prepareStatement(query);

            ps.setString(1, user);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                // System.out.println(rs.getString("username"));
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        }

    }
}
