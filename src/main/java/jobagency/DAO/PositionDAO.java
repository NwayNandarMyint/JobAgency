package jobagency.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jobagency.DTO.PositionRequestDTO;
import jobagency.DTO.PositionResponseDTO;

public class PositionDAO {

	public static Connection con=null;
	static {
		con=MyConnection.getConnection();
	}
	
	//Insert
			public int addPosition(PositionRequestDTO positionDTO) {
				int result=0;
				String sql="INSERT INTO position (name,is_delete) VALUES(?,?)";
				try {
					PreparedStatement ps=con.prepareStatement(sql);
					ps.setString(1, positionDTO.getName());
					ps.setBoolean(2, false);
					
					result=ps.executeUpdate();	
				}catch(SQLException e) {
					System.out.println("Insert Errot"+e);
				}
				return result;
			}
			
		//Update
			
			public int editPosition(PositionRequestDTO positionDTO) {
				int result = 0;
				String sql = "UPDATE position SET name=? WHERE id=?";
				try {
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setString(1, positionDTO.getName());
					ps.setInt(2, positionDTO.getId());
					
					result = ps.executeUpdate();
				} catch (SQLException e) {
					System.out.println("Position Update error: " + e);
				}
				return result;
			}
			
		//Delete
			
			public static int deletePosition(int id ) {
				int result = 0;
				String sql = "update position set is_delete=? where id=?";
				try {
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setInt(1, 1);
					ps.setInt(2, id);
					result = ps.executeUpdate();
				} catch (SQLException e) {
					System.out.println("Position Delete error: " + e);
				}
				return result;
			}
			
		//selectById
			
			public PositionResponseDTO getPositionById(int id) {
				PositionResponseDTO position = new PositionResponseDTO();
				String sql = "SELECT * FROM position WHERE id=?";
				try {
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setInt(1, id);
					ResultSet rs = ps.executeQuery();

					while (rs.next()) {
						position.setId(rs.getInt("id"));
						position.setName(rs.getString("name"));	
					}
				} catch (SQLException e) {
					System.out.println("select position by id error" + e);
				}
				return position;
			}
			
	//Select By Id
			
			public PositionResponseDTO getpositionById(int id) {
				PositionResponseDTO position = new PositionResponseDTO();
				String sql = "SELECT * FROM position WHERE id=?";
				try {
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setInt(1, id);
					ResultSet rs = ps.executeQuery();

					while (rs.next()) {
						position.setId(rs.getInt("id"));
						position.setName(rs.getString("name"));	
					}
				} catch (SQLException e) {
					System.out.println("select position by id error" + e);
				}
				return position;
			}
			
			//selectNameById
			public String getPositionNameById(int id) {
					String name="";
					String sql = "SELECT name FROM position WHERE id=?";
					try {
						PreparedStatement ps = con.prepareStatement(sql);
						ps.setInt(1, id);
						ResultSet rs = ps.executeQuery();

						while (rs.next()) {					
							name=rs.getString("name");					
						}
					} catch (SQLException e) {
						System.out.println("select position by id error" + e);
					}
					return name;
				}
			
			
	//Select All
			
			public List<PositionResponseDTO> getAllPosition() {
				List<PositionResponseDTO> positions=new ArrayList<PositionResponseDTO>();
				String sql="SELECT * FROM position WHERE is_delete = 0";
				
				try {
					PreparedStatement ps=con.prepareStatement(sql);			
					ResultSet rs=ps.executeQuery();			
					while(rs.next()) {
						PositionResponseDTO position=new PositionResponseDTO();
						position.setId(rs.getInt("id"));
						position.setName(rs.getString("name"));		
						positions.add(position);
					}				
				}catch(SQLException e) {
					System.out.println("select all error: "+e);
				}
				return positions;
			}
	
}
