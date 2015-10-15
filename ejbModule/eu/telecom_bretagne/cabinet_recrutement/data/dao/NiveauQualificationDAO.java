package eu.telecom_bretagne.cabinet_recrutement.data.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import eu.telecom_bretagne.cabinet_recrutement.data.model.NiveauQualification;

@LocalBean
@Stateless
public class NiveauQualificationDAO{
	
	@PersistenceContext
	EntityManager entityManager;
	
	public NiveauQualificationDAO(){
		
	}
	
	public NiveauQualification findById(String id)
	{
		return entityManager.find(NiveauQualification.class, id);
	}
	
	
	//----------------------------------------------------------------------------
	public List<NiveauQualification> findAll()
	{
		Query query = entityManager.createQuery("select niveauQualification from NiveauQualification niveauQualification order by niveauQualification.intitule");
		List l = query.getResultList();
 
		return (List<NiveauQualification>) l;
	}
	
	public NiveauQualification persist(NiveauQualification niveauQualification){
		
		 entityManager.persist(niveauQualification);
		 return niveauQualification ;
	}
	
	public NiveauQualification update(NiveauQualification niveauQualification){
		 entityManager.merge(niveauQualification);
		 return niveauQualification ;
	}
	
    

}
