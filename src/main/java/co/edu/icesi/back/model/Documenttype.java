package co.edu.icesi.back.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the DOCUMENTTYPE database table.
 * 
 */
@Entity
@NamedQuery(name="Documenttype.findAll", query="SELECT d FROM Documenttype d")
public class Documenttype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="DOCUMENTTYPE_DOCTYPEID_GENERATOR", sequenceName="DOCUMENTTYPE_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DOCUMENTTYPE_DOCTYPEID_GENERATOR")
	@Column(name="DOCTYPE_ID")
	private long doctypeId;

	@Column(name="DOCTYPE_ISACTIVE")
	private String doctypeIsactive;

	@Column(name="DOCTYPE_NAME")
	private String doctypeName;

	@Column(name="INST_INST_ID")
	private BigDecimal instInstId;
	
	@JsonIgnore
	//bi-directional many-to-one association to Documentstate
	@OneToMany(mappedBy="documenttype")
	private List<Documentstate> documentstates;
	
	@JsonIgnore
	//bi-directional many-to-one association to Documentt
	@OneToMany(mappedBy="documenttype")
	private List<Documentt> documentts;

	public Documenttype() {
	}

	public long getDoctypeId() {
		return this.doctypeId;
	}

	public void setDoctypeId(long doctypeId) {
		this.doctypeId = doctypeId;
	}

	public String getDoctypeIsactive() {
		return this.doctypeIsactive;
	}

	public void setDoctypeIsactive(String doctypeIsactive) {
		this.doctypeIsactive = doctypeIsactive;
	}

	public String getDoctypeName() {
		return this.doctypeName;
	}

	public void setDoctypeName(String doctypeName) {
		this.doctypeName = doctypeName;
	}

	public BigDecimal getInstInstId() {
		return this.instInstId;
	}

	public void setInstInstId(BigDecimal instInstId) {
		this.instInstId = instInstId;
	}

	public List<Documentstate> getDocumentstates() {
		return this.documentstates;
	}

	public void setDocumentstates(List<Documentstate> documentstates) {
		this.documentstates = documentstates;
	}

	public Documentstate addDocumentstate(Documentstate documentstate) {
		getDocumentstates().add(documentstate);
		documentstate.setDocumenttype(this);

		return documentstate;
	}

	public Documentstate removeDocumentstate(Documentstate documentstate) {
		getDocumentstates().remove(documentstate);
		documentstate.setDocumenttype(null);

		return documentstate;
	}

	public List<Documentt> getDocumentts() {
		return this.documentts;
	}

	public void setDocumentts(List<Documentt> documentts) {
		this.documentts = documentts;
	}

	public Documentt addDocumentt(Documentt documentt) {
		getDocumentts().add(documentt);
		documentt.setDocumenttype(this);

		return documentt;
	}

	public Documentt removeDocumentt(Documentt documentt) {
		getDocumentts().remove(documentt);
		documentt.setDocumenttype(null);

		return documentt;
	}

}