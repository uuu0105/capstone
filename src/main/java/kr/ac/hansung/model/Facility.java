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
@Table(name="seoulrecyclingfacilities")
public class Facility {
		
	@Column(name="cmpnm")
	String name;
	
	@Column(name="detail_adres_cn")
	String detail_adres;
	
	@Column(name="site_url")
	String url;	
	
	@Column(name="area_se")
	String address;
	
	@Column(name="cttpc_cn")
	String tel;
	
	@Id
	@Column(name="sn")
	int no;
}
