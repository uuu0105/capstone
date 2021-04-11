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
	public int getTotalNum() {
		return facilityDao.getAllNum();
	}
	public List<Facility> getCurrent(int page, int size){
		return facilityDao.getFacilities(page, size);
	}
//	public List<Facility> getFacilitiesIn(String location) {
//		return facilityDao.getFacilitiesIn(location);
//	}
	public List<Facility> getFacilitiesIn(String location, int page, int size) {
		return facilityDao.getReqFacilities(location, page, size);
	}
	public int getReqTotalNum(String location) {
		return facilityDao.getReqNum(location);
	}
}
