package jobagency.controllers;
import java.io.IOException;
import java.util.List;
import jobagency.DTO.TicketResponseDTO;
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

import jobagency.DAO.CandidateCVDAO;
import jobagency.DAO.CandidateCVMapper;
import jobagency.DAO.EmployerDAO;
import jobagency.DAO.EmployerLoginDAO;
import jobagency.DAO.EmployerMapper;
import jobagency.DAO.Employer_ticketsDAO;
import jobagency.DAO.Employer_ticketsMapper;
import jobagency.DAO.IndustryDAO;
import jobagency.DAO.IndustryMapper;
import jobagency.DAO.Job_postDAO;
import jobagency.DAO.Job_postMapper;
import jobagency.DAO.TicketDAO;
import jobagency.DAO.TicketMapper;
import jobagency.DTO.CandidateCVResponseDTO;
import jobagency.DTO.EmployerRequestDTO;
import jobagency.DTO.EmployerResponseDTO;
import jobagency.DTO.Employer_ticketsRequestDTO;
import jobagency.DTO.IndustryResponseDTO;
import jobagency.DTO.Job_postResponseDTO;
import jobagency.DTO.Job_postRequestDTO;
import jobagency.models.CandidateCVBean;
import jobagency.models.EmployerBean;
import jobagency.models.EmployerLoginModel;
import jobagency.models.Employer_tickets;
import jobagency.models.IndustryBean;
import jobagency.models.Job_postBean;
import jobagency.models.TicketBean;
@Controller
@RequestMapping("/employer")
public class EmployerController {
	@Autowired
	EmployerDAO employerDAO;
	@Autowired
	EmployerMapper employerMapper;
	@Autowired
	IndustryDAO industryDAO;
	@Autowired
	IndustryMapper industryMapper;
	@Autowired
	EmployerLoginDAO employerloginDAO;
	@Autowired
	TicketDAO ticketDAO;
	@Autowired
	TicketMapper ticketMapper;
	@Autowired
	Job_postDAO job_postDAO;
	@Autowired
	Job_postMapper job_postMapper;
	@Autowired
	Employer_ticketsDAO employer_ticketsDAO;
	@Autowired
	CandidateCVDAO candidatecvDAO;
	@Autowired
	CandidateCVMapper candidatecvMapper;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public Object employerLoginChecking(HttpServletRequest request, Model model,@ModelAttribute("loginerror") String data,@ModelAttribute("emailerror") String emaildata,@ModelAttribute("passworderror") String passworddata) {
		HttpSession session = request.getSession();
		if(session.getAttribute("employerId") == null) {
		model.addAttribute("receivedloginerror", data);
		model.addAttribute("receivedemailerror", emaildata);
		model.addAttribute("receivedpassworderror", passworddata);
		return new ModelAndView("employerlogin","checkemployer",new EmployerLoginModel());
		}
		else {
			return "redirect:/employer/displayemployer";
		}
	}
	@RequestMapping(value="/loginemployer" ,method=RequestMethod.POST)
	public String employerLoginChecking(@ModelAttribute("checkemployer")@Validated EmployerLoginModel employer,ModelMap model, HttpServletRequest request,RedirectAttributes redirectAttributes) {
		if(employer.getEmail().length() == 0 && employer.getPassword().length() == 0) {
			redirectAttributes.addFlashAttribute("emailerror", "Please Enter Your E-Mail !");
			redirectAttributes.addFlashAttribute("passworderror", "Please Enter Your Password !");
			return "redirect:/employer/";
		}
		boolean loginResult=employerloginDAO.checkingEmployerLogin(employer.getEmail(),employer.getPassword());
			if(loginResult == true) {
				 int employerId=employerloginDAO.getEmployerId(employer.getEmail(),employer.getPassword());
				 HttpSession session = request.getSession();
				 session.setAttribute("employerId", employerId);
				 return "redirect:/employer/displayemployer";
			}else if(loginResult != true){
		    	redirectAttributes.addFlashAttribute("loginerror", "Your E-Mail (OR) Password is Incorrect !");
		    	return "redirect:/employer/";
			}
		 return "redirect:/employer/";  
	}
	@RequestMapping(value="/addemployer",method=RequestMethod.GET)
	public Object addEmployer( ModelMap model) {
			List<IndustryResponseDTO> pos=industryDAO.getAllIndustry();
			List<IndustryBean> industries=industryMapper.mapToListBean(pos)	;	
			model.addAttribute("industries",industries);
			return new ModelAndView("createnewemployer","employer", new EmployerBean());
	}
	@RequestMapping(value="/addemployer", method=RequestMethod.POST)
	public String addEmployer(@ModelAttribute("employer")@Validated EmployerBean employer,BindingResult bResult,ModelMap model) {
		if(bResult.hasErrors() || employer.getIndustry_id()==0) {
			List<IndustryResponseDTO> pos=industryDAO.getAllIndustry();
			List<IndustryBean> industries=industryMapper.mapToListBean(pos)	;	
			model.addAttribute("industries",industries);
			
			if(employer.getIndustry_id()==0) {
				model.addAttribute("Industry_error","Please select industry");
			}
			
			return "createnewemployer";
		}
		EmployerRequestDTO dto=employerMapper.beanToRequest(employer);
		dto.setCreated_date(employer.getCreated_date());

		int rs=employerDAO.addEmployer(dto);
		if(rs==0) {
			List<IndustryResponseDTO> pos=industryDAO.getAllIndustry();
			List<IndustryBean> industries=industryMapper.mapToListBean(pos)	;	
			model.addAttribute("industries",industries);
			model.addAttribute("error","You Need Some Column To Add");
			return "createnewemployer";
		}
		model.addAttribute("result",rs);
		return "createnewemployer";
			
	}
	@RequestMapping(value="/displayemployer",method=RequestMethod.GET)
	public String displayEmployer( ModelMap model, HttpServletRequest request) {	
		HttpSession session = request.getSession(false);
		if(session != null && session.getAttribute("employerId") != null) {
			 int id = (Integer) session.getAttribute("employerId");
			var dto=employerDAO.getEmployerById(id);
			var bean=employerMapper.responseToBean(dto);
			model.addAttribute("employer",bean);
			return "employerprofilepage";
		}
		return "redirect:/employer/";
		
	}
	@RequestMapping(value="/updateemployer",method=RequestMethod.GET)
	public Object updateEmployer(ModelMap model,HttpServletRequest request) {	
		HttpSession session = request.getSession(false);
		if(session != null && session.getAttribute("employerId") != null) {
			 int id = (Integer) session.getAttribute("employerId");
				var dto=employerDAO.getEmployerById(id);
				var bean=employerMapper.responseToBean(dto);
				model.addAttribute("employer",bean);
			return new ModelAndView("updateemployer","updateemployer", new EmployerBean());
		}
		return "redirect:/employer/";
	}
	
