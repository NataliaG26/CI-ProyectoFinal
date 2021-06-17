package co.edu.icesi.back.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
 * The persistent class for the UST_PERSON_STATUS database table.
 * 
 */
@Entity
@Table(name="UST_PERSON_STATUS")
@NamedQuery(name="UstPersonStatus.findAll", query="SELECT u FROM UstPersonStatus u")
public class UstPersonStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="UST_PERSON_STATUS_PERSTAID_GENERATOR", sequenceName="UST_PERSON_STATUS_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="UST_PERSON_STATUS_PERSTAID_GENERATOR")
	@Column(name="PERSTA_ID")
	private long perstaId;

	@Temporal(TemporalType.DATE)
	private Date enddate;

	@Column(name="EVESTAT_EVESTAT_ID")
	private BigDecimal evestatEvestatId;

	@Temporal(TemporalType.DATE)
	private Date startdate;

	//bi-directional many-to-one association to Person
	@ManyToOne
	@JoinColumn(name="PERS_PERS_ID")
	private Person person;

	public UstPersonStatus() {
	}

	public long getPerstaId() {
		return this.perstaId;
	}

	public void setPerstaId(long perstaId) {
		this.perstaId = perstaId;
	}

	public Date getEnddate() {
		return this.enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public BigDecimal getEvestatEvestatId() {
		return this.evestatEvestatId;
	}

	public void setEvestatEvestatId(BigDecimal evestatEvestatId) {
		this.evestatEvestatId = evestatEvestatId;
	}

	public Date getStartdate() {
		return this.startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}