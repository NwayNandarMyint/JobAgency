package jobagency.DTO;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;


public class CandidateCVRequestDTO {
  private int id;
  @NotEmpty
  private String applied_position;
  @NotEmpty
  private String expected_salary;
  private String certificates;
  @NotEmpty
  private byte[] cv_photo;
  private byte[] cv_form;
  
  private String uploaded_date;
  @NotEmpty
  private String work_experience;
  private int candidate_id;
  private String candidate_name;
  private int job_post_id;
  private List<LanguageRequestDTO> languages=new ArrayList<LanguageRequestDTO>();
  private int employer_id;
  
  public CandidateCVRequestDTO() {
    
  }
  
  public int getEmployer_id() {
	return employer_id;
}

public void setEmployer_id(int employer_id) {
	this.employer_id = employer_id;
}

public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getApplied_position() {
    return applied_position;
  }
  public void setApplied_position(String applied_position) {
    this.applied_position = applied_position;
  }
  public String getExpected_salary() {
    return expected_salary;
  }
  public void setExpected_salary(String expected_salary) {
    this.expected_salary = expected_salary;
  }
  
  public String getCertificates() {
    return certificates;
  }
  public void setCertificates(String certificates) {
    this.certificates = certificates;
  }
  public byte[] getCv_photo() {
    return cv_photo;
  }
  public void setCv_photo(byte[] cv_photo) {
    this.cv_photo = cv_photo;
  }
  public byte[] getCv_form() {
    return cv_form;
  }
  public void setCv_form(byte[] cv_form) {
    this.cv_form = cv_form;
  }
  public String getUploaded_date() {
    return uploaded_date;
  }
  public void setUploaded_date(String uploaded_date) {
    this.uploaded_date = uploaded_date;
  }
  public String getWork_experience() {
    return work_experience;
  }
  public void setWork_experience(String work_experience) {
    this.work_experience = work_experience;
  }
  public int getJob_post_id() {
    return job_post_id;
  }
  public void setJob_post_id(int job_post_id) {
    this.job_post_id = job_post_id;
  }
  public int getCandidate_id() {
    return candidate_id;
  }
  public void setCandidate_id(int candidate_id) {
    this.candidate_id = candidate_id;
  }
  public String getCandidate_name() {
    return candidate_name;
  }
  public void setCandidate_name(String candidate_name) {
    this.candidate_name = candidate_name;
  }

  public List<LanguageRequestDTO> getLanguages() {
    return languages;
  }

  public void setLanguages(List<LanguageRequestDTO> languages) {
    this.languages = languages;
  }

  

}