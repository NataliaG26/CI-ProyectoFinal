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
 * The persistent class for the EPIDEMSTATUS database table.
 * 
 */
@Entity
@NamedQuery(name="Epidemstatus.findAll", query="SELECT e FROM Epidemstatus e")
public class Epidemstatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EPIDEMSTATUS_EPISTATID_GENERATOR", sequenceName="EPIDEMSTATUS_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EPIDEMSTATUS_EPISTATID_GENERATOR")
	@Column(name="EPISTAT_ID")
	private long epistatId;

	@Column(name="EPISTAT_NAME")
	private String epistatName;

	//bi-directional many-to-one association to Eventstatus
	@OneToMany(mappedBy="epidemstatus")
	private List<Eventstatus> eventstatuses;

	public Epidemstatus() {
	}

	public long getEpistatId() {
		return this.epistatId;
	}

	public void setEpistatId(long epistatId) {
		this.epistatId = epistatId;
	}

	public String getEpistatName() {
		return this.epistatName;
	}

	public void setEpistatName(String epistatName) {
		this.epistatName = epistatName;
	}

	public List<Eventstatus> getEventstatuses() {
		return this.eventstatuses;
	}

	public void setEventstatuses(List<Eventstatus> eventstatuses) {
		this.eventstatuses = eventstatuses;
	}

	public Eventstatus addEventstatus(Eventstatus eventstatus) {
		getEventstatuses().add(eventstatus);
		eventstatus.setEpidemstatus(this);

		return eventstatus;
	}

	public Eventstatus removeEventstatus(Eventstatus eventstatus) {
		getEventstatuses().remove(eventstatus);
		eventstatus.setEpidemstatus(null);

		return eventstatus;
	}

}