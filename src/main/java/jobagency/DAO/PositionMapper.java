package jobagency.DAO;

import java.util.ArrayList;
import java.util.List;
import jobagency.DTO.PositionRequestDTO;
import jobagency.DTO.PositionResponseDTO;
import jobagency.models.PositionBean;

public class PositionMapper {

	public PositionRequestDTO mapToRequestDTO( PositionBean bean) {
		PositionRequestDTO dto=new PositionRequestDTO();
		dto.setId(bean.getId());
		dto.setName(bean.getName());
		dto.setIs_delete(bean.isIs_delete());
		return dto;
	}
	
	public PositionBean mapToBean(PositionResponseDTO dto) {
		PositionBean bean=new PositionBean();
		bean.setId(dto.getId());
		bean.setName(dto.getName());
		bean.setIs_delete(dto.isIs_delete());
		return bean;
	}
	
	public List<PositionBean> mapToListBean(List<PositionResponseDTO> dtos) {
		List<PositionBean> beans=new ArrayList<PositionBean>();
		for(PositionResponseDTO dto: dtos) {
			PositionBean bean=mapToBean(dto);
			beans.add(bean);
		}
		return beans;
	}
	
}
