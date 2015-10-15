package eu.telecom_bretagne.cabinet_recrutement.data.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import eu.telecom_bretagne.cabinet_recrutement.data.model.MessageCand;

@LocalBean
@Stateless
public class MessageCandDAO{
	
	@PersistenceContext
	EntityManager entityManager;
	
	public MessageCandDAO(){
		
	}
	
	public MessageCand findById(Integer id)
	{
		return entityManager.find(MessageCand.class, id);
	}
	
	//----------------------------------------------------------------------------
	public List<MessageCand> findAll()
	{
		Query query = entityManager.createQuery("select messageCand from MessageCand messageCand order by messageCand.numMsg");
		List l = query.getResultList();

		return (List<MessageCand>) l;
	}
	
	public MessageCand persist(MessageCand messageCand){
		
		 entityManager.persist(messageCand);
		 return messageCand ;
	}
	
	public MessageCand update(MessageCand messageCand){
		 entityManager.merge(messageCand);
		 return messageCand ;
	}
	
	public void remove(MessageCand messageCand){
		
		if(!entityManager.contains(messageCand)){
			entityManager.remove(messageCand);
		}
	}
    

}
