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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the QUEUEDISABLEFENCE database table.
 * 
 */
@Entity
@NamedQuery(name="Queuedisablefence.findAll", query="SELECT q FROM Queuedisablefence q")
public class Queuedisablefence implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="QUEUEDISABLEFENCE_QUEDISFENID_GENERATOR", sequenceName="QUEUEDISABLEFENCE_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="QUEUEDISABLEFENCE_QUEDISFENID_GENERATOR")
	@Column(name="QUEDISFEN_ID")
	private long quedisfenId;

	@Column(name="INST_INST_ID")
	private BigDecimal instInstId;

	@Temporal(TemporalType.DATE)
	@Column(name="QUEDISFEN_PUSHDATE")
	private Date quedisfenPushdate;

	//bi-directional many-to-one association to Contactfence
	@ManyToOne
	@JoinColumn(name="CONTFEN_CONTFEN_ID")
	private Contactfence contactfence;

	//bi-directional many-to-one association to Personautotran
	@ManyToOne
	@JoinColumn(name="PERAUT_PERAUT_ID")
	private Personautotran personautotran;

	public Queuedisablefence() {
	}

	public long getQuedisfenId() {
		return this.quedisfenId;
	}

	public void setQuedisfenId(long quedisfenId) {
		this.quedisfenId = quedisfenId;
	}

	public BigDecimal getInstInstId() {
		return this.instInstId;
	}

	public void setInstInstId(BigDecimal instInstId) {
		this.instInstId = instInstId;
	}

	public Date getQuedisfenPushdate() {
		return this.quedisfenPushdate;
	}

	public void setQuedisfenPushdate(Date quedisfenPushdate) {
		this.quedisfenPushdate = quedisfenPushdate;
	}

	public Contactfence getContactfence() {
		return this.contactfence;
	}

	public void setContactfence(Contactfence contactfence) {
		this.contactfence = contactfence;
	}

	public Personautotran getPersonautotran() {
		return this.personautotran;
	}

	public void setPersonautotran(Personautotran personautotran) {
		this.personautotran = personautotran;
	}

}