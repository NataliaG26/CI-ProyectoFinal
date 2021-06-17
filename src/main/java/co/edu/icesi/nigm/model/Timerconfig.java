package co.edu.icesi.nigm.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;


/**
 * The persistent class for the TIMERCONFIG database table.
 * 
 */
@Entity
@NamedQuery(name="Timerconfig.findAll", query="SELECT t FROM Timerconfig t")
public class Timerconfig implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TIMERCONFIG_TIMCONID_GENERATOR", sequenceName="TIMERCONFIG_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TIMERCONFIG_TIMCONID_GENERATOR")
	@Column(name="TIMCON_ID")
	private long timconId;

	@Column(name="INST_INST_ID")
	private BigDecimal instInstId;

	@Column(name="TIMCON_TIMERSTRING")
	private String timconTimerstring;

	//bi-directional many-to-one association to Task
	@ManyToOne
	private Task task;

	public Timerconfig() {
	}

	public long getTimconId() {
		return this.timconId;
	}

	public void setTimconId(long timconId) {
		this.timconId = timconId;
	}

	public BigDecimal getInstInstId() {
		return this.instInstId;
	}

	public void setInstInstId(BigDecimal instInstId) {
		this.instInstId = instInstId;
	}

	public String getTimconTimerstring() {
		return this.timconTimerstring;
	}

	public void setTimconTimerstring(String timconTimerstring) {
		this.timconTimerstring = timconTimerstring;
	}

	public Task getTask() {
		return this.task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

}