	@RequestMapping(value="/updateemployer",method=RequestMethod.POST)
	public String updateEmployer(@ModelAttribute("updateemployer") @Validated EmployerBean employer,BindingResult bResult,ModelMap model,HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if(session != null && session.getAttribute("employerId") != null) {
			 int id = (Integer) session.getAttribute("employerId");
			 EmployerRequestDTO dto=EmployerMapper.beanToRequest(employer);	
				dto.setUpdated_date(employer.getUpdated_date());		
				dto.setId(id);
				int rs=employerDAO.updateEmployer(dto);
				if(rs==0) {
					model.addAttribute("error","Update Fail(SQL Error)");
					return "error"; 
				}
				model.addAttribute("result",rs);
				return "updateemployer";
		}
		return "redirect:/employer/";
	}
	
	@RequestMapping(value="/ticket",method=RequestMethod.GET)
	  public Object ticketEmployer( ModelMap model,HttpServletRequest request,@ModelAttribute("loginerror") String data) {
	    HttpSession session = request.getSession(false);
	    if(session != null && session.getAttribute("employerId") != null) {
	       int id = (Integer) session.getAttribute("employerId");
	       var dto=employerDAO.getEmployerById(id);
	        var bean=employerMapper.responseToBean(dto);
	        model.addAttribute("employer",bean);
	        
	        List<TicketResponseDTO> ticket=ticketDAO.getAllTicket();
	          List<TicketBean> tickets=ticketMapper.mapToListBean(ticket);
	          model.addAttribute("tickets",tickets);
	          model.addAttribute("receivedloginerror", data);
	        return new ModelAndView("ticketpage","ticketorder",new Employer_tickets());
	    }
	    return "redirect:/employer/";
	  }
	  @RequestMapping(value="/ticket",method=RequestMethod.POST)
	  public String employerTicketBuying(@ModelAttribute("ticketorder") @Validated Employer_tickets ticket,ModelMap model,HttpServletRequest request,RedirectAttributes redirectAttributes) {
	    HttpSession session = request.getSession(false);
	    if(session != null && session.getAttribute("employerId") != null) {
	       int id = (Integer) session.getAttribute("employerId");
	       ticket.setEmployer_id(id);
	       Employer_ticketsRequestDTO dto=Employer_ticketsMapper.beanToRequest(ticket);
	       
	       int rs=employer_ticketsDAO.addEmployer_cticket(dto);
	       if(rs==0) {
	    	   redirectAttributes.addFlashAttribute("loginerror", "You Need To Add!");
	          return "redirect:/employer/ticket"; 
	      }
	       model.addAttribute("result",rs);
	    }
	    return "ticketpage";
	  }
	
