package eu.telecom_bretagne.cabinet_recrutement.data.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the candidature database table.
 * 
 */
@Entity
@NamedQuery(name="Candidature.findAll", query="SELECT c FROM Candidature c")
public class Candidature implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CANDIDATURE_NUMCAND_GENERATOR", sequenceName="CANDIDATURE_NUM_CAND_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CANDIDATURE_NUMCAND_GENERATOR")
	@Column(name="num_cand")
	private Integer numCand;

	@Column(name="adresse_mail")
	private String adresseMail;

	@Column(name="adresse_postale")
	private String adressePostale;

	private String cv;

	@Temporal(TemporalType.DATE)
	@Column(name="date_depot")
	private Date dateDepot;

	@Temporal(TemporalType.DATE)
	@Column(name="date_naiss")
	private Date dateNaiss;

	private String nom;

	private String prenom;

	//bi-directional many-to-one association to NiveauQualification
	@ManyToOne
	@JoinColumn(name="qualification")
	private NiveauQualification niveauQualification;

	//bi-directional many-to-one association to MessageCand
	@OneToMany(mappedBy="candidature")
	private Set<MessageCand> messageCands;

	//bi-directional many-to-one association to MessageOffre
	@OneToMany(mappedBy="candidature")
	private Set<MessageOffre> messageOffres;

	//bi-directional many-to-many association to SecteurActivite
	@ManyToMany(mappedBy="candidatures")
	private Set<SecteurActivite> secteurActivites;

	public Candidature() {
	}

	public Integer getNumCand() {
		return this.numCand;
	}

	public void setNumCand(Integer numCand) {
		this.numCand = numCand;
	}

	public String getAdresseMail() {
		return this.adresseMail;
	}

	public void setAdresseMail(String adresseMail) {
		this.adresseMail = adresseMail;
	}

	public String getAdressePostale() {
		return this.adressePostale;
	}

	public void setAdressePostale(String adressePostale) {
		this.adressePostale = adressePostale;
	}

	public String getCv() {
		return this.cv;
	}

	public void setCv(String cv) {
		this.cv = cv;
	}

	public Date getDateDepot() {
		return this.dateDepot;
	}

	public void setDateDepot(Date dateDepot) {
		this.dateDepot = dateDepot;
	}

	public Date getDateNaiss() {
		return this.dateNaiss;
	}

	public void setDateNaiss(Date dateNaiss) {
		this.dateNaiss = dateNaiss;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public NiveauQualification getNiveauQualification() {
		return this.niveauQualification;
	}

	public void setNiveauQualification(NiveauQualification niveauQualification) {
		this.niveauQualification = niveauQualification;
	}

	public Set<MessageCand> getMessageCands() {
		return this.messageCands;
	}

	public void setMessageCands(Set<MessageCand> messageCands) {
		this.messageCands = messageCands;
	}

	public MessageCand addMessageCand(MessageCand messageCand) {
		getMessageCands().add(messageCand);
		messageCand.setCandidature(this);

		return messageCand;
	}

	public MessageCand removeMessageCand(MessageCand messageCand) {
		getMessageCands().remove(messageCand);
		messageCand.setCandidature(null);

		return messageCand;
	}

	public Set<MessageOffre> getMessageOffres() {
		return this.messageOffres;
	}

	public void setMessageOffres(Set<MessageOffre> messageOffres) {
		this.messageOffres = messageOffres;
	}

	public MessageOffre addMessageOffre(MessageOffre messageOffre) {
		getMessageOffres().add(messageOffre);
		messageOffre.setCandidature(this);

		return messageOffre;
	}

	public MessageOffre removeMessageOffre(MessageOffre messageOffre) {
		getMessageOffres().remove(messageOffre);
		messageOffre.setCandidature(null);

		return messageOffre;
	}

	public Set<SecteurActivite> getSecteurActivites() {
		return this.secteurActivites;
	}

	public void setSecteurActivites(Set<SecteurActivite> secteurActivites) {
		this.secteurActivites = secteurActivites;
	}

}