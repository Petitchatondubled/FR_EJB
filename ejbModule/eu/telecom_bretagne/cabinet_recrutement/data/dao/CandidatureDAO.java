package eu.telecom_bretagne.cabinet_recrutement.data.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import eu.telecom_bretagne.cabinet_recrutement.data.model.Candidature;
import eu.telecom_bretagne.cabinet_recrutement.data.model.NiveauQualification;
import eu.telecom_bretagne.cabinet_recrutement.data.model.SecteurActivite;

@LocalBean
@Stateless
public class CandidatureDAO {
	
	@PersistenceContext
	EntityManager entityManager;
	
	public CandidatureDAO(){
		
	}
	
	public Candidature findById(Integer id)
	{
		return entityManager.find(Candidature.class, id);
	}
	
	//----------------------------------------------------------------------------
	public List<Candidature> findAll()
	{
		Query query = entityManager.createQuery("select candidature from Candidature candidature order by candidature.numCand");
		List l = query.getResultList();

		return (List<Candidature>) l;
	}
	
	public Candidature persist(Candidature candidature){
		
		 entityManager.persist(candidature);
		 return candidature ;
	}
	
	public Candidature update(Candidature candidature){
		 entityManager.merge(candidature);
		 return candidature ;
	}
	
	public void remove(Candidature candidature){
		entityManager.remove(candidature);
	}
    
	public List<Candidature> candidatByActANDQuali(String secteurActiviteIntitule,String niveauQualifIntitule){
		
		Query query = entityManager.createQuery("select candidature from Candidature candidature "
				+ "join candidature.secteurActivites s,candidature.niveauQualification n where "
				+ "s.intitule =:secteurIntitule AND "
				+ "n.intitule =:niveauIntitule "
				+ " order by candidature.numCand");
		query.setParameter("secteurIntitule",secteurActiviteIntitule);
		query.setParameter("niveauIntitule",niveauQualifIntitule);
		List l = query.getResultList();
		return (List<Candidature>) l;

	}

}
