package jobagency.DAO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jobagency.DTO.CandidateCVRequestDTO;
import jobagency.DTO.CandidateCVResponseDTO;
import jobagency.DTO.LanguageRequestDTO;
import jobagency.DTO.LanguageResponseDTO;
import jobagency.models.CandidateCVBean;
import jobagency.models.LanguageBean;

public class CandidateCVMapper {

  public CandidateCVRequestDTO mapToRequestDTO(CandidateCVBean bean) {
    LanguageMapper language_mapper=new LanguageMapper();
    
    CandidateCVRequestDTO dto=new CandidateCVRequestDTO();
    dto.setId(bean.getId());
    dto.setApplied_position(bean.getApplied_position());
    dto.setExpected_salary(bean.getExpected_salary());
    dto.setCertificates(bean.getCertificates());
    try {
      dto.setCv_photo(bean.getCv_photo().getBytes());
    } catch (IOException e) {
      e.printStackTrace();
    }
    try {
      dto.setCv_form(bean.getCv_form().getBytes());
    } catch (IOException e) {
      e.printStackTrace();
    }
    dto.setUploaded_date(bean.getUploaded_date());  
    dto.setWork_experience(bean.getWork_experience());
    dto.setJob_post_id(bean.getJob_post_id());
    dto.setCandidate_id(bean.getCandidate_id());
     List<LanguageRequestDTO> languages=new ArrayList<LanguageRequestDTO>();
     
     for(LanguageBean language:bean.getLanguages()) {
       LanguageRequestDTO language_dto=language_mapper.mapToRequestDTO(language);      
       languages.add(language_dto);      
      }    
  
      dto.setLanguages(languages);
    
    return dto;
  }
  
  public CandidateCVBean mapToBean(CandidateCVResponseDTO dto) {
	CandidateDAO candidateDAO=new CandidateDAO();
    
    CandidateCVBean bean=new CandidateCVBean();
    bean.setId(dto.getId());
    bean.setApplied_position(dto.getApplied_position());
    bean.setExpected_salary(dto.getExpected_salary());
    bean.setCertificates(dto.getCertificates());
    bean.setPhotoString(dto.getCv_photo());
    bean.setFormString(dto.getCv_form());
    bean.setUploaded_date(dto.getUploaded_date());
    bean.setWork_experience(dto.getWork_experience());
    bean.setJob_post_id(dto.getJob_post_id());
    bean.setCandidate_id(dto.getCandidate_id());
    String candidate_name=candidateDAO.getCandidateNameById(dto.getCandidate_id());
    bean.setCandidate_name(candidate_name);
    String candidate_phone=candidateDAO.getCandidatePhoneById(dto.getCandidate_id());
    bean.setCandidate_phone(candidate_phone);
    String candidate_gender=candidateDAO.getCandidateGenderById(dto.getCandidate_id());
    bean.setCandidate_gender(candidate_gender);
    String candidate_education=candidateDAO.getCandidateEducationById(dto.getCandidate_id());
	bean.setCandidate_education(candidate_education);
	
	 String candidate_email=candidateDAO.getEmailById(dto.getCandidate_id());
	 bean.setCandidate_email(candidate_email);
	 String candidate_bitrhday=candidateDAO.getBirthdayById(dto.getCandidate_id());
	 bean.setCandidate_bitrhday(candidate_bitrhday);
	 String candidate_status=candidateDAO.getStatusById(dto.getCandidate_id());
	 bean.setCandidate_status(candidate_status);
	 String candidate_address=candidateDAO.getAddressById(dto.getCandidate_id());
	 bean.setCandidate_address(candidate_address);
	
    
    StringBuilder language_names=new StringBuilder();
    List<LanguageBean> languages=new ArrayList<LanguageBean>();
    for(LanguageResponseDTO dto_language:dto.getLanguages()) {
      
      LanguageBean language=new LanguageBean();
      language.setId(dto_language.getId());
      language.setName(dto_language.getName());
      language_names.append(dto_language.getName()+", ");
      
      languages.add(language);
    }    
    bean.setLanguage_name(language_names.toString());
    
    
    bean.setLanguages(languages);
    
    return bean;
  }
  
  public List<CandidateCVBean> mapToListBean(List<CandidateCVResponseDTO> dtos) {
    List<CandidateCVBean> beans=new ArrayList<CandidateCVBean>();
    for(CandidateCVResponseDTO dto: dtos) {
      CandidateCVBean bean=mapToBean(dto);
      beans.add(bean);
    }
    return beans;
  }
  
}