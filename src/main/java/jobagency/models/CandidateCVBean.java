package jobagency.models;

import java.util.*;

import javax.validation.constraints.NotEmpty;

import org.springframework.web.multipart.MultipartFile;

public class CandidateCVBean {
  private int id;
  @NotEmpty
  private String applied_position;
  @NotEmpty
  private String expected_salary;
  @NotEmpty
  private String certificates;
  private MultipartFile cv_photo;
  private String photoString;
  
  private MultipartFile cv_form;
  private String formString;
  
  private String uploaded_date;
  @NotEmpty
  private String work_experience;
  private int candidate_id;
  private String candidate_name;
  private String candidate_phone;
  private String candidate_gender;
  private String candidate_education;
  private String candidate_email;
  private String candidate_bitrhday;
  private String candidate_status;
  private String candidate_address;
  
  private int job_post_id;
  
  private List<LanguageBean> languages=new ArrayList<LanguageBean>();
  private String language_name;
  
  public CandidateCVBean() {
    
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
  public MultipartFile getCv_photo() {
    return cv_photo;
  }
  public void setCv_photo(MultipartFile cv_photo) {
    this.cv_photo = cv_photo;
  }
  public String getPhotoString() {
    return photoString;
  }

  public void setPhotoString(String photoString) {
    this.photoString = photoString;
  }
  public MultipartFile getCv_form() {
    return cv_form;
  }
  public void setCv_form(MultipartFile cv_form) {
    this.cv_form = cv_form;
  }
  public String getFormString() {
    return formString;
  }

  public void setFormString(String formString) {
    this.formString = formString;
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

  public List<LanguageBean> getLanguages() {
    return languages;
  }

  public void setLanguages(List<LanguageBean> languages) {
    this.languages = languages;
  }

  public String getLanguage_name() {
    return language_name;
  }

  public void setLanguage_name(String language_name) {
    this.language_name = language_name;
  }

public String getCandidate_name() {
	return candidate_name;
}

public void setCandidate_name(String candidate_name) {
	this.candidate_name = candidate_name;
}

public String getCandidate_phone() {
	return candidate_phone;
}

public void setCandidate_phone(String candidate_phone) {
	this.candidate_phone = candidate_phone;
}

public String getCandidate_gender() {
	return candidate_gender;
}

public void setCandidate_gender(String candidate_gender) {
	this.candidate_gender = candidate_gender;
}

public String getCandidate_education() {
	return candidate_education;
}

public void setCandidate_education(String candidate_education) {
	this.candidate_education = candidate_education;
}

public String getCandidate_email() {
	return candidate_email;
}

public void setCandidate_email(String candidate_email) {
	this.candidate_email = candidate_email;
}

public String getCandidate_bitrhday() {
	return candidate_bitrhday;
}

public void setCandidate_bitrhday(String candidate_bitrhday) {
	this.candidate_bitrhday = candidate_bitrhday;
}

public String getCandidate_status() {
	return candidate_status;
}

public void setCandidate_status(String candidate_status) {
	this.candidate_status = candidate_status;
}

public String getCandidate_address() {
	return candidate_address;
}

public void setCandidate_address(String candidate_address) {
	this.candidate_address = candidate_address;
}
  
}