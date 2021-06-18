package co.edu.icesi.front.model.classes;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Documenttype{
	
	private static final long serialVersionUID = 1L;

	private long doctypeId;

	private String doctypeIsactive;

	private String doctypeName;

	private BigDecimal instInstId;
	
	@JsonIgnore
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
