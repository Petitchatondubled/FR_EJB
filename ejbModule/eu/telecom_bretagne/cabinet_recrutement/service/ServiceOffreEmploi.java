package eu.telecom_bretagne.cabinet_recrutement.service;

import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import eu.telecom_bretagne.cabinet_recrutement.data.dao.OffreEmploiDAO;
import eu.telecom_bretagne.cabinet_recrutement.data.dao.SecteurActiviteDAO;
import eu.telecom_bretagne.cabinet_recrutement.data.model.OffreEmploi;
import eu.telecom_bretagne.cabinet_recrutement.data.model.SecteurActivite;

/**
 * Session Bean implementation class ServiceOffreEmploi
 */
@Stateless
@LocalBean
public class ServiceOffreEmploi implements IServiceOffreEmploi {

	@EJB
	private OffreEmploiDAO offreEmploiDAO ;
	@EJB
	private SecteurActiviteDAO secteurActiviteDAO ;
    /**
     * Default constructor. 
     */
    public ServiceOffreEmploi() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public OffreEmploi addOffreEmploi(OffreEmploi offre) {
		// TODO Auto-generated method stub
		
		OffreEmploi offreCree = offreEmploiDAO.persist(offre);
		Set<SecteurActivite> sects = offreCree.getSecteurActivites();
		for(SecteurActivite s : sects){
			s.getOffreEmplois().add(offreCree);
			secteurActiviteDAO.update(s);
		}
		return offreCree ;
	}

	@Override
	public List<OffreEmploi> listeOffreEmploi() {
		
		return offreEmploiDAO.findAll();
	}

	@Override
	public OffreEmploi getOffreEmploi(int id) {
		
		return offreEmploiDAO.findById(id);
	}

	@Override
	public OffreEmploi updateOffreEmploi(OffreEmploi offre) {
		
		return offreEmploiDAO.update(offre);
	}

	@Override
	public void removeOffreEmploi(OffreEmploi offre) {
		offreEmploiDAO.remove(offre);
		System.out.println("L'offre "+offre.getTitre()+" est supprimée");
	}

}
