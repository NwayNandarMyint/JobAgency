package jobagency.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import jobagency.DTO.Job_postRequestDTO;
import jobagency.DTO.Job_postResponseDTO;

public class Job_postDAO {
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
	public int addJobpost(Job_postRequestDTO job_postDTO) {
		int result=0;
		String sql="INSERT INTO job_post(age_range,salary,background_education,work_experiences,isActive,created_date,address,level_id,employer_id,position_id,required_candidate) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, job_postDTO.getAge_range());
			ps.setString(2, job_postDTO.getSalary());
			ps.setString(3, job_postDTO.getBackground_education());
			ps.setString(4, job_postDTO.getWork_experiences());
			ps.setBoolean(5, job_postDTO.isActive());
			ps.setString(6, DateTime());
			ps.setString(7, job_postDTO.getAddress());
			ps.setInt(8, job_postDTO.getLevel_id());
			ps.setInt(9, job_postDTO.getEmployer_id());
			ps.setInt(10, job_postDTO.getPosition_id());
			ps.setString(11, job_postDTO.getRequired_candidate());
			result=ps.executeUpdate();	
		}catch(SQLException e) {
			System.out.println("Insert Error"+e);
		}
		return result;
	}
	
	//update
		public int editJobpost(Job_postRequestDTO job_postDTO) {
			int result = 0;
			String sql = "UPDATE job_post SET age_range=?,salary=?,background_education=?,work_experiences=?,isDelete=?,updated_date=?,address=?,level_id=?,employer_id=?,position_id=? WHERE id=?";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, job_postDTO.getAge_range());
				ps.setString(2, job_postDTO.getSalary());
				ps.setString(3, job_postDTO.getBackground_education());
				ps.setString(4, job_postDTO.getWork_experiences());
				ps.setBoolean(5, job_postDTO.isActive());
				ps.setString(6, DateTime());
				ps.setString(7, job_postDTO.getAddress());
				ps.setInt(8, job_postDTO.getLevel_id());
				ps.setInt(9, job_postDTO.getEmployer_id());
				ps.setInt(10, job_postDTO.getPosition_id());
				ps.setInt(11, job_postDTO.getId());
				result = ps.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Jobpost Update error: " + e);
			}
			return result;
		}
		
		//delete
		public int deleteJobpost(int id) {
			int result = 0;
			String sql = "DELETE FROM job_post WHERE id=?";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, id);

				result = ps.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Jobpost Delete error: " + e);
			}
			return result;
		}
				
		//selectById
		public List<Job_postResponseDTO> getJobpostById(int id) {
			List<Job_postResponseDTO> jobposts = new ArrayList<Job_postResponseDTO>();
			String sql = "SELECT * FROM job_post WHERE  employer_id=?";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					Job_postResponseDTO jobpost=new Job_postResponseDTO();
					jobpost.setEmployer_id(rs.getInt("employer_id"));
					jobpost.setId(rs.getInt("id"));
					jobpost.setAge_range(rs.getString("age_range"));
					jobpost.setSalary(rs.getString("salary"));
					jobpost.setBackground_education(rs.getString("background_education"));
					jobpost.setWork_experiences(rs.getString("work_experiences"));
					jobpost.setCreated_date(rs.getString("created_date"));
					jobpost.setAddress(rs.getString("address"));
					jobpost.setLevel_id(rs.getInt("level_id"));
					jobpost.setPosition_id(rs.getInt("position_id"));
					jobpost.setRequired_candidate(rs.getString("required_candidate"));
					jobposts.add(jobpost);
				}
			} catch (SQLException e) {
				System.out.println("select employer by id error" + e);
			}
			return jobposts;
		}
		//selectById
				public Job_postResponseDTO getPostById(int id) {
					Job_postResponseDTO jobpost = new Job_postResponseDTO();
					String sql = "SELECT * FROM job_post WHERE  employer_id=?";
					try {
						PreparedStatement ps = con.prepareStatement(sql);
						ps.setInt(1, id);
						ResultSet rs = ps.executeQuery();

						while (rs.next()) {
						
							jobpost.setEmployer_id(rs.getInt("employer_id"));
							jobpost.setId(rs.getInt("id"));
							jobpost.setAge_range(rs.getString("age_range"));
							jobpost.setSalary(rs.getString("salary"));
							jobpost.setBackground_education(rs.getString("background_education"));
							jobpost.setWork_experiences(rs.getString("work_experiences"));
							jobpost.setCreated_date(rs.getString("created_date"));
							jobpost.setAddress(rs.getString("address"));
							jobpost.setLevel_id(rs.getInt("level_id"));
							jobpost.setPosition_id(rs.getInt("position_id"));
							jobpost.setRequired_candidate(rs.getString("required_candidate"));
						}
					} catch (SQLException e) {
						System.out.println("select employer by id error" + e);
					}
					return jobpost;
				}
				
				//selectById
				public Job_postResponseDTO getJobById(int id) {
					Job_postResponseDTO jobpost = new Job_postResponseDTO();
					String sql = "SELECT * FROM job_post WHERE  id=?";
					try {
						PreparedStatement ps = con.prepareStatement(sql);
						ps.setInt(1, id);
						ResultSet rs = ps.executeQuery();

						while (rs.next()) {
						
							jobpost.setId(rs.getInt("id"));
							jobpost.setAge_range(rs.getString("age_range"));
							jobpost.setSalary(rs.getString("salary"));
							jobpost.setBackground_education(rs.getString("background_education"));
							jobpost.setWork_experiences(rs.getString("work_experiences"));
							jobpost.setCreated_date(rs.getString("created_date"));
							jobpost.setAddress(rs.getString("address"));
							jobpost.setLevel_id(rs.getInt("level_id"));
							jobpost.setPosition_id(rs.getInt("position_id"));
							
						}
					} catch (SQLException e) {
						System.out.println("select employer by id error" + e);
					}
					return jobpost;
				}
				
		//selectAll
		public List<Job_postResponseDTO> getJobposts() {
			List<Job_postResponseDTO> jobposts = new ArrayList<Job_postResponseDTO>();
			String sql = "SELECT * FROM job_post where isActive=0";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					Job_postResponseDTO jobpost = new Job_postResponseDTO();
					jobpost.setId(rs.getInt("id"));
					jobpost.setAge_range(rs.getString("age_range"));
					jobpost.setSalary(rs.getString("salary"));
					jobpost.setBackground_education(rs.getString("background_education"));
					jobpost.setWork_experiences(rs.getString("work_experiences"));
					jobpost.setCreated_date(rs.getString("created_date"));
					jobpost.setAddress(rs.getString("address"));
					jobpost.setLevel_id(rs.getInt("level_id"));
					jobpost.setEmployer_id(rs.getInt("employer_id"));
					jobpost.setPosition_id(rs.getInt("position_id"));
					jobpost.setRequired_candidate(rs.getString("required_candidate"));

					jobposts.add(jobpost);
				}
			} catch (SQLException e) {
				System.out.println("select employer all error: " + e);
			}
			return jobposts;
		}
		
		//job post disable on click employer in this method 
		// in this 0 mean true 1 mean false where prepare isActive
				public int deniedJobpost(Job_postRequestDTO job_postDTO) {
					int result = 0;
					String sql = "UPDATE job_post SET isActive=? WHERE id=? AND employer_id=?";
					try {
						PreparedStatement ps = con.prepareStatement(sql);
						
						ps.setInt(1,1);
						ps.setInt(2, job_postDTO.getId());
						ps.setInt(3, job_postDTO.getEmployer_id());
						result = ps.executeUpdate();
					} catch (SQLException e) {
						System.out.println("Jobpost Denied  error: " + e);
					}
					return result;
				}
	//selectById Active JobPost
				public List<Job_postResponseDTO> getActiveJobPosts(int id) {
					List<Job_postResponseDTO> jobposts = new ArrayList<Job_postResponseDTO>();
					String sql = "SELECT * FROM job_post WHERE employer_id=? AND isActive=?";
					try {
						PreparedStatement ps = con.prepareStatement(sql);
						ps.setInt(1, id);
						ps.setInt(2, 0);
						ResultSet rs = ps.executeQuery();

						while (rs.next()) {
							Job_postResponseDTO jobpost=new Job_postResponseDTO();
							jobpost.setEmployer_id(rs.getInt("employer_id"));
							jobpost.setId(rs.getInt("id"));
							jobpost.setAge_range(rs.getString("age_range"));
							jobpost.setSalary(rs.getString("salary"));
							jobpost.setBackground_education(rs.getString("background_education"));
							jobpost.setWork_experiences(rs.getString("work_experiences"));
							jobpost.setCreated_date(rs.getString("created_date"));
							jobpost.setRequired_candidate(rs.getString("required_candidate"));
							jobpost.setAddress(rs.getString("address"));
							jobpost.setLevel_id(rs.getInt("level_id"));
							jobpost.setPosition_id(rs.getInt("position_id"));
							jobposts.add(jobpost);
						}
					} catch (SQLException e) {
						System.out.println("select employer by id error" + e);
					}
					return jobposts;
				}
				
				//selectById Unactive JobPost
				public List<Job_postResponseDTO> getUnActiveJobPosts(int id) {
					List<Job_postResponseDTO> jobposts = new ArrayList<Job_postResponseDTO>();
					String sql = "SELECT * FROM job_post WHERE employer_id=? AND isActive=?";
					try {
						PreparedStatement ps = con.prepareStatement(sql);
						ps.setInt(1, id);
						ps.setInt(2, 1);
						ResultSet rs = ps.executeQuery();

						while (rs.next()) {
							Job_postResponseDTO jobpost=new Job_postResponseDTO();
							jobpost.setEmployer_id(rs.getInt("employer_id"));
							jobpost.setId(rs.getInt("id"));
							jobpost.setAge_range(rs.getString("age_range"));
							jobpost.setSalary(rs.getString("salary"));
							jobpost.setBackground_education(rs.getString("background_education"));
							jobpost.setWork_experiences(rs.getString("work_experiences"));
							jobpost.setCreated_date(rs.getString("created_date"));
							jobpost.setRequired_candidate(rs.getString("required_candidate"));
							jobpost.setAddress(rs.getString("address"));
							jobpost.setLevel_id(rs.getInt("level_id"));
							jobpost.setPosition_id(rs.getInt("position_id"));
							jobposts.add(jobpost);
						}
					} catch (SQLException e) {
						System.out.println("select employer by id error" + e);
					}
					return jobposts;
				}
				
				//selectAll
				public List<Job_postResponseDTO> getJobpost(String data) {
					List<Job_postResponseDTO> jobposts = new ArrayList<Job_postResponseDTO>();
					String sql = "SELECT * FROM job_agency.job_post jp JOIN position p ON jp.position_id = p.id  WHERE p.name LIKE ?";
					try {
						PreparedStatement ps = con.prepareStatement(sql);
						ps.setString(1, "%" + data + "%");
					
						ResultSet rs = ps.executeQuery();
						while (rs.next()) {
							Job_postResponseDTO jobpost = new Job_postResponseDTO();
							jobpost.setId(rs.getInt("id"));
							jobpost.setEmployer_id(rs.getInt("employer_id"));
							jobpost.setAge_range(rs.getString("age_range"));
							jobpost.setSalary(rs.getString("salary"));
							jobpost.setBackground_education(rs.getString("background_education"));
							jobpost.setWork_experiences(rs.getString("work_experiences"));
							jobpost.setCreated_date(rs.getString("created_date"));
							jobpost.setAddress(rs.getString("address"));
							jobpost.setLevel_id(rs.getInt("level_id"));
							jobpost.setEmployer_id(rs.getInt("employer_id"));
							jobpost.setPosition_id(rs.getInt("position_id"));

							jobposts.add(jobpost);
						}
					} catch (SQLException e) {
						System.out.println("select employer all error: " + e);
					}
					return jobposts;
				}
				
				
}
