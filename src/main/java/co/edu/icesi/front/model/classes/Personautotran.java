package co.edu.icesi.front.model.classes;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class Personautotran {
	
	private static final long serialVersionUID = 1L;

	private long perautId;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate perautDate;
	
	private Autotransition autotransition;

	private Person person;

	private long personId;

	private long autotranId;

	public Personautotran() {
	}

	public long getPerautId() {
		return this.perautId;
	}

	public void setPerautId(long perautId) {
		this.perautId = perautId;
	}

	public LocalDate getPerautDate() {
		return this.perautDate;
	}

	public void setPerautDate(LocalDate perautDate) {
		this.perautDate = perautDate;
	}

	public Autotransition getAutotransition() {
		return this.autotransition;
	}

	public void setAutotransition(Autotransition autotransition) {
		this.autotransition = autotransition;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	public long getAutotranId() {
		return autotranId;
	}
	public void setAutotranId(long autotranId) {
		this.autotranId = autotranId;
	}
	public long getPersonId() {
		return personId;
	}
	public void setPersonId(long personId) {
		this.personId = personId;
	}

}