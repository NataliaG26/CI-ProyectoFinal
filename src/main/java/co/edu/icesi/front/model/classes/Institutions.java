package co.edu.icesi.front.model.classes;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Institutions {
	
	@JsonIgnore
	private Iterable<Institution> institutions;
	
	public Institutions() {
		
	}
	
	public Iterable<Institution> getInstitutions() {
		return institutions;
	}
	
	public void setInstitutions(Iterable<Institution> institutions) {
		this.institutions = institutions;
	}

}
