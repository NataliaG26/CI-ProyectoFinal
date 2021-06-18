package co.edu.icesi.front.model.classes;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Autotransition{
	
	private static final long serialVersionUID = 1L;

	private long autotranId;

	private String autotranIsactive;

	private String autotranLogicaloperand;

	private String autotranName;

	private BigDecimal instInstId;
/*
	private Eventstatus eventstatus1;

	private Eventstatus eventstatus2; */
	
//	@JsonIgnore
//	private List<Personautotran> personautotrans;

	public Autotransition() {
	}

	public long getAutotranId() {
		return this.autotranId;
	}

	public void setAutotranId(long autotranId) {
		this.autotranId = autotranId;
	}

	public String getAutotranIsactive() {
		return this.autotranIsactive;
	}

	public void setAutotranIsactive(String autotranIsactive) {
		this.autotranIsactive = autotranIsactive;
	}

	public String getAutotranLogicaloperand() {
		return this.autotranLogicaloperand;
	}

	public void setAutotranLogicaloperand(String autotranLogicaloperand) {
		this.autotranLogicaloperand = autotranLogicaloperand;
	}

	public String getAutotranName() {
		return this.autotranName;
	}

	public void setAutotranName(String autotranName) {
		this.autotranName = autotranName;
	}

	public BigDecimal getInstInstId() {
		return this.instInstId;
	}

	public void setInstInstId(BigDecimal instInstId) {
		this.instInstId = instInstId;
	}
/*
	public Eventstatus getEventstatus1() {
		return this.eventstatus1;
	}

	public void setEventstatus1(Eventstatus eventstatus1) {
		this.eventstatus1 = eventstatus1;
	}

	public Eventstatus getEventstatus2() {
		return this.eventstatus2;
	}

	public void setEventstatus2(Eventstatus eventstatus2) {
		this.eventstatus2 = eventstatus2;
	} */

//	public List<Personautotran> getPersonautotrans() {
//		return this.personautotrans;
//	}
//
//	public void setPersonautotrans(List<Personautotran> personautotrans) {
//		this.personautotrans = personautotrans;
//	}
//
//	public Personautotran addPersonautotran(Personautotran personautotran) {
//		getPersonautotrans().add(personautotran);
//		personautotran.setAutotransition(this);
//
//		return personautotran;
//	}
//
//	public Personautotran removePersonautotran(Personautotran personautotran) {
//		getPersonautotrans().remove(personautotran);
//		personautotran.setAutotransition(null);
//
//		return personautotran;
//	}
	
	
}