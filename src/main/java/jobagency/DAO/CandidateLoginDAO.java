package jobagency.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class CandidateLoginDAO {
	public static Connection con=null;
	static {
		con=MyConnection.getConnection();
	}
	public boolean checkingCandidateLogin(String email, String password) {
        String sql = "SELECT * FROM candidate WHERE email = ? AND password = ?";
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
            System.out.println("select candidate error" + e);
        }
        return false;
    }

public int getCandidateId(String email, String password) {
    int result = 0;
    String sql = "SELECT id FROM candidate WHERE email = ? AND password = ?";
    
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, email);
        ps.setString(2, password);
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            int candidateId = rs.getInt("id");
            return candidateId;
        }
    } catch (SQLException e) {
        System.out.println("Select company error: " + e);
    }
    
    return result;
}
}
