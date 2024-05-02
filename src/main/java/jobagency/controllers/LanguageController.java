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

import jobagency.DAO.LanguageDAO;
import jobagency.DAO.LanguageMapper;
import jobagency.DTO.LanguageRequestDTO;
import jobagency.DTO.LanguageResponseDTO;
import jobagency.models.LanguageBean;

@Controller
public class LanguageController {

	@Autowired
	LanguageDAO languageDAO;
	@Autowired
	LanguageMapper languageMapper;
	
	@RequestMapping(value="/Language",method=RequestMethod.GET)
	public String displayLanguage(ModelMap m,HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if(session != null && session.getAttribute("adminId") != null) {
			List<LanguageResponseDTO>dtos=languageDAO.getLanguages();	
			List<LanguageBean>languages=languageMapper.mapToListBean(dtos);		
			m.addAttribute("languages", languages);
			m.addAttribute("lan", new LanguageBean());
			return "displaylanguage";
		}
		return "redirect:/admin/";
	}
	
	@RequestMapping(value="/addlanguage",method=RequestMethod.POST)
	public String addLanguage(@ModelAttribute("lan")@Validated LanguageBean lan,BindingResult bResult,ModelMap model) {
		if(bResult.hasErrors()) {

			List<LanguageResponseDTO>dtos=languageDAO.getLanguages();	
			List<LanguageBean>languages=languageMapper.mapToListBean(dtos);		
			model.addAttribute("languages", languages);
			return "displaylanguage";
		}
		LanguageRequestDTO dto=languageMapper.mapToRequestDTO(lan);

		int rs=languageDAO.addLanguage(dto);
		if(rs==0) {
			model.addAttribute("error","Insert Fail(SQL Error)");
			return "displaylanguage";
		}
		return "redirect:/Language";
	}
	
	
	@RequestMapping(value = "/deletelanguage/{id}", method = RequestMethod.GET)
	public String deleteLanguage(@PathVariable int id, ModelMap model) {

		int result = languageDAO.deleteLanguage(id);
		if (result == 0) {
			model.addAttribute("error", "Language Delete Fail(SQL Error)");
			return "displaylanguage";
		}

		return "redirect:/Language";
	}
	  
	@RequestMapping(value="/SimpleLanguage",method=RequestMethod.GET)
	public String displaySimpleLanguage(ModelMap m,HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if(session != null && session.getAttribute("simpleadminId") != null) {
			List<LanguageResponseDTO>dtos=languageDAO.getLanguages();	
			List<LanguageBean>languages=languageMapper.mapToListBean(dtos);		
			m.addAttribute("languages", languages);
			m.addAttribute("lan", new LanguageBean());
			return "displaysimplelanguage";
		}
		return "redirect:/admin/";
	}
	
	@RequestMapping(value="/addsimplelanguage",method=RequestMethod.POST)
	public String addSimpleLanguage(@ModelAttribute("lan")@Validated LanguageBean lan,BindingResult bResult,ModelMap model) {
		if(bResult.hasErrors()) {

			List<LanguageResponseDTO>dtos=languageDAO.getLanguages();	
			List<LanguageBean>languages=languageMapper.mapToListBean(dtos);		
			model.addAttribute("languages", languages);
			return "displaysimplelanguage";
		}
		LanguageRequestDTO dto=languageMapper.mapToRequestDTO(lan);

		int rs=languageDAO.addLanguage(dto);
		if(rs==0) {
			model.addAttribute("error","Insert Fail(SQL Error)");
			return "displaysimplelanguage";
		}
		return "redirect:/SimpleLanguage";
	}
	
	
	@RequestMapping(value = "/deletesimplelanguage/{id}", method = RequestMethod.GET)
	public String deleteSimpleLanguage(@PathVariable int id, ModelMap model) {

		int result = languageDAO.deleteLanguage(id);
		if (result == 0) {
			model.addAttribute("error", "Language Delete Fail(SQL Error)");
			return "displaysimplelanguage";
		}

		return "redirect:/SimpleLanguage";
	}
	
}
