package eu.telecom_bretagne.cabinet_recrutement.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import eu.telecom_bretagne.cabinet_recrutement.data.dao.CandidatureDAO;
import eu.telecom_bretagne.cabinet_recrutement.data.dao.OffreEmploiDAO;
import eu.telecom_bretagne.cabinet_recrutement.data.dao.SecteurActiviteDAO;
import eu.telecom_bretagne.cabinet_recrutement.data.model.Candidature;
import eu.telecom_bretagne.cabinet_recrutement.data.model.MessageCand;
import eu.telecom_bretagne.cabinet_recrutement.data.model.MessageOffre;
import eu.telecom_bretagne.cabinet_recrutement.data.model.OffreEmploi;
import eu.telecom_bretagne.cabinet_recrutement.data.model.SecteurActivite;

/**
 * Session Bean implementation class ServiceCandidature
 */
@Stateless
@LocalBean
public class ServiceCandidature implements IServiceCandidature {

	@EJB
	private CandidatureDAO candidatureDAO ;
	@EJB
	private OffreEmploiDAO offreEmploiDAO ;
	@EJB
	private SecteurActiviteDAO secteurActiviteDAO ;
    /**
     * Default constructor. 
     */
    public ServiceCandidature() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Candidature addCandidature(Candidature candidature) {
		
		Candidature candidat = candidatureDAO.persist(candidature);
		Set<SecteurActivite> sects = candidat.getSecteurActivites();
		for(SecteurActivite s : sects){
			s.getCandidatures().add(candidat);
			secteurActiviteDAO.update(s);
		}
		
		return candidat ;
	}

	@Override
	public List<Candidature> listeCandidature() {
		
		return candidatureDAO.findAll();
	}


	@Override
	public List<OffreEmploi> offreEmploiByCandidature(Candidature candidat) {
		
		List<OffreEmploi> offreListe = (List<OffreEmploi>) new HashSet<OffreEmploi>()  ;
		Set<SecteurActivite> secteurs = candidat.getSecteurActivites() ;
		
		for(SecteurActivite s : secteurs){
			for(OffreEmploi o : offreEmploiDAO.offreByActANDQuali(s.getIntitule(),candidat.getNiveauQualification().getIntitule())){
				offreListe.add(o);
			}
		}
		return offreListe;
	}

	@Override
	public Candidature updateCandidature(Candidature candidature) {
		
		return candidatureDAO.update(candidature);
	}

	@Override
	public void removeCandidature(Candidature candidature) {
		
		candidatureDAO.remove(candidature);
		
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
		
		return candidatureDAO.findById(id);
	}

}
