package kr.ac.hansung.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.hansung.model.Facility;
import kr.ac.hansung.service.FacilityService;

@Controller
public class FacilityController {
	
	@Autowired
	private FacilityService facilityService;
	
	@RequestMapping("/facilities")
	public String showFacilities(Model model) {
		
		List<Facility> facilities = facilityService.getCurrent();
		model.addAttribute("facilities", facilities);
		
		return "facilities";
	}
}
