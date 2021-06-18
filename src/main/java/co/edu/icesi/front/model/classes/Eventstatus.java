package co.edu.icesi.front.model.classes;

import java.util.List;

public class Eventstatus{
	
	private static final long serialVersionUID = 1L;

	private long evestatId;

	private String evestatAllowsmobility;

	private String evestatIsactive;

	private String evestatName;

	private List<Autotransition> autotransitions1;

	private List<Autotransition> autotransitions2;

	private Institution institution;

	public Eventstatus() {
	}

	public long getEvestatId() {
		return this.evestatId;
	}

	public void setEvestatId(long evestatId) {
		this.evestatId = evestatId;
	}

	public String getEvestatAllowsmobility() {
		return this.evestatAllowsmobility;
	}

	public void setEvestatAllowsmobility(String evestatAllowsmobility) {
		this.evestatAllowsmobility = evestatAllowsmobility;
	}

	public String getEvestatIsactive() {
		return this.evestatIsactive;
	}

	public void setEvestatIsactive(String evestatIsactive) {
		this.evestatIsactive = evestatIsactive;
	}

	public String getEvestatName() {
		return this.evestatName;
	}

	public void setEvestatName(String evestatName) {
		this.evestatName = evestatName;
	}

	public List<Autotransition> getAutotransitions1() {
		return this.autotransitions1;
	}

	public void setAutotransitions1(List<Autotransition> autotransitions1) {
		this.autotransitions1 = autotransitions1;
	}
/*
	public Autotransition addAutotransitions1(Autotransition autotransitions1) {
		getAutotransitions1().add(autotransitions1);
		autotransitions1.setEventstatus1(this);

		return autotransitions1;
	}

	public Autotransition removeAutotransitions1(Autotransition autotransitions1) {
		getAutotransitions1().remove(autotransitions1);
		autotransitions1.setEventstatus1(null);

		return autotransitions1;
	}
*/
	public List<Autotransition> getAutotransitions2() {
		return this.autotransitions2;
	}

	public void setAutotransitions2(List<Autotransition> autotransitions2) {
		this.autotransitions2 = autotransitions2;
	}
/*
	public Autotransition addAutotransitions2(Autotransition autotransitions2) {
		getAutotransitions2().add(autotransitions2);
		autotransitions2.setEventstatus2(this);

		return autotransitions2;
	}

	public Autotransition removeAutotransitions2(Autotransition autotransitions2) {
		getAutotransitions2().remove(autotransitions2);
		autotransitions2.setEventstatus2(null);

		return autotransitions2;
	}
*/
	public Institution getInstitution() {
		return this.institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

}