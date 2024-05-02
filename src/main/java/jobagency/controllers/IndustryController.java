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
import org.springframework.web.servlet.ModelAndView;
import jobagency.DAO.IndustryDAO;
import jobagency.DAO.IndustryMapper;
import jobagency.DTO.IndustryRequestDTO;
import jobagency.DTO.IndustryResponseDTO;
import jobagency.models.IndustryBean;

@Controller
public class IndustryController {

	@Autowired
	IndustryDAO industryDAO;
	@Autowired
	IndustryMapper industryMapper;

//	@RequestMapping(value="/Industry",method=RequestMethod.GET)
//	public String displayIndustry(ModelMap m) {
//		List<IndustryResponseDTO>dtos=industryDAO.getAllIndustry();	
//		List<IndustryBean>industrys=industryMapper.mapToListBean(dtos);		
//		m.addAttribute("industrys", industrys);
//		m.addAttribute("industry", new IndustryBean());
//
//		return "displayindustry";
//	}

//	@RequestMapping(value = "/addindustry", method = RequestMethod.GET)
//	public ModelAndView addIndustry() {
//		return new ModelAndView("displayindustry", "industry", new IndustryBean());
//	}

	@RequestMapping(value = "/Industry", method = RequestMethod.GET)
	public String displayIndustry(ModelMap m,HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if(session != null && session.getAttribute("adminId") != null) {
			List<IndustryResponseDTO> dtos = industryDAO.getAllIndustry();
			List<IndustryBean> industrys = industryMapper.mapToListBean(dtos);
			m.addAttribute("industrys", industrys);
			m.addAttribute("industry", new IndustryBean());
			return "displayindustry";
		}
		return "redirect:/admin/";
	}

	@RequestMapping(value = "/addindustry", method = RequestMethod.POST)
	public String addIndustry(@ModelAttribute("industry") @Validated IndustryBean industry, BindingResult bResult,
			ModelMap model) {
		if (bResult.hasErrors()) {
			List<IndustryResponseDTO> dtos = industryDAO.getAllIndustry();
			List<IndustryBean> industrys = industryMapper.mapToListBean(dtos);
			model.addAttribute("industrys", industrys);
			return "displayindustry";
		}
		IndustryRequestDTO dto = industryMapper.mapToRequestDTO(industry);

		int rs = industryDAO.addIndustry(dto);
		if (rs == 0) {
			List<IndustryResponseDTO> dtos = industryDAO.getAllIndustry();
			List<IndustryBean> industrys = industryMapper.mapToListBean(dtos);
			model.addAttribute("industrys", industrys);
			model.addAttribute("error", "Insert Fail(SQL Error)");
			return "displayindustry";
		}
		return "redirect:/Industry";
	}

	@RequestMapping(value = "/editindustry/{id}", method = RequestMethod.GET)
	public ModelAndView editIndustry(@PathVariable int id) {
		IndustryResponseDTO dto = industryDAO.getIndustryById(id);
		IndustryBean industry = industryMapper.mapToBean(dto);
		return new ModelAndView("editindustry", "industry", industry);
	}

	@RequestMapping(value = "/editindustry", method = RequestMethod.POST)
	public String editIndustry(@ModelAttribute("industry") @Validated IndustryBean industry, BindingResult bResult,
			ModelMap model) {
		if (bResult.hasErrors()) {
			return "editindustry";
		}
		IndustryRequestDTO dto = industryMapper.mapToRequestDTO(industry);
		int rs = industryDAO.editIndustry(dto);
		if (rs == 0) {
			model.addAttribute("error", "Industry Update Fail(SQL Error)");
			return "editindustry";
		}
		return "redirect:/Industry";
	}

	@RequestMapping(value = "/deleteindustry/{id}", method = RequestMethod.GET)
	public String deleteIndustry(@PathVariable int id, ModelMap model) {

		int result = IndustryDAO.deleteIndustry(id);
		if (result == 0) {
			model.addAttribute("error", "Industry Delete Fail(SQL Error)");
			return "displayindustry";
		}

		return "redirect:/Industry";
	}
	
	@RequestMapping(value = "/SimpleIndustry", method = RequestMethod.GET)
	public String displaySimpleIndustry(ModelMap m,HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if(session != null && session.getAttribute("simpleadminId") != null) {
			List<IndustryResponseDTO> dtos = industryDAO.getAllIndustry();
			List<IndustryBean> industrys = industryMapper.mapToListBean(dtos);
			m.addAttribute("industrys", industrys);
			m.addAttribute("industry", new IndustryBean());
			return "displaysimpleindustry";
		}
		return "redirect:/admin/";
	}

	@RequestMapping(value = "/addsimpleindustry", method = RequestMethod.POST)
	public String addSimpleIndustry(@ModelAttribute("industry") @Validated IndustryBean industry, BindingResult bResult,
			ModelMap model) {
		if (bResult.hasErrors()) {
			List<IndustryResponseDTO> dtos = industryDAO.getAllIndustry();
			List<IndustryBean> industrys = industryMapper.mapToListBean(dtos);
			model.addAttribute("industrys", industrys);
			return "displaysimpleindustry";
		}
		IndustryRequestDTO dto = industryMapper.mapToRequestDTO(industry);

		int rs = industryDAO.addIndustry(dto);
		if (rs == 0) {
			List<IndustryResponseDTO> dtos = industryDAO.getAllIndustry();
			List<IndustryBean> industrys = industryMapper.mapToListBean(dtos);
			model.addAttribute("industrys", industrys);
			model.addAttribute("error", "Insert Fail(SQL Error)");
			return "displaysimpleindustry";
		}
		return "redirect:/SimpleIndustry";
	}

	@RequestMapping(value = "/editsimpleindustry/{id}", method = RequestMethod.GET)
	public ModelAndView editSimpleIndustry(@PathVariable int id) {
		IndustryResponseDTO dto = industryDAO.getIndustryById(id);
		IndustryBean industry = industryMapper.mapToBean(dto);
		return new ModelAndView("editsimpleindustry", "industry", industry);
	}

	@RequestMapping(value = "/editsimpleindustry", method = RequestMethod.POST)
	public String editSimpleIndustry(@ModelAttribute("industry") @Validated IndustryBean industry, BindingResult bResult,
			ModelMap model) {
		if (bResult.hasErrors()) {
			return "editsimpleindustry";
		}
		IndustryRequestDTO dto = industryMapper.mapToRequestDTO(industry);
		int rs = industryDAO.editIndustry(dto);
		if (rs == 0) {
			model.addAttribute("error", "Industry Update Fail(SQL Error)");
			return "editsimpleindustry";
		}
		return "redirect:/SimpleIndustry";
	}

	@RequestMapping(value = "/deletesimpleindustry/{id}", method = RequestMethod.GET)
	public String deleteSimpleIndustry(@PathVariable int id, ModelMap model) {

		int result = IndustryDAO.deleteIndustry(id);
		if (result == 0) {
			model.addAttribute("error", "Industry Delete Fail(SQL Error)");
			return "displaysimpleindustry";
		}

		return "redirect:/SimpleIndustry";
	}

}
