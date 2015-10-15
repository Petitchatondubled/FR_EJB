package eu.telecom_bretagne.cabinet_recrutement.service;

import javax.ejb.Asynchronous;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class ServiceMessageOffre
 */
@Stateless
@LocalBean
@Asynchronous
public class ServiceMessageOffre implements IServiceMessageOffre {

    /**
     * Default constructor. 
     */
    public ServiceMessageOffre() {
        // TODO Auto-generated constructor stub
    }

}
