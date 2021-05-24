package kr.ac.hansung.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@ToString

@Entity
@Table(name = "detail_location")
public class FacilityDetail {
	
	@Id
	@Column(name="center_name")
	private String name;
	
	private String address_detail;
	
	private String latitude;
	private String longitude;
	
	private String tel;
	
	private String opentime;
	private String closetime;
	
	private String opentime_holiday;
	private String closetime_holiday;
	
	private String off_info;
	private String site_url;
	
}
