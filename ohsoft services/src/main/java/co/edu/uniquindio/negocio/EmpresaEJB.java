package co.edu.uniquindio.negocio;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.edu.uniquindio.entidades.Empresa;
/**
 * 
 * @author Juan Jose Ramirez, Juan Camilo Correa Pacheco, Miguelangel Diaz Cabezas.
 * @version 1.0
 */
@Stateless
public class EmpresaEJB {
	//Manjeador de la persistencia (mysql).
	@PersistenceContext(name = "persistencia")
	protected transient EntityManager em;
	
	/**
	 * Buscar empresa por el identificador en la persistencia.
	 * @param idEmpresa, identificador de empresa.
	 * @return, retorna la empresa encontrada.
	 */
	public Empresa buscarEmpresa(int idEmpresa) {
		Query q = em.createNamedQuery(Empresa.BUSCAR_EMPRESA);
		q.setParameter(1, idEmpresa);
		List<Empresa> result = q.getResultList();
		return result.size() == 0? null : result.get(0);
	}
	/**
	 * agregar la empresa en la persistencia.
	 * @param empresa, empresa a agregar.
	 * @return, retorna verdadero si la empresa no existe en la persistencia
	 * y falso si existe.
	 */
	public boolean agregarEmpresa(Empresa empresa) {
		if(buscarEmpresa(empresa.getIdEmpresa()) == null) {
			em.persist(empresa);
			return true;
		}
		return false;
	}
	/**
	 * Enlista las empresas que estan guardadas en la persistencia.
	 * @return, retorna la lista de empresas.
	 */
	public List<Empresa> listarEmpresas(){
		Query q = em.createNamedQuery(Empresa.LISTAR_EMPRESAS);
		List<Empresa> result = q.getResultList();
		return result;
	}

}
