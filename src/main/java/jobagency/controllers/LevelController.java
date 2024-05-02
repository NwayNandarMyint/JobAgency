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
import jobagency.DAO.LevelDAO;
import jobagency.DAO.LevelMapper;
import jobagency.DTO.LevelRequestDTO;
import jobagency.DTO.LevelResponseDTO;
import jobagency.models.LevelBean;

@Controller
public class LevelController {

	@Autowired
	LevelDAO levelDAO;
	@Autowired
	LevelMapper levelMapper;
	
	@RequestMapping(value="/Level",method=RequestMethod.GET)
	public String displayLevel(ModelMap m,HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if(session != null && session.getAttribute("adminId") != null) {
			List<LevelResponseDTO>dtos=levelDAO.getAllLevel();	
			List<LevelBean>levels=levelMapper.mapToListBean(dtos);		
			m.addAttribute("levels", levels);
			m.addAttribute("level", new LevelBean());
			return "displaylevel";
		}
		return "redirect:/admin/";
	}
	
	@RequestMapping(value="/addlevel",method=RequestMethod.POST)
	public String addLevel(@ModelAttribute("level")@Validated LevelBean level,BindingResult bResult,ModelMap model) {
		if(bResult.hasErrors()) {
			List<LevelResponseDTO>dtos=levelDAO.getAllLevel();	
			List<LevelBean>levels=levelMapper.mapToListBean(dtos);		
			model.addAttribute("levels", levels);
			return "displaylevel";
		}
		LevelRequestDTO dto=levelMapper.mapToRequestDTO(level);

		int rs=levelDAO.addLevel(dto);
		if(rs==0) {
			model.addAttribute("error","Insert Fail(SQL Error)");
			return "displaylevel";
		}
		return "redirect:/Level";
	}
	
	@RequestMapping(value="/editlevel/{id}",method=RequestMethod.GET)
	public ModelAndView editLevel(@PathVariable int id) {
		LevelResponseDTO dto=levelDAO.getLevelById(id);
		LevelBean level=levelMapper.mapToBean(dto);
		return new ModelAndView("editlevel","level",level);
	}
	
	@RequestMapping(value="/editlevel",method=RequestMethod.POST)
	public String editLevel(@ModelAttribute("level") @Validated LevelBean level,BindingResult bResult,ModelMap model) {
		if(bResult.hasErrors()) {
			return "editlevel";
		}		
		LevelRequestDTO dto=levelMapper.mapToRequestDTO(level);		
		int rs=levelDAO.editLevel(dto);
		if(rs==0) {
			model.addAttribute("error","Level Update Fail(SQL Error)");
			return "editlevel"; 
		}
		return "redirect:/Level";
	}
	
	@RequestMapping(value="/deletelevel/{id}",method=RequestMethod.GET)
	public String deleteLevel(@PathVariable int id,ModelMap model) {
						
		int result=LevelDAO.deleteLevel(id);
		if(result==0) {
			model.addAttribute("error","Level Delete Fail(SQL Error)");
			return "displaylevel"; 
		}
		
		return "redirect:/Level";		
	}
	
	@RequestMapping(value="/SimpleLevel",method=RequestMethod.GET)
	public String displaySimpleLevel(ModelMap m,HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if(session != null && session.getAttribute("simpleadminId") != null) {
			List<LevelResponseDTO>dtos=levelDAO.getAllLevel();	
			List<LevelBean>levels=levelMapper.mapToListBean(dtos);		
			m.addAttribute("levels", levels);
			m.addAttribute("level", new LevelBean());
			return "displaysimplelevel";
		}
		return "redirect:/admin/";
	}
	
	@RequestMapping(value="/addsimplelevel",method=RequestMethod.POST)
	public String addSimpleLevel(@ModelAttribute("level")@Validated LevelBean level,BindingResult bResult,ModelMap model) {
		if(bResult.hasErrors()) {
			List<LevelResponseDTO>dtos=levelDAO.getAllLevel();	
			List<LevelBean>levels=levelMapper.mapToListBean(dtos);		
			model.addAttribute("levels", levels);
			return "displaysimplelevel";
		}
		LevelRequestDTO dto=levelMapper.mapToRequestDTO(level);

		int rs=levelDAO.addLevel(dto);
		if(rs==0) {
			model.addAttribute("error","Insert Fail(SQL Error)");
			return "displaylevel";
		}
		return "redirect:/SimpleLevel";
	}
	
	@RequestMapping(value="/editsimplelevel/{id}",method=RequestMethod.GET)
	public ModelAndView editSimpleLevel(@PathVariable int id) {
		LevelResponseDTO dto=levelDAO.getLevelById(id);
		LevelBean level=levelMapper.mapToBean(dto);
		return new ModelAndView("editsimplelevel","level",level);
	}
	
	@RequestMapping(value="/editsimplelevel",method=RequestMethod.POST)
	public String editSimpleLevel(@ModelAttribute("level") @Validated LevelBean level,BindingResult bResult,ModelMap model) {
		if(bResult.hasErrors()) {
			return "editsimplelevel";
		}		
		LevelRequestDTO dto=levelMapper.mapToRequestDTO(level);		
		int rs=levelDAO.editLevel(dto);
		if(rs==0) {
			model.addAttribute("error","Level Update Fail(SQL Error)");
			return "editsimplelevel"; 
		}
		return "redirect:/SimpleLevel";
	}
	
	@RequestMapping(value="/deletesimplelevel/{id}",method=RequestMethod.GET)
	public String deleteSimpleLevel(@PathVariable int id,ModelMap model) {
						
		int result=LevelDAO.deleteLevel(id);
		if(result==0) {
			model.addAttribute("error","Level Delete Fail(SQL Error)");
			return "displaysimplelevel"; 
		}
		
		return "redirect:/SimpleLevel";		
	}
	
}
