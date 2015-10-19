package eu.telecom_bretagne.cabinet_recrutement.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import eu.telecom_bretagne.cabinet_recrutement.data.model.Candidature;
import eu.telecom_bretagne.cabinet_recrutement.data.model.MessageCand;
import eu.telecom_bretagne.cabinet_recrutement.data.model.MessageOffre;
import eu.telecom_bretagne.cabinet_recrutement.data.model.OffreEmploi;

/**
 * Session Bean implementation class ServiceCandidature
 */
@Stateless
@LocalBean
public class ServiceCandidature implements IServiceCandidature {

    /**
     * Default constructor. 
     */
    public ServiceCandidature() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Candidature addCandidature(Candidature candidature) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Candidature> listeCandidature() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<OffreEmploi> offreEmploiByCandidature() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Candidature updateCandidature(Candidature candidature) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeCandidature() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MessageCand sendMessageOffre(MessageCand msg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MessageOffre> listeMessageFromEntreprise() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MessageCand> listeMessageToEntreprise() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Candidature getCandidature(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
