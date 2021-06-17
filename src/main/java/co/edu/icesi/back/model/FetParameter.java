package co.edu.icesi.back.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * The persistent class for the FET_PARAMETER database table.
 * 
 */
@Entity
@Table(name="FET_PARAMETER")
@NamedQuery(name="FetParameter.findAll", query="SELECT f FROM FetParameter f")
public class FetParameter implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="FET_PARAMETER_PARAMID_GENERATOR", sequenceName="FET_PARAMETER_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="FET_PARAMETER_PARAMID_GENERATOR")
	@Column(name="PARAM_ID")
	private long paramId;

	@Column(name="INST_INST_ID")
	private BigDecimal instInstId;

	@Column(name="PARAM_NAME")
	private String paramName;

	@Column(name="PARAM_TYPE")
	private String paramType;

	@Column(name="PARAM_VALUE")
	private String paramValue;

	public FetParameter() {
	}

	public long getParamId() {
		return this.paramId;
	}

	public void setParamId(long paramId) {
		this.paramId = paramId;
	}

	public BigDecimal getInstInstId() {
		return this.instInstId;
	}

	public void setInstInstId(BigDecimal instInstId) {
		this.instInstId = instInstId;
	}

	public String getParamName() {
		return this.paramName;
	}

	public void setParamName(String paramName) {
		this.paramName = paramName;
	}

	public String getParamType() {
		return this.paramType;
	}

	public void setParamType(String paramType) {
		this.paramType = paramType;
	}

	public String getParamValue() {
		return this.paramValue;
	}

	public void setParamValue(String paramValue) {
		this.paramValue = paramValue;
	}

}