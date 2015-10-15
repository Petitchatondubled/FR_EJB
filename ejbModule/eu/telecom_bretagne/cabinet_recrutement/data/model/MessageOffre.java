package eu.telecom_bretagne.cabinet_recrutement.data.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the message_offre database table.
 * 
 */
@Entity
@Table(name="message_offre")
@NamedQuery(name="MessageOffre.findAll", query="SELECT m FROM MessageOffre m")
public class MessageOffre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MESSAGE_OFFRE_NUMMSG_GENERATOR", sequenceName="MESSAGE_OFFRE_NUM_MSG_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MESSAGE_OFFRE_NUMMSG_GENERATOR")
	@Column(name="num_msg")
	private Integer numMsg;

	@Column(name="corps_msg")
	private String corpsMsg;

	@Temporal(TemporalType.DATE)
	@Column(name="date_envoi")
	private Date dateEnvoi;

	//bi-directional many-to-one association to Candidature
	@ManyToOne
	@JoinColumn(name="num_cand")
	private Candidature candidature;

	//bi-directional many-to-one association to OffreEmploi
	@ManyToOne
	@JoinColumn(name="num_offre")
	private OffreEmploi offreEmploi;

	public MessageOffre() {
	}

	public Integer getNumMsg() {
		return this.numMsg;
	}

	public void setNumMsg(Integer numMsg) {
		this.numMsg = numMsg;
	}

	public String getCorpsMsg() {
		return this.corpsMsg;
	}

	public void setCorpsMsg(String corpsMsg) {
		this.corpsMsg = corpsMsg;
	}

	public Date getDateEnvoi() {
		return this.dateEnvoi;
	}

	public void setDateEnvoi(Date dateEnvoi) {
		this.dateEnvoi = dateEnvoi;
	}

	public Candidature getCandidature() {
		return this.candidature;
	}

	public void setCandidature(Candidature candidature) {
		this.candidature = candidature;
	}

	public OffreEmploi getOffreEmploi() {
		return this.offreEmploi;
	}

	public void setOffreEmploi(OffreEmploi offreEmploi) {
		this.offreEmploi = offreEmploi;
	}

}