	@RequestMapping(value="/alljobpost",method=RequestMethod.GET)
	public String jobPostEmployer( ModelMap model,HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if(session != null && session.getAttribute("employerId") != null) {
			int id = (Integer) session.getAttribute("employerId");
			var dto=employerDAO.getEmployerById(id);
			var bean=employerMapper.responseToBean(dto);
			model.addAttribute("employer",bean);
				  List<Job_postResponseDTO> dtos=job_postDAO.getJobpostById(id);
				    List<Job_postBean> posts=job_postMapper.responstToListBean(dtos);
				    model.addAttribute("posts", posts);
				    return "employerprofilepage";
		}
		return "redirect:error";
	}
	
	@RequestMapping(value="/allemployer",method=RequestMethod.GET)
	public String displayAllEmployer( ModelMap model,HttpServletRequest request) throws IOException {	
		HttpSession session = request.getSession(false);
		if(session != null && session.getAttribute("adminId") != null) {
			List<EmployerResponseDTO>dtos=employerDAO.getEmployers();	
			List<EmployerBean>employers=employerMapper.responstToListBean(dtos);		
			model.addAttribute("employers", employers);
			return "allcompany";
		}
		return "redirect:/admin/";
	}
	
	@RequestMapping(value="/simpleallemployer",method=RequestMethod.GET)
	public String displaySimpleAllEmployer( ModelMap model,HttpServletRequest request) throws IOException {	
		HttpSession session = request.getSession(false);
		if(session != null && session.getAttribute("simpleadminId") != null) {
			List<EmployerResponseDTO>dtos=employerDAO.getEmployers();	
			List<EmployerBean>employers=employerMapper.responstToListBean(dtos);		
			model.addAttribute("employers", employers);
			return "simpleallcompany";
		}
		return "redirect:/admin/";
	}
	
	@RequestMapping(value="/viewall",method=RequestMethod.GET)
	public String viewAllEmployer( ModelMap model) throws IOException {	
		List<EmployerResponseDTO>dtos=employerDAO.getEmployers();	
		List<EmployerBean>employers=employerMapper.responstToListBean(dtos);		
		model.addAttribute("employers", employers);
		return "viewallcompany";
		
	}
	
	@RequestMapping(value="/homeviewall",method=RequestMethod.GET)
	public String homeViewAllEmployer( ModelMap model) throws IOException {	
		List<EmployerResponseDTO>dtos=employerDAO.getEmployers();	
		List<EmployerBean>employers=employerMapper.responstToListBean(dtos);		
		model.addAttribute("employers", employers);
		return "homeviewallcompany";
		
	}

