package jobagency.DAO;

import java.util.ArrayList;
import java.util.List;
import jobagency.DTO.RoleRequestDTO;
import jobagency.DTO.RoleResponseDTO;
import jobagency.models.RoleBean;

public class RoleMapper {

	public RoleRequestDTO mapToRequestDTO(RoleBean bean) {
		RoleRequestDTO dto=new RoleRequestDTO();
		dto.setId(bean.getId());
		dto.setName(bean.getName());
		return dto;
	}
	
	public RoleBean mapToBean(RoleResponseDTO dto) {
		RoleBean bean=new RoleBean();
		bean.setId(dto.getId());
		bean.setName(dto.getName());
		return bean;
	}
	
	public List<RoleBean> mapToListBean(List<RoleResponseDTO> dtos) {
		List<RoleBean> beans=new ArrayList<RoleBean>();
		for(RoleResponseDTO dto: dtos) {
			RoleBean bean=mapToBean(dto);
			beans.add(bean);
		}
		return beans;
	}
	
}
