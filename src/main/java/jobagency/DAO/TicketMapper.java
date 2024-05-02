package jobagency.DAO;

import java.util.ArrayList;
import java.util.List;
import jobagency.DTO.TicketRequestDTO;
import jobagency.DTO.TicketResponseDTO;
import jobagency.models.TicketBean;

public class TicketMapper {

	public TicketRequestDTO mapToRequestDTO(TicketBean bean) {
		TicketRequestDTO dto=new TicketRequestDTO();
		dto.setId(bean.getId());
		dto.setAmount(bean.getAmount());
		dto.setPost(bean.getPost());
		dto.setAdmin_id(bean.getAdmin_id());
		dto.setCode_number(bean.getCode_number());
		dto.setIs_delete(bean.isIs_delete());
		return dto;
	}
	
	public TicketBean mapToBean(TicketResponseDTO dto) {
		
		AdminDAO adminDAO=new AdminDAO();
		
		TicketBean bean=new TicketBean();
		bean.setId(dto.getId());
		bean.setAmount(dto.getAmount());
		bean.setPost(dto.getPost());
		bean.setAdmin_id(dto.getAdmin_id());
		String admin_name=adminDAO.getAdminNameById(dto.getAdmin_id());
		bean.setAdmin_name(admin_name);
		bean.setCode_number(dto.getCode_number());
		bean.setIs_delete(dto.isIs_delete());
		return bean;
	}
	
	public List<TicketBean> mapToListBean(List<TicketResponseDTO> dtos) {
		List<TicketBean> beans=new ArrayList<TicketBean>();
		for(TicketResponseDTO dto: dtos) {
			TicketBean bean=mapToBean(dto);
			beans.add(bean);
		}
		return beans;
	}
	
}
