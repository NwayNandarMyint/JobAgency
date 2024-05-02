package jobagency.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jobagency.DTO.LevelRequestDTO;
import jobagency.DTO.LevelResponseDTO;

public class LevelDAO {

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
		String sql = "update level set is_delete=? where id=?";
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
		String sql = "SELECT * FROM level WHERE id=?";
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
	
	//selectNameById
			public String getLevelNameById(int id) {
					String name="";
					String sql = "SELECT name FROM level WHERE id=?";
					try {
						PreparedStatement ps = con.prepareStatement(sql);
						ps.setInt(1, id);
						ResultSet rs = ps.executeQuery();

						while (rs.next()) {					
							name=rs.getString("name");					
						}
					} catch (SQLException e) {
						System.out.println("select level by id error" + e);
					}
					return name;
				}
	
	//Select All
	public List<LevelResponseDTO> getAllLevel() {
		List<LevelResponseDTO> levels=new ArrayList<LevelResponseDTO>();
		String sql="SELECT * FROM level where is_delete=0";
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);			
			ResultSet rs=ps.executeQuery();			
			while(rs.next()) {
				LevelResponseDTO level=new LevelResponseDTO();
				level.setId(rs.getInt("id"));
				level.setName(rs.getString("name"));
				
				levels.add(level);
			}				
		}catch(SQLException e) {
			System.out.println("select all error: "+e);
		}
		return levels;
	}
	
}
