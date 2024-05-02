package jobagency.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class AdminLoginDAO {
  public static Connection con=null;
  static {
    con=MyConnection.getConnection();
  }
  public boolean checkingAdminLogin(String email, String password) {
        String sql = "SELECT * FROM admin WHERE email = ? AND password = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            if(email.equals(rs.getString("email")) && password.equals(rs.getString("password"))) {
              return true;
            }
            else return false;
          }
        } catch (SQLException e) {
            System.out.println("select company error" + e);
        }
        return false;
    }
  public int getAdminById(String email, String password) {
      int result = 0;
      String sql = "SELECT id FROM admin WHERE email = ? AND password = ?";
      
      try {
          PreparedStatement ps = con.prepareStatement(sql);
          ps.setString(1, email);
          ps.setString(2, password);
          ResultSet rs = ps.executeQuery();
          
          while (rs.next()) {
              int employerId = rs.getInt("id");
              return employerId;
          }
      } catch (SQLException e) {
          System.out.println("Select company error: " + e);
      }
      
      return result;
  }

}