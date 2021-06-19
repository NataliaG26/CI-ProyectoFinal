package co.edu.icesi.front.model.classes;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.Date;
//import co.edu.icesi.front.model.classes.Personautotran;

public class Person {
	
	private static final long serialVersionUID = 1L;

	private long persId;

	private String persAddress;

	private String persContactnumber;

	@Email
	@Size(min=6)
	private String persEmail;
	
	private String persExtid;
	
	private String persIddocument;

	private String persIsactive;
	
	//@NotBlank(message="the link cannot be blank")
	private String persLastname;

	private String persLatitude;

	private String persLocaldata;

	private String persLongitude;
	
	private String persName;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate persOnsetdate;

	private String persPoliticsaccepted;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate persPoliticsaccepteddate;

	private Institution institution;
	
	//@NotBlank(message="the link cannot be blank")
	private long instid;

//	@JsonIgnore
//	private List<Personautotran> personautotrans;

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

	public LocalDate getPersOnsetdate() {
		return this.persOnsetdate;
	}

	public void setPersOnsetdate(LocalDate persOnsetdate) {
		this.persOnsetdate = persOnsetdate;
	}

	public String getPersPoliticsaccepted() {
		return this.persPoliticsaccepted;
	}

	public void setPersPoliticsaccepted(String persPoliticsaccepted) {
		this.persPoliticsaccepted = persPoliticsaccepted;
	}

	public LocalDate getPersPoliticsaccepteddate() {
		return this.persPoliticsaccepteddate;
	}

	public void setPersPoliticsaccepteddate(LocalDate persPoliticsaccepteddate) {
		this.persPoliticsaccepteddate = persPoliticsaccepteddate;
	}


	public Institution getInstitution() {
		return this.institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}
	
	public long getInstid() {
		return instid;
	}
	public void setInstid(long instid) {
		this.instid = instid;
	}
//
//	public List<Personautotran> getPersonautotrans() {
//		return this.personautotrans;
//	}
//
//	public void setPersonautotrans(List<Personautotran> personautotrans) {
//		this.personautotrans = personautotrans;
//	}
//
//	public Personautotran addPersonautotran(Personautotran personautotran) {
//		getPersonautotrans().add(personautotran);
//		personautotran.setPerson(this);
//
//		return personautotran;
//	}
//
//	public Personautotran removePersonautotran(Personautotran personautotran) {
//		getPersonautotrans().remove(personautotran);
//		personautotran.setPerson(null);
//
//		return personautotran;
//	}

}