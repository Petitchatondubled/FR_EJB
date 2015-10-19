package eu.telecom_bretagne.cabinet_recrutement.service;

import java.util.List;

import javax.ejb.Remote;

import eu.telecom_bretagne.cabinet_recrutement.data.model.Candidature;
import eu.telecom_bretagne.cabinet_recrutement.data.model.Entreprise;
import eu.telecom_bretagne.cabinet_recrutement.data.model.MessageCand;
import eu.telecom_bretagne.cabinet_recrutement.data.model.MessageOffre;
import eu.telecom_bretagne.cabinet_recrutement.data.model.OffreEmploi;

/**
 * Interface du service gérant les entreprises.
 * @author Philippe TANGUY
 */
@Remote
public interface IServiceEntreprise
{
	//-----------------------------------------------------------------------------
	/**
	 * Obtention d'une entreprise suivant son id.
	 * @param id id de l'entreprise.
	 * @return l'instance de l'entreprise.
	 */
	//-----------------------------------------------------------------------------
	public Entreprise getEntreprise(int id);
	/**
	 * Obtention de la liste de toutes les entreprises référencées dans le système.
	 * @return la liste des candidatures dans une {@code List<Entreprise>}.
	 */
	public List<Entreprise> listeDesEntreprises();
	
	public Entreprise addEntreprise(Entreprise pentreprise);
	public List<OffreEmploi> offreEntreprise();
	public Entreprise updateEntreprise(Entreprise pentreprise);
	public void removeEntreprise();
	public void sendMessageApplicant(Candidature cand,String message);
	public List<MessageOffre> messageRecive();
	public List<MessageCand> messageSend();
	
	//-----------------------------------------------------------------------------
}
