package co.edu.uniquindio.dto;
/**
 * Clase login de la logica del negocio.
 * @author Juan Jose Ramirez
 *
 */
public class LoginDTO {
	
	//Atributos
	private String correo;
	private String password;
	/**
	 * construtor LoginDto con parametros
	 * @param correo, correo del login.
	 * @param password, password del login.
	 */
	public LoginDTO(String correo, String password) {
		super();
		this.correo = correo;
		this.password = password;
	}
	//Metodo get y set.
	/**
	 * Obtiene el correo del login.
	 * @return, retorna el correo del login
	 */
	public String getCorreo() {
		return correo;
	}
	/**
	 * Mete el correo del login
	 * @param correo, correo del login
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	/**
	 * Obtiene el password del login
	 * @return, retorna el password del login
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * Mete el password del login 
	 * @param password, password del login
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
}
