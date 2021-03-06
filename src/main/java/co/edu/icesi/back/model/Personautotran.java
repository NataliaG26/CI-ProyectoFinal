package co.edu.icesi.back.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the PERSONAUTOTRAN database table.
 * 
 */
@Entity
@NamedQuery(name="Personautotran.findAll", query="SELECT p FROM Personautotran p")
public class Personautotran implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PERSONAUTOTRAN_PERAUTID_GENERATOR", sequenceName="PERSONAUTOTRAN_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PERSONAUTOTRAN_PERAUTID_GENERATOR")
	@Column(name="PERAUT_ID")
	private long perautId;

	@Column(name="PERAUT_DATE")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate perautDate;

	//bi-directional many-to-one association to Autotransition
	@ManyToOne
	@JoinColumn(name="AUTOTRAN_AUTOTRAN_ID")
	private Autotransition autotransition;

	//bi-directional many-to-one association to Person
	@ManyToOne
	@JoinColumn(name="PERS_PERS_ID")
	private Person person;
	
	private long personId;
	
	private long autotranId;
	@JsonIgnore
	//bi-directional many-to-one association to Queuecreatefence
	@OneToMany(mappedBy="personautotran")
	private List<Queuecreatefence> queuecreatefences;
	@JsonIgnore
	//bi-directional many-to-one association to Queuecreatefencehistory
	@OneToMany(mappedBy="personautotran")
	private List<Queuecreatefencehistory> queuecreatefencehistories;
	@JsonIgnore
	//bi-directional many-to-one association to Queuedisablefence
	@OneToMany(mappedBy="personautotran")
	private List<Queuedisablefence> queuedisablefences;
	@JsonIgnore
	//bi-directional many-to-one association to Queuedisablefencehistory
	@OneToMany(mappedBy="personautotran")
	private List<Queuedisablefencehistory> queuedisablefencehistories;

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

	public List<Queuecreatefence> getQueuecreatefences() {
		return this.queuecreatefences;
	}

	public void setQueuecreatefences(List<Queuecreatefence> queuecreatefences) {
		this.queuecreatefences = queuecreatefences;
	}

	public Queuecreatefence addQueuecreatefence(Queuecreatefence queuecreatefence) {
		getQueuecreatefences().add(queuecreatefence);
		queuecreatefence.setPersonautotran(this);

		return queuecreatefence;
	}

	public Queuecreatefence removeQueuecreatefence(Queuecreatefence queuecreatefence) {
		getQueuecreatefences().remove(queuecreatefence);
		queuecreatefence.setPersonautotran(null);

		return queuecreatefence;
	}

	public List<Queuecreatefencehistory> getQueuecreatefencehistories() {
		return this.queuecreatefencehistories;
	}

	public void setQueuecreatefencehistories(List<Queuecreatefencehistory> queuecreatefencehistories) {
		this.queuecreatefencehistories = queuecreatefencehistories;
	}

	public Queuecreatefencehistory addQueuecreatefencehistory(Queuecreatefencehistory queuecreatefencehistory) {
		getQueuecreatefencehistories().add(queuecreatefencehistory);
		queuecreatefencehistory.setPersonautotran(this);

		return queuecreatefencehistory;
	}

	public Queuecreatefencehistory removeQueuecreatefencehistory(Queuecreatefencehistory queuecreatefencehistory) {
		getQueuecreatefencehistories().remove(queuecreatefencehistory);
		queuecreatefencehistory.setPersonautotran(null);

		return queuecreatefencehistory;
	}

	public List<Queuedisablefence> getQueuedisablefences() {
		return this.queuedisablefences;
	}

	public void setQueuedisablefences(List<Queuedisablefence> queuedisablefences) {
		this.queuedisablefences = queuedisablefences;
	}

	public Queuedisablefence addQueuedisablefence(Queuedisablefence queuedisablefence) {
		getQueuedisablefences().add(queuedisablefence);
		queuedisablefence.setPersonautotran(this);

		return queuedisablefence;
	}

	public Queuedisablefence removeQueuedisablefence(Queuedisablefence queuedisablefence) {
		getQueuedisablefences().remove(queuedisablefence);
		queuedisablefence.setPersonautotran(null);

		return queuedisablefence;
	}

	public List<Queuedisablefencehistory> getQueuedisablefencehistories() {
		return this.queuedisablefencehistories;
	}

	public void setQueuedisablefencehistories(List<Queuedisablefencehistory> queuedisablefencehistories) {
		this.queuedisablefencehistories = queuedisablefencehistories;
	}

	public Queuedisablefencehistory addQueuedisablefencehistory(Queuedisablefencehistory queuedisablefencehistory) {
		getQueuedisablefencehistories().add(queuedisablefencehistory);
		queuedisablefencehistory.setPersonautotran(this);

		return queuedisablefencehistory;
	}

	public Queuedisablefencehistory removeQueuedisablefencehistory(Queuedisablefencehistory queuedisablefencehistory) {
		getQueuedisablefencehistories().remove(queuedisablefencehistory);
		queuedisablefencehistory.setPersonautotran(null);

		return queuedisablefencehistory;
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