package eu.telecom_bretagne.cabinet_recrutement.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import eu.telecom_bretagne.cabinet_recrutement.data.dao.EntrepriseDAO;
import eu.telecom_bretagne.cabinet_recrutement.data.dao.MessageOffreDAO;
import eu.telecom_bretagne.cabinet_recrutement.data.dao.OffreEmploiDAO;
import eu.telecom_bretagne.cabinet_recrutement.data.model.Candidature;
import eu.telecom_bretagne.cabinet_recrutement.data.model.Entreprise;
import eu.telecom_bretagne.cabinet_recrutement.data.model.MessageCand;
import eu.telecom_bretagne.cabinet_recrutement.data.model.MessageOffre;
import eu.telecom_bretagne.cabinet_recrutement.data.model.OffreEmploi;

/**
 * Session Bean implementation class ServiceEntreprise
 * 
 * @author Philippe TANGUY
 */
@Stateless
@LocalBean
public class ServiceEntreprise implements IServiceEntreprise
{
	//-----------------------------------------------------------------------------
	@EJB
	private EntrepriseDAO entrepriseDAO;
	@EJB
	private OffreEmploiDAO offreEmploiDAO ;
	@EJB
	private MessageOffreDAO messageOffreDAO ;
	
	//-----------------------------------------------------------------------------
	/**
	 * Default constructor.
	 */
	public ServiceEntreprise()
	{
		// TODO Auto-generated constructor stub
	}
	//-----------------------------------------------------------------------------
	@Override
	public Entreprise getEntreprise(int id)
	{
		return entrepriseDAO.findById(id);
	}
	//-----------------------------------------------------------------------------
	@Override
	public List<Entreprise> listeDesEntreprises()
	{
		return entrepriseDAO.findAll();
	}
	
	@Override
	public Entreprise addEntreprise(Entreprise pentreprise) {
		
		return entrepriseDAO.persist(pentreprise);
	}
	
	@Override
	public List<OffreEmploi> offreEntreprise(int id) {
			
		return offreEmploiDAO.getOffreByEntreprise(id);
	}
	
	@Override
	public Entreprise updateEntreprise(Entreprise pentreprise) {
		
		return entrepriseDAO.update(pentreprise);
	}
	
	@Override
	public void removeEntreprise(Entreprise entreprise) {
		
		entrepriseDAO.remove(entreprise);
		System.out.println("L'entreprise "+entreprise.getNom()+" est supprimée");
	}
	
	@Override
	public MessageOffre sendMessageApplicant(MessageOffre msg) {
		
		return messageOffreDAO.persist(msg) ;
	}
	
	@Override
	public List<MessageCand> messageRecive() {
		
		return null;
	}
	
	@Override
	public List<MessageOffre> messageSend() {
		// TODO Auto-generated method stub
		return null;
	}
	
	// -----------------------------------------------------------------------------
}
