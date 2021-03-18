package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import kr.ac.hansung.model.Facility;


@Component("facilityDao")
public class FacilityDao {
	
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    } //dao는 jdbc template을 사용한다. datasource는 의존성주입이 될 예정.
    //jdbc template으로 crud 구현한다.
    
    public int getRowCount() {
    	String sqlStatement = "select count(*) from seoulrecyclingfacilities";
    	return jdbcTemplate.queryForObject(sqlStatement, Integer.class);
    }
    
    //query and return a single object
    public Facility getFacility(String name) {
    	
    	String sqlStatement = "select * from seoulrecyclingfacilities where cmpnm=?";
    	// 두번째 인자는 placeholder(?)에 들어갈 인자값.. 세번째인자는 데이터의 객체변환을 위한 annonymous class(정해진약속)
    	return jdbcTemplate.queryForObject(sqlStatement, new Object[] {name},
    			new RowMapper<Facility>() {

			@Override
			public Facility mapRow(ResultSet rs, int rowNum) throws SQLException {
				Facility facility = new Facility();
				facility.setNo(rs.getInt("sn"));
				facility.setName(rs.getString("cmpnm"));
				facility.setTel(rs.getString("cttpc_cn"));
				facility.setUrl(rs.getString("site_url"));
				facility.setAddress(rs.getString("area_se"));
				facility.setDetail_adres(rs.getString("detail_adres_cn"));
				
				return facility;
				
			}
    		
    	});
    }
    
    
  //query and return a multiple objects
    public List<Facility> getFacilities() {
    	
    	String sqlStatement = "select * from seoulrecyclingfacilities";
    	return jdbcTemplate.query(sqlStatement, new RowMapper<Facility>() {

			@Override
			public Facility mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Facility facility = new Facility();
				facility.setNo(rs.getInt("sn"));
				facility.setName(rs.getString("cmpnm"));
				facility.setTel(rs.getString("cttpc_cn"));
				facility.setUrl(rs.getString("site_url"));
				facility.setAddress(rs.getString("area_se"));
				facility.setDetail_adres(rs.getString("detail_adres_cn"));
				
				return facility;
				
			}
    		
    	});
    }
    
}
