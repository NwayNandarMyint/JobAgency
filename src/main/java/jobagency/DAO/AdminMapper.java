package jobagency.DAO;

import java.util.ArrayList;
import java.util.List;

import jobagency.DTO.AdminRequestDTO;
import jobagency.DTO.AdminResponseDTO;
import jobagency.models.AdminBean;

public class AdminMapper {

	public AdminRequestDTO mapToRequestDTO(AdminBean bean) {
		AdminRequestDTO dto=new AdminRequestDTO();
		dto.setId(bean.getId());
		dto.setName(bean.getName());
		dto.setEmail(bean.getEmail());
		dto.setPassword(bean.getPassword());
		dto.setRole_id(bean.getRole_id());
		return dto;
	}
	
	public AdminBean mapToBean(AdminResponseDTO dto) {
		
		AdminDAO adminDAO = new AdminDAO();
		RoleDAO rDAO=new RoleDAO();
		AdminBean bean=new AdminBean();
		bean.setId(dto.getId());
		bean.setName(dto.getName());
		bean.setEmail(dto.getEmail());
		bean.setPassword(dto.getPassword());
		bean.setRole_id(dto.getRole_id());
		String role_name = rDAO.getRoleNameById(dto.getRole_id());
		bean.setRole_name(role_name);
		//bean.setRole_name(dto.getRole_name());
		return bean;
	}
	
	public List<AdminBean> mapToListBean(List<AdminResponseDTO> dtos) {
		List<AdminBean> beans=new ArrayList<AdminBean>();
		for(AdminResponseDTO dto: dtos) {
			AdminBean bean=mapToBean(dto);
			beans.add(bean);
		}
		return beans;
	}
	
}
