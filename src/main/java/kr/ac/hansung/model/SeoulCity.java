package kr.ac.hansung.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table(name="seoulcity")
public class SeoulCity {
	
	@Id
	@Column(name="city")
	private String cityName;
		
	//@JoinColumn(name="city")  // mappedBy와 같이 쓸수 없음 
	@JsonIgnore
	@OneToMany(mappedBy="district", fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Facility> facilities = new ArrayList<>();
	
	//Custom get method for Paging
	public List<Facility> _getFacilities(int page, int size){
		List<Facility> newFacilities = new ArrayList<>();
		
		for(int i=0; i<size; i++) {
			int fromIndex = page*size-size+i;
			if(0<=fromIndex && fromIndex<facilities.size()) {
				newFacilities.add(facilities.get(fromIndex));
			}
			else break;		
		}		
		return newFacilities;
		
	}
}
