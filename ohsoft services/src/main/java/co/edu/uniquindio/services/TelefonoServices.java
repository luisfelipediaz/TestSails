package co.edu.uniquindio.services;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import co.edu.uniquindio.entidades.Ciudad;
import co.edu.uniquindio.entidades.Empresa;
import co.edu.uniquindio.entidades.Telefono;
import co.edu.uniquindio.negocio.CiudadEJB;
import co.edu.uniquindio.negocio.TelefonoEJB;
/**
 * 
 * @author Juan Jose Ramirez, Juan Camilo Correa Pacheco, Miguelangel Diaz Cabezas.
 * @version 1.0
 */
@Path("/telefono")
@RequestScoped
public class TelefonoServices {
	//Contenedor de telefono.
	@EJB
	private TelefonoEJB tejb;
	
	/**
	 * Servicio para registrar un telefono.
	 * @param telefono, telefono a agregar.
	 * @return, retorna ok si se registro de lo contrario
	 * ya existe en la persistencia.
	 */
	@POST
	@Path("/registrar")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response registrarTelefono(Telefono telefono) {
		return 	tejb.agregarTelefono(telefono)? 
				Response.ok().build() : 
				Response.noContent().build();
	}
	
	/**
	 * Servicio para enlistar un telefono
	 * @return, retorna una lista de las ciudades.
	 */
	@GET
	@Path("/listar")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarCiudades() {
		List<Telefono> t = tejb.listarTelefono();
		return t == null ? Response.noContent().build() : 
			Response.ok(t).build();
	}
	
	/**
	 * Servicio para buscar un telefono por identificacion.
	 * @param idTelefono, identficador del telefono.
	 * @return, retorna el telefono buscado.
	 */
	@GET
	@Path("/buscar/{idTelefono}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarTelefono(@PathParam("idTelefono") int idTelefono) {
		Telefono empresa = tejb.buscarTelefono(idTelefono);
		return empresa == null? Response.accepted("La empresa no existe!").build():
			Response.ok(empresa).build();
	}
	
}
