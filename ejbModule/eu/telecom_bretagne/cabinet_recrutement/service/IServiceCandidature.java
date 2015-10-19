package eu.telecom_bretagne.cabinet_recrutement.service;

import java.util.List;

import javax.ejb.Remote;

import eu.telecom_bretagne.cabinet_recrutement.data.model.Candidature;
import eu.telecom_bretagne.cabinet_recrutement.data.model.MessageCand;
import eu.telecom_bretagne.cabinet_recrutement.data.model.MessageOffre;
import eu.telecom_bretagne.cabinet_recrutement.data.model.OffreEmploi;

@Remote
public interface IServiceCandidature {
	
	public Candidature addCandidature(Candidature candidature);
	public List<Candidature> listeCandidature();
	public Candidature getCandidature(int id);
	public List<OffreEmploi> offreEmploiByCandidature(Candidature candidat);
	public Candidature updateCandidature(Candidature candidature);
	public void removeCandidature(Candidature candidature);
	public MessageCand sendMessageOffre(MessageCand msg);
	public List<MessageOffre> listeMessageFromEntreprise();
	public List<MessageCand> listeMessageToEntreprise();
	

}
