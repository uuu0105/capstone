package kr.ac.hansung.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import kr.ac.hansung.model.SeoulCity;

@Repository
@Transactional
public class CityDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	// Dropdown Data : number of Seoul cities
	public List<SeoulCity> getCities(){
		Session session = sessionFactory.getCurrentSession();
		String hql = "from SeoulCity";
				
		Query<SeoulCity> query = session.createQuery(hql);	
		List<SeoulCity> cityList = query.getResultList();
		
		return cityList;
	}
	
	public SeoulCity getCityByName(String searching) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		SeoulCity city = (SeoulCity)session.get(SeoulCity.class, searching);
		
		return city;
	}
}
