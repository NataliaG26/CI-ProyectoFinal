package co.edu.icesi.front.model.classes;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import co.edu.icesi.front.model.classes.Autotransition;

public class Personautotran {
	
	private static final long serialVersionUID = 1L;

	private long perautId;

	private Date perautDate;

	private Autotransition autotransition;

	private Person person;

	public Personautotran() {
	}

	public long getPerautId() {
		return this.perautId;
	}

	public void setPerautId(long perautId) {
		this.perautId = perautId;
	}

	public Date getPerautDate() {
		return this.perautDate;
	}

	public void setPerautDate(Date perautDate) {
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

}