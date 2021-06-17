package co.edu.icesi.back.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the FET_TASKINSTANCE database table.
 * 
 */
@Entity
@Table(name="FET_TASKINSTANCE")
@NamedQuery(name="FetTaskinstance.findAll", query="SELECT f FROM FetTaskinstance f")
public class FetTaskinstance implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="FET_TASKINSTANCE_TASKINSID_GENERATOR", sequenceName="FET_TASKINSTANCE_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="FET_TASKINSTANCE_TASKINSID_GENERATOR")
	@Column(name="TASKINS_ID")
	private long taskinsId;

	@Temporal(TemporalType.DATE)
	@Column(name="TASKINS_EXECUTIONDATE")
	private Date taskinsExecutiondate;

	@Column(name="TASKINS_TARGETTYPE")
	private String taskinsTargettype;

	@Column(name="TASKINS_TARGETVALUE")
	private BigDecimal taskinsTargetvalue;

	//bi-directional many-to-one association to Task
	@ManyToOne
	private Task task;

	public FetTaskinstance() {
	}

	public long getTaskinsId() {
		return this.taskinsId;
	}

	public void setTaskinsId(long taskinsId) {
		this.taskinsId = taskinsId;
	}

	public Date getTaskinsExecutiondate() {
		return this.taskinsExecutiondate;
	}

	public void setTaskinsExecutiondate(Date taskinsExecutiondate) {
		this.taskinsExecutiondate = taskinsExecutiondate;
	}

	public String getTaskinsTargettype() {
		return this.taskinsTargettype;
	}

	public void setTaskinsTargettype(String taskinsTargettype) {
		this.taskinsTargettype = taskinsTargettype;
	}

	public BigDecimal getTaskinsTargetvalue() {
		return this.taskinsTargetvalue;
	}

	public void setTaskinsTargetvalue(BigDecimal taskinsTargetvalue) {
		this.taskinsTargetvalue = taskinsTargetvalue;
	}

	public Task getTask() {
		return this.task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

}