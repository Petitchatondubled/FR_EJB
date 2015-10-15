package eu.telecom_bretagne.cabinet_recrutement.data.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the offre_emploi database table.
 * 
 */
@Entity
@Table(name="offre_emploi")
@NamedQuery(name="OffreEmploi.findAll", query="SELECT o FROM OffreEmploi o")
public class OffreEmploi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="OFFRE_EMPLOI_NUMOFFRE_GENERATOR", sequenceName="OFFRE_EMPLOI_NUM_OFFRE_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="OFFRE_EMPLOI_NUMOFFRE_GENERATOR")
	@Column(name="num_offre")
	private Integer numOffre;

	@Temporal(TemporalType.DATE)
	@Column(name="date_depot")
	private Date dateDepot;

	private String descriptif;

	@Column(name="profil_recheche")
	private String profilRecheche;

	private String titre;

	//bi-directional many-to-one association to MessageCand
	@OneToMany(mappedBy="offreEmploi")
	private Set<MessageCand> messageCands;

	//bi-directional many-to-one association to MessageOffre
	@OneToMany(mappedBy="offreEmploi")
	private Set<MessageOffre> messageOffres;

	//bi-directional many-to-one association to Entreprise
	@ManyToOne
	@JoinColumn(name="identreprise")
	private Entreprise entreprise;

	//bi-directional many-to-one association to NiveauQualification
	@ManyToOne
	@JoinColumn(name="qualification")
	private NiveauQualification niveauQualification;

	//bi-directional many-to-many association to SecteurActivite
	@ManyToMany(mappedBy="offreEmplois")
	private Set<SecteurActivite> secteurActivites;

	public OffreEmploi() {
	}

	public Integer getNumOffre() {
		return this.numOffre;
	}

	public void setNumOffre(Integer numOffre) {
		this.numOffre = numOffre;
	}

	public Date getDateDepot() {
		return this.dateDepot;
	}

	public void setDateDepot(Date dateDepot) {
		this.dateDepot = dateDepot;
	}

	public String getDescriptif() {
		return this.descriptif;
	}

	public void setDescriptif(String descriptif) {
		this.descriptif = descriptif;
	}

	public String getProfilRecheche() {
		return this.profilRecheche;
	}

	public void setProfilRecheche(String profilRecheche) {
		this.profilRecheche = profilRecheche;
	}

	public String getTitre() {
		return this.titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Set<MessageCand> getMessageCands() {
		return this.messageCands;
	}

	public void setMessageCands(Set<MessageCand> messageCands) {
		this.messageCands = messageCands;
	}

	public MessageCand addMessageCand(MessageCand messageCand) {
		getMessageCands().add(messageCand);
		messageCand.setOffreEmploi(this);

		return messageCand;
	}

	public MessageCand removeMessageCand(MessageCand messageCand) {
		getMessageCands().remove(messageCand);
		messageCand.setOffreEmploi(null);

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
		messageOffre.setOffreEmploi(this);

		return messageOffre;
	}

	public MessageOffre removeMessageOffre(MessageOffre messageOffre) {
		getMessageOffres().remove(messageOffre);
		messageOffre.setOffreEmploi(null);

		return messageOffre;
	}

	public Entreprise getEntreprise() {
		return this.entreprise;
	}

	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}

	public NiveauQualification getNiveauQualification() {
		return this.niveauQualification;
	}

	public void setNiveauQualification(NiveauQualification niveauQualification) {
		this.niveauQualification = niveauQualification;
	}

	public Set<SecteurActivite> getSecteurActivites() {
		return this.secteurActivites;
	}

	public void setSecteurActivites(Set<SecteurActivite> secteurActivites) {
		this.secteurActivites = secteurActivites;
	}

}