package junittest;

import static org.junit.Assert.*;
import org.junit.Test;
import com.mysql.jdbc.Connection;
import conexion.ConexionBaseDatos;
import crudLibro.CrudLibro;
import entidad.Libro;

public class CrudLibroTest {

	@Test
	public void testCrearLibro() {
		System.out.println("1");
		Libro libro = new Libro("Cien a�os de solodad",
				"Gabriel Garcia Marquez", 28);
		CrudLibro crudLibro = new CrudLibro();
		String respuestaCreacion = crudLibro.crearLibro(libro);
		System.out.println("1");
		assertEquals("se creo el libro", respuestaCreacion);
		System.out.println("1");

	}

	@Test
	public void assertFalseTest() {
		assertFalse(false);

	}

	@Test
	public void assertNotNullTest() {
		CrudLibro cL = new CrudLibro();
		assertNotNull(cL);
	}

	@Test
	public void assertNullTest() {
		String a = null;
		assertNull(a);
	}

	@Test
	public void assertTrueTest() {
		assertTrue(false);
	}

	@Test
	public void assertArrayEqualsTest() {
		String[] arreglo = { "a", "" };
		String[] arregloesperado = { "a", "b" };
		assertArrayEquals("arregloesperado", arregloesperado, arreglo);
	}

}
