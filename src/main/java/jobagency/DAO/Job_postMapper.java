package jobagency.DAO;

import java.util.ArrayList;
import java.util.List;
import jobagency.DTO.Job_postRequestDTO;
import jobagency.DTO.Job_postResponseDTO;
import jobagency.models.Job_postBean;

public class Job_postMapper {
	public Job_postRequestDTO beanToRequest(Job_postBean bean) {
		Job_postRequestDTO dto=new Job_postRequestDTO();
		dto.setId(bean.getId());
		dto.setAge_range(bean.getAge_range());
		dto.setSalary(bean.getSalary());
		dto.setBackground_education(bean.getBackground_education());
		dto.setWork_experiences(bean.getWork_experiences());
		dto.setActive(bean.isActive());
		dto.setCreated_date(bean.getCreated_date());
		dto.setUpdated_date(bean.getUpdated_date());
		dto.setAddress(bean.getAddress());
		dto.setLevel_id(bean.getLevel_id());
		dto.setEmployer_id(bean.getEmployer_id());
		dto.setPosition_id(bean.getPosition_id());
		dto.setRequired_candidate(bean.getRequired_candidate());
		return dto;
	}
	
	public Job_postBean responseToBean(Job_postResponseDTO dto) {
		LevelDAO levelDAO=new LevelDAO();
		PositionDAO positionDAO=new PositionDAO();
		EmployerDAO employerDAO=new EmployerDAO();
		
		Job_postBean bean=new Job_postBean();
		bean.setAge_range(dto.getAge_range());
		bean.setId(dto.getId());
		bean.setSalary(dto.getSalary());
		bean.setBackground_education(dto.getBackground_education());
		bean.setWork_experiences(dto.getWork_experiences());
		bean.setActive(dto.isActive());
		bean.setCreated_date(dto.getCreated_date());
		bean.setUpdated_date(dto.getUpdated_date());
		bean.setRequired_candidate(dto.getRequired_candidate());
		bean.setAddress(dto.getAddress());
		bean.setLevel_id(dto.getLevel_id());
		bean.setRequired_candidate(dto.getRequired_candidate());
		String level_name=levelDAO.getLevelNameById(dto.getLevel_id());
		bean.setLevel_name(level_name);
		bean.setEmployer_id(dto.getEmployer_id());
		String employer_name=employerDAO.getEmployerNameById(dto.getEmployer_id());
		bean.setEmployer_name(employer_name);
		bean.setPosition_id(dto.getPosition_id());
		String position_name=positionDAO.getPositionNameById(dto.getPosition_id());
		bean.setPosition_name(position_name);
		
		return bean;
	}
	
	public List<Job_postBean> responstToListBean(List<Job_postResponseDTO> dtos) {
		List<Job_postBean> beans=new ArrayList<Job_postBean>();
		for(Job_postResponseDTO dto: dtos) {
			Job_postBean bean=responseToBean(dto);
			beans.add(bean);
		}
		return beans; 
	}


}
