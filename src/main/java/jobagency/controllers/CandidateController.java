package jobagency.controllers;

import java.io.IOException;
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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jobagency.DAO.CandidateDAO;
import jobagency.DAO.CandidateLoginDAO;
import jobagency.DAO.CandidateMapper;
import jobagency.DAO.EmployerDAO;
import jobagency.DAO.EmployerMapper;
import jobagency.DAO.Job_postDAO;
import jobagency.DAO.Job_postMapper;
import jobagency.DTO.CandidateRequestDTO;
import jobagency.DTO.CandidateResponseDTO;
import jobagency.DTO.EmployerResponseDTO;
import jobagency.DTO.Job_postResponseDTO;
import jobagency.models.CandidateBean;
import jobagency.models.CandidateLoginModel;
import jobagency.models.EmployerBean;
import jobagency.models.Job_postBean;


@Controller
@RequestMapping("/candidate")
public class CandidateController {
	@Autowired
	CandidateDAO candidateDAO;
	@Autowired
	CandidateMapper candidateMapper;
	@Autowired
	CandidateLoginDAO candidateloginDAO;
	@Autowired
	Job_postDAO job_postDAO;
    @Autowired
    Job_postMapper job_postMapper;
    @Autowired
    EmployerDAO employerDAO;
    @Autowired
    EmployerMapper employerMapper;
   
	@RequestMapping(value="/",method=RequestMethod.GET)
	  public Object candidateLoginChecking(HttpServletRequest request, ModelMap model,@ModelAttribute("loginerror") String data,@ModelAttribute("emailerror") String emaildata,@ModelAttribute("passworderror") String passworddata) {
		HttpSession session = request.getSession();
		if(session.getAttribute("candidateId") == null) {
			model.addAttribute("receivedloginerror", data);
			model.addAttribute("receivedemailerror", emaildata);
			model.addAttribute("receivedpassworderror", passworddata);
			return new ModelAndView("candidateLogin","login",new CandidateLoginModel());
	        
		}
		
			return "redirect:/candidate/userHome";
		
		
	}
	
	@RequestMapping(value="/login" ,method=RequestMethod.POST)
	  public String employerLoginChecking(@ModelAttribute("login")@Validated CandidateLoginModel candidatelogin,ModelMap model, HttpServletRequest request,RedirectAttributes redirectAttributes) {
		if(candidatelogin.getEmail().length() == 0 && candidatelogin.getPassword().length() == 0) {
			redirectAttributes.addFlashAttribute("emailerror", "Please Enter Your E-Mail !");
			redirectAttributes.addFlashAttribute("passworderror", "Please Enter Your Password !");
			return "redirect:/candidate/";
		}
	    boolean loginResult=candidateloginDAO.checkingCandidateLogin(candidatelogin.getEmail(),candidatelogin.getPassword());
	    
	      if(loginResult == true) {
	         int candidateId=candidateloginDAO.getCandidateId(candidatelogin.getEmail(),candidatelogin.getPassword());
	         HttpSession session=request.getSession();
	         System.out.println(candidateId);
	         session.setAttribute("candidateId", candidateId);
	         return "redirect:/candidate/userHome";
	      }else if(loginResult != true){
		    	redirectAttributes.addFlashAttribute("loginerror", "Your E-Mail (OR) Password is Incorrect !");
		    	return "redirect:/candidate/";
			}
	       
	     return "redirect:/candidate/";
	}
	  
	@RequestMapping(value = "/addcandidate", method = RequestMethod.GET)
	public ModelAndView addCandidate() {
		return new ModelAndView("addcandidate", "checkcandidate", new CandidateBean());
	}
	
