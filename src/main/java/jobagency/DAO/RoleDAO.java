package jobagency.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jobagency.DTO.LevelRequestDTO;
import jobagency.DTO.LevelResponseDTO;
import jobagency.DTO.RoleResponseDTO;

public class RoleDAO {

	public static Connection con=null;
	static {
		con=MyConnection.getConnection();
	}
	
	//Insert
	public int addLevel(LevelRequestDTO levelDTO) {
		int result=0;
		String sql="INSERT INTO level (name,is_delete) VALUES(?,?)";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, levelDTO.getName());
			ps.setInt(2, 0);
			
			result=ps.executeUpdate();	
		}catch(SQLException e) {
			System.out.println("Insert Errot"+e);
		}
		return result;
	}
	
	//Update
	
	public int editLevel(LevelRequestDTO levelDTO) {
		int result = 0;
		String sql = "UPDATE level SET name=? WHERE id=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, levelDTO.getName());
			ps.setInt(2, levelDTO.getId());
			
			result = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Level Update error: " + e);
		}
		return result;
	}
	
	//Delete
	
	public static int deleteLevel(int id ) {
		int result = 0;
		String sql = "update role set is_delete=? where id=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, 1);
			ps.setInt(2, id);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Level Delete error: " + e);
		}
		return result;
	}
	
	//selectById
	
	public LevelResponseDTO getLevelById(int id) {
		LevelResponseDTO level = new LevelResponseDTO();
		String sql = "SELECT * FROM role WHERE id=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				level.setId(rs.getInt("id"));
				level.setName(rs.getString("name"));	
			}
		} catch (SQLException e) {
			System.out.println("select industry by id error" + e);
		}
		return level;
	}
	
	
	public String getRoleNameById(int id) {
		String roleName=null;
		String sql = "SELECT name FROM role WHERE id=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {				
				roleName=rs.getString("name");	
			}
		} catch (SQLException e) {
			System.out.println("select role by id error" + e);
		}
		return roleName;
	}
	
	//Select All
	public List<RoleResponseDTO> getAllRole() {
		List<RoleResponseDTO> roles=new ArrayList<RoleResponseDTO>();
		String sql="SELECT * FROM role";
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);			
			ResultSet rs=ps.executeQuery();			
			while(rs.next()) {
				RoleResponseDTO role=new RoleResponseDTO();
				role.setId(rs.getInt("id"));
				role.setName(rs.getString("name"));
				
				roles.add(role);
			}				
		}catch(SQLException e) {
			System.out.println("select all error: "+e);
		}
		return roles;
	}
	
}
