package co.edu.icesi.front.model.classes;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

import co.edu.icesi.front.model.classes.Institution;
import co.edu.icesi.front.model.classes.Personautotran;

public class Person {
	
	private static final long serialVersionUID = 1L;

	private long persId;

	private String persAddress;

	private String persContactnumber;

	private String persEmail;

	private String persExtid;

	private String persIddocument;

	private String persIsactive;

	private String persLastname;

	private String persLatitude;

	private String persLocaldata;

	private String persLongitude;

	private String persName;

	private Date persOnsetdate;

	private String persPoliticsaccepted;

	private Date persPoliticsaccepteddate;

	private Institution institution;

	@JsonIgnore
	private List<Personautotran> personautotrans;

	public Person() {
	}

	public long getPersId() {
		return this.persId;
	}

	public void setPersId(long persId) {
		this.persId = persId;
	}

	public String getPersAddress() {
		return this.persAddress;
	}

	public void setPersAddress(String persAddress) {
		this.persAddress = persAddress;
	}

	public String getPersContactnumber() {
		return this.persContactnumber;
	}

	public void setPersContactnumber(String persContactnumber) {
		this.persContactnumber = persContactnumber;
	}

	public String getPersEmail() {
		return this.persEmail;
	}

	public void setPersEmail(String persEmail) {
		this.persEmail = persEmail;
	}

	public String getPersExtid() {
		return this.persExtid;
	}

	public void setPersExtid(String persExtid) {
		this.persExtid = persExtid;
	}

	public String getPersIddocument() {
		return this.persIddocument;
	}

	public void setPersIddocument(String persIddocument) {
		this.persIddocument = persIddocument;
	}

	public String getPersIsactive() {
		return this.persIsactive;
	}

	public void setPersIsactive(String persIsactive) {
		this.persIsactive = persIsactive;
	}

	public String getPersLastname() {
		return this.persLastname;
	}

	public void setPersLastname(String persLastname) {
		this.persLastname = persLastname;
	}

	public String getPersLatitude() {
		return this.persLatitude;
	}

	public void setPersLatitude(String persLatitude) {
		this.persLatitude = persLatitude;
	}

	public String getPersLocaldata() {
		return this.persLocaldata;
	}

	public void setPersLocaldata(String persLocaldata) {
		this.persLocaldata = persLocaldata;
	}

	public String getPersLongitude() {
		return this.persLongitude;
	}

	public void setPersLongitude(String persLongitude) {
		this.persLongitude = persLongitude;
	}

	public String getPersName() {
		return this.persName;
	}

	public void setPersName(String persName) {
		this.persName = persName;
	}

	public Date getPersOnsetdate() {
		return this.persOnsetdate;
	}

	public void setPersOnsetdate(Date persOnsetdate) {
		this.persOnsetdate = persOnsetdate;
	}

	public String getPersPoliticsaccepted() {
		return this.persPoliticsaccepted;
	}

	public void setPersPoliticsaccepted(String persPoliticsaccepted) {
		this.persPoliticsaccepted = persPoliticsaccepted;
	}

	public Date getPersPoliticsaccepteddate() {
		return this.persPoliticsaccepteddate;
	}

	public void setPersPoliticsaccepteddate(Date persPoliticsaccepteddate) {
		this.persPoliticsaccepteddate = persPoliticsaccepteddate;
	}


	public Institution getInstitution() {
		return this.institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

	public List<Personautotran> getPersonautotrans() {
		return this.personautotrans;
	}

	public void setPersonautotrans(List<Personautotran> personautotrans) {
		this.personautotrans = personautotrans;
	}

	public Personautotran addPersonautotran(Personautotran personautotran) {
		getPersonautotrans().add(personautotran);
		personautotran.setPerson(this);

		return personautotran;
	}

	public Personautotran removePersonautotran(Personautotran personautotran) {
		getPersonautotrans().remove(personautotran);
		personautotran.setPerson(null);

		return personautotran;
	}

}