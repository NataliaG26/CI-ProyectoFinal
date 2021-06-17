package co.edu.icesi.nigm.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the UST_PERSON_SYMPTOM database table.
 * 
 */
@Entity
@Table(name="UST_PERSON_SYMPTOM")
@NamedQuery(name="UstPersonSymptom.findAll", query="SELECT u FROM UstPersonSymptom u")
public class UstPersonSymptom implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="UST_PERSON_SYMPTOM_PERSSYMPID_GENERATOR", sequenceName="UST_PERSON_SYMPTOM_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="UST_PERSON_SYMPTOM_PERSSYMPID_GENERATOR")
	@Column(name="PERSSYMP_ID")
	private long perssympId;

	private String answer;

	@Temporal(TemporalType.DATE)
	private Date answerdate;

	@Temporal(TemporalType.DATE)
	private Date answerexpiration;

	@Temporal(TemporalType.DATE)
	private Date lastdateanswchanged;

	//bi-directional many-to-one association to Person
	@ManyToOne
	@JoinColumn(name="PERS_PERS_ID")
	private Person person;

	//bi-directional many-to-one association to Symptomquestion
	@ManyToOne
	@JoinColumn(name="SYMPQUES_SYMPQUES_ID")
	private Symptomquestion symptomquestion;

	public UstPersonSymptom() {
	}

	public long getPerssympId() {
		return this.perssympId;
	}

	public void setPerssympId(long perssympId) {
		this.perssympId = perssympId;
	}

	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Date getAnswerdate() {
		return this.answerdate;
	}

	public void setAnswerdate(Date answerdate) {
		this.answerdate = answerdate;
	}

	public Date getAnswerexpiration() {
		return this.answerexpiration;
	}

	public void setAnswerexpiration(Date answerexpiration) {
		this.answerexpiration = answerexpiration;
	}

	public Date getLastdateanswchanged() {
		return this.lastdateanswchanged;
	}

	public void setLastdateanswchanged(Date lastdateanswchanged) {
		this.lastdateanswchanged = lastdateanswchanged;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Symptomquestion getSymptomquestion() {
		return this.symptomquestion;
	}

	public void setSymptomquestion(Symptomquestion symptomquestion) {
		this.symptomquestion = symptomquestion;
	}

}