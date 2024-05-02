package jobagency.controllers;



import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jobagency.DAO.AdminDAO;
import jobagency.DAO.CandidateDAO;
import jobagency.DAO.EmployerDAO;
import jobagency.DAO.EmployerMapper;
import jobagency.DAO.Job_postDAO;
import jobagency.DAO.Job_postMapper;
import jobagency.DTO.EmployerResponseDTO;
import jobagency.DTO.Job_postResponseDTO;
import jobagency.models.CandidateCVBean;
import jobagency.models.EmployerBean;
import jobagency.models.Job_postBean;
import jobagency.models.LanguageBean;

@Controller
public class HomeController {
  @Autowired
  CandidateDAO candidateDAO;
  @Autowired
  AdminDAO adminDAO;
  @Autowired
  EmployerDAO employerDAO;
  @Autowired
  EmployerMapper employerMapper;
  @Autowired
  Job_postDAO job_postDAO;
  @Autowired
  Job_postMapper job_postMapper;
  @RequestMapping(value="/",method=RequestMethod.GET)
  public String home( ModelMap model) throws IOException {  
    List<EmployerResponseDTO>dtos=employerDAO.getEmployers();  
    List<EmployerBean>employers=employerMapper.responstToListBean(dtos);
    model.addAttribute("employers", employers);
    
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
    
    return "home";
  }
  
  
    
}