package webservicelibro;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.QueryParam;
import javax.ws.rs.PathParam;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;

import com.sun.xml.internal.txw2.Document;

import servicio.ServicioLibro;
import modelo.Libro;

@Path("crudLibroRest")
@Produces("application/json")
public class CrudLibroRest {

	ServicioLibro servicioLibro = new ServicioLibro();

	// CONSULTAR LIBRO POR ID
	@GET
	@Path("consultarLibro")
	public Libro consultarLibro(@QueryParam("varId") int idLibro) {
		Libro libro = servicioLibro.findByIdLibro(idLibro);
		return libro;

	}
	// CONSULTAR LIBRO POR titulo
	@GET
	@Path("consultarLibroTitulo")
	public Libro consultarLibroTitulo(@QueryParam("varTitulo") String tituloLibro) {
		Libro libro = servicioLibro.findByTituloLibro(tituloLibro);
		return libro;

	}
	// CONSULTAR LIBRO POR titulo
	@GET
	@Path("consultarLibroTituloLista")
	public List<Libro> consultarLibroTituloLista(@QueryParam("varTitulo") String tituloLibro) {
		List<Libro>  libro = servicioLibro.findByTituloLibroLista(tituloLibro);
		return libro;

	}

	// CONSULTAR LIBROs
	@GET
	@Path("consultarLibros")
	public List<Libro> consultarLibro() {
		List<Libro> libros = servicioLibro.findLibros();
		return libros;

	}

	@POST
	@Path("registrarLibro")
	public void registrarLibro(@FormParam("txtAutor") String autor,
			@FormParam("txtTitulo") String titulo,
			@FormParam("txtStock") int stock) {
		Libro nuevoLibro = new Libro(autor, titulo, stock);
		servicioLibro.crearLibro(nuevoLibro);
		System.out.println("Libro creado successfully");
	}
//	ACTUALIZAR LIBRO
	@POST
	@Path("actualizarLibro")
	@Consumes("application/json")
	@Produces("application/json")
	public String registrarLibro(Libro libro) {
		
		System.out.println("**************** "+libro.getAutor());
		String mensaje = servicioLibro.actualizarLibro(libro);
		System.out.println(mensaje);
		return mensaje;
	}
	/**
	 * actualizar con Post
	 * @param autor
	 * @param titulo
	 * @param stock
	 */
//	@POST
//	@Path("actualizarLibro")
//	public String registrarLibro(@FormParam("id") int id, 
//			@FormParam("titulo") String titulo, 
//			@FormParam("autor") String autor, 
//			@FormParam("stock") int stock) {
//		Libro libro = new Libro();
//		libro.setId(id);
//		libro.setTitulo(titulo);
//		libro.setAutor(autor);
//		libro.setStock(stock);
//		System.out.println("****************"+titulo+" "+autor+" "+stock);
//		String mensaje = servicioLibro.actualizarLibro(libro);
//		System.out.println(mensaje);
//		return mensaje;
//	}
	//ACTUALIZAR, METODO INGENIERO
//	@POST
//	@Path("actualizarLibro")
//	@Consumes(MediaType.APPLICATION_JSON)
//	public String actualizar (Libro l) {
//       EntityManagerFactory emf = Persistence.createEntityManagerFactory("epnweb");
//	   EntityManager em = emf.createEntityManager();
//	   em.getTransaction().begin();
//	   em.merge(l);
//	   em.getTransaction().commit();
//	   return "Libro actualizado exitosamente";
//	}



	// ACTUALIZAR LIBRO con PathParam
	@GET
	@Path("actualizarLibro/id/{varId}/autor/{varAutor}/titulo/{varTitulo}/stock/{varStock}")
	public void ActualizarLibro(@PathParam("varId") int id,
			@PathParam("varAutor") String autor,
			@PathParam("varTitulo") String titulo,
			@PathParam("varStock") int stock) {
		Libro libro = new Libro(id, autor, titulo, stock);
		servicioLibro.editarLibro(libro);
		
		System.out.println("libro actualizado correctamente");
	}

	// ELIMINAR LIBRO
	@GET
	@Path("eliminarLibro/id/{varId}")
	public void eliminarLibro(@PathParam("varId") int id) {
		Libro libro = servicioLibro.findByIdLibro(id);
		servicioLibro.eliminarLibro(libro);
		System.out.println("libro eliminado correctamente");
	}
}
