package jobagency.DAO;

import java.util.ArrayList;
import java.util.List;
import jobagency.DTO.IndustryRequestDTO;
import jobagency.DTO.IndustryResponseDTO;
import jobagency.models.IndustryBean;


public class IndustryMapper {
	public IndustryRequestDTO mapToRequestDTO(IndustryBean bean) {
		IndustryRequestDTO dto=new IndustryRequestDTO();
		dto.setId(bean.getId());
		dto.setName(bean.getName());
		dto.setIs_delete(bean.isIs_delete());
		return dto;
	}
	
	public IndustryBean mapToBean(IndustryResponseDTO dto) {
		IndustryBean bean=new IndustryBean();
		bean.setId(dto.getId());
		bean.setName(dto.getName());
		bean.setIs_delete(dto.is_delete());
		return bean;
	}
	
	public List<IndustryBean> mapToListBean(List<IndustryResponseDTO> dtos) {
		List<IndustryBean> beans=new ArrayList<IndustryBean>();
		for(IndustryResponseDTO dto: dtos) {
			IndustryBean bean=mapToBean(dto);
			beans.add(bean);
		}
		return beans; 
	}


}
