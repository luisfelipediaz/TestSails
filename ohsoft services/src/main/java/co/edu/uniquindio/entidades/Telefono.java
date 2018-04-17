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
 * Clase telefono de la logica de negocio.
 *@author Juan Jose Ramirez, Juan Camilo Correa Pacheco, Miguelangel Diaz Cabezas.
 *@version 1.0
 */
@Entity
@NamedQueries({
	@NamedQuery(name=Telefono.BUSCAR_X_ID,query="select c from Telefono c where c.idTelefono = ?1 "),
	@NamedQuery(name=Telefono.LISTAR_TELEFONO,query="select c from Telefono c")})
public class Telefono implements Serializable{
	//Constantes
	public static final String BUSCAR_X_ID="telefono.id";
	public static final String LISTAR_TELEFONO="telefono.all";
	
	//Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idTelefono")
	private int idTelefono;
	@Column(name = "numero", nullable = false, length = 20)
	private String numero;
	@Column(name = "descripcion", nullable = true, length = 50)
	private String descripcion;
	@ManyToOne
	@JoinColumn(name = "idEmpresa", nullable = false)
	private Empresa empresa;
	
	/**
	 * Constructor del telefono con parametros.
	 * @param idTelefono, identificador del telefono.
	 * @param numero, numero del telefono.
	 * @param descripcion,descripcion del telefono.
	 * @param empresa, empresa del telefono
	 */
	public Telefono(int idTelefono, String numero, String descripcion, Empresa empresa) {
		super();
		this.idTelefono = idTelefono;
		this.numero = numero;
		this.descripcion = descripcion;
		this.empresa = empresa;
	}
	/**
	 * Constructor del telefono sin parametros.
	 */
	public Telefono() {
		super();
	}
	//Metodos get y set.
	
	/**
	 * Obtiene el identificador del telefono.
	 * @return, retorna el identificador del correo.
	 */
	public int getIdTelefono() {
		return idTelefono;
	}
	/**
	 * Mete el identificador del telefono
	 * @param idTelefono, identificador del telefono.
	 */
	public void setIdTelefono(int idTelefono) {
		this.idTelefono = idTelefono;
	}
	/**
	 * Obtiene el numero del telefono.
	 * @return, retorna el numero del telefono.
	 */
	public String getNumero() {
		return numero;
	}
	/**
	 * Mete el numero del telefono.
	 * @param numero,numero del telefono.
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}
	/**
	 * Obtiene la descripcion del telefono.
	 * @return, retorna la descripcion del telefono.
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * Mete la descripcion del telefono.
	 * @param descripcion, descripcion del telefono.
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	/**
	 * Obtiene la empresa del telefono.
	 * @return, retorna la empresa del telefono.
	 */
	public Empresa getEmpresa() {
		return empresa;
	}
	/**
	 * Mete la empresa del telefono
	 * @param empresa, empresa del telefono
	 */
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
}
