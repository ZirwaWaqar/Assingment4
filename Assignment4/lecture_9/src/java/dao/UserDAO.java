package dao;

import java.sql.*;

public class UserDAO {

    public static boolean login(String user, String password) {
        PreparedStatement ps = null;
        try {

            Connection con; //variable con of type Connection
            String dbURL = "jdbc:postgresql://127.0.0.1:5432/umt";
            String userName = "postgres";
            String Password = "zirwa";
            con = DriverManager.getConnection(dbURL, userName, Password);
            //String query="SELECT username, password FROM student.\*login1\" WHERE username=? AND password=?";
             //ps = con.prepareStatement(query);
            
            ps = con.prepareStatement("select username, password from student.\"login1\" WHERE username = ? AND password = ?");
            ps.setString(1, user);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) 
            {
                System.out.println(rs.getString("username"));
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
