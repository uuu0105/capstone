package kr.ac.hansung.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.ac.hansung.model.Facility;
import kr.ac.hansung.model.FacilityDetail;
import kr.ac.hansung.model.SeoulCity;
import kr.ac.hansung.service.CityService;
import kr.ac.hansung.service.FacilityService;

@RestController
@RequestMapping(path = "/facilities")
public class FacilityController {
	
	@Autowired
	private FacilityService facilityService;
	
	
//	@RequestMapping(method = RequestMethod.GET)
//	public ResponseEntity<?> showFacilities(
//			@RequestParam(value="q", required=false) String searching) {
//	
	
	//그냥 메인
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> showFacilities2(
			@RequestParam(value="page",defaultValue="1") int page, 
			@RequestParam(value="size",defaultValue="10") int size) {
	
		List<Facility> facilities = facilityService.getCurrent(page,size);
		//int f_totalNum = facilityService.getTotalNum();
		//List<String> cities = facilityService.getCities();
		
		if( facilities.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		//model.addAttribute("facilities", facilities);
		//model.addAttribute("f_totalNum", f_totalNum);
		//model.addAttribute("cities", cities);
		
		
		//return "facilities";
		return new ResponseEntity<List<Facility>>(facilities, HttpStatus.OK);
	}
	
	
	
	
//	@RequestMapping(path = "/{location}", method = RequestMethod.GET)
//	public String showFacilities(Model model,
//			@RequestParam(value="page",defaultValue="1") int page,
//			@RequestParam(value="size",defaultValue="10") int size,
//			@RequestParam(value="address",required=false) String location) {
//		
//		if (location != null) { //드롭박스 이용 시
//			List<Facility> reqFacilities = facilityService.getFacilitiesIn(location, page, size);
//			int req_totalNum = facilityService.getReqTotalNum(location);
//			List<String> cities = facilityService.getCities();
//			
//			model.addAttribute("facilities", reqFacilities);
//			model.addAttribute("req_totalNum", req_totalNum);
//			model.addAttribute("req_location", location);
//			model.addAttribute("cities", cities);
//			
//			return "searching";
//		}
//		
//
//		return "facilities";
//	}


	@RequestMapping(path = "/{location}/detail", method = RequestMethod.GET)
	public ResponseEntity<FacilityDetail> retrieveFacilities(@PathVariable String location) {
		
		//List<Facility> reqFacilities = facilityService.getFacilitiesIn(location);
		
		FacilityDetail fd = facilityService.getFacilityDetail(location);
		
		if (fd != null) { //드롭박스 이용 시
			
			
			
			//int req_totalNum = facilityService.getReqTotalNum(location);
			//List<String> cities = facilityService.getCities();
			
			//model.addAttribute("facilities", reqFacilities);
			//model.addAttribute("req_totalNum", req_totalNum);
			//model.addAttribute("req_location", location);
			//model.addAttribute("cities", cities);
			
			//return "searching";
			return new ResponseEntity<FacilityDetail>(fd, HttpStatus.OK);
		}
		
//		if(reqFacilities.isEmpty()) {
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		}
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		//return new ResponseEntity<List<Facility>>(reqFacilities, HttpStatus.OK);
		//return "facilities";
	}
}
