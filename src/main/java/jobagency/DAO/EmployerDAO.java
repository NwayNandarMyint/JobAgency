package jobagency.DAO;

import java.sql.Connection;
import java.io.UnsupportedEncodingException;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.util.codec.binary.Base64;

import jobagency.DTO.EmployerRequestDTO;
import jobagency.DTO.EmployerResponseDTO;
public class EmployerDAO {
	public static Connection con=null;
	static {
		con=MyConnection.getConnection();
	}
	
	private String DateTime() {
	DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	LocalDateTime now=LocalDateTime.now();
	String datetime=dtf.format(now);
	return datetime;
}
	

	//insert
	public int addEmployer(EmployerRequestDTO employerDTO) {
		int result=0;
		String sql="INSERT INTO employer(name,email,password,phone_number,created_date,avaliable_jobpost,logo,industry_id) VALUES (?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, employerDTO.getName());
			ps.setString(2, employerDTO.getEmail());
			ps.setString(3, employerDTO.getPassword());
			ps.setString(4, employerDTO.getPhone_number());
			ps.setString(5, DateTime());
//	        Timestamp timestamp2 = Timestamp.valueOf(employerDTO.getUpdated_date());
//	        ps.setTimestamp(6, timestamp2);
			ps.setInt(6, employerDTO.getAvaliable_jobpost());
			Blob blob = new javax.sql.rowset.serial.SerialBlob(employerDTO.getLogo());
			ps.setBlob(7, blob);
			ps.setInt(8, employerDTO.getIndustry_id());
			
			result=ps.executeUpdate();	
		}catch(SQLException e) {
			System.out.println("Insert Error"+e);
		}
		return result;
	}
	
	//update
	public int updateEmployer(EmployerRequestDTO employerDTO) {
		int result = 0;
		String sql="";		
		if(employerDTO.getLogo()!=null)
		  sql = "UPDATE employer SET name=?,email=?,password=?,phone_number=?,updated_date=?,logo=? WHERE id=?";
		else
			sql = "UPDATE employer SET name=?,email=?,password=?,phone_number=?,updated_date=? WHERE id=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, employerDTO.getName());			
			ps.setString(2, employerDTO.getEmail());			
			ps.setString(3, employerDTO.getPassword());			
			ps.setString(4, employerDTO.getPhone_number());			
			ps.setString(5, DateTime());
			
			if(employerDTO.getLogo()!=null) {
				Blob blob = new javax.sql.rowset.serial.SerialBlob(employerDTO.getLogo());
				ps.setBlob(6, blob);				    	
		        ps.setInt(7, employerDTO.getId());	
			}else {
				ps.setInt(6, employerDTO.getId());
				System.out.println(employerDTO.getId());
			}			        
			result = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Employer Update error: " + e);
		}
		return result;
	}
	//delete
	public int deleteEmployer(int id) {
		int result = 0;
		String sql = "DELETE FROM employer WHERE id=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);

			result = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Employer Delete error: " + e);
		}
		return result;
	}
			
	//selectById
	public EmployerResponseDTO getEmployerById(int id) {
		EmployerResponseDTO employer = new EmployerResponseDTO();
		String sql = "SELECT * FROM employer WHERE id=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				employer.setId(rs.getInt("id"));
				employer.setName(rs.getString("name"));
				employer.setEmail(rs.getString("email"));
				employer.setPassword(rs.getString("password"));
				employer.setPhone_number(rs.getString("phone_number"));
				employer.setCreated_date(rs.getString("created_date"));
				Blob blob = (Blob) rs.getBlob("logo");
	            byte [] bytes  =  blob.getBytes(1,(int) blob.length());
	            byte[] encodeBase64 = Base64.encodeBase64(bytes);
	            try {
	            	employer.setLogo(new String(encodeBase64, "UTF-8"));
	              } catch (UnsupportedEncodingException e) {
	                e.printStackTrace();
	              }
				employer.setAvaliable_jobpost(rs.getInt("avaliable_jobpost"));
				employer.setIndustry_id(rs.getInt("industry_id"));
			}
		} catch (SQLException e) {
			System.out.println("select employer by id error" + e);
		}
		return employer;
	}
	
	//selectNameById
			public String getEmployerNameById(int id) {
					String name="";
					String sql = "SELECT name FROM employer WHERE id=?";
					try {
						PreparedStatement ps = con.prepareStatement(sql);
						ps.setInt(1, id);
						ResultSet rs = ps.executeQuery();

						while (rs.next()) {					
							name=rs.getString("name");					
						}
					} catch (SQLException e) {
						System.out.println("select employer by id error" + e);
					}
					return name;
				}
			
	//selectAll
			public List<EmployerResponseDTO> getEmployers() {
			    List<EmployerResponseDTO> employers = new ArrayList<EmployerResponseDTO>();
			    String sql = "SELECT * FROM employer";
			    try {
			      PreparedStatement ps = con.prepareStatement(sql);
			      ResultSet rs = ps.executeQuery();
			      while (rs.next()) {
			        EmployerResponseDTO employer = new EmployerResponseDTO();
			        employer.setId(rs.getInt("id"));
			        employer.setName(rs.getString("name"));
			        employer.setEmail(rs.getString("email"));
			        employer.setPassword(rs.getString("password"));
			        employer.setPhone_number(rs.getString("phone_number"));
			        Blob blob = (Blob) rs.getBlob("logo");
			              byte [] bytes  =  blob.getBytes(1,(int) blob.length());
			              byte[] encodeBase64 = Base64.encodeBase64(bytes);
			              try {
			          employer.setLogo(new String(encodeBase64, "UTF-8"));
			        } catch (UnsupportedEncodingException e) {
			          
			          e.printStackTrace();
			        }
			        employer.setCreated_date(rs.getString("created_date"));
			        employer.setAvaliable_jobpost(rs.getInt("avaliable_jobpost"));
			        employer.setIndustry_id(rs.getInt("industry_id"));
			        employers.add(employer);
			      }
			    } catch (SQLException e) {
			      System.out.println("select employer all error: " + e);
			    }
			    return employers;
	}
			
			// insert avaliable jobpost
			public int insertAvailabeJobPost(EmployerRequestDTO employerDTO) {
				int result = 0;
				String sql = "UPDATE employer SET avaliable_jobpost = avaliable_jobpost + ? WHERE id = ?";
				try {
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setInt(1, employerDTO.getAvaliable_jobpost());
					ps.setInt(2, employerDTO.getId());
					
					result = ps.executeUpdate();
				} catch (SQLException e) {
					System.out.println("Ticket Update error: " + e);
				}
				return result;
			}
			// insert avaliable jobpost
		public int updateAvailabeJobPost(EmployerRequestDTO employerDTO) {
				int result = 0;
				String sql = "UPDATE employer SET avaliable_jobpost=? WHERE id=?";
							try {
								PreparedStatement ps = con.prepareStatement(sql);
								ps.setInt(1, employerDTO.getAvaliable_jobpost());
								ps.setInt(2, employerDTO.getId());
								
								result = ps.executeUpdate();
						} catch (SQLException e) {
							System.out.println("Ticket Update error: " + e);
					}
				return result;
		}
}
