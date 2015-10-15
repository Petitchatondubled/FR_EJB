package eu.telecom_bretagne.cabinet_recrutement.data.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import eu.telecom_bretagne.cabinet_recrutement.data.model.Candidature;
import eu.telecom_bretagne.cabinet_recrutement.data.model.Entreprise;
import eu.telecom_bretagne.cabinet_recrutement.data.model.NiveauQualification;
import eu.telecom_bretagne.cabinet_recrutement.data.model.OffreEmploi;
import eu.telecom_bretagne.cabinet_recrutement.data.model.SecteurActivite;

@LocalBean
@Stateless
public class OffreEmploiDAO{
	
	@PersistenceContext
	EntityManager entityManager;
	
	public OffreEmploiDAO(){
		
	}
	
	public OffreEmploi findById(Integer id)
	{
		return entityManager.find(OffreEmploi.class, id);
	}
	
	//----------------------------------------------------------------------------
	public List<OffreEmploi> findAll()
	{
		Query query = entityManager.createQuery("select offreEmploi from OffreEmploi offreEmploi order by offreEmploi.numOffre");
		List l = query.getResultList();

		return (List<OffreEmploi>) l;
	}
	
	public OffreEmploi persist(OffreEmploi offreEmploi){
		
		 entityManager.persist(offreEmploi);
		 return offreEmploi ;
	}
	
	public OffreEmploi update(OffreEmploi offreEmploi){
		 entityManager.merge(offreEmploi);
		 return offreEmploi ;
	}
	
	public void remove(OffreEmploi offreEmploi){
		if(!entityManager.contains(offreEmploi)){
			entityManager.remove(offreEmploi);
		}
	}
    
	public List<OffreEmploi> getOffreByEntreprise(int entrepriseID){
		
		Query query = entityManager.createQuery("select offre from OffreEmploi offre join offre.entreprise e "
				+ "where e.id = :eID "
				+ "order by offre.numOffre");
		query.setParameter("eID", entrepriseID);
		List l = query.getResultList();

		return (List<OffreEmploi>) l;
	}
	
	public List<OffreEmploi> offreByActANDQuali(String secteurActiviteIntitule,String niveauQualifIntitule){
		
		Query query = entityManager.createQuery("select offre from OffreEmploi offre "
				+ "join offre.secteurActivites s,offre.niveauQualification n where "
				+ "s.intitule =:secteurIntitule AND "
				+ "n.intitule =:niveauIntitule "
				+ " order by offre.numOffre");
		query.setParameter("secteurIntitule",secteurActiviteIntitule);
		query.setParameter("niveauIntitule",niveauQualifIntitule);
		List l = query.getResultList();
		return (List<OffreEmploi>) l;

	}

}
