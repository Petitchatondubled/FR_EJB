package eu.telecom_bretagne.cabinet_recrutement.data.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the secteur_activite database table.
 * 
 */
@Entity
@Table(name="secteur_activite")
@NamedQuery(name="SecteurActivite.findAll", query="SELECT s FROM SecteurActivite s")
public class SecteurActivite implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SECTEUR_ACTIVITE_INTITULE_GENERATOR", sequenceName="SECTEUR_ACTIVITE_INTITULE_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SECTEUR_ACTIVITE_INTITULE_GENERATOR")
	private String intitule;

	//bi-directional many-to-many association to Candidature
	@ManyToMany
	@JoinTable(
		name="sect_act_cand"
		, joinColumns={
			@JoinColumn(name="intitule")
			}
		, inverseJoinColumns={
			@JoinColumn(name="num_cand")
			}
		)
	private Set<Candidature> candidatures;

	//bi-directional many-to-many association to OffreEmploi
	@ManyToMany
	@JoinTable(
		name="sect_act_emp"
		, joinColumns={
			@JoinColumn(name="intitule")
			}
		, inverseJoinColumns={
			@JoinColumn(name="num_offre")
			}
		)
	private Set<OffreEmploi> offreEmplois;

	public SecteurActivite() {
	}

	public String getIntitule() {
		return this.intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public Set<Candidature> getCandidatures() {
		return this.candidatures;
	}

	public void setCandidatures(Set<Candidature> candidatures) {
		this.candidatures = candidatures;
	}

	public Set<OffreEmploi> getOffreEmplois() {
		return this.offreEmplois;
	}

	public void setOffreEmplois(Set<OffreEmploi> offreEmplois) {
		this.offreEmplois = offreEmplois;
	}

}