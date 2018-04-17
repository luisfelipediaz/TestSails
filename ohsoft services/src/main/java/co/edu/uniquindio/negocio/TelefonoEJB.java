package co.edu.uniquindio.negocio;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.edu.uniquindio.entidades.Ciudad;
import co.edu.uniquindio.entidades.Telefono;

/**
 * 
 * @author Juan Jose Ramirez, Juan Camilo Correa Pacheco, Miguelangel Diaz Cabezas.
 * @version 1.0
 */
@Stateless
public class TelefonoEJB {
	//Manjeador de la persistencia (mysql).
	@PersistenceContext(name = "persistencia")
	protected transient EntityManager em;
	
	/**
	 * Enlista todos los telefonos de la persistencia.
	 * @return, retorna la lista de los telefonos.
	 */
	public List<Telefono> listarTelefono(){
		Query q = em.createNamedQuery(Telefono.LISTAR_TELEFONO);
		List<Telefono> result = q.getResultList();
		return result;
	}
	/**
	 * agrega un telefono a la persistencia
	 * @param telefono, telefono de la empresa.
	 * @return, verdadero si el telefono no esta en la persistencia y falso si ya
	 * esta agregado
	 */
	public boolean agregarTelefono(Telefono telefono) {
		if(buscarTelefono(telefono.getIdTelefono()) == null) {
			em.persist(telefono);
			return true;
		}
		return false;
	}
	/**
	 * busca un telefono por su identificador.
	 * @param idTelefono, identificador del telefono.
	 * @return, retorna el telefono buscado. 
	 */
	public Telefono buscarTelefono(int idTelefono){
        Query query = em.createNamedQuery(Telefono.BUSCAR_X_ID);	
        query.setParameter(1,idTelefono);
        List<Telefono> result = query.getResultList();
        return result.size() == 0? null : result.get(0);
	}
}
