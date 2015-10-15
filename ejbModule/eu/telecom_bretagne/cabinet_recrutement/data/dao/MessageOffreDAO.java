package eu.telecom_bretagne.cabinet_recrutement.data.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import eu.telecom_bretagne.cabinet_recrutement.data.model.MessageOffre;

@LocalBean
@Stateless
public class MessageOffreDAO{
	
	@PersistenceContext
	EntityManager entityManager;
	
	public MessageOffreDAO(){
		
	}
	
	public MessageOffre findById(Integer id)
	{
		return entityManager.find(MessageOffre.class, id);
	}
	
	//----------------------------------------------------------------------------
	public List<MessageOffre> findAll()
	{
		Query query = entityManager.createQuery("select messageOffre from MessageOffre messageOffre order by messageOffre.numMsg");
		List l = query.getResultList();

		return (List<MessageOffre>) l;
	}
	
	public MessageOffre persist(MessageOffre messageOffre){
		
		 entityManager.persist(messageOffre);
		 return messageOffre ;
	}
	
	public MessageOffre update(MessageOffre messageOffre){
		 entityManager.merge(messageOffre);
		 return messageOffre ;
	}
	
	public void remove(MessageOffre messageOffre){
		if(!entityManager.contains(messageOffre)){
			entityManager.remove(messageOffre);
		}
	}
    

}
