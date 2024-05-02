package jobagency.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import jobagency.DAO.AdminDAO;
import jobagency.DAO.AdminMapper;
import jobagency.DAO.TicketDAO;
import jobagency.DAO.TicketMapper;
import jobagency.DTO.AdminResponseDTO;
import jobagency.DTO.TicketRequestDTO;
import jobagency.DTO.TicketResponseDTO;
import jobagency.models.AdminBean;
import jobagency.models.TicketBean;

@Controller
public class TicketController {

	@Autowired
	TicketDAO ticketDAO;
	@Autowired
	TicketMapper ticketMapper;
	@Autowired
	AdminDAO adminDAO;
	@Autowired
	AdminMapper adminMapper;
	
	@RequestMapping(value="/Ticket",method=RequestMethod.GET)
	public String displayTicket(ModelMap m,HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if(session != null && session.getAttribute("adminId") != null) {
			List<TicketResponseDTO>dtos=ticketDAO.getAllTicket();	
			List<TicketBean>tickets=ticketMapper.mapToListBean(dtos);		
			m.addAttribute("tickets", tickets);
			List<AdminResponseDTO> adms=adminDAO.getAllAdmin();
			List<AdminBean> admins=adminMapper.mapToListBean(adms);		
			m.addAttribute("admins",admins);
			m.addAttribute("ticket", new TicketBean());
			return "displayticket";
		}
		return "redirect:/admin/";
	}
	
	@RequestMapping(value="/addticket", method=RequestMethod.POST)
	public String addTicket(@ModelAttribute("ticket")@Validated TicketBean ticket,BindingResult bResult,ModelMap model) {
		if(bResult.hasErrors()) {
			List<TicketResponseDTO>dtos=ticketDAO.getAllTicket();	
			List<TicketBean>tickets=ticketMapper.mapToListBean(dtos);		
			model.addAttribute("tickets", tickets);
			List<AdminResponseDTO> adms=adminDAO.getAllAdmin();
			List<AdminBean> admins=adminMapper.mapToListBean(adms);		
			model.addAttribute("admins",admins);
			return "displayticket";
		}
		System.out.println(ticket.getAdmin_id());
		
		TicketRequestDTO dto=ticketMapper.mapToRequestDTO(ticket);

		int rs=ticketDAO.addTicket(dto);
		if(rs==0) {
			List<TicketResponseDTO>dtos=ticketDAO.getAllTicket();	
			List<TicketBean>tickets=ticketMapper.mapToListBean(dtos);		
			model.addAttribute("tickets", tickets);
			List<AdminResponseDTO> adms=adminDAO.getAllAdmin();
			List<AdminBean> admins=adminMapper.mapToListBean(adms);		
			model.addAttribute("admins",admins);
			model.addAttribute("error","You Need Some Column To Add");
			return "displayticket";
		}
		return "redirect:/Ticket";
	}
	
//	@RequestMapping(value="/editticket/{id}",method=RequestMethod.GET)
//	public ModelAndView editTicket(@PathVariable int id,ModelMap model) {
//		List<AdminResponseDTO> adms=adminDAO.getAllAdmin();
//		List<AdminBean> admins=adminMapper.mapToListBean(adms);		
//		model.addAttribute("admins",admins);
//		TicketResponseDTO dto=ticketDAO.getTicketById(id);
//		TicketBean ticket=ticketMapper.mapToBean(dto);
//		return new ModelAndView("editticket","ticket",ticket);
//	}
//	
//	@RequestMapping(value="/editticket",method=RequestMethod.POST)
//	public String editTicket(@ModelAttribute("ticket") @Validated TicketBean ticket,BindingResult bResult,ModelMap model) {
//		if(bResult.hasErrors()) {
//			List<AdminResponseDTO> adms=adminDAO.getAllAdmin();
//			List<AdminBean> admins=adminMapper.mapToListBean(adms);		
//			model.addAttribute("admins",admins);
//			return "editticket";
//		}		
//		TicketRequestDTO dto=ticketMapper.mapToRequestDTO(ticket);		
//		int rs=ticketDAO.editTicket(dto);
//		if(rs==0) {
//			model.addAttribute("error","Ticket Update Fail(SQL Error)");
//			return "editticket"; 
//		}
//		return "redirect:/Ticket";
//	}
	
