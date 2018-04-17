package co.edu.uniquindio.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


/**
 * Clase empresa de la logica de negocio.
 *@author Juan Jose Ramirez, Juan Camilo Correa Pacheco, Miguelangel Diaz Cabezas.
 *@version 1.0
 */
@Entity
@NamedQueries({
	@NamedQuery(name=Empresa.BUSCAR_EMPRESA,query="select e from Empresa e where e.idEmpresa = ?1"),
	@NamedQuery(name=Empresa.LISTAR_EMPRESAS,query="select e from Empresa e")})
public class Empresa implements Serializable{

	
	//Constantes.
	public final static String BUSCAR_EMPRESA = "empresa.id";
	public final static String LISTAR_EMPRESAS = "empresa.all";
	
	//Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idEmpresa", nullable = false)
	private int idEmpresa;
	@Column(name = "nit", length = 50, nullable = false, unique = true)
	private String nit;
	@Column(name = "nombre", length = 50, nullable = false)
	private String nombre;
	@Column(name = "correo", length = 50, nullable = false, unique = true)
	private String correo;
	@Column(name = "contrasenia", length = 200, nullable = false)
	private String contrasenia;
	@ManyToOne
	@JoinColumn(name = "idCiudad", nullable = true)
	private Ciudad ciudad;
	
	/**
	 * Construtor con parametros de la empresa.
	 * @param idEmpresa, identificador de la empresa.
	 * @param nit, el numero de identificacion tributario de la empresa.
	 * @param nombre, nombre de la empresa.
	 * @param correo, correo de la empresa.
	 * @param contrasenia, contrasenia de la empresa.
	 * @param ciudad, ciudad en donde esta la empresa.
	 */
	public Empresa(int idEmpresa, String nit, String nombre, String correo, String contrasenia, Ciudad ciudad) {
		super();
		this.idEmpresa = idEmpresa;
		this.nit = nit;
		this.nombre = nombre;
		this.correo = correo;
		this.contrasenia = contrasenia;
		this.ciudad = ciudad;
	}
	/**
	 * Construtor sin parametros de la empresa.
	 */
	public Empresa() {
		super();
	}
	
	//Metodos  get y set.
	/**
	 * Obtiene el identificador de la empresa.
	 * @return, identificador de la empresa.
	 */
	public int getIdEmpresa() {
		return idEmpresa;
	}
	
	/**
	 * Mete el identificador de la empresa.
	 * @param idEmpresa,idenficador de la empresa.
	 */
	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	
	/**
	 * Obtiene el numero de identificacion tributario de la empresa.
	 * @return, numero de identificacion tributario
	 */
	public String getNit() {
		return nit;
	}
	
	/**
	 * Mete el numero de identificacion tributario de la empresa.
	 * @param nit, numero de identificacion tributario.
	 */
	public void setNit(String nit) {
		this.nit = nit;
	}
	
	/**
	 * Obtiene el nombre de la empresa.
	 * @return, nombre de la empresa.
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * mete el nombre de la empresa.
	 * @param nombre, nombre de la empresa.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Obtiene el correo de la empresa.
	 * @return, retorna el correo de la empresa.
	 */
	public String getCorreo() {
		return correo;
	}
	/**
	 * Mete el correo de la empresa.
	 * @param correo, correo de la empresa.
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	/**
	 * Obtiene la constraseña de la empresa.
	 * @return,retorna la contraseña de la empresa.
	 */
	public String getContrasenia() {
		return contrasenia;
	}
	/**
	 * Mete la constraseña de la empresa.
	 * @param contrasenia, contraseña de la empresa.
	 */
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	/**
	 * Obtiene la ciudad de donde es la empresa.
	 * @return, retorna la ciudad de  donde es la empresa.
	 */
	public Ciudad getCiudad() {
		return ciudad;
	}
	/**
	 * Mete la ciudad de donde es la empresa.
	 * @param ciudad, ciudad de donde es la empresa.
	 */
	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}
	
	
	
}
