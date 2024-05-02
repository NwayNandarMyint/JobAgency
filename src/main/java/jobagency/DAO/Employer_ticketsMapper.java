package jobagency.DAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import jobagency.DTO.Employer_ticketsRequestDTO;
import jobagency.DTO.Employer_ticketsResponseDTO;
import jobagency.models.Employer_tickets;

public class Employer_ticketsMapper {
  public static Employer_ticketsRequestDTO beanToRequest(Employer_tickets bean) {
    Employer_ticketsRequestDTO dto=new Employer_ticketsRequestDTO();
    dto.setId(bean.getId());
    dto.setApplied_date(bean.getApplied_date());
    dto.setPayment_date(bean.getPayment_date());
    dto.setAdmin_id(bean.getAdmin_id());
    dto.setEmployer_id(bean.getEmployer_id());;
    dto.setTicket_id(bean.getTicket_id());;
    try {
      dto.setScreen_shot(bean.getScreen_shot().getBytes());
    } catch (IOException e) {
      e.printStackTrace();
    }
    return dto;
  }
  
  public Employer_tickets responseToBean(Employer_ticketsResponseDTO dto) {
	 EmployerDAO employerDAO=new EmployerDAO();
	Employer_tickets bean=new Employer_tickets();
    bean.setApplied_date(dto.getApplied_date());
    bean.setPayment_date(dto.getPayment_date());
    bean.setAdmin_id(dto.getAdmin_id());
    bean.setEmployer_id(dto.getEmployer_id());
    bean.setIs_Approved(dto.getIs_Approved());
    bean.setId(dto.getId());
    String employer_name=employerDAO.getEmployerNameById(dto.getEmployer_id());
	bean.setEmployer_name(employer_name);
    bean.setTicket_id(dto.getTicket_id());
    bean.setGetscreen_shot(dto.getScreen_shot());
    
    return bean;
  }
  
  public List<Employer_tickets> responstToListBean(List<Employer_ticketsResponseDTO> dtos) {
    List<Employer_tickets> beans=new ArrayList<Employer_tickets>();
    for(Employer_ticketsResponseDTO dto: dtos) {
    	Employer_tickets bean=responseToBean(dto);
    	beans.add(bean);
    }
    return beans; 
  }
  
}