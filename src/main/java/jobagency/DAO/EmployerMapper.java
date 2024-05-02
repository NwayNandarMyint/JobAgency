package jobagency.DAO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jobagency.DTO.EmployerRequestDTO;
import jobagency.DTO.EmployerResponseDTO;
import jobagency.models.EmployerBean;

public class EmployerMapper {
	
	//1
	public static EmployerRequestDTO beanToRequest(EmployerBean bean) {
				
		EmployerRequestDTO dto=new EmployerRequestDTO();
		dto.setId(bean.getId());
		dto.setName(bean.getName());
		System.out.print(bean.getName());
		dto.setEmail(bean.getEmail());
		dto.setPassword(bean.getPassword());
		dto.setPhone_number(bean.getPhone_number());
		if(bean.getLogo().getSize()>0) {
			try {
				dto.setLogo(bean.getLogo().getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		dto.setCreated_date(bean.getCreated_date());		
		dto.setUpdated_date(bean.getUpdated_date());
		dto.setAvaliable_jobpost(bean.getAvaliable_jobpost());
		dto.setIndustry_id(bean.getIndustry_id());
		return dto;
	}
	
	//2
	
	public EmployerBean responseToBean(EmployerResponseDTO dto){
		IndustryDAO industryDAO=new IndustryDAO();
		
		EmployerBean bean=new EmployerBean();
		bean.setId(dto.getId());
		bean.setName(dto.getName());
		bean.setEmail(dto.getEmail());
		bean.setPassword(dto.getPassword());
		bean.setPhone_number(dto.getPhone_number()); 
		bean.setLogoString(dto.getLogo());
		bean.setCreated_date(dto.getCreated_date());
		bean.setUpdated_date(dto.getUpdated_date());
		bean.setAvaliable_jobpost(dto.getAvaliable_jobpost());
		bean.setIndustry_id(dto.getIndustry_id());
		String industry_name=industryDAO.getIndustryNameById(dto.getIndustry_id());
		bean.setIndustry_name(industry_name);
		return bean;
	}
	//3
	public List<EmployerBean> responstToListBean(List<EmployerResponseDTO> dtos) throws IOException {
		List<EmployerBean> beans=new ArrayList<EmployerBean>();
		for(EmployerResponseDTO dto: dtos) {
			EmployerBean bean=responseToBean(dto);
			beans.add(bean);
		}
		return beans; 
	}
}
