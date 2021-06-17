package co.edu.icesi.nigm.model;

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
 * The persistent class for the UST_PARAMETER database table.
 * 
 */
@Entity
@Table(name="UST_PARAMETER")
@NamedQuery(name="UstParameter.findAll", query="SELECT u FROM UstParameter u")
public class UstParameter implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="UST_PARAMETER_PARAMID_GENERATOR", sequenceName="UST_PARAMETER_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="UST_PARAMETER_PARAMID_GENERATOR")
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

	public UstParameter() {
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