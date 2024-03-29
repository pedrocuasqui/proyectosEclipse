package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBaseDatos {
	static Connection con = null;

	public static void main(String args[]) {

	}

	/**
	 * metodo para crear una conexion con Mysql
	 * 
	 * @return
	 */
	public static Connection conexion() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/movilesdb?useSSL=false",
					"moviles", "pwd");
			System.out.println("conexion establecida ");
		} catch (Exception e) {
			System.out.println("error al conectar " + e);
		}

		return con;
	}

	/**
	 * metodo para cerrar la conexion
	 * 
	 * @param con
	 * @return
	 */
	public static void cerrarConexion(Connection con) {
		try {
			con.close();
		} catch (Exception e) {
			System.out.println("no se ha podido cerrar la onexion " + e);
		}

	}
}
