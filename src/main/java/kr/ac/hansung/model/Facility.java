package kr.ac.hansung.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString

public class Facility {
	int no;
	String name;
	String address;
	String detail_adres;
	String tel;
	String url;	
}
