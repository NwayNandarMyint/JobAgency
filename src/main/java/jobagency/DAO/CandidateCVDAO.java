
package jobagency.DAO;
import java.io.UnsupportedEncodingException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.util.codec.binary.Base64;

import jobagency.DTO.CandidateCVRequestDTO;
import jobagency.DTO.CandidateCVResponseDTO;
import jobagency.DTO.LanguageRequestDTO;
public class CandidateCVDAO {

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
  ///Insert
  public int addCandidateCV(CandidateCVRequestDTO candidateCVDTO) {
      int result = 0;
      String sql = "INSERT INTO candidate_cv (applied_position, expected_salary, certificates, uploaded_date, cv_photo, cv_form, work_experience, candidate_id, job_post_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
      try {
          PreparedStatement ps = con.prepareStatement(sql);
          
          ps.setString(1, candidateCVDTO.getApplied_position());
          ps.setString(2, candidateCVDTO.getExpected_salary());
          ps.setString(3, candidateCVDTO.getCertificates());
          ps.setString(4, DateTime());
          
          Blob blobPhoto = con.createBlob();
          blobPhoto.setBytes(1, candidateCVDTO.getCv_photo());
          ps.setBlob(5, blobPhoto);
          
          Blob blobForm = con.createBlob();
          blobForm.setBytes(1, candidateCVDTO.getCv_form());
          ps.setBlob(6, blobForm);
          ps.setString(7, candidateCVDTO.getWork_experience());
          ps.setInt(8, candidateCVDTO.getCandidate_id());
          ps.setInt(9, candidateCVDTO.getJob_post_id());
          result = ps.executeUpdate();
          
          if (result != 0) {
              for (LanguageRequestDTO language : candidateCVDTO.getLanguages()) {
                  sql = "INSERT INTO candidate_cv_has_language (candidate_cv_id, language_id) VALUES (LAST_INSERT_ID(), ?)";
                  ps = con.prepareStatement(sql);
                  ps.setInt(1, language.getId());
                  result = ps.executeUpdate();
              }
          }
      } catch (SQLException e) {
          System.out.println("Insert Error: " + e);
      }
      return result;
  }
//selectById
  public List<CandidateCVResponseDTO> getCvById(int id) {
    List<CandidateCVResponseDTO> candidateCV = new ArrayList<CandidateCVResponseDTO>();
    String sql = "SELECT * FROM job_agency.candidate_cv cc JOIN job_post jp ON cc.job_post_id = jp.id JOIN employer e ON jp.employer_id = e.id WHERE e.id = ?";
    LanguageDAO languageDAO=new LanguageDAO();
    try {
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setInt(1, id);
      ResultSet rs = ps.executeQuery();
        while (rs.next()) {
           CandidateCVResponseDTO cv = new CandidateCVResponseDTO();
           cv.setId(rs.getInt("id"));
           cv.setApplied_position(rs.getString("applied_position"));
           cv.setExpected_salary(rs.getString("expected_salary"));
           cv.setCertificates(rs.getString("certificates"));
           cv.setUploaded_date(rs.getString("uploaded_date"));
           
            Blob blob = (Blob) rs.getBlob("cv_photo");
              byte [] bytes  =  blob.getBytes(1,(int) blob.length());
              byte[] encodeBase64 = Base64.encodeBase64(bytes);
              try {
                cv.setCv_photo(new String(encodeBase64, "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                  e.printStackTrace();
                }
              
              Blob blob2 = (Blob) rs.getBlob("cv_form");
              byte [] cv_form  =  blob2.getBytes(1,(int) blob2.length());
              byte[] encodeBase = Base64.encodeBase64(cv_form);
              try {
                cv.setCv_form(new String(encodeBase, "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                  e.printStackTrace();
                }
              cv.setWork_experience(rs.getString("work_experience"));
              cv.setCandidate_id(rs.getInt("candidate_id"));
              cv.setJob_post_id(rs.getInt("job_post_id"));
             
              cv.setLanguages(languageDAO.getLanguageByCVID(rs.getInt("id")));
              
              candidateCV.add(cv);
     
      }
    } catch (SQLException e) {
      System.out.println("select employer by id error" + e);
    }
    
    return candidateCV;
    
  }
    //selectAll
    public List<CandidateCVResponseDTO> getAllCV() {
      List<CandidateCVResponseDTO> allCV=new ArrayList<CandidateCVResponseDTO>();
      String sql="SELECT * FROM candidate_cv";
      LanguageDAO languageDAO=new LanguageDAO();
      try {
        PreparedStatement ps=con.prepareStatement(sql);      
        ResultSet rs=ps.executeQuery();      
        while(rs.next()) {
          CandidateCVResponseDTO candidateCV=new CandidateCVResponseDTO();
          candidateCV.setId(rs.getInt("id"));
          candidateCV.setApplied_position(rs.getString("applied_position"));
          candidateCV.setExpected_salary(rs.getString("expected_salary"));
          candidateCV.setCertificates(rs.getString("certificates"));
          candidateCV.setUploaded_date(rs.getString("uploaded_date"));
          Blob blob = (Blob) rs.getBlob("cv_photo");
                byte [] bytes  =  blob.getBytes(1,(int) blob.length());
                byte[] encodeBase64 = Base64.encodeBase64(bytes);
                try {
                  candidateCV.setCv_photo(new String(encodeBase64, "UTF-8"));
                  } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                  }
                Blob blob2 = (Blob) rs.getBlob("cv_form");
                byte [] cv_form  =  blob2.getBytes(1,(int) blob2.length());
                byte[] encodeBase = Base64.encodeBase64(cv_form);
                try {
                  candidateCV.setCv_form(new String(encodeBase, "UTF-8"));
                  } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                  }
          candidateCV.setWork_experience(rs.getString("work_experience"));
          candidateCV.setCandidate_id(rs.getInt("candidate_id"));
          candidateCV.setJob_post_id(rs.getInt("job_post_id"));
          
          candidateCV.setLanguages(languageDAO.getLanguageByCVID(rs.getInt("id")));
            
          
          allCV.add(candidateCV);
        }        
      }catch(SQLException e) {
        System.out.println("select all error: "+e);
      }
      return allCV;
    }
  //selectById
    public CandidateCVResponseDTO getEmployerIdFromJobPostTable(int id) {
      CandidateCVResponseDTO employerid = new CandidateCVResponseDTO();
      String sql = "SELECT employer_id FROM job_post WHERE id=?";
      try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        	while (rs.next()) {
        		employerid.setEmployer_id(rs.getInt("employer_id"));
        }
      } catch (SQLException e) {
        System.out.println("select employer by id error" + e);
      }
      return employerid;
    }
}