package co.edu.uniquindio.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
/**
 * Clase ciudad de la logica de negocio.
 *@author Juan Jose Ramirez, Juan Camilo Correa Pacheco, Miguelangel Diaz Cabezas.
 *@version 1.0
 */
@Entity
@NamedQueries({
	@NamedQuery(name=Ciudad.BUSCAR_X_ID,query="select c from Ciudad c where c.idCiudad = ?1 "),
	@NamedQuery(name=Ciudad.LISTAR_CIUDADES,query="select c from Ciudad c")})
public class Ciudad implements Serializable{
	
	//Constantes
	public static final String BUSCAR_X_ID="cuidad.id";
	public static final String LISTAR_CIUDADES="cuidad.all";
	
	//Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idCiudad", nullable = false)
	private int idCiudad;
	@Column(name = "nombre", length = 50, nullable = false)
	private String nombre;
	
	/**
	 * Constructor de la ciudad con parametros.
	 * @param idCiudad, identificador de la ciudad.
	 * @param nombre, nombre de la ciudad.
	 */
	public Ciudad(int idCiudad, String nombre) {
		super();
		this.idCiudad = idCiudad;
		this.nombre = nombre;
	}
	
	/**
	 * Constructor de la ciudad con parametros.
	 */
	public Ciudad() {
		super();
	}
	
	//Metodos get y set
	/**
	 * Obtiene el identificador de la ciudad.
	 * @return, retorna el identificador de la ciudad.
	 */
	public int getIdCiudad() {
		return idCiudad;
	}
	/**
	 * Mete el identificador  de la ciudad.
	 * @param idCiudad, identificador de la ciudad.
	 */
	public void setIdCiudad(int idCiudad) {
		this.idCiudad = idCiudad;
	}
	/**
	 * Obtiene el nombre de la ciudad.
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Mete el nombre de la ciudad.
	 * @param nombre,nombre de la ciudad.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
