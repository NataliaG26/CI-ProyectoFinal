package co.edu.icesi.back.model;

import java.io.Serializable;
import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the UST_SOCIALCLOSECONTACT database table.
 * 
 */
@Entity
@Table(name="UST_SOCIALCLOSECONTACT")
@NamedQuery(name="UstSocialclosecontact.findAll", query="SELECT u FROM UstSocialclosecontact u")
public class UstSocialclosecontact implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="UST_SOCIALCLOSECONTACT_SOCIALID_GENERATOR", sequenceName="UST_SOCIALCLOSECONTACT_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="UST_SOCIALCLOSECONTACT_SOCIALID_GENERATOR")
	@Column(name="SOCIAL_ID")
	private long socialId;

	@Temporal(TemporalType.DATE)
	@Column(name="SOCIAL_LASTCONTACTDATE")
	private Date socialLastcontactdate;

	@Column(name="SOCIAL_NAME")
	private String socialName;

	//bi-directional many-to-one association to Person
	@ManyToOne
	@JoinColumn(name="PERS_PERS_ID")
	private Person person;

	public UstSocialclosecontact() {
	}

	public long getSocialId() {
		return this.socialId;
	}

	public void setSocialId(long socialId) {
		this.socialId = socialId;
	}

	public Date getSocialLastcontactdate() {
		return this.socialLastcontactdate;
	}

	public void setSocialLastcontactdate(Date socialLastcontactdate) {
		this.socialLastcontactdate = socialLastcontactdate;
	}

	public String getSocialName() {
		return this.socialName;
	}

	public void setSocialName(String socialName) {
		this.socialName = socialName;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}