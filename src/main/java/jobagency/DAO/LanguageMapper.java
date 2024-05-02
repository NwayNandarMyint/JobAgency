package jobagency.DAO;

import java.util.ArrayList;
import java.util.List;

import jobagency.DTO.LanguageRequestDTO;
import jobagency.DTO.LanguageResponseDTO;
import jobagency.models.LanguageBean;

public class LanguageMapper {

	public LanguageRequestDTO mapToRequestDTO(LanguageBean bean) {
		LanguageRequestDTO dto=new LanguageRequestDTO();
		dto.setId(bean.getId());
		dto.setName(bean.getName());
		dto.setIs_delete(bean.getIs_delete());
		return dto;
	}
	
	public LanguageBean mapToBean(LanguageResponseDTO dto) {
		LanguageBean bean=new LanguageBean();
		bean.setId(dto.getId());
		bean.setName(dto.getName());
		bean.setIs_delete(dto.getIs_delete());
		return bean;
	}
	
	public List<LanguageBean> mapToListBean(List<LanguageResponseDTO> dtos) {
		List<LanguageBean> beans=new ArrayList<LanguageBean>();
		for(LanguageResponseDTO dto: dtos) {
			LanguageBean bean=mapToBean(dto);
			beans.add(bean);
		}
		return beans;
	}
	
}
