package jobagency.DAO;

import java.util.ArrayList;
import java.util.List;

import jobagency.DTO.CandidateRequestDTO;
import jobagency.DTO.CandidateResponseDTO;
import jobagency.models.CandidateBean;

public class CandidateMapper {

	public CandidateRequestDTO mapToRequestDTO(CandidateBean bean) {
		CandidateRequestDTO dto=new CandidateRequestDTO();
		dto.setId(bean.getId());
		dto.setName(bean.getName());
		dto.setEmail(bean.getEmail());
		dto.setPassword(bean.getPassword());
		dto.setPhone(bean.getPhone());
		dto.setCreated_date(bean.getCreated_date());
		dto.setUpdated_date(bean.getUpdated_date());
		dto.setDate_of_birth(bean.getDate_of_birth());
		dto.setNationality(bean.getNationality());
		dto.setMarital_status(bean.getMarital_status());
		dto.setGender(bean.getGender());
		dto.setContact_address(bean.getContact_address());
		dto.setParmanent_address(bean.getParmanent_address());
		dto.setEducation_background(bean.getEducation_background());
		return dto;
	}
	
	public CandidateBean mapToBean(CandidateResponseDTO dto) {
		CandidateBean bean=new CandidateBean();
		bean.setId(dto.getId());
		bean.setName(dto.getName());
		bean.setEmail(dto.getEmail());
		bean.setPassword(dto.getPassword());
		bean.setPhone(dto.getPhone());
		bean.setCreated_date(dto.getCreated_date());
		bean.setUpdated_date(dto.getUpdated_date());
		bean.setDate_of_birth(dto.getDate_of_birth());
		bean.setNationality(dto.getNationality());
		bean.setMarital_status(dto.getMarital_status());
		bean.setGender(dto.getGender());
		bean.setContact_address(dto.getContact_address());
		bean.setParmanent_address(dto.getParmanent_address());
		bean.setEducation_background(dto.getEducation_background());
		return bean;
	}
	
	public List<CandidateBean> mapToListBean(List<CandidateResponseDTO> dtos) {
		List<CandidateBean> beans=new ArrayList<CandidateBean>();
		for(CandidateResponseDTO dto: dtos) {
			CandidateBean bean=mapToBean(dto);
			beans.add(bean);
		}
		return beans;
	}
	
}
