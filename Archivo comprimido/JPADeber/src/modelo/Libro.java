package modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Libro database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Libro.findAll", query="SELECT l FROM Libro l"),
    @NamedQuery(name = "Libro.findByIdLibro", query = "SELECT l FROM Libro l WHERE l.id = :idLibro")})

public class Libro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String autor;

	private int stock;

	private String titulo;

	public Libro() {
	}

	
	public Libro(String autor, String titulo, int stock) {
		super();
		this.autor = autor;
		this.stock = stock;
		this.titulo = titulo;
	}


	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAutor() {
		return this.autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getStock() {
		return this.stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}