	@RequestMapping(value="/deleteticket/{id}",method=RequestMethod.GET)
	public String deleteTicket(@PathVariable int id,ModelMap model) {
						
		int result=ticketDAO.deleteTicket(id);
		if(result==0) {
			model.addAttribute("error","Level Delete Fail(SQL Error)");
			return "displayticket"; 
		}
		
		return "redirect:/Ticket";		
	}

	@RequestMapping(value="/SimpleTicket",method=RequestMethod.GET)
	public String displaySimpleTicket(ModelMap m,HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if(session != null && session.getAttribute("simpleadminId") != null) {
			List<TicketResponseDTO>dtos=ticketDAO.getAllTicket();	
			List<TicketBean>tickets=ticketMapper.mapToListBean(dtos);		
			m.addAttribute("tickets", tickets);
			List<AdminResponseDTO> adms=adminDAO.getAllAdmin();
			List<AdminBean> admins=adminMapper.mapToListBean(adms);		
			m.addAttribute("admins",admins);
			m.addAttribute("ticket", new TicketBean());
			return "displaysimpleticket";
		}
		return "redirect:/admin/";
	}
	
	@RequestMapping(value="/addsimpleticket", method=RequestMethod.POST)
	public String addSimpleTicket(@ModelAttribute("ticket")@Validated TicketBean ticket,BindingResult bResult,ModelMap model) {
		if(bResult.hasErrors()) {
			List<TicketResponseDTO>dtos=ticketDAO.getAllTicket();	
			List<TicketBean>tickets=ticketMapper.mapToListBean(dtos);		
			model.addAttribute("tickets", tickets);
			List<AdminResponseDTO> adms=adminDAO.getAllAdmin();
			List<AdminBean> admins=adminMapper.mapToListBean(adms);		
			model.addAttribute("admins",admins);
			return "displaysimpleticket";
		}
		System.out.println(ticket.getAdmin_id());
		
		TicketRequestDTO dto=ticketMapper.mapToRequestDTO(ticket);

		int rs=ticketDAO.addTicket(dto);
		if(rs==0) {
			List<TicketResponseDTO>dtos=ticketDAO.getAllTicket();	
			List<TicketBean>tickets=ticketMapper.mapToListBean(dtos);		
			model.addAttribute("tickets", tickets);
			List<AdminResponseDTO> adms=adminDAO.getAllAdmin();
			List<AdminBean> admins=adminMapper.mapToListBean(adms);		
			model.addAttribute("admins",admins);
			model.addAttribute("error","You Need Some Column To Add");
			return "displaysimpleticket";
		}
		return "redirect:/SimpleTicket";
	}
	
//	@RequestMapping(value="/editticket/{id}",method=RequestMethod.GET)
//	public ModelAndView editTicket(@PathVariable int id,ModelMap model) {
//		List<AdminResponseDTO> adms=adminDAO.getAllAdmin();
//		List<AdminBean> admins=adminMapper.mapToListBean(adms);		
//		model.addAttribute("admins",admins);
//		TicketResponseDTO dto=ticketDAO.getTicketById(id);
//		TicketBean ticket=ticketMapper.mapToBean(dto);
//		return new ModelAndView("editticket","ticket",ticket);
//	}
//	
//	@RequestMapping(value="/editticket",method=RequestMethod.POST)
//	public String editTicket(@ModelAttribute("ticket") @Validated TicketBean ticket,BindingResult bResult,ModelMap model) {
//		if(bResult.hasErrors()) {
//			List<AdminResponseDTO> adms=adminDAO.getAllAdmin();
//			List<AdminBean> admins=adminMapper.mapToListBean(adms);		
//			model.addAttribute("admins",admins);
//			return "editticket";
//		}		
//		TicketRequestDTO dto=ticketMapper.mapToRequestDTO(ticket);		
//		int rs=ticketDAO.editTicket(dto);
//		if(rs==0) {
//			model.addAttribute("error","Ticket Update Fail(SQL Error)");
//			return "editticket"; 
//		}
//		return "redirect:/Ticket";
//	}
	
	@RequestMapping(value="/deletesimpleticket/{id}",method=RequestMethod.GET)
	public String deleteSimpleTicket(@PathVariable int id,ModelMap model) {
						
		int result=ticketDAO.deleteTicket(id);
		if(result==0) {
			model.addAttribute("error","Level Delete Fail(SQL Error)");
			return "displaysimpleticket"; 
		}
		
		return "redirect:/SimpleTicket";		
	}

}
	
