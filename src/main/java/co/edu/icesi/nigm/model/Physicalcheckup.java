package co.edu.icesi.nigm.model;

import java.io.Serializable;
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


/**
 * The persistent class for the PHYSICALCHECKUP database table.
 * 
 */
@Entity
@NamedQuery(name="Physicalcheckup.findAll", query="SELECT p FROM Physicalcheckup p")
public class Physicalcheckup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PHYSICALCHECKUP_PHYCHEID_GENERATOR", sequenceName="PHYSICALCHECKUP_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PHYSICALCHECKUP_PHYCHEID_GENERATOR")
	@Column(name="PHYCHE_ID")
	private long phycheId;

	@Temporal(TemporalType.DATE)
	@Column(name="PHYCHE_DATE")
	private Date phycheDate;

	//bi-directional many-to-one association to CheckMeasur
	@OneToMany(mappedBy="physicalcheckup")
	private List<CheckMeasur> checkMeasurs;

	//bi-directional many-to-one association to Person
	@ManyToOne
	@JoinColumn(name="PERS_PERS_ID")
	private Person person;

	//bi-directional many-to-one association to Visit
	@ManyToOne
	private Visit visit;

	public Physicalcheckup() {
	}

	public long getPhycheId() {
		return this.phycheId;
	}

	public void setPhycheId(long phycheId) {
		this.phycheId = phycheId;
	}

	public Date getPhycheDate() {
		return this.phycheDate;
	}

	public void setPhycheDate(Date phycheDate) {
		this.phycheDate = phycheDate;
	}

	public List<CheckMeasur> getCheckMeasurs() {
		return this.checkMeasurs;
	}

	public void setCheckMeasurs(List<CheckMeasur> checkMeasurs) {
		this.checkMeasurs = checkMeasurs;
	}

	public CheckMeasur addCheckMeasur(CheckMeasur checkMeasur) {
		getCheckMeasurs().add(checkMeasur);
		checkMeasur.setPhysicalcheckup(this);

		return checkMeasur;
	}

	public CheckMeasur removeCheckMeasur(CheckMeasur checkMeasur) {
		getCheckMeasurs().remove(checkMeasur);
		checkMeasur.setPhysicalcheckup(null);

		return checkMeasur;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Visit getVisit() {
		return this.visit;
	}

	public void setVisit(Visit visit) {
		this.visit = visit;
	}

}