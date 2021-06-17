package co.edu.icesi.nigm.model;

import java.io.Serializable;
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


/**
 * The persistent class for the POSESSIONTYPE database table.
 * 
 */
@Entity
@NamedQuery(name="Posessiontype.findAll", query="SELECT p FROM Posessiontype p")
public class Posessiontype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="POSESSIONTYPE_POSTYPEID_GENERATOR", sequenceName="POSESSIONTYPE_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="POSESSIONTYPE_POSTYPEID_GENERATOR")
	@Column(name="POSTYPE_ID")
	private long postypeId;

	@Column(name="POSTYPE_NAME")
	private String postypeName;

	//bi-directional many-to-one association to Posession
	@OneToMany(mappedBy="posessiontype")
	private List<Posession> posessions;

	//bi-directional many-to-one association to Institution
	@ManyToOne
	@JoinColumn(name="INST_INST_ID")
	private Institution institution;

	public Posessiontype() {
	}

	public long getPostypeId() {
		return this.postypeId;
	}

	public void setPostypeId(long postypeId) {
		this.postypeId = postypeId;
	}

	public String getPostypeName() {
		return this.postypeName;
	}

	public void setPostypeName(String postypeName) {
		this.postypeName = postypeName;
	}

	public List<Posession> getPosessions() {
		return this.posessions;
	}

	public void setPosessions(List<Posession> posessions) {
		this.posessions = posessions;
	}

	public Posession addPosession(Posession posession) {
		getPosessions().add(posession);
		posession.setPosessiontype(this);

		return posession;
	}

	public Posession removePosession(Posession posession) {
		getPosessions().remove(posession);
		posession.setPosessiontype(null);

		return posession;
	}

	public Institution getInstitution() {
		return this.institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

}