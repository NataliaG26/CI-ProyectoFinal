package co.edu.icesi.back.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the FET_ACTIVENODE database table.
 * 
 */
@Entity
@Table(name="FET_ACTIVENODE")
@NamedQuery(name="FetActivenode.findAll", query="SELECT f FROM FetActivenode f")
public class FetActivenode implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="FET_ACTIVENODE_ACTNODEID_GENERATOR", sequenceName="FET_ACTIVENODE_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="FET_ACTIVENODE_ACTNODEID_GENERATOR")
	@Column(name="ACTNODE_ID")
	private long actnodeId;

	@Temporal(TemporalType.DATE)
	@Column(name="ACTNODE_DATE")
	private Date actnodeDate;

	@Column(name="ACTNODE_NUMBER")
	private BigDecimal actnodeNumber;

	public FetActivenode() {
	}

	public long getActnodeId() {
		return this.actnodeId;
	}

	public void setActnodeId(long actnodeId) {
		this.actnodeId = actnodeId;
	}

	public Date getActnodeDate() {
		return this.actnodeDate;
	}

	public void setActnodeDate(Date actnodeDate) {
		this.actnodeDate = actnodeDate;
	}

	public BigDecimal getActnodeNumber() {
		return this.actnodeNumber;
	}

	public void setActnodeNumber(BigDecimal actnodeNumber) {
		this.actnodeNumber = actnodeNumber;
	}

}