package jobagency.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jobagency.DTO.AdminRequestDTO;
import jobagency.DTO.AdminResponseDTO;

public class AdminDAO {

	public static Connection con=null;
	static {
		con=MyConnection.getConnection();
	}
	
	//Insert
	public int addAdmin(AdminRequestDTO adminDTO) {
		int result=0;
		String sql="INSERT INTO admin(name,email,password,role_id,is_delete) VALUES(?,?,?,?,?)";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, adminDTO.getName());
			ps.setString(2, adminDTO.getEmail());
			ps.setString(3, adminDTO.getPassword());
			ps.setInt(4, adminDTO.getRole_id());
			ps.setInt(5, 0);
			result=ps.executeUpdate();	
		}catch(SQLException e) {
			System.out.println("Insert Errot"+e);
		}
		return result;
	}
	
	//Update 
	
	public int editAdmin(AdminRequestDTO adminDTO) {
		int result = 0;
		String sql = "UPDATE admin SET name=?,email=?,password=?,role_id=? WHERE id=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, adminDTO.getName());
			ps.setString(2, adminDTO.getEmail());
			ps.setString(3, adminDTO.getPassword());
			ps.setInt(4, adminDTO.getRole_id());
			ps.setInt(5, adminDTO.getId());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Admin Update error: " + e);
		}
		return result;
	}
	
	//Delete
	
	public static int deleteAdmin(int id ) {
		int result = 0;
		String sql = "update admin set is_delete=? where id=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, 1);
			ps.setInt(2, id);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Admin Delete error: " + e);
		}
		return result;
	}
	
	//selectById
		public AdminResponseDTO getAdminById(int id) {
			AdminResponseDTO author = new AdminResponseDTO();
			String sql = "SELECT * FROM admin WHERE id=?";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					author.setId(rs.getInt("id"));
					author.setName(rs.getString("name"));
					author.setEmail(rs.getString("email"));
					author.setPassword(rs.getString("password"));
					author.setRole_id(rs.getInt("role_id"));
				}
			} catch (SQLException e) {
				System.out.println("select admin by id error" + e);
			}
			return author;
		}
		//selectNameById
		public String getAdminNameById(int id) {
				String name="";
				String sql = "SELECT name FROM admin WHERE id=?";
				try {
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setInt(1, id);
					ResultSet rs = ps.executeQuery();

					while (rs.next()) {					
						name=rs.getString("name");					
					}
				} catch (SQLException e) {
					System.out.println("select admin by id error" + e);
				}
				return name;
			}
	
	//Select All
	public List<AdminResponseDTO> getAllAdmin() {
		List<AdminResponseDTO> admins=new ArrayList<AdminResponseDTO>();
		String sql="SELECT a.*,r.name FROM admin a inner join role r on a.role_id=r.id where is_delete=0";
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);			
			ResultSet rs=ps.executeQuery();			
			while(rs.next()) {
				AdminResponseDTO admin=new AdminResponseDTO();
				admin.setId(rs.getInt("id"));
				admin.setName(rs.getString("name"));
				admin.setEmail(rs.getString("email"));
				admin.setPassword(rs.getString("password"));
				admin.setRole_id(rs.getInt("role_id"));
				//admin.setRole_name(rs.getString("role"));
				admins.add(admin);
			}				
		}catch(SQLException e) {
			System.out.println("select all error: "+e);
		}
		return admins;
	}
	
	
	
}
