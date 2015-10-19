package eu.telecom_bretagne.cabinet_recrutement.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import eu.telecom_bretagne.cabinet_recrutement.data.model.OffreEmploi;

/**
 * Session Bean implementation class ServiceOffreEmploi
 */
@Stateless
@LocalBean
public class ServiceOffreEmploi implements IServiceOffreEmploi {

    /**
     * Default constructor. 
     */
    public ServiceOffreEmploi() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public OffreEmploi addOffreEmploi(OffreEmploi offre) {
		// TODO Auto-generated method stub
		System.out.println("coucou");
		return null;
		
	}

	@Override
	public List<OffreEmploi> listeOffreEmploi() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OffreEmploi getOffreEmploi() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OffreEmploi updateOffreEmploi() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeOffreEmploi() {
		// TODO Auto-generated method stub
		
	}

}