	@RequestMapping(value="/addcandidate",method=RequestMethod.POST)
	public String addCandidate(@ModelAttribute("checkcandidate")@Validated CandidateBean candidate,BindingResult bResult,ModelMap model) {
		if(bResult.hasErrors()) {
			return "addcandidate";
		}
		CandidateRequestDTO dto=candidateMapper.mapToRequestDTO(candidate);
		int rs=candidateDAO.addCandidate(dto);
		
		if(rs==0) {
			model.addAttribute("error","Insert Fail(SQL Error)");
			return "addcandidate";
		}
		model.addAttribute("result",rs);
		return "addcandidate";
	}
	
	@RequestMapping(value="/userHome",method=RequestMethod.GET)
	  public String userHome( ModelMap model, HttpServletRequest request) throws IOException {  
	    HttpSession session = request.getSession(false);
//	    session.invalidate();
	    if(session != null && session.getAttribute("candidateId") != null) {
	       int candidateId = (Integer) session.getAttribute("candidateId");
	       CandidateResponseDTO candidate=candidateDAO.getCandidateById(candidateId);
	       model.addAttribute("candidate", candidate);
	       
	       List<EmployerResponseDTO>dtos=employerDAO.getEmployers();  
	       List<EmployerBean>employers=employerMapper.responstToListBean(dtos);
	       model.addAttribute("employers", employers);
	       List<Job_postResponseDTO> total=job_postDAO.getJobposts();
	        
	       var dto1=employerDAO.getEmployerById(1);
	       var bean1=employerMapper.responseToBean(dto1);
	       model.addAttribute("employer1",bean1);
	       List<Job_postResponseDTO> finaljobpostdto1=job_postDAO.getJobpostById(1);
	       System.out.println("aya length"+finaljobpostdto1 );
	       List<Job_postBean> jobpost=job_postMapper.responstToListBean(finaljobpostdto1);    
	       model.addAttribute("jobpost", jobpost);
	       
	       var dto2=employerDAO.getEmployerById(2);
	       var bean2=employerMapper.responseToBean(dto2);
	       model.addAttribute("employer2",bean2);
	       List<Job_postResponseDTO> finaljobpostdto2=job_postDAO.getJobpostById(2);
	       List<Job_postBean> jobpost2=job_postMapper.responstToListBean(finaljobpostdto2);    
	       model.addAttribute("jobpost2", jobpost2);
	       
	       var dto3=employerDAO.getEmployerById(3);
	       var bean3=employerMapper.responseToBean(dto3);
	       model.addAttribute("employer3",bean3);
	       List<Job_postResponseDTO> finaljobpostdto3=job_postDAO.getJobpostById(3);
	       List<Job_postBean> jobpost3=job_postMapper.responstToListBean(finaljobpostdto3);
	       model.addAttribute("jobpost3", jobpost3);
	       
	       var dto4=employerDAO.getEmployerById(4);
	       var bean4=employerMapper.responseToBean(dto4);
	       model.addAttribute("employer4",bean4);
	       List<Job_postResponseDTO> finaljobpostdto4=job_postDAO.getJobpostById(4);
	       List<Job_postBean> jobpost4=job_postMapper.responstToListBean(finaljobpostdto4);    
	       model.addAttribute("jobpost4", jobpost4);
	       
	       var dto5=employerDAO.getEmployerById(5);
	       var bean5=employerMapper.responseToBean(dto5);
	       model.addAttribute("employer5",bean5);
	       List<Job_postResponseDTO> finaljobpostdto5=job_postDAO.getJobpostById(5);
	       List<Job_postBean> jobpost5=job_postMapper.responstToListBean(finaljobpostdto5);    
	       model.addAttribute("jobpost5", jobpost5);
	       
	       var dto6=employerDAO.getEmployerById(6);
	       var bean6=employerMapper.responseToBean(dto6);
	       model.addAttribute("employer6",bean6);
	       List<Job_postResponseDTO> finaljobpostdto6=job_postDAO.getJobpostById(6);
	       List<Job_postBean> jobpost6=job_postMapper.responstToListBean(finaljobpostdto6);    
	       model.addAttribute("jobpost6", jobpost6);

	      return "userHome";
	    }
	    return "redirect:/candidate/";
	    
	}
	  
	@RequestMapping(value="/displayCandidate",method=RequestMethod.GET)
	public String displayCandate( ModelMap m,HttpServletRequest request) {
		 HttpSession session = request.getSession(false);
		 if(session != null && session.getAttribute("candidateId") != null) {
			 int candidateId=(Integer) session.getAttribute("candidateId");
			 CandidateResponseDTO candidate=candidateDAO.getCandidateById(candidateId);
			 m.addAttribute("candidate", candidate);
			 return "displayCandidate"; 
		 }
		return "redirect:/candidate/";
	}	
	  @RequestMapping(value="/logout",method=RequestMethod.GET)
	  public String LogOut( ModelMap model, HttpServletRequest request) {  
	    HttpSession session = request.getSession(false);
	        if (session != null) {
	            session.invalidate();
	        }
	        return "redirect:/";
	  }
	  
	  @RequestMapping(value="/editCandidate",method=RequestMethod.GET)
		public Object updateCandidate(ModelMap model,HttpServletRequest request) {	
			HttpSession session = request.getSession(false);
			if(session != null && session.getAttribute("candidateId") != null) {
				 int id = (Integer) session.getAttribute("candidateId");
					var dto=candidateDAO.getCandidateById(id);
					var bean=candidateMapper.mapToBean(dto);
					model.addAttribute("candidate",bean);
				return new ModelAndView("editCandidate","updatecandidate", new CandidateBean());
			}
			return "redirect:/candidate/";
		}
		
		@RequestMapping(value="/editCandidate",method=RequestMethod.POST)
		public String updateCandidate(@ModelAttribute("updatecandidate") @Validated CandidateBean candidate,BindingResult bResult,ModelMap model,HttpServletRequest request) {
			HttpSession session = request.getSession(false);
			if(session != null && session.getAttribute("candidateId") != null) {
				 int id = (Integer) session.getAttribute("candidateId");
				 CandidateRequestDTO dto=candidateMapper.mapToRequestDTO(candidate)	;
					dto.setUpdated_date(candidate.getUpdated_date());		
					dto.setId(id);
					int rs=candidateDAO.updateCandidate(dto);
					if(rs==0) {
						model.addAttribute("error","Update Fail(SQL Error)");
						return "editCandidate"; 
					}
					model.addAttribute("result",rs);
					return "editCandidate";
			}
			return "redirect:/candidate/editCandidate";
		}
	
		//logo click
		@RequestMapping(value="/detail/{id}",method=RequestMethod.GET)
		  public String displaydetail(@PathVariable int id,ModelMap model) {
		    
		      var dto=employerDAO.getEmployerById(id);
				var bean=employerMapper.responseToBean(dto);
				model.addAttribute("employer",bean);
				return "detail";
		      
		     }
		
		//company 1 khu  yae job twy
		
		@RequestMapping(value="/jobpost/{id}",method=RequestMethod.GET)
		public String companyjobpost( @PathVariable int id,ModelMap model) {
			List<Job_postResponseDTO> dtos=job_postDAO.getJobpostById(id);
			List<Job_postBean> posts=job_postMapper.responstToListBean(dtos);
			model.addAttribute("posts", posts);
			return "jobpost";
			
		}
		
		//under ka click yin paw mae page
		@RequestMapping(value="/postdetail/{id}",method=RequestMethod.GET)
		public String jobpostdetail( @PathVariable int id,ModelMap model) {
			EmployerResponseDTO dto=employerDAO.getEmployerById(id);
			EmployerBean bean=employerMapper.responseToBean(dto);
			model.addAttribute("employer",bean);
			
			Job_postResponseDTO post=job_postDAO.getPostById(id);
			Job_postBean view=job_postMapper.responseToBean(post);
			model.addAttribute("post",view);
			
			return "postdetail";
			
		}
	  

	
}
