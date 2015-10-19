package eu.telecom_bretagne.cabinet_recrutement.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import eu.telecom_bretagne.cabinet_recrutement.data.dao.EntrepriseDAO;
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
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<OffreEmploi> offreEntreprise() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Entreprise updateEntreprise(Entreprise pentreprise) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void removeEntreprise() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void sendMessageApplicant(Candidature cand, String message) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<MessageOffre> messageRecive() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<MessageCand> messageSend() {
		// TODO Auto-generated method stub
		return null;
	}
	
	// -----------------------------------------------------------------------------
}
