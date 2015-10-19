package eu.telecom_bretagne.cabinet_recrutement.service;

import java.util.List;

import javax.ejb.Remote;

import eu.telecom_bretagne.cabinet_recrutement.data.model.OffreEmploi;

@Remote
public interface IServiceOffreEmploi {

	public OffreEmploi addOffreEmploi(OffreEmploi offre);
	public List<OffreEmploi> listeOffreEmploi();
	public OffreEmploi getOffreEmploi(int id);
	public OffreEmploi updateOffreEmploi(OffreEmploi offre);
	public void removeOffreEmploi(OffreEmploi offre);

}
