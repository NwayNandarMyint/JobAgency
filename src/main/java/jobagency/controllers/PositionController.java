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
import jobagency.DAO.PositionDAO;
import jobagency.DAO.PositionMapper;
import jobagency.DTO.PositionRequestDTO;
import jobagency.DTO.PositionResponseDTO;
import jobagency.models.PositionBean;

@Controller
public class PositionController {

	@Autowired
	PositionDAO positionDAO;
	@Autowired
	PositionMapper positionMapper;
	
	@RequestMapping(value="/Position",method=RequestMethod.GET)
	public String displayPosition(ModelMap m,HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if(session != null && session.getAttribute("adminId") != null) {
			List<PositionResponseDTO>dtos=positionDAO.getAllPosition();	
			List<PositionBean>positions=positionMapper.mapToListBean(dtos);		
			m.addAttribute("positions", positions);
			m.addAttribute("position", new PositionBean());
			return "displayposition";
		}
		return "redirect:/admin/";
	}
	
	@RequestMapping(value="/addposition",method=RequestMethod.POST)
	public String addPosition(@ModelAttribute("position")@Validated PositionBean position,BindingResult bResult,ModelMap model) {
		if(bResult.hasErrors()) {
			List<PositionResponseDTO>dtos=positionDAO.getAllPosition();	
			List<PositionBean>positions=positionMapper.mapToListBean(dtos);		
			model.addAttribute("positions", positions);
			return "displayposition";
		}
		PositionRequestDTO dto=positionMapper.mapToRequestDTO(position);

		int rs=positionDAO.addPosition(dto);
		if(rs==0) {
			List<PositionResponseDTO>dtos=positionDAO.getAllPosition();	
			List<PositionBean>positions=positionMapper.mapToListBean(dtos);		
			model.addAttribute("positions", positions);
			model.addAttribute("error","Insert Fail(SQL Error)");
			return "displayposition";
		}
		return "redirect:/Position";
	}
	
	@RequestMapping(value="/editposition/{id}",method=RequestMethod.GET)
	public ModelAndView editPosition(@PathVariable int id) {
		PositionResponseDTO dto=positionDAO.getPositionById(id);
		PositionBean position=positionMapper.mapToBean(dto);
		return new ModelAndView("editposition","position",position);
	}
	
	@RequestMapping(value="/editposition",method=RequestMethod.POST)
	public String editPosition(@ModelAttribute("position") @Validated PositionBean position,BindingResult bResult,ModelMap model) {
		if(bResult.hasErrors()) {
			return "editposition";
		}		
		PositionRequestDTO dto=positionMapper.mapToRequestDTO(position);		
		int rs=positionDAO.editPosition(dto);
		if(rs==0) {
			model.addAttribute("error","Position Update Fail(SQL Error)");
			return "editposition"; 
		}
		return "redirect:/Position";
	}
	
	@RequestMapping(value="/deleteposition/{id}",method=RequestMethod.GET)
	public String deletePosition(@PathVariable int id,ModelMap model) {
						
		int result=PositionDAO.deletePosition(id);
		if(result==0) {
			model.addAttribute("error","Position Delete Fail(SQL Error)");
			return "displayposition"; 
		}
		
		return "redirect:/Position";		
	}
	
	@RequestMapping(value="/SimplePosition",method=RequestMethod.GET)
	public String displaySimplePosition(ModelMap m,HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if(session != null && session.getAttribute("simpleadminId") != null) {
			List<PositionResponseDTO>dtos=positionDAO.getAllPosition();	
			List<PositionBean>positions=positionMapper.mapToListBean(dtos);		
			m.addAttribute("positions", positions);
			m.addAttribute("position", new PositionBean());
			return "displaysimpleposition";
		}
		return "redirect:/admin/";
	}
	
	@RequestMapping(value="/addsimpleposition",method=RequestMethod.POST)
	public String addSimplePosition(@ModelAttribute("position")@Validated PositionBean position,BindingResult bResult,ModelMap model) {
		if(bResult.hasErrors()) {
			List<PositionResponseDTO>dtos=positionDAO.getAllPosition();	
			List<PositionBean>positions=positionMapper.mapToListBean(dtos);		
			model.addAttribute("positions", positions);
			return "displaysimpleposition";
		}
		PositionRequestDTO dto=positionMapper.mapToRequestDTO(position);

		int rs=positionDAO.addPosition(dto);
		if(rs==0) {
			List<PositionResponseDTO>dtos=positionDAO.getAllPosition();	
			List<PositionBean>positions=positionMapper.mapToListBean(dtos);		
			model.addAttribute("positions", positions);
			model.addAttribute("error","Insert Fail(SQL Error)");
			return "displaysimpleposition";
		}
		return "redirect:/SimplePosition";
	}
	
//	@RequestMapping(value="/editposition/{id}",method=RequestMethod.GET)
//	public ModelAndView editPosition(@PathVariable int id) {
//		PositionResponseDTO dto=positionDAO.getPositionById(id);
//		PositionBean position=positionMapper.mapToBean(dto);
//		return new ModelAndView("editposition","position",position);
//	}
//	
//	@RequestMapping(value="/editposition",method=RequestMethod.POST)
//	public String editPosition(@ModelAttribute("position") @Validated PositionBean position,BindingResult bResult,ModelMap model) {
//		if(bResult.hasErrors()) {
//			return "editposition";
//		}		
//		PositionRequestDTO dto=positionMapper.mapToRequestDTO(position);		
//		int rs=positionDAO.editPosition(dto);
//		if(rs==0) {
//			model.addAttribute("error","Position Update Fail(SQL Error)");
//			return "editposition"; 
//		}
//		return "redirect:/Position";
//	}
	
	@RequestMapping(value="/deletesimpleposition/{id}",method=RequestMethod.GET)
	public String deleteSimplePosition(@PathVariable int id,ModelMap model) {
						
		int result=PositionDAO.deletePosition(id);
		if(result==0) {
			model.addAttribute("error","Position Delete Fail(SQL Error)");
			return "displaysimpleposition"; 
		}
		
		return "redirect:/SimplePosition";		
	}
	
}
