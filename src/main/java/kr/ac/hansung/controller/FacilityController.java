package kr.ac.hansung.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.hansung.model.Facility;
import kr.ac.hansung.service.FacilityService;

@Controller
public class FacilityController {
	
	@Autowired
	private FacilityService facilityService;
	
	@RequestMapping("/facilities")
	public String showFacilities(Model model,
			@RequestParam(value="address",required=false) String location) {
		
		if (location != null) { //드롭박스 이용 시
			List<Facility> reqFacilities = facilityService.getFacilitiesIn(location);
			model.addAttribute("facilities", reqFacilities);
			
			return "facilities";
		}
		
		List<Facility> facilities = facilityService.getCurrent();
		List<String> cities = facilityService.getCities();
		
		model.addAttribute("facilities", facilities);
		model.addAttribute("cities", cities);
		
		return "facilities";
	}
	
}