	@RequestMapping(value="/viewallcv",method=RequestMethod.GET)
	public String viewAllCv( ModelMap model,HttpServletRequest request) throws IOException {	
		HttpSession session = request.getSession(false);
		if(session != null && session.getAttribute("employerId") != null) {
			int id = (Integer) session.getAttribute("employerId");
			
			EmployerResponseDTO dto=employerDAO.getEmployerById(id);
			EmployerBean bean=employerMapper.responseToBean(dto);
			model.addAttribute("employer",bean);
			
			List<CandidateCVResponseDTO> dtos=candidatecvDAO.getCvById(id);
			
			List<CandidateCVBean> cvforms=candidatecvMapper.mapToListBean(dtos);
			model.addAttribute("cvforms", cvforms);
			
			return "viewallcv";
		}
		return "redirect:error";
	}
	//logo click
	@RequestMapping(value="/companydetail/{id}",method=RequestMethod.GET)
	  public String displaydetail(@PathVariable int id,ModelMap model) {
	    
	      var dto=employerDAO.getEmployerById(id);
			var bean=employerMapper.responseToBean(dto);
			model.addAttribute("employer",bean);
			return "companydetail";
	      
	     }
	//company 1 khu  yae job twy
	
	@RequestMapping(value="/companyjobpost/{id}",method=RequestMethod.GET)
	public String companyjobpost( @PathVariable int id,ModelMap model) {
		List<Job_postResponseDTO> dtos=job_postDAO.getJobpostById(id);
		List<Job_postBean> posts=job_postMapper.responstToListBean(dtos);
		model.addAttribute("posts", posts);
		return "companyjobpost";
		
	}
	//under ka click yin paw mae page
	@RequestMapping(value="/jobpostdetail/{id}",method=RequestMethod.GET)
	public String jobpostdetail( @PathVariable int id,ModelMap model) {
		EmployerResponseDTO dto=employerDAO.getEmployerById(id);
		EmployerBean bean=employerMapper.responseToBean(dto);
		model.addAttribute("employer",bean);
		
		Job_postResponseDTO post=job_postDAO.getPostById(id);
		Job_postBean view=job_postMapper.responseToBean(post);
		model.addAttribute("post",view);
		
		return "jobpostdetail";
	}
	//discussing jobpost inactive
	@RequestMapping(value="/deniedjobpost",method=RequestMethod.GET)
	public String unactiveJobPost( @RequestParam("denied_post") int deniedid,ModelMap model,HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if(session != null && session.getAttribute("employerId") != null) {
			int id = (Integer) session.getAttribute("employerId");
			Job_postRequestDTO dto=new Job_postRequestDTO();
			dto.setId(deniedid);
			dto.setEmployer_id(id);
			int rs=job_postDAO.deniedJobpost(dto);
			 if(rs==0) {
		          model.addAttribute("error","Job Post Denied  Fail(SQL Error)");
		          return "reditect:/employer/deniedjobpost"; 
		      }
		}
		return "redirect:/employer/jobposthistory";
	}
	@RequestMapping(value="/jobposthistory",method=RequestMethod.GET)
	public String classifiedJobPost(ModelMap model,HttpServletRequest request) throws IOException {
		HttpSession session = request.getSession(false);
		if(session != null && session.getAttribute("employerId") != null) {
			int id = (Integer) session.getAttribute("employerId");
			var dto=employerDAO.getEmployerById(id);
			var bean=employerMapper.responseToBean(dto);
			model.addAttribute("employer",bean);
			
			List<Job_postResponseDTO> activedtos=job_postDAO.getActiveJobPosts(id);
			List<Job_postBean> activeposts=job_postMapper.responstToListBean(activedtos);
			model.addAttribute("activeposts", activeposts);
			
			List<Job_postResponseDTO> unactivedtos=job_postDAO.getUnActiveJobPosts(id);
			List<Job_postBean> unactiveposts=job_postMapper.responstToListBean(unactivedtos);
			model.addAttribute("unactiveposts", unactiveposts);

			return "classifiedjobpost";
		}
		return "redirect:/employer/jobposthistory";
	}
	
}
