package co.edu.uniquindio.negocio;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.edu.uniquindio.entidades.Ciudad;
/**
 * 
 * @author Juan Jose Ramirez, Juan Camilo Correa Pacheco, Miguelangel Diaz Cabezas.
 * @version 1.0
 */
@Stateless
public class CiudadEJB {
	//Manjeador de la persistencia (mysql).
	@PersistenceContext(name = "persistencia")
	protected transient EntityManager em;
	
	/**
	 * buscar la ciudad por si identificador si esta en la persistencia.
	 * @param idCiudad, identificador de la ciudad.
	 * @return, retorna la ciudad buscada.
	 */
	public Ciudad buscarCiudad(int idCiudad){
        Query query = em.createNamedQuery(Ciudad.BUSCAR_X_ID);	
        query.setParameter(1,idCiudad);
        List<Ciudad> result = query.getResultList();
        return result.size() == 0? null : result.get(0);
	}
	/**
	 * agrega una ciudad en la persistencia.
	 * @param ciudad, ciudad agregar.
	 * @return, true si se agrego o false si ya existe en la persistencia.
	 */
	public boolean agregarCiudad(Ciudad ciudad) {
		if(buscarCiudad(ciudad.getIdCiudad()) == null) {
			em.persist(ciudad);
			return true;
		}
		return false;
	}
	/**
	 * enlista las ciudades que hay en la persistencia.
	 * @return, retorna la lista de la persistencia.
	 */
	public List<Ciudad> listarCiudades(){
		Query q = em.createNamedQuery(Ciudad.LISTAR_CIUDADES);
		List<Ciudad> result = q.getResultList();
		return result;
	}
}
