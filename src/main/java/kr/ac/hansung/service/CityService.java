package kr.ac.hansung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.dao.CityDao;
import kr.ac.hansung.model.SeoulCity;

@Service
public class CityService {

	@Autowired
	private CityDao cityDao;
	
	public List<SeoulCity> getCities(){
		return cityDao.getCities();
	}
	
	public SeoulCity getCityByName(String searching) {
		// TODO Auto-generated method stub
		return cityDao.getCityByName(searching);
	}
}
