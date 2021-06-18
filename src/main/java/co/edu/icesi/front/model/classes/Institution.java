package co.edu.icesi.front.model.classes;

import com.fasterxml.jackson.annotation.JsonIgnore;

import co.edu.icesi.back.model.Eventstatus;

import java.util.List;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class Institution {
	
	private static final long serialVersionUID = 1L;
	
	private long instId;
	
	@NotBlank(message="the link cannot be blank")
	@Pattern(regexp = "^(((https)://)(%[0-9A-Fa-f]{2}|[-()_.!~*';/?:@&=+$,A-Za-z0-9])+)([).!';/?:,][[:blank:]])?$", message ="The link must start with 'https'")
	private String instAcademicserverurl;

	@NotBlank(message="the link cannot be blank")
	@Pattern(regexp = "^(((https)://)(%[0-9A-Fa-f]{2}|[-()_.!~*';/?:@&=+$,A-Za-z0-9])+)([).!';/?:,][[:blank:]])?$", message ="The link must start with 'https'")
	private String instAcadextradataurl;

	@Column(name = "INST_ACADLOGINPASSWORD")
	private String instAcadloginpassword;
	
	@NotBlank(message="the link cannot be blank")
	@Pattern(regexp = "^(((https)://)(%[0-9A-Fa-f]{2}|[-()_.!~*';/?:@&=+$,A-Za-z0-9])+)([).!';/?:,][[:blank:]])?$", message ="The link must start with 'https'")
	private String instAcadloginurl;

	//@NotBlank(message="the login user name cannot be blank")
	@Column(name = "INST_ACADLOGINUSERNAME")
	private String instAcadloginusername;

	@NotBlank(message="the link cannot be blank")
	@Pattern(regexp = "^(((https)://)(%[0-9A-Fa-f]{2}|[-()_.!~*';/?:@&=+$,A-Za-z0-9])+)([).!';/?:,][[:blank:]])?$", message ="The link must start with 'https'")
	private String instAcadpersoninfodocurl;
	
	@NotBlank(message="the link cannot be blank")
	@Pattern(regexp = "^(((https)://)(%[0-9A-Fa-f]{2}|[-()_.!~*';/?:@&=+$,A-Za-z0-9])+)([).!';/?:,][[:blank:]])?$", message ="The link must start with 'https'")
	private String instAcadpersoninfoidurl;
	
	@NotBlank(message="the link cannot be blank")
	@Pattern(regexp = "^(((https)://)(%[0-9A-Fa-f]{2}|[-()_.!~*';/?:@&=+$,A-Za-z0-9])+)([).!';/?:,][[:blank:]])?$", message ="The link must start with 'https'")
	private String instAcadphysicalspacesurl;

	@NotBlank(message="the link cannot be blank")
	@Pattern(regexp = "^(((https)://)(%[0-9A-Fa-f]{2}|[-()_.!~*';/?:@&=+$,A-Za-z0-9])+)([).!';/?:,][[:blank:]])?$", message ="The link must start with 'https'")
	private String instAcadprogrammedcoursesurl;

	private String instLdapbasedn;

	private String instLdappassword;

	@NotBlank(message="the link cannot be blank")
	@Pattern(regexp = "^(((https)://)(%[0-9A-Fa-f]{2}|[-()_.!~*';/?:@&=+$,A-Za-z0-9])+)([).!';/?:,][[:blank:]])?$", message ="The link must start with 'https'")
	private String instLdapurl;

	private String instLdapusername;

	private String instLdapusersearchbase;

	private String instLdapusersearchfilter;

	private String instName;
	
	@JsonIgnore
	private List<Person> persons;
	
	@JsonIgnore
	private List<Eventstatus> eventstatuses;

	public Institution() {
	}

	public long getInstId() {
		return this.instId;
	}

	public void setInstId(long instId) {
		this.instId = instId;
	}

	public String getInstAcademicserverurl() {
		return this.instAcademicserverurl;
	}

	public void setInstAcademicserverurl(String instAcademicserverurl) {
		this.instAcademicserverurl = instAcademicserverurl;
	}

	public String getInstAcadextradataurl() {
		return this.instAcadextradataurl;
	}

	public void setInstAcadextradataurl(String instAcadextradataurl) {
		this.instAcadextradataurl = instAcadextradataurl;
	}

	public String getInstAcadloginpassword() {
		return this.instAcadloginpassword;
	}

	public void setInstAcadloginpassword(String instAcadloginpassword) {
		this.instAcadloginpassword = instAcadloginpassword;
	}

	public String getInstAcadloginurl() {
		return this.instAcadloginurl;
	}

	public void setInstAcadloginurl(String instAcadloginurl) {
		this.instAcadloginurl = instAcadloginurl;
	}

	public String getInstAcadloginusername() {
		return this.instAcadloginusername;
	}

	public void setInstAcadloginusername(String instAcadloginusername) {
		this.instAcadloginusername = instAcadloginusername;
	}

	public String getInstAcadpersoninfodocurl() {
		return this.instAcadpersoninfodocurl;
	}

	public void setInstAcadpersoninfodocurl(String instAcadpersoninfodocurl) {
		this.instAcadpersoninfodocurl = instAcadpersoninfodocurl;
	}

	public String getInstAcadpersoninfoidurl() {
		return this.instAcadpersoninfoidurl;
	}

	public void setInstAcadpersoninfoidurl(String instAcadpersoninfoidurl) {
		this.instAcadpersoninfoidurl = instAcadpersoninfoidurl;
	}

	public String getInstAcadphysicalspacesurl() {
		return this.instAcadphysicalspacesurl;
	}

	public void setInstAcadphysicalspacesurl(String instAcadphysicalspacesurl) {
		this.instAcadphysicalspacesurl = instAcadphysicalspacesurl;
	}

	public String getInstAcadprogrammedcoursesurl() {
		return this.instAcadprogrammedcoursesurl;
	}

	public void setInstAcadprogrammedcoursesurl(String instAcadprogrammedcoursesurl) {
		this.instAcadprogrammedcoursesurl = instAcadprogrammedcoursesurl;
	}

	public String getInstLdapbasedn() {
		return this.instLdapbasedn;
	}

	public void setInstLdapbasedn(String instLdapbasedn) {
		this.instLdapbasedn = instLdapbasedn;
	}

	public String getInstLdappassword() {
		return this.instLdappassword;
	}

	public void setInstLdappassword(String instLdappassword) {
		this.instLdappassword = instLdappassword;
	}

	public String getInstLdapurl() {
		return this.instLdapurl;
	}

	public void setInstLdapurl(String instLdapurl) {
		this.instLdapurl = instLdapurl;
	}

	public String getInstLdapusername() {
		return this.instLdapusername;
	}

	public void setInstLdapusername(String instLdapusername) {
		this.instLdapusername = instLdapusername;
	}

	public String getInstLdapusersearchbase() {
		return this.instLdapusersearchbase;
	}

	public void setInstLdapusersearchbase(String instLdapusersearchbase) {
		this.instLdapusersearchbase = instLdapusersearchbase;
	}

	public String getInstLdapusersearchfilter() {
		return this.instLdapusersearchfilter;
	}

	public void setInstLdapusersearchfilter(String instLdapusersearchfilter) {
		this.instLdapusersearchfilter = instLdapusersearchfilter;
	}

	public String getInstName() {
		return this.instName;
	}

	public void setInstName(String instName) {
		this.instName = instName;
	}

	public List<Person> getPersons() {
		return this.persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	public Person addPerson(Person person) {
		getPersons().add(person);
		person.setInstitution(this);

		return person;
	}

	public Person removePerson(Person person) {
		getPersons().remove(person);
		person.setInstitution(null);

		return person;
	}
	
}
