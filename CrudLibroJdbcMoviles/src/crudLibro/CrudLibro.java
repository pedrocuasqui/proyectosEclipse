package crudLibro;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import conexion.ConexionBaseDatos;
import entidad.Libro;

public class CrudLibro {
	private static Connection conexion = null;
	private static String respuesta;

	public static void main(String[] args) {

		// Libro libroCrear = new Libro("Fisica basica 2009", "sandoval A", 5);
		// respuesta = crearLibro(libroCrear);
		// Libro libroActualizar = new Libro("Fisica basica 2020", "sandoval A",
		// 5);
		// respuesta = actualizarLibro(libroActualizar);

		// respuesta = eliminarLibro("2");
		Libro libro = consultarLibro("1");

		System.out.println(libro.getAutor());
		try {
			conexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String crearLibro(Libro libro) {
		conexion = (Connection) ConexionBaseDatos.conexion();
		PreparedStatement ps;
		try {
			ps = (PreparedStatement) conexion.prepareStatement(""
					+ "insert into libro(titulo, autor, stock) values(?,?,?)");
			ps.setString(1, libro.getTitulo());
			ps.setString(2, libro.getAutor());
			ps.setInt(3, libro.getStock());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			System.out.println("no se pudo crear el libro " + e);
			e.printStackTrace();
		}
		ConexionBaseDatos.cerrarConexion(conexion);
		return "se creo el libro ";
	}

	public static String actualizarLibro(Libro libro) {
		conexion = (Connection) ConexionBaseDatos.conexion();
		try {
			PreparedStatement ps = (PreparedStatement) conexion
					.prepareStatement("update libro set titulo= ?, autor=?, stock=? where id= ?");
			ps.setString(1, libro.getTitulo());
			ps.setString(2, libro.getAutor());
			ps.setInt(3, libro.getStock());
			ps.setInt(4, 2);
			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			System.out.println("no se pudo actualizar el libro " + e);
			e.printStackTrace();
		}
		ConexionBaseDatos.cerrarConexion(conexion);
		return "se actualizo el libro" + true;
	}

	public static String eliminarLibro(String idLibro) {
		conexion = (Connection) ConexionBaseDatos.conexion();
		try {
			PreparedStatement ps = (PreparedStatement) conexion
					.prepareStatement("delete from libro where id=?");
			ps.setInt(1, Integer.parseInt(idLibro));
			ps.execute();
			ps.close();
		} catch (Exception e) {
			System.out.println("no se pudo eliminar el libro " + e);
			e.printStackTrace();
		}
		ConexionBaseDatos.cerrarConexion(conexion);
		return "se elimino el libro";
	}

	public static Libro consultarLibro(String idLibro) {
		conexion = (Connection) ConexionBaseDatos.conexion();
		List<Libro> librosConsultados = new ArrayList<Libro>();
		Libro libro = new Libro();
		try {
			PreparedStatement ps = (PreparedStatement) conexion
					.prepareStatement("select * from libro where id=? ");
			ps.setInt(1, Integer.parseInt(idLibro));
			ResultSet libros = ps.executeQuery();
			while (libros.next()) {
				libro.setAutor(libros.getString("autor"));
				libro.setTitulo(libros.getString("titulo"));
				libro.setStock(libros.getInt("stock"));
			}
		} catch (Exception e) {
			System.out.println("no se pudo consultar el libro " + e);
			e.printStackTrace();
		}
		ConexionBaseDatos.cerrarConexion(conexion);
		return libro;
	}

}
