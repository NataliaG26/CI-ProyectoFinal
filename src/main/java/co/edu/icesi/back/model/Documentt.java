package co.edu.icesi.back.model;

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
 * The persistent class for the DOCUMENTT database table.
 * 
 */
@Entity
@NamedQuery(name="Documentt.findAll", query="SELECT d FROM Documentt d")
public class Documentt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="DOCUMENTT_DOCID_GENERATOR", sequenceName="DOCUMENTT_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DOCUMENTT_DOCID_GENERATOR")
	@Column(name="DOC_ID")
	private long docId;

	@Column(name="DOC_ISPOSITIVE")
	private String docIspositive;

	@Column(name="DOC_NAME")
	private String docName;

	@Column(name="DOC_URL")
	private String docUrl;

	//bi-directional many-to-one association to Docstateinstance
	@OneToMany(mappedBy="documentt")
	private List<Docstateinstance> docstateinstances;

	//bi-directional many-to-one association to Documenttype
	@ManyToOne
	@JoinColumn(name="DOCTYPE_DOCTYPE_ID")
	private Documenttype documenttype;

	//bi-directional many-to-one association to Person
	@ManyToOne
	@JoinColumn(name="PERS_PERS_ID")
	private Person person;

	public Documentt() {
	}

	public long getDocId() {
		return this.docId;
	}

	public void setDocId(long docId) {
		this.docId = docId;
	}

	public String getDocIspositive() {
		return this.docIspositive;
	}

	public void setDocIspositive(String docIspositive) {
		this.docIspositive = docIspositive;
	}

	public String getDocName() {
		return this.docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public String getDocUrl() {
		return this.docUrl;
	}

	public void setDocUrl(String docUrl) {
		this.docUrl = docUrl;
	}

	public List<Docstateinstance> getDocstateinstances() {
		return this.docstateinstances;
	}

	public void setDocstateinstances(List<Docstateinstance> docstateinstances) {
		this.docstateinstances = docstateinstances;
	}

	public Docstateinstance addDocstateinstance(Docstateinstance docstateinstance) {
		getDocstateinstances().add(docstateinstance);
		docstateinstance.setDocumentt(this);

		return docstateinstance;
	}

	public Docstateinstance removeDocstateinstance(Docstateinstance docstateinstance) {
		getDocstateinstances().remove(docstateinstance);
		docstateinstance.setDocumentt(null);

		return docstateinstance;
	}

	public Documenttype getDocumenttype() {
		return this.documenttype;
	}

	public void setDocumenttype(Documenttype documenttype) {
		this.documenttype = documenttype;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}