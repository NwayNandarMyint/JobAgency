package jobagency.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import jobagency.DTO.CandidateRequestDTO;
import jobagency.DTO.CandidateResponseDTO;



public class CandidateDAO {

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
	
	//Insert
	public int addCandidate(CandidateRequestDTO candidateDTO) {
		int result=0;
		String sql="INSERT INTO candidate(name,email,password,phone,created_date,date_of_birth,nationality,marital_status,gender,contact_address,parmanent_address,education_background)"
				+ " VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, candidateDTO.getName());
			ps.setString(2, candidateDTO.getEmail());
			ps.setString(3, candidateDTO.getPassword());
			ps.setString(4, candidateDTO.getPhone());
			ps.setString(5, DateTime());
//			Timestamp timestamp = Timestamp.valueOf(candidateDTO.getCreated_date());
//	        ps.setTimestamp(5, timestamp);
			ps.setString(6, candidateDTO.getDate_of_birth());
			ps.setString(7, candidateDTO.getNationality());
			ps.setString(8, candidateDTO.getMarital_status());
			ps.setString(9, candidateDTO.getGender());
			ps.setString(10, candidateDTO.getContact_address());
			ps.setString(11, candidateDTO.getParmanent_address());
			ps.setString(12, candidateDTO.getEducation_background());
			result=ps.executeUpdate();	
		}catch(SQLException e) {
			System.out.println("Insert Errot"+e);
		}
		return result;
	}
	
	//update
		public int updateCandidate(CandidateRequestDTO candidateDTO) {
			int result = 0;		
			String sql = "UPDATE candidate SET name=?,email=?,password=?,phone=?,updated_date=?,date_of_birth=?,nationality=?,marital_status=?,gender=?,contact_address=?,parmanent_address=?,education_background=? WHERE id=?";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, candidateDTO.getName());			
				ps.setString(2, candidateDTO.getEmail());			
				ps.setString(3, candidateDTO.getPassword());			
				ps.setString(4, candidateDTO.getPhone());			
				ps.setString(5, DateTime());
				ps.setString(6, candidateDTO.getDate_of_birth());
				ps.setString(7, candidateDTO.getNationality());
				ps.setString(8, candidateDTO.getMarital_status());
				ps.setString(9, candidateDTO.getGender());
				ps.setString(10, candidateDTO.getContact_address());
				ps.setString(11, candidateDTO.getParmanent_address());
				ps.setString(12, candidateDTO.getEducation_background());
				ps.setInt(13, candidateDTO.getId());
						        
				result = ps.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Candidate Update error: " + e);
			}
			return result;
		}
	
	
	//Delete
	
	public int deleteCandidate(int id) {
		int result = 0;
		String sql = "DELETE FROM candidate WHERE id=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);

			result = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Candidate Delete error: " + e);
		}
		return result;
	}
	
	//selectById
		public CandidateResponseDTO getCandidateById(int id) {
			CandidateResponseDTO candidate = new CandidateResponseDTO();
			String sql = "SELECT * FROM candidate WHERE id=?";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					candidate.setId(rs.getInt("id"));
					candidate.setName(rs.getString("name"));
					candidate.setEmail(rs.getString("email"));
					candidate.setPassword(rs.getString("password"));
					candidate.setPhone(rs.getString("phone"));
					candidate.setCreated_date(rs.getString("created_date"));
					candidate.setDate_of_birth(rs.getString("date_of_birth"));
					candidate.setNationality(rs.getString("nationality"));
					candidate.setMarital_status(rs.getString("marital_status"));
					candidate.setGender(rs.getString("gender"));
					candidate.setContact_address(rs.getString("contact_address"));
					candidate.setParmanent_address(rs.getString("parmanent_address"));
					candidate.setEducation_background(rs.getString("education_background"));
				}
			} catch (SQLException e) {
				System.out.println("select employer by id error" + e);
			}
			return candidate;
		}
		
	
	//selectNameById
	public String getCandidateNameById(int id) {
			String name="";		
			String sql = "SELECT name FROM candidate WHERE id=?";
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
	
	//selectPhoneById
		public String getCandidatePhoneById(int id) {
				String phone="";	
				String sql = "SELECT phone FROM candidate WHERE id=?";
				try {
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setInt(1, id);
					ResultSet rs = ps.executeQuery();

					while (rs.next()) {					
						
						phone=rs.getString("phone");
						
						
					}
				} catch (SQLException e) {
					System.out.println("select employer by id error" + e);
				}
				return phone;
			}
		
		//selectGenderById
				public String getCandidateGenderById(int id) {
					String gender="";	
						String sql = "SELECT gender FROM candidate WHERE id=?";
						try {
							PreparedStatement ps = con.prepareStatement(sql);
							ps.setInt(1, id);
							ResultSet rs = ps.executeQuery();

							while (rs.next()) {					
								
								gender=rs.getString("gender");
								
								
							}
						} catch (SQLException e) {
							System.out.println("select employer by id error" + e);
						}
						return gender;
					}
				
				//selectEducationById
				public String getCandidateEducationById(int id) {
					String education="";	
						String sql = "SELECT education_background FROM candidate WHERE id=?";
						try {
							PreparedStatement ps = con.prepareStatement(sql);
							ps.setInt(1, id);
							ResultSet rs = ps.executeQuery();

							while (rs.next()) {					
								
								education=rs.getString("education_background");
								
								
							}
						} catch (SQLException e) {
							System.out.println("select employer by id error" + e);
						}
						return education;
					}
				//selectEmailById
				public String getEmailById(int id) {
						String email="";	
						String sql = "SELECT email FROM candidate WHERE id=?";
						try {
							PreparedStatement ps = con.prepareStatement(sql);
							ps.setInt(1, id);
							ResultSet rs = ps.executeQuery();

							while (rs.next()) {					
								
								email=rs.getString("email");
								
								
							}
						} catch (SQLException e) {
							System.out.println("select employer by id error" + e);
						}
						return email;
					}
				
				//selectBirthdayById
				public String getBirthdayById(int id) {
						String birthday="";	
						String sql = "SELECT date_of_birth FROM candidate WHERE id=?";
						try {
							PreparedStatement ps = con.prepareStatement(sql);
							ps.setInt(1, id);
							ResultSet rs = ps.executeQuery();

							while (rs.next()) {					
								
								birthday=rs.getString("date_of_birth");
								
								
							}
						} catch (SQLException e) {
							System.out.println("select employer by id error" + e);
						}
						return birthday;
					}
				//selectBirthdayById
				public String getStatusById(int id) {
						String status="";	
						String sql = "SELECT marital_status FROM candidate WHERE id=?";
						try {
							PreparedStatement ps = con.prepareStatement(sql);
							ps.setInt(1, id);
							ResultSet rs = ps.executeQuery();

							while (rs.next()) {					
								
								status=rs.getString("marital_status");
								
								
							}
						} catch (SQLException e) {
							System.out.println("select employer by id error" + e);
						}
						return status;
					}
				//selectBirthdayById
				public String getAddressById(int id) {
						String address="";	
						String sql = "SELECT contact_address FROM candidate WHERE id=?";
						try {
							PreparedStatement ps = con.prepareStatement(sql);
							ps.setInt(1, id);
							ResultSet rs = ps.executeQuery();

							while (rs.next()) {					
								
								address=rs.getString("contact_address");
								
								
							}
						} catch (SQLException e) {
							System.out.println("select employer by id error" + e);
						}
						return address;
					}
					
	//selectAll
	public List<CandidateResponseDTO> getCandidates() {
		List<CandidateResponseDTO> candidates = new ArrayList<CandidateResponseDTO>();
		String sql = "SELECT * FROM candidate";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CandidateResponseDTO candidate = new CandidateResponseDTO();
				candidate.setId(rs.getInt("id"));
				candidate.setName(rs.getString("name"));
				candidate.setEmail(rs.getString("email"));
				candidate.setPassword(rs.getString("password"));
				candidate.setPhone(rs.getString("phone"));
				candidate.setCreated_date(rs.getString("created_date"));
				candidate.setDate_of_birth(rs.getString("date_of_birth"));
				candidate.setNationality(rs.getString("nationality"));
				candidate.setMarital_status(rs.getString("marital_status"));
				candidate.setGender(rs.getString("gender"));
				candidate.setContact_address(rs.getString("contact_address"));
				candidate.setParmanent_address(rs.getString("parmanent_address"));
				candidate.setEducation_background(rs.getString("education_background"));

				candidates.add(candidate);
			}
		} catch (SQLException e) {
			System.out.println("select industry all error: " + e);
		}
		return candidates;
	}
	
}
