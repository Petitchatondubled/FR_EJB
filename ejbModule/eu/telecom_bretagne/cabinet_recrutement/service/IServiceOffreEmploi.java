package eu.telecom_bretagne.cabinet_recrutement.service;

import java.util.List;

import javax.ejb.Remote;

import eu.telecom_bretagne.cabinet_recrutement.data.model.OffreEmploi;

@Remote
public interface IServiceOffreEmploi {

	public OffreEmploi addOffreEmploi(OffreEmploi offre);
	public List<OffreEmploi> listeOffreEmploi();
	public OffreEmploi getOffreEmploi();
	public OffreEmploi updateOffreEmploi();
	public void removeOffreEmploi();
	coucou
}
