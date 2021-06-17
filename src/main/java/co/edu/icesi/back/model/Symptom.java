package co.edu.icesi.back.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;


/**
 * The persistent class for the SYMPTOM database table.
 * 
 */
@Entity
@NamedQuery(name="Symptom.findAll", query="SELECT s FROM Symptom s")
public class Symptom implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SYMPTOM_SYMPID_GENERATOR", sequenceName="SYMPTOM_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SYMPTOM_SYMPID_GENERATOR")
	@Column(name="SYMP_ID")
	private long sympId;

	@Column(name="SYMP_ISACTIVE")
	private String sympIsactive;

	@Column(name="SYMP_NAME")
	private String sympName;

	//bi-directional many-to-one association to DenialSymptom
	@OneToMany(mappedBy="symptom")
	private List<DenialSymptom> denialSymptoms;

	//bi-directional many-to-one association to Symptomquestion
	@OneToMany(mappedBy="symptom")
	private List<Symptomquestion> symptomquestions;

	public Symptom() {
	}

	public long getSympId() {
		return this.sympId;
	}

	public void setSympId(long sympId) {
		this.sympId = sympId;
	}

	public String getSympIsactive() {
		return this.sympIsactive;
	}

	public void setSympIsactive(String sympIsactive) {
		this.sympIsactive = sympIsactive;
	}

	public String getSympName() {
		return this.sympName;
	}

	public void setSympName(String sympName) {
		this.sympName = sympName;
	}

	public List<DenialSymptom> getDenialSymptoms() {
		return this.denialSymptoms;
	}

	public void setDenialSymptoms(List<DenialSymptom> denialSymptoms) {
		this.denialSymptoms = denialSymptoms;
	}

	public DenialSymptom addDenialSymptom(DenialSymptom denialSymptom) {
		getDenialSymptoms().add(denialSymptom);
		denialSymptom.setSymptom(this);

		return denialSymptom;
	}

	public DenialSymptom removeDenialSymptom(DenialSymptom denialSymptom) {
		getDenialSymptoms().remove(denialSymptom);
		denialSymptom.setSymptom(null);

		return denialSymptom;
	}

	public List<Symptomquestion> getSymptomquestions() {
		return this.symptomquestions;
	}

	public void setSymptomquestions(List<Symptomquestion> symptomquestions) {
		this.symptomquestions = symptomquestions;
	}

	public Symptomquestion addSymptomquestion(Symptomquestion symptomquestion) {
		getSymptomquestions().add(symptomquestion);
		symptomquestion.setSymptom(this);

		return symptomquestion;
	}

	public Symptomquestion removeSymptomquestion(Symptomquestion symptomquestion) {
		getSymptomquestions().remove(symptomquestion);
		symptomquestion.setSymptom(null);

		return symptomquestion;
	}

}