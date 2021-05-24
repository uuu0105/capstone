package kr.ac.hansung.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString

@Entity
@Table(name="seoulrecyclingfacilities")
public class Facility {
	
	@Id
	@Column(name="sn")
	private int no;
	
	@Column(name="cmpnm")
	private String name;
	
	@Column(name="detail_adres_cn")
	private String detail_adres;
	
	@Column(name="site_url")
	private String url;	
	
	//@Column(name="area_se")
	//private String address;
		
	@Column(name="cttpc_cn")
	private String tel;

	@ManyToOne(optional=false)
	@JoinColumn(name="city")
	private SeoulCity district;
	
	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY, optional=false, cascade = CascadeType.ALL)	
	@JoinColumn(name="center_name", nullable=false, unique=true)
	private FacilityDetail fd;
	

}
