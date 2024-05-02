package jobagency.DAO;

import java.util.ArrayList;
import java.util.List;
import jobagency.DTO.LevelRequestDTO;
import jobagency.DTO.LevelResponseDTO;
import jobagency.models.LevelBean;

public class LevelMapper {

	public LevelRequestDTO mapToRequestDTO(LevelBean bean) {
		LevelRequestDTO dto=new LevelRequestDTO();
		dto.setId(bean.getId());
		dto.setName(bean.getName());
		dto.setIs_delete(bean.isIs_delete());
		return dto;
	}
	
	public LevelBean mapToBean(LevelResponseDTO dto) {
		LevelBean bean=new LevelBean();
		bean.setId(dto.getId());
		bean.setName(dto.getName());
		bean.setIs_delete(dto.isIs_delete());
		return bean;
	}
	
	public List<LevelBean> mapToListBean(List<LevelResponseDTO> dtos) {
		List<LevelBean> beans=new ArrayList<LevelBean>();
		for(LevelResponseDTO dto: dtos) {
			LevelBean bean=mapToBean(dto);
			beans.add(bean);
		}
		return beans;
	}
	
}
