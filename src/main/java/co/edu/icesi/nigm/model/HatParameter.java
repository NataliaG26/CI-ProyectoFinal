package co.edu.icesi.nigm.model;

import java.io.Serializable;

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


/**
 * The persistent class for the HAT_PARAMETER database table.
 * 
 */
@Entity
@Table(name="HAT_PARAMETER")
@NamedQuery(name="HatParameter.findAll", query="SELECT h FROM HatParameter h")
public class HatParameter implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="HAT_PARAMETER_PARAMID_GENERATOR", sequenceName="HAT_PARAMETER_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HAT_PARAMETER_PARAMID_GENERATOR")
	@Column(name="PARAM_ID")
	private long paramId;

	@Column(name="PARAM_NAME")
	private String paramName;

	@Column(name="PARAM_TYPE")
	private String paramType;

	@Column(name="PARAM_VALUE")
	private String paramValue;

	//bi-directional many-to-one association to Institution
	@ManyToOne
	@JoinColumn(name="INST_INST_ID")
	private Institution institution;

	public HatParameter() {
	}

	public long getParamId() {
		return this.paramId;
	}

	public void setParamId(long paramId) {
		this.paramId = paramId;
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

	public Institution getInstitution() {
		return this.institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

}