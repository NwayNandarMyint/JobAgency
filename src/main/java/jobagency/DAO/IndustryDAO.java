package jobagency.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jobagency.DTO.IndustryRequestDTO;
import jobagency.DTO.IndustryResponseDTO;

public class IndustryDAO {

	public static Connection con=null;
	static {
		con=MyConnection.getConnection();
	}
	
	//Insert
			public int addIndustry(IndustryRequestDTO industryDTO) {
				int result=0;
				String sql="INSERT INTO industry (name,is_delete) VALUES(?,?)";
				try {
					PreparedStatement ps=con.prepareStatement(sql);
					ps.setString(1, industryDTO.getName());
					ps.setInt(2, 0);
					
					result=ps.executeUpdate();	
				}catch(SQLException e) {
					System.out.println("Insert Errot"+e);
				}
				return result;
			}
			
	//Update
			
			public int editIndustry(IndustryRequestDTO industryDTO) {
				int result = 0;
				String sql = "UPDATE industry SET name=? WHERE id=?";
				try {
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setString(1, industryDTO.getName());
					ps.setInt(2, industryDTO.getId());
					
					result = ps.executeUpdate();
				} catch (SQLException e) {
					System.out.println("Industry Update error: " + e);
				}
				return result;
			}
			
	//Delete
			
			public static int deleteIndustry(int id ) {
				int result = 0;
				String sql = "update industry set is_delete=? where id=?";
				try {
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setInt(1, 1);
					ps.setInt(2, id);
					result = ps.executeUpdate();
				} catch (SQLException e) {
					System.out.println("Language Delete error: " + e);
				}
				return result;
			}
			
	//selectById
			
			public IndustryResponseDTO getIndustryById(int id) {
				IndustryResponseDTO industry = new IndustryResponseDTO();
				String sql = "SELECT * FROM industry WHERE id=?";
				try {
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setInt(1, id);
					ResultSet rs = ps.executeQuery();

					while (rs.next()) {
						industry.setId(rs.getInt("id"));
						industry.setName(rs.getString("name"));	
					}
				} catch (SQLException e) {
					System.out.println("select industry by id error" + e);
				}
				return industry;
			}
			
	//Select Id By Name
			 public String getIndustryNameById(int id) {
		          String name="";
		          String sql = "SELECT name FROM industry WHERE id=?";
		          try {
		            PreparedStatement ps = con.prepareStatement(sql);
		            ps.setInt(1, id);
		            ResultSet rs = ps.executeQuery();

		            while (rs.next()) {          
		              name=rs.getString("name");          
		            }
		          } catch (SQLException e) {
		            System.out.println("select industry by id error" + e);
		          }
		          return name;
		        }
			
	//Select All
			public List<IndustryResponseDTO> getAllIndustry() {
				List<IndustryResponseDTO> industrys=new ArrayList<IndustryResponseDTO>();
				String sql="SELECT * FROM industry where is_delete=0";
				
				try {
					PreparedStatement ps=con.prepareStatement(sql);			
					ResultSet rs=ps.executeQuery();			
					while(rs.next()) {
						IndustryResponseDTO industry=new IndustryResponseDTO();
						industry.setId(rs.getInt("id"));
						industry.setName(rs.getString("name"));
						
						industrys.add(industry);
					}				
				}catch(SQLException e) {
					System.out.println("select all error: "+e);
				}
				return industrys;
			}
	
}
