package kr.ac.hansung.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import kr.ac.hansung.model.Facility;


//@Component("facilityDao")
@Repository
@Transactional
public class FacilityDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	// Dropdown Data : number of Seoul cities
	public List<String> getCities(){
		Session session = sessionFactory.getCurrentSession();
		String hql = "from SeoulCity";
				
		Query<String> query = session.createQuery(hql);	
		List<String> cityList = query.getResultList();
		
		return cityList;
	}
	
	// return Data By page&size : pagination!!
//	public List<Facility> getFacilities(int page, int size){
//		Session session = sessionFactory.getCurrentSession();
//		String hql = "from Facility facility order by facility.name asc";
//		
//		Query<Facility> query = session.createQuery(hql, Facility.class);
//		query.setFirstResult((page-1)*size);
//		query.setMaxResults(size);
//		
//    	List<Facility> facilityList = query.getResultList();
//    	
//    	return facilityList;
//	}
	
	public List<Facility> getFacilities(){
	Session session = sessionFactory.getCurrentSession();
	String hql = "from Facility facility order by facility.name asc";
	
	Query<Facility> query = session.createQuery(hql, Facility.class);
	//query.setFirstResult((page-1)*size);
	//query.setMaxResults(size);
	
	List<Facility> facilityList = query.getResultList();
	
	return facilityList;
}	
    // return User's requesting Data 
//	public List<Facility> getFacilitiesIn(String location) {
//		
//		Session session = sessionFactory.getCurrentSession();
//		String hql = "from Facility facility where facility.name like '%" + location + "%'";
//		
//		Query<Facility> query = session.createQuery(hql, Facility.class);
//		query.setFirstResult(0);
//		query.setMaxResults(10);
//		
//    	List<Facility> facilityList = query.getResultList();
//    	
//    	return facilityList;
//	}
	
	// Count total_facilities_num
	public int getAllNum() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select count(*) from Facility";		 
		Query query = session.createQuery(hql);
		
		List listResult = query.list();
		Number number = (Number) listResult.get(0);
		return number.intValue();
		
	}
	
	// return User's requesting Data + pagination
//	public List<Facility> getReqFacilities(String location, int page, int size) {
//		Session session = sessionFactory.getCurrentSession();
//		String hql = "from Facility facility where facility.name like '%" + location + "%'";
//		
//		Query<Facility> query = session.createQuery(hql, Facility.class);
//		query.setFirstResult((page-1)*size);
//		query.setMaxResults(size);
//		
//    	List<Facility> facilityList = query.getResultList();
//    	
//    	return facilityList;
//	}
	
	public List<Facility> getReqFacilities(String location) {
		Session session = sessionFactory.getCurrentSession();
		//String hql = "from Facility facility where facility.address like '%" + location + "%'";
		//String hql = "from Facility facility where facility.address="+location;
		String hql = "from Facility facility where facility.address= :location";
		Query<Facility> query = session.createQuery(hql, Facility.class);
		query.setParameter("location", location);
		//query.setFirstResult((page-1)*size);
		//query.setMaxResults(size);
		
    	List<Facility> facilityList = query.getResultList();
    	
    	//List<Facility> facilityList = (List<Facility>) session.get(Facility.class, location);
    	return facilityList;
	}
	

	public int getReqNum(String location) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select count(name) from Facility facility where facility.name like '%" + location + "%'";		 
		Query query = session.createQuery(hql);
		
		List listResult = query.list();
		Number number = (Number) listResult.get(0);
		return number.intValue();
	}

//    @Autowired
//    public void setDataSource(DataSource dataSource) {
//        this.jdbcTemplate = new JdbcTemplate(dataSource);
//    } //dao는 jdbc template을 사용한다. datasource는 의존성주입이 될 예정.
//    //jdbc template으로 crud 구현한다.
//    
//    public int getRowCount() {
//    	String sqlStatement = "select count(*) from seoulrecyclingfacilities";
//    	return jdbcTemplate.queryForObject(sqlStatement, Integer.class);
//    }
//    
//    //query and return a single object
//    public Facility getFacility(String name) {
//    	
//    	String sqlStatement = "select * from seoulrecyclingfacilities where cmpnm=?";
//    	// 두번째 인자는 placeholder(?)에 들어갈 인자값.. 세번째인자는 데이터의 객체변환을 위한 annonymous class(정해진약속)
//    	return jdbcTemplate.queryForObject(sqlStatement, new Object[] {name},
//    			new RowMapper<Facility>() {
//
//			@Override
//			public Facility mapRow(ResultSet rs, int rowNum) throws SQLException {
//				Facility facility = new Facility();
//				facility.setNo(rs.getInt("sn"));
//				facility.setName(rs.getString("cmpnm"));
//				facility.setTel(rs.getString("cttpc_cn"));
//				facility.setUrl(rs.getString("site_url"));
//				facility.setAddress(rs.getString("area_se"));
//				facility.setDetail_adres(rs.getString("detail_adres_cn"));
//				
//				return facility;
//				
//			}
//    		
//    	});
//    }
//    
//    
//  //query and return a multiple objects
//    public List<Facility> getFacilities() {
//    	
//    	String sqlStatement = "select * from seoulrecyclingfacilities";
//    	return jdbcTemplate.query(sqlStatement, new RowMapper<Facility>() {
//
//			@Override
//			public Facility mapRow(ResultSet rs, int rowNum) throws SQLException {
//				
//				Facility facility = new Facility();
//				facility.setNo(rs.getInt("sn"));
//				facility.setName(rs.getString("cmpnm"));
//				facility.setTel(rs.getString("cttpc_cn"));
//				facility.setUrl(rs.getString("site_url"));
//				facility.setAddress(rs.getString("area_se"));
//				facility.setDetail_adres(rs.getString("detail_adres_cn"));
//				
//				return facility;
//				
//			}
//    		
//    	});
//    }
    
}
