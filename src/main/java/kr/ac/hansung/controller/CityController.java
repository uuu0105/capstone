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

import kr.ac.hansung.exception.NotFoundException;
import kr.ac.hansung.model.Facility;
import kr.ac.hansung.model.SeoulCity;
import kr.ac.hansung.service.CityService;

@RestController
@RequestMapping(path="/city")
public class CityController {
	@Autowired
	private CityService cityService;
	
	//city정보
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> showCities(){
		List<SeoulCity> cities = cityService.getCities();
		
		if(cities.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<SeoulCity>>(cities, HttpStatus.OK);
	}
	
	//구 선택시
	@RequestMapping(path = "/{location}", method = RequestMethod.GET)
	public ResponseEntity<?> showFacilities(
			@RequestParam(value="page",defaultValue="1") int page, 
			@RequestParam(value="size",defaultValue="3") int size,
			@PathVariable String location) {
	
		final SeoulCity city = cityService.getCityByName(location);
		
		if (city == null) {
			throw new NotFoundException(location);
		}
		
		//if(city != null ){//searching != null) {
			//List<Facility> reqFacilities = facilityService.getFacilitiesIn(searching);
			//List<Facility> reqFacilities = facilityService.getFacilitiesIn(location);
			
			List<Facility> reqFacilities = city._getFacilities(page,size);			
			
			if(reqFacilities.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<List<Facility>>(reqFacilities, HttpStatus.OK);
		//}
//		List<Facility> facilities = facilityService.getCurrent();
//		//int f_totalNum = facilityService.getTotalNum();
//		//List<String> cities = facilityService.getCities();
//		
//		if( facilities.isEmpty()) {
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		}
//		//model.addAttribute("facilities", facilities);
//		//model.addAttribute("f_totalNum", f_totalNum);
//		//model.addAttribute("cities", cities);
//		
//		
//		//return "facilities";
//		return new ResponseEntity<List<Facility>>(facilities, HttpStatus.OK);
	}
}
