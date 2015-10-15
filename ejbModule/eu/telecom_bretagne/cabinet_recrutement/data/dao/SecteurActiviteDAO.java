package eu.telecom_bretagne.cabinet_recrutement.data.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import eu.telecom_bretagne.cabinet_recrutement.data.model.SecteurActivite;

@LocalBean
@Stateless
public class SecteurActiviteDAO{
	
	@PersistenceContext
	EntityManager entityManager;
	
	public SecteurActiviteDAO(){
		
	}
	
	public SecteurActivite findById(String id)
	{
		return entityManager.find(SecteurActivite.class, id);
	}
	
	//----------------------------------------------------------------------------
	public List<SecteurActivite> findAll()
	{
		Query query = entityManager.createQuery("select secteurActivite from SecteurActivite secteurActivite order by secteurActivite.intitule");
		List l = query.getResultList();

		return (List<SecteurActivite>) l;
	}
	
	public SecteurActivite persist(SecteurActivite secteurActivite){
		
		 entityManager.persist(secteurActivite);
		 return secteurActivite ;
	}
	
	public SecteurActivite update(SecteurActivite secteurActivite){
		 entityManager.merge(secteurActivite);
		 return secteurActivite ;
	}
	
	
    

}
