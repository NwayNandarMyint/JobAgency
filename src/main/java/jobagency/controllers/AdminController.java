package jobagency.controllers;
import java.io.IOException;
import jobagency.DTO.Employer_ticketsRequestDTO;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jobagency.DAO.AdminDAO;
import jobagency.DAO.AdminLoginDAO;
import jobagency.DAO.AdminMapper;
import jobagency.DAO.EmployerDAO;
import jobagency.DAO.EmployerMapper;
import jobagency.DAO.Employer_ticketsDAO;
import jobagency.DAO.Employer_ticketsMapper;
import jobagency.DAO.RoleDAO;
import jobagency.DAO.RoleMapper;
import jobagency.DAO.TicketDAO;
import jobagency.DAO.TicketMapper;
import jobagency.DTO.AdminRequestDTO;
import jobagency.DTO.AdminResponseDTO;
import jobagency.DTO.Employer_ticketsResponseDTO;
import jobagency.DTO.RoleResponseDTO;
import jobagency.DTO.TicketResponseDTO;
import jobagency.models.AdminBean;
import jobagency.models.Employer_tickets;
import jobagency.models.RoleBean;
import jobagency.models.TicketBean;
import jobagency.DTO.EmployerRequestDTO;
@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	AdminDAO adminDAO;
	@Autowired
	AdminMapper adminMapper;
	@Autowired
	RoleDAO roleDAO;
	@Autowired
	RoleMapper roleMapper;
	@Autowired
	EmployerDAO employerDAO;
	@Autowired
	EmployerMapper employerMapper;
	@Autowired
	AdminLoginDAO adminloginDAO;
	@Autowired
	Employer_ticketsDAO employer_ticketsDAO;
	@Autowired
	Employer_ticketsMapper employer_ticketsMapper; 
	@Autowired
	TicketDAO ticketDAO; 
	@Autowired
	TicketMapper ticketMapper; 
	@RequestMapping(value="/",method=RequestMethod.GET)
	public Object adminLoginChecking(HttpServletRequest request,Model model,@ModelAttribute("loginerror") String data,@ModelAttribute("emailerror") String emaildata,@ModelAttribute("passworderror") String passworddata) {
		HttpSession session = request.getSession();
		if(session.getAttribute("simpleadminId") == null && session.getAttribute("adminId") == null) {
			model.addAttribute("receivedloginerror", data);
			model.addAttribute("receivedemailerror", emaildata);
			model.addAttribute("receivedpassworderror", passworddata);
			return new ModelAndView("adminlogin","checkadmin",new AdminBean());
		}
		
		else if(session !=null && session.getAttribute("simpleadminId") != null) {
			return "redirect:/admin/SimpleAdmin";
	} else {
		return "redirect:/admin/SuperAdmin";
	}
	
	}
	
	@RequestMapping(value="/checkadmin" ,method=RequestMethod.POST)
	public String adminLoginChecking(@ModelAttribute("checkadmin")AdminBean admin,ModelMap model, HttpServletRequest request,RedirectAttributes redirectAttributes) {
		if(admin.getEmail().length() == 0 && admin.getPassword().length() == 0) {
			redirectAttributes.addFlashAttribute("emailerror", "Please Enter Your E-Mail !");
			redirectAttributes.addFlashAttribute("passworderror", "Please Enter Your Password !");
			return"redirect:/admin/";
		}
		boolean loginResult=adminloginDAO.checkingAdminLogin(admin.getEmail(),admin.getPassword());
		if (loginResult == true) {
			String adminemail="aungkyawnyein456@gmail.com";
			String adminpassword="1111111";
			if(adminemail.equals(admin.getEmail())&& adminpassword.equals(admin.getPassword())) {
				 int adminId=adminloginDAO.getAdminById(admin.getEmail(),admin.getPassword());
				 HttpSession session = request.getSession();
				 session.setAttribute("adminId", adminId);
				return "redirect:/admin/SuperAdmin";
			}else {
				 int adminId=adminloginDAO.getAdminById(admin.getEmail(),admin.getPassword());
				 HttpSession session = request.getSession();
				 session.setAttribute("simpleadminId", adminId);
				return "redirect:/admin/SimpleAdmin";
			}
	    }else if(loginResult != true){
	    	redirectAttributes.addFlashAttribute("loginerror", "Your E-Mail (OR) Password is Incorrect !");
			return"redirect:/admin/";
		}
		 return "redirect:/admin/"; 
	}
	@RequestMapping(value="/SimpleAdmin",method=RequestMethod.GET)
	public String mainAdmin(ModelMap m,HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if(session != null && session.getAttribute("simpleadminId") != null) {
			List<AdminResponseDTO>dtos=adminDAO.getAllAdmin();	
			List<AdminBean>admins=adminMapper.mapToListBean(dtos);		
			m.addAttribute("admins", admins);
			return "redirect:/SimpleTicket";	
		}
		return "redirect:/admin/";
	}
	@RequestMapping(value="/SuperAdmin",method=RequestMethod.GET)
	public String displayAdmin(ModelMap m,HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if(session != null && session.getAttribute("adminId") != null) {
			List<AdminResponseDTO>dtos=adminDAO.getAllAdmin();	
			List<AdminBean>admins=adminMapper.mapToListBean(dtos);		
			m.addAttribute("admins", admins);
			
			List<RoleResponseDTO> pos=roleDAO.getAllRole();
		    List<RoleBean> roles=roleMapper.mapToListBean(pos);  
		    m.addAttribute("roles",roles);
		    m.addAttribute("admin", new AdminBean());
			return "displayadmin";
		}
		return "redirect:/admin/";
	}
	
	@RequestMapping(value="/addadmin",method=RequestMethod.POST)
	public String addAdmin(@ModelAttribute("admin")@Validated AdminBean admin,BindingResult bResult,ModelMap model) {
		if(bResult.hasErrors()) {
			List<AdminResponseDTO>dtos=adminDAO.getAllAdmin();	
			List<AdminBean>admins=adminMapper.mapToListBean(dtos);		
			model.addAttribute("admins", admins);
			List<RoleResponseDTO> pos=roleDAO.getAllRole();
		    List<RoleBean> roles=roleMapper.mapToListBean(pos);  
		    model.addAttribute("roles",roles);
			return "displayadmin";
		}     								
		AdminRequestDTO dto=adminMapper.mapToRequestDTO(admin);

		int rs=adminDAO.addAdmin(dto);
		if(rs==0) {
			List<AdminResponseDTO>dtos=adminDAO.getAllAdmin();	
			List<AdminBean>admins=adminMapper.mapToListBean(dtos);		
			model.addAttribute("admins", admins);
			List<RoleResponseDTO> pos=roleDAO.getAllRole();
		    List<RoleBean> roles=roleMapper.mapToListBean(pos);  
		    model.addAttribute("roles",roles);
			model.addAttribute("error","You Need Some Column To Add");
			return "displayadmin";
		}
		return "redirect:/admin/SuperAdmin";
	}
	
	@RequestMapping(value="/editadmin/{id}",method=RequestMethod.GET)
	public ModelAndView editAdmin(@PathVariable int id,ModelMap model) {
		List<RoleResponseDTO> pos=roleDAO.getAllRole();
	    List<RoleBean> roles=roleMapper.mapToListBean(pos);  
	    model.addAttribute("roles",roles);
		AdminResponseDTO dto=adminDAO.getAdminById(id);
		AdminBean admin=adminMapper.mapToBean(dto);
		return new ModelAndView("editadmin","admin",admin);
	}
	
	@RequestMapping(value="/editadmin",method=RequestMethod.POST)
	public String editAdmin(@ModelAttribute("admin") @Validated AdminBean admin,BindingResult bResult,ModelMap model) {
		if(bResult.hasErrors()) {
			List<RoleResponseDTO> pos=roleDAO.getAllRole();
		    List<RoleBean> roles=roleMapper.mapToListBean(pos);  
		    model.addAttribute("roles",roles);
			return "editadmin";
		}		
		AdminRequestDTO dto=adminMapper.mapToRequestDTO(admin);	
		dto.setId(admin.getId());
		int rs=adminDAO.editAdmin(dto);
		if(rs==0) {
			model.addAttribute("error","Admin Update Fail(SQL Error)");
			return "editadmin"; 
		}
		return "redirect:/admin";
	}
	
	@RequestMapping(value="/deleteadmin/{id}",method=RequestMethod.GET)
	public String deleteAdmin(@PathVariable int id,ModelMap model) {
						
		int result=AdminDAO.deleteAdmin(id);
		if(result==0) {
			model.addAttribute("error","Admin Delete Fail(SQL Error)");
			return "displayadmin"; 
		}
		return "redirect:/admin/SuperAdmin";		
	}
	
	@RequestMapping(value="/ticketorder",method=RequestMethod.GET)
	public String viewAllTicketOrder( ModelMap model,HttpServletRequest request) throws IOException {	
		HttpSession session = request.getSession(false);
		if(session != null && session.getAttribute("adminId") != null) {
			List<Employer_ticketsResponseDTO>dtos=employer_ticketsDAO.getAllTicketOrder();	
			List<Employer_tickets> ticketorders=employer_ticketsMapper.responstToListBean(dtos);
			model.addAttribute("ticketorders", ticketorders);
			return "ticketorder";
		}
		return "redirect:/admin/";
	}
	
	@RequestMapping(value="/simpleticketorder",method=RequestMethod.GET)
	public String viewSimpleAllTicketOrder( ModelMap model,HttpServletRequest request) throws IOException {	
		HttpSession session = request.getSession(false);
		if(session != null && session.getAttribute("simpleadminId") != null) {
			List<Employer_ticketsResponseDTO>dtos=employer_ticketsDAO.getAllTicketOrder();	
			List<Employer_tickets> ticketorders=employer_ticketsMapper.responstToListBean(dtos);
			model.addAttribute("ticketorders", ticketorders);
			
			return "simpleticketorder";
		}
		return "redirect:/admin/";
	}
	
	@RequestMapping(value="/confirmticket",method=RequestMethod.GET)
	public String ConfirmTicketOrder(@RequestParam("em_id")int employer_id,@RequestParam("tc_id")int ticket_id,@RequestParam("employer_ticketid")int employerticketid,ModelMap model,HttpServletRequest request) throws IOException {	
		HttpSession session = request.getSession(false);
		if(session != null && session.getAttribute("adminId") != null) {
			int adminid=(int) session.getAttribute("adminId");
			Employer_ticketsRequestDTO ticketdto=new Employer_ticketsRequestDTO();
			ticketdto.setId(employerticketid);
			ticketdto.setAdmin_id(adminid);
			int result=employer_ticketsDAO.confirmTicket(ticketdto);
			
			TicketResponseDTO amountticket=ticketDAO.getTicketById(ticket_id);
			int amount=amountticket.getPost();
			
			EmployerRequestDTO employerdto=new EmployerRequestDTO();
			employerdto.setId(employer_id);
			employerdto.setAvaliable_jobpost(amount);
			int insertpost=employerDAO.insertAvailabeJobPost(employerdto);
		}
		return "redirect:/admin/ticketorder";
	}
	
	@RequestMapping(value="/cancelticket",method=RequestMethod.GET)
	  public String CancelTicketOrder(@RequestParam("employer_ticketid")int employerticketid,ModelMap model,HttpServletRequest request,RedirectAttributes redirectAttributes) throws IOException {
	    HttpSession session = request.getSession(false);
	    if(session != null && session.getAttribute("adminId") != null) {
	      int adminid=(int) session.getAttribute("adminId");
	      Employer_ticketsRequestDTO ticketdto=new Employer_ticketsRequestDTO();
	      ticketdto.setId(employerticketid);
	      ticketdto.setAdmin_id(adminid);
	      int cancelorder=employer_ticketsDAO.cancelTicket(ticketdto);
	      
	      return "redirect:/admin/ticketorder";
	    }
	    return "redirect:/admin/ticketorder";
	  }
	
	@RequestMapping(value="/confirmsimpleticket",method=RequestMethod.GET)
	public String ConfirmSimpleTicketOrder(@RequestParam("em_id")int employer_id,@RequestParam("tc_id")int ticket_id,@RequestParam("employer_ticketid")int employerticketid,ModelMap model,HttpServletRequest request) throws IOException {	
		HttpSession session = request.getSession(false);
		if(session != null && session.getAttribute("simpleadminId") != null) {
			int adminid=(int) session.getAttribute("simpleadminId");
			Employer_ticketsRequestDTO ticketdto=new Employer_ticketsRequestDTO();
			ticketdto.setId(employerticketid);
			ticketdto.setAdmin_id(adminid);
			int result=employer_ticketsDAO.confirmTicket(ticketdto);
			
			TicketResponseDTO amountticket=ticketDAO.getTicketById(ticket_id);
			int amount=amountticket.getPost();
			
			EmployerRequestDTO employerdto=new EmployerRequestDTO();
			employerdto.setId(employer_id);
			employerdto.setAvaliable_jobpost(amount);
			int insertpost=employerDAO.insertAvailabeJobPost(employerdto);
		}
		return "redirect:/admin/simpleticketorder";
	}
	
	@RequestMapping(value="/cancelsimpleticket",method=RequestMethod.GET)
	  public String CancelSimpleTicketOrder(@RequestParam("employer_ticketid")int employerticketid,ModelMap model,HttpServletRequest request,RedirectAttributes redirectAttributes) throws IOException {
	    HttpSession session = request.getSession(false);
	    if(session != null && session.getAttribute("simpleadminId") != null) {
	      int adminid=(int) session.getAttribute("simpleadminId");
	      Employer_ticketsRequestDTO ticketdto=new Employer_ticketsRequestDTO();
	      ticketdto.setId(employerticketid);
	      ticketdto.setAdmin_id(adminid);
	      int cancelorder=employer_ticketsDAO.cancelTicket(ticketdto);
	      
	      return "redirect:/admin/simpleticketorder";
	    }
	    return "redirect:/admin/simpleticketorder";
	  }
	
}
