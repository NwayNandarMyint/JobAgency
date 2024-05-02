package jobagency.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jobagency.DTO.LanguageRequestDTO;
import jobagency.DTO.LanguageResponseDTO;

public class LanguageDAO {

	public static Connection con=null;
	static {
		con=MyConnection.getConnection();
	}
	
	//Insert
		public int addLanguage(LanguageRequestDTO languageDTO) {
			int result=0;
			String sql="INSERT INTO language(name,is_delete) VALUES(?,?)";
			try {
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setString(1, languageDTO.getName());
				ps.setInt(2, 0);
				
				result=ps.executeUpdate();	
			}catch(SQLException e) {
				System.out.println("Insert Erro "+e);
			}
			return result;
		}
		
		//delete
		public int deleteLanguage(int id) {
			int result = 0;
			String sql = "UPDATE language SET is_delete=? WHERE id=?";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				 ps.setInt(1, 1);
			     ps.setInt(2, id);

				result = ps.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Languane Delete error: " + e);
			}
			return result;
		}
				
				//Select All
				public List<LanguageResponseDTO> getLanguages() {
					List<LanguageResponseDTO> languages=new ArrayList<LanguageResponseDTO>();
					String sql="SELECT * FROM language WHERE is_delete = 0";
					
					try {
						PreparedStatement ps=con.prepareStatement(sql);			
						ResultSet rs=ps.executeQuery();			
						while(rs.next()) {
							LanguageResponseDTO language=new LanguageResponseDTO();
							language.setId(rs.getInt("id"));
							language.setName(rs.getString("name"));
							
							languages.add(language);
						}				
					}catch(SQLException e) {
						System.out.println("Select All Error: "+e);
					}
					return languages;
				}
				
				//selectById
				public List<LanguageResponseDTO> getLanguageByCVID(int candidate_cv_id) {
					List<LanguageResponseDTO> languages = new ArrayList<LanguageResponseDTO>();			
					String sql = "SELECT * FROM language l INNER JOIN  candidate_cv_has_language cl  ON  l.id=cl.language_id WHERE cl.candidate_cv_id=?";
					try {
						PreparedStatement ps = con.prepareStatement(sql);
						ps.setInt(1, candidate_cv_id);
						ResultSet rs = ps.executeQuery();

						while (rs.next()) {
							LanguageResponseDTO language = new LanguageResponseDTO();
							language.setId(rs.getInt("id"));
							language.setName(rs.getString("name"));
							
							languages.add(language);
						}
					} catch (SQLException e) {
						System.out.println("select candidatecv by id error" + e);
					}
					return languages;
				}
	
}
////Update 
//
//public int editLanguage(LanguageRequestDTO languageDTO) {
//	int result = 0;
//	String sql = "UPDATE languages SET language=?,candidate_cv_id=? WHERE id=?";
//	try {
//		PreparedStatement ps = con.prepareStatement(sql);
//		ps.setString(1, languageDTO.getLanguage());
//		ps.setInt(2, languageDTO.getCandidate_cv_id());
//		ps.setInt(3, languageDTO.getId());
//		result = ps.executeUpdate();
//	} catch (SQLException e) {
//		System.out.println("Language Update error: " + e);
//	}
//	return result;
//}
