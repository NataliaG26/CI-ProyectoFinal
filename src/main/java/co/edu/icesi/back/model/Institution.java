package co.edu.icesi.back.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The persistent class for the INSTITUTION database table.
 * 
 */
@Entity
@NamedQuery(name = "Institution.findAll", query = "SELECT i FROM Institution i")
public class Institution implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "INSTITUTION_INSTID_GENERATOR", sequenceName = "INSTITUTION_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "INSTITUTION_INSTID_GENERATOR")
	@Column(name = "INST_ID")
	private long instId;
	
	@NotBlank(message="the link cannot be blank")
	@Pattern(regexp = "^(((https)://)(%[0-9A-Fa-f]{2}|[-()_.!~*';/?:@&=+$,A-Za-z0-9])+)([).!';/?:,][[:blank:]])?$", message ="The link must start with 'https'")
	@Column(name = "INST_ACADEMICSERVERURL")
	private String instAcademicserverurl;

	@NotBlank(message="the link cannot be blank")
	@Pattern(regexp = "^(((https)://)(%[0-9A-Fa-f]{2}|[-()_.!~*';/?:@&=+$,A-Za-z0-9])+)([).!';/?:,][[:blank:]])?$", message ="The link must start with 'https'")
	@Column(name = "INST_ACADEXTRADATAURL")
	private String instAcadextradataurl;

	@Column(name = "INST_ACADLOGINPASSWORD")
	private String instAcadloginpassword;
	
	@NotBlank(message="the link cannot be blank")
	@Pattern(regexp = "^(((https)://)(%[0-9A-Fa-f]{2}|[-()_.!~*';/?:@&=+$,A-Za-z0-9])+)([).!';/?:,][[:blank:]])?$", message ="The link must start with 'https'")
	@Column(name = "INST_ACADLOGINURL")
	private String instAcadloginurl;

	//@NotBlank(message="the login user name cannot be blank")
	@Column(name = "INST_ACADLOGINUSERNAME")
	private String instAcadloginusername;

	@NotBlank(message="the link cannot be blank")
	@Pattern(regexp = "^(((https)://)(%[0-9A-Fa-f]{2}|[-()_.!~*';/?:@&=+$,A-Za-z0-9])+)([).!';/?:,][[:blank:]])?$", message ="The link must start with 'https'")
	@Column(name = "INST_ACADPERSONINFODOCURL")
	private String instAcadpersoninfodocurl;
	
	@NotBlank(message="the link cannot be blank")
	@Pattern(regexp = "^(((https)://)(%[0-9A-Fa-f]{2}|[-()_.!~*';/?:@&=+$,A-Za-z0-9])+)([).!';/?:,][[:blank:]])?$", message ="The link must start with 'https'")
	@Column(name = "INST_ACADPERSONINFOIDURL")
	private String instAcadpersoninfoidurl;
	
	@NotBlank(message="the link cannot be blank")
	@Pattern(regexp = "^(((https)://)(%[0-9A-Fa-f]{2}|[-()_.!~*';/?:@&=+$,A-Za-z0-9])+)([).!';/?:,][[:blank:]])?$", message ="The link must start with 'https'")
	@Column(name = "INST_ACADPHYSICALSPACESURL")
	private String instAcadphysicalspacesurl;

	@NotBlank(message="the link cannot be blank")
	@Pattern(regexp = "^(((https)://)(%[0-9A-Fa-f]{2}|[-()_.!~*';/?:@&=+$,A-Za-z0-9])+)([).!';/?:,][[:blank:]])?$", message ="The link must start with 'https'")
	@Column(name = "INST_ACADPROGRAMMEDCOURSESURL")
	private String instAcadprogrammedcoursesurl;

	
	@Column(name = "INST_LDAPBASEDN")
	private String instLdapbasedn;

	@Column(name = "INST_LDAPPASSWORD")
	private String instLdappassword;

	@NotBlank(message="the link cannot be blank")
	@Pattern(regexp = "^(((https)://)(%[0-9A-Fa-f]{2}|[-()_.!~*';/?:@&=+$,A-Za-z0-9])+)([).!';/?:,][[:blank:]])?$", message ="The link must start with 'https'")
	@Column(name = "INST_LDAPURL")
	private String instLdapurl;

	@Column(name = "INST_LDAPUSERNAME")
	private String instLdapusername;

	@Column(name = "INST_LDAPUSERSEARCHBASE")
	private String instLdapusersearchbase;

	@Column(name = "INST_LDAPUSERSEARCHFILTER")
	private String instLdapusersearchfilter;
	
	@NotEmpty//(message="Nooooo")
	@NotBlank//(message="Noop")
	@Column(name = "INST_NAME")
	private String instName;
	
	@JsonIgnore
	// bi-directional many-to-one association to Accessdenialevent
	@OneToMany(mappedBy = "institution", cascade = CascadeType.REMOVE)
	private List<Accessdenialevent> accessdenialevents;
	@JsonIgnore
	// bi-directional many-to-one association to Devicestatus
	@OneToMany(mappedBy = "institution", cascade = CascadeType.REMOVE)
	private List<Devicestatus> devicestatuses;
	@JsonIgnore
	// bi-directional many-to-one association to Devicetype
	@OneToMany(mappedBy = "institution", cascade = CascadeType.REMOVE)
	private List<Devicetype> devicetypes;
	@JsonIgnore
	// bi-directional many-to-one association to Epidemstatustransition
	@OneToMany(mappedBy = "institution", cascade = CascadeType.REMOVE)
	private List<Epidemstatustransition> epidemstatustransitions;
	@JsonIgnore
	// bi-directional many-to-one association to Eventstatus
	@OneToMany(mappedBy = "institution", cascade = CascadeType.REMOVE)
	private List<Eventstatus> eventstatuses;
	@JsonIgnore
	// bi-directional many-to-one association to HatParameter
	@OneToMany(mappedBy = "institution", cascade = CascadeType.REMOVE)
	private List<HatParameter> hatParameters;
	@JsonIgnore
	// bi-directional many-to-one association to Institutioncampus
	@OneToMany(mappedBy = "institution", cascade = CascadeType.REMOVE)
	private List<Institutioncampus> institutioncampuses;
	@JsonIgnore
	// bi-directional many-to-one association to Measurement
	@OneToMany(mappedBy = "institution", cascade = CascadeType.REMOVE)
	private List<Measurement> measurements;
	@JsonIgnore
	// bi-directional many-to-one association to Person
	@OneToMany(mappedBy = "institution", cascade = CascadeType.REMOVE)
	private List<Person> persons;
	@JsonIgnore
	// bi-directional many-to-one association to Physicalspacetype
	@OneToMany(mappedBy = "institution", cascade = CascadeType.REMOVE)
	private List<Physicalspacetype> physicalspacetypes;
	@JsonIgnore
	// bi-directional many-to-one association to Posessiontype
	@OneToMany(mappedBy = "institution", cascade = CascadeType.REMOVE)
	private List<Posessiontype> posessiontypes;

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

	public List<Accessdenialevent> getAccessdenialevents() {
		return this.accessdenialevents;
	}

	public void setAccessdenialevents(List<Accessdenialevent> accessdenialevents) {
		this.accessdenialevents = accessdenialevents;
	}

	public Accessdenialevent addAccessdenialevent(Accessdenialevent accessdenialevent) {
		getAccessdenialevents().add(accessdenialevent);
		accessdenialevent.setInstitution(this);

		return accessdenialevent;
	}

	public Accessdenialevent removeAccessdenialevent(Accessdenialevent accessdenialevent) {
		getAccessdenialevents().remove(accessdenialevent);
		accessdenialevent.setInstitution(null);

		return accessdenialevent;
	}

	public List<Devicestatus> getDevicestatuses() {
		return this.devicestatuses;
	}

	public void setDevicestatuses(List<Devicestatus> devicestatuses) {
		this.devicestatuses = devicestatuses;
	}

	public Devicestatus addDevicestatus(Devicestatus devicestatus) {
		getDevicestatuses().add(devicestatus);
		devicestatus.setInstitution(this);

		return devicestatus;
	}

	public Devicestatus removeDevicestatus(Devicestatus devicestatus) {
		getDevicestatuses().remove(devicestatus);
		devicestatus.setInstitution(null);

		return devicestatus;
	}

	public List<Devicetype> getDevicetypes() {
		return this.devicetypes;
	}

	public void setDevicetypes(List<Devicetype> devicetypes) {
		this.devicetypes = devicetypes;
	}

	public Devicetype addDevicetype(Devicetype devicetype) {
		getDevicetypes().add(devicetype);
		devicetype.setInstitution(this);

		return devicetype;
	}

	public Devicetype removeDevicetype(Devicetype devicetype) {
		getDevicetypes().remove(devicetype);
		devicetype.setInstitution(null);

		return devicetype;
	}

	public List<Epidemstatustransition> getEpidemstatustransitions() {
		return this.epidemstatustransitions;
	}

	public void setEpidemstatustransitions(List<Epidemstatustransition> epidemstatustransitions) {
		this.epidemstatustransitions = epidemstatustransitions;
	}

	public Epidemstatustransition addEpidemstatustransition(Epidemstatustransition epidemstatustransition) {
		getEpidemstatustransitions().add(epidemstatustransition);
		epidemstatustransition.setInstitution(this);

		return epidemstatustransition;
	}

	public Epidemstatustransition removeEpidemstatustransition(Epidemstatustransition epidemstatustransition) {
		getEpidemstatustransitions().remove(epidemstatustransition);
		epidemstatustransition.setInstitution(null);

		return epidemstatustransition;
	}

	public List<Eventstatus> getEventstatuses() {
		return this.eventstatuses;
	}

	public void setEventstatuses(List<Eventstatus> eventstatuses) {
		this.eventstatuses = eventstatuses;
	}

	public Eventstatus addEventstatus(Eventstatus eventstatus) {
		getEventstatuses().add(eventstatus);
		eventstatus.setInstitution(this);

		return eventstatus;
	}

	public Eventstatus removeEventstatus(Eventstatus eventstatus) {
		getEventstatuses().remove(eventstatus);
		eventstatus.setInstitution(null);

		return eventstatus;
	}

	public List<HatParameter> getHatParameters() {
		return this.hatParameters;
	}

	public void setHatParameters(List<HatParameter> hatParameters) {
		this.hatParameters = hatParameters;
	}

	public HatParameter addHatParameter(HatParameter hatParameter) {
		getHatParameters().add(hatParameter);
		hatParameter.setInstitution(this);

		return hatParameter;
	}

	public HatParameter removeHatParameter(HatParameter hatParameter) {
		getHatParameters().remove(hatParameter);
		hatParameter.setInstitution(null);

		return hatParameter;
	}

	public List<Institutioncampus> getInstitutioncampuses() {
		return this.institutioncampuses;
	}

	public void setInstitutioncampuses(List<Institutioncampus> institutioncampuses) {
		this.institutioncampuses = institutioncampuses;
	}

	public Institutioncampus addInstitutioncampus(Institutioncampus institutioncampus) {
		getInstitutioncampuses().add(institutioncampus);
		institutioncampus.setInstitution(this);

		return institutioncampus;
	}

	public Institutioncampus removeInstitutioncampus(Institutioncampus institutioncampus) {
		getInstitutioncampuses().remove(institutioncampus);
		institutioncampus.setInstitution(null);

		return institutioncampus;
	}

	public List<Measurement> getMeasurements() {
		return this.measurements;
	}

	public void setMeasurements(List<Measurement> measurements) {
		this.measurements = measurements;
	}

	public Measurement addMeasurement(Measurement measurement) {
		getMeasurements().add(measurement);
		measurement.setInstitution(this);

		return measurement;
	}

	public Measurement removeMeasurement(Measurement measurement) {
		getMeasurements().remove(measurement);
		measurement.setInstitution(null);

		return measurement;
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

	public List<Physicalspacetype> getPhysicalspacetypes() {
		return this.physicalspacetypes;
	}

	public void setPhysicalspacetypes(List<Physicalspacetype> physicalspacetypes) {
		this.physicalspacetypes = physicalspacetypes;
	}

	public Physicalspacetype addPhysicalspacetype(Physicalspacetype physicalspacetype) {
		getPhysicalspacetypes().add(physicalspacetype);
		physicalspacetype.setInstitution(this);

		return physicalspacetype;
	}

	public Physicalspacetype removePhysicalspacetype(Physicalspacetype physicalspacetype) {
		getPhysicalspacetypes().remove(physicalspacetype);
		physicalspacetype.setInstitution(null);

		return physicalspacetype;
	}

	public List<Posessiontype> getPosessiontypes() {
		return this.posessiontypes;
	}

	public void setPosessiontypes(List<Posessiontype> posessiontypes) {
		this.posessiontypes = posessiontypes;
	}

	public Posessiontype addPosessiontype(Posessiontype posessiontype) {
		getPosessiontypes().add(posessiontype);
		posessiontype.setInstitution(this);

		return posessiontype;
	}

	public Posessiontype removePosessiontype(Posessiontype posessiontype) {
		getPosessiontypes().remove(posessiontype);
		posessiontype.setInstitution(null);

		return posessiontype;
	}

}