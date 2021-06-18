package co.edu.icesi.front.model.classes;

public class Documentt{
	
	private static final long serialVersionUID = 1L;

	private long docId;

	private String docIspositive;

	private String docName;

	private String docUrl;

	private Documenttype documenttype;

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