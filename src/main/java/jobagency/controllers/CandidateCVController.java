package jobagency.controllers;
import java.util.*;
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
import jobagency.DAO.CandidateCVDAO;
import jobagency.DAO.CandidateCVMapper;
import jobagency.DAO.CandidateDAO;
import jobagency.DAO.CandidateMapper;
import jobagency.DAO.Job_postDAO;
import jobagency.DAO.Job_postMapper;
import jobagency.DAO.LanguageDAO;
import jobagency.DAO.LanguageMapper;
import jobagency.DTO.CandidateCVRequestDTO;
import jobagency.DTO.CandidateCVResponseDTO;
import jobagency.DTO.Job_postResponseDTO;
import jobagency.models.CandidateCVBean;
import jobagency.models.Job_postBean;
import jobagency.models.LanguageBean;

@Controller
@RequestMapping("/candidatecv")
public class CandidateCVController {
  @Autowired
  CandidateCVDAO candidatecvDAO;
  @Autowired
  CandidateCVMapper candidatecvMapper;
  @Autowired
  LanguageDAO languageDAO;
  @Autowired
  LanguageMapper languageMapper;
  @Autowired
  CandidateDAO candidateDAO;
  @Autowired
  CandidateMapper candidateMapper;
  @Autowired
  Job_postDAO job_postDAO;
  @Autowired
  Job_postMapper job_postMapper;
  
  @RequestMapping(value="/{id}",method=RequestMethod.GET)
  public Object addCandidateCV(@PathVariable int id,ModelMap model,HttpServletRequest request) {
    HttpSession session = request.getSession(false);
    if(session != null && session.getAttribute("candidateId") != null) {
      
//    	int jobpostid=id;
//    	model.addAttribute("jobpostid",jobpostid);
      
      Job_postResponseDTO post=job_postDAO.getJobById(id);
      Job_postBean view=job_postMapper.responseToBean(post);    
      model.addAttribute("post",view);
		
      List<LanguageBean> languages=languageMapper.mapToListBean(languageDAO.getLanguages());  
      model.addAttribute("languagesOptionList",languages);
      return new ModelAndView("addcandidatecv","candidatecv",new CandidateCVBean());
       
     }
    return "redirect:/candidateLogin/";
  }
  @RequestMapping(value="/addcandidatecv",method=RequestMethod.POST)
  public String addCandidateCV(@ModelAttribute("candidatecv")@Validated CandidateCVBean candidatecv,BindingResult bResult,ModelMap model,HttpServletRequest request) {
    
    if(bResult.hasErrors()) {
      List<LanguageBean> languages=languageMapper.mapToListBean(languageDAO.getLanguages());  
      model.addAttribute("languagesOptionList",languages);
      return "addcandidatecv";
    }
    HttpSession session = request.getSession(false);
    if(session != null && session.getAttribute("candidateId") != null) {
       int candidateId = (Integer) session.getAttribute("candidateId");
       
       int a=candidatecv.getJob_post_id();
       CandidateCVResponseDTO employerid =candidatecvDAO.getEmployerIdFromJobPostTable(a);
       CandidateCVRequestDTO dto=candidatecvMapper.mapToRequestDTO(candidatecv);
       dto.setEmployer_id( employerid.getEmployer_id());
       dto.setCandidate_id(candidateId);
       int rs=candidatecvDAO.addCandidateCV(dto);
       
        if(rs==0) {
          model.addAttribute("error","Insert Fail(SQL Error)");
          System.out.println("hi error"+ rs);
          List<LanguageBean> languages=languageMapper.mapToListBean(languageDAO.getLanguages());  
          model.addAttribute("languagesOptionList",languages);
          return "addcandidatecv";
        }  
        model.addAttribute("result",rs);
        
        return "addcandidatecv";
    }
    return "redirect:/jobpost/viewall";
    
  }
}