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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import jobagency.DAO.EmployerDAO;
import jobagency.DAO.EmployerMapper;
import jobagency.DAO.Job_postDAO;
import jobagency.DAO.Job_postMapper;
import jobagency.DAO.LevelDAO;
import jobagency.DAO.LevelMapper;
import jobagency.DAO.PositionDAO;
import jobagency.DAO.PositionMapper;
import jobagency.DTO.EmployerRequestDTO;
import jobagency.DTO.EmployerResponseDTO;
import jobagency.DTO.Job_postRequestDTO;
import jobagency.DTO.Job_postResponseDTO;
import jobagency.DTO.LevelResponseDTO;
import jobagency.DTO.PositionResponseDTO;
import jobagency.models.EmployerBean;
import jobagency.models.Job_postBean;
import jobagency.models.LevelBean;
import jobagency.models.PositionBean;


@Controller
@RequestMapping("/jobpost")
public class Job_postController {
	@Autowired
	Job_postDAO job_postDAO;
	@Autowired
	Job_postMapper job_postMapper;
	@Autowired
	LevelDAO levelDAO;
	@Autowired
	LevelMapper levelMapper;
	@Autowired
	PositionDAO positionDAO;
	@Autowired
	PositionMapper positionMapper;
	@Autowired
	EmployerDAO employerDAO;
	@Autowired
	EmployerMapper employerMapper;
	@RequestMapping(value="/post",method=RequestMethod.GET)
	public Object addPost(ModelMap model,HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if(session != null && session.getAttribute("employerId") != null) {
			 int id = (Integer) session.getAttribute("employerId");
			 	List<LevelResponseDTO> dtos=levelDAO.getAllLevel();
				List<LevelBean> levels=levelMapper.mapToListBean(dtos);	
				model.addAttribute("levels",levels);
				
				List<PositionResponseDTO> pos=positionDAO.getAllPosition();
				List<PositionBean> positions=positionMapper.mapToListBean(pos);	
				model.addAttribute("positions",positions);
				
				EmployerResponseDTO emp=employerDAO.getEmployerById(id);
				EmployerBean employer=employerMapper.responseToBean(emp);	
				model.addAttribute("employer",employer);
				return new ModelAndView("jobpostpage","jobpost", new Job_postBean());
		}
		return "redirect:/employer/";
	}
	@RequestMapping(value="/addjobpost", method=RequestMethod.POST)
	public String addPost(@ModelAttribute("jobpost")@Validated Job_postBean jobpost,BindingResult bResult,ModelMap model,HttpServletRequest request) {
		if(bResult.hasErrors()||jobpost.getLevel_id()==0 ||jobpost.getPosition_id()==0 ) {
			HttpSession session = request.getSession(false);
			if(session != null && session.getAttribute("employerId") != null) {
				 int id = (Integer) session.getAttribute("employerId");
			
			List<LevelResponseDTO> dtos=levelDAO.getAllLevel();
			List<LevelBean> levels=levelMapper.mapToListBean(dtos);	
			model.addAttribute("levels",levels);
			
			List<PositionResponseDTO> pos=positionDAO.getAllPosition();
			List<PositionBean> positions=positionMapper.mapToListBean(pos);	
			model.addAttribute("positions",positions);
			
			EmployerResponseDTO emp=employerDAO.getEmployerById(id);
			EmployerBean employer=employerMapper.responseToBean(emp);	
			model.addAttribute("employer",employer);
			
			if(jobpost.getLevel_id()==0) {
				model.addAttribute("level_error","Please select level");
			}
			if(jobpost.getPosition_id()==0) {
				model.addAttribute("position_error","Please select position");
			}
			return "jobpostpage";
			}
		}
		HttpSession session = request.getSession(false);
	    if(session != null && session.getAttribute("employerId") != null) {
	       int id = (Integer) session.getAttribute("employerId");
	       List<LevelResponseDTO> dtos=levelDAO.getAllLevel();
			List<LevelBean> levels=levelMapper.mapToListBean(dtos);	
			model.addAttribute("levels",levels);
			
			List<PositionResponseDTO> pos=positionDAO.getAllPosition();
			List<PositionBean> positions=positionMapper.mapToListBean(pos);	
			model.addAttribute("positions",positions);
			
			EmployerResponseDTO emp=employerDAO.getEmployerById(id);
			EmployerBean employer=employerMapper.responseToBean(emp);	
			model.addAttribute("employer",employer);
	       
	        var dto2=employerDAO.getEmployerById(id);
	        var bean=employerMapper.responseToBean(dto2);
	        if(bean.getAvaliable_jobpost() == 0) {
	           var dto=employerDAO.getEmployerById(id);
	           var beans=employerMapper.responseToBean(dto);
	           	model.addAttribute("employer",beans);
	             model.addAttribute("error","Not Available Upload Your Post.You Need To Go Ticket Page And Buy Ticket!");
	          return "jobpostpage";
	        }else {
	           jobpost.setEmployer_id(id);
	            Job_postRequestDTO dto=job_postMapper.beanToRequest(jobpost);
	            
	            EmployerResponseDTO emp2=employerDAO.getEmployerById(id);
	            EmployerBean employer2=employerMapper.responseToBean(emp2);
	            int updatejobpost=employer2.getAvaliable_jobpost();
	            EmployerRequestDTO employerdto=new EmployerRequestDTO();
	            employerdto.setAvaliable_jobpost(updatejobpost-1);
	            employerdto.setId(id);
	            int updateavailablepost=employerDAO.updateAvailabeJobPost(employerdto);
	            if(updateavailablepost==0) {
		              model.addAttribute("error","update availabel ticket update Fail(SQL Error)");
		              return "error";
		            }
	            int rs=job_postDAO.addJobpost(dto);      
	            if(rs==0) {
	              model.addAttribute("error2","You Need Some Column To Add");
	              return "jobpostpage";
	            }
	            model.addAttribute("result",rs);
	            return "jobpostpage";
	        }
	    }
	    return "redirect:/employer/";
	}
	
	@RequestMapping(value="/alljobpost",method=RequestMethod.GET)
	public String displayAllJobpost( ModelMap model,HttpServletRequest request) throws IOException {	
		HttpSession session = request.getSession(false);
		if(session != null && session.getAttribute("adminId") != null) {
			List<Job_postResponseDTO> dtos=job_postDAO.getJobposts();
			List<Job_postBean> jobposts=job_postMapper.responstToListBean(dtos);		
			model.addAttribute("jobposts", jobposts);
			return "allJobpost";
		}
		return "redirect:/admin/";
	}
	
	@RequestMapping(value="/simplealljobpost",method=RequestMethod.GET)
	public String displaySimpleAllJobpost( ModelMap model,HttpServletRequest request) throws IOException {	
		HttpSession session = request.getSession(false);
		if(session != null && session.getAttribute("simpleadminId") != null) {
			List<Job_postResponseDTO> dtos=job_postDAO.getJobposts();
			List<Job_postBean> jobposts=job_postMapper.responstToListBean(dtos);		
			model.addAttribute("jobposts", jobposts);
			return "SimpleallJobpost";
		}
		return "redirect:/admin/";
		
	}
	
	
	@RequestMapping(value="/viewall",method=RequestMethod.GET)
	public String viewAllJobpost( ModelMap model) throws IOException {	
		List<Job_postResponseDTO> dtos=job_postDAO.getJobposts();
		List<Job_postBean> jobposts=job_postMapper.responstToListBean(dtos);		
		model.addAttribute("jobposts", jobposts);
		return "viewallJob";
		
	}
	
	@RequestMapping(value="/homeviewall",method=RequestMethod.GET)
	public String homeViewAllJobpost( ModelMap model) throws IOException {	
		List<Job_postResponseDTO> dtos=job_postDAO.getJobposts();
		List<Job_postBean> jobposts=job_postMapper.responstToListBean(dtos);		
		model.addAttribute("jobposts", jobposts);
		return "homeviewalljob";
		
	}
	
	@RequestMapping(value="/jobpostall",method=RequestMethod.GET)
	public String jobPosts( ModelMap model,@RequestParam("data") String data) throws IOException {	
		List<Job_postResponseDTO> dtos=job_postDAO.getJobpost(data);
		List<Job_postBean> jobposts=job_postMapper.responstToListBean(dtos);		
		model.addAttribute("jobposts", jobposts);
		return "searchjobpost";
		
	}
	
	
	@RequestMapping(value="/secrchjobpost",method=RequestMethod.GET)
	public String secrchJobPosts( ModelMap model,@RequestParam("data") String data) throws IOException {	
		List<Job_postResponseDTO> dtos=job_postDAO.getJobpost(data);
		List<Job_postBean> jobposts=job_postMapper.responstToListBean(dtos);		
		model.addAttribute("jobposts", jobposts);
		return "searchjobpostfromuserhome";
		
	}
}
