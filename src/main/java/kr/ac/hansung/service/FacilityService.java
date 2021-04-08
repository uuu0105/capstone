package kr.ac.hansung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.dao.FacilityDao;
import kr.ac.hansung.model.Facility;

@Service
public class FacilityService {

	@Autowired
	private FacilityDao facilityDao;
	
	public List<String> getCities(){
		return facilityDao.getCities();
	}
	public List<Facility> getCurrent(){
		return facilityDao.getFacilities();
	}
	public List<Facility> getFacilitiesIn(String location) {
		return facilityDao.getFacilitiesIn(location);
	}
}
