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
			@RequestParam(value="page",defaultValue="1") int page,
			@RequestParam(value="size",defaultValue="10") int size) {
		
		List<Facility> facilities = facilityService.getCurrent(page,size);
		int f_totalNum = facilityService.getTotalNum();
		List<String> cities = facilityService.getCities();
				
		model.addAttribute("facilities", facilities);
		model.addAttribute("f_totalNum", f_totalNum);
		model.addAttribute("cities", cities);
		
		
		return "facilities";
	}
	
	
	@RequestMapping("/searching")
	public String showFacilities(Model model,
			@RequestParam(value="page",defaultValue="1") int page,
			@RequestParam(value="size",defaultValue="10") int size,
			@RequestParam(value="address",required=false) String location) {
		
		if (location != null) { //드롭박스 이용 시
			List<Facility> reqFacilities = facilityService.getFacilitiesIn(location, page, size);
			int req_totalNum = facilityService.getReqTotalNum(location);
			List<String> cities = facilityService.getCities();
			
			model.addAttribute("facilities", reqFacilities);
			model.addAttribute("req_totalNum", req_totalNum);
			model.addAttribute("req_location", location);
			model.addAttribute("cities", cities);
			
			return "searching";
		}
		

		return "facilities";
	}
}
