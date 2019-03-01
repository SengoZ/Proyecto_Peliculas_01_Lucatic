package model;

/**
 * Clase Peliculas
 *
 * Contiene informacion de las películas
 *
 * @author Sheila
 * @version 1.0
 * @date 01/03/2019
 */
public class Peliculas {

	// ATRIBUTOS
	/**
	 * Se definen los atributos nombre, anioEstreno y categoría de las películas
	 */

	private String nombre;
	private int anioEstreno;
	private Categoria categoria;

	// Getter y Setter

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getAnioEstreno() {
		return anioEstreno;
	}

	public void setAnioEstreno(int anioEstreno) {
		this.anioEstreno = anioEstreno;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	// ToString
	@Override
	public String toString() {
		return "Peliculas [nombre=" + nombre + ", anioEstreno=" + anioEstreno + "]";
	}
	// Constructores. Con parámetros y vacío

	public Peliculas(String nombre, int anioEstreno, Categoria categoria) {
		super();
		this.nombre = nombre;
		this.anioEstreno = anioEstreno;
		this.categoria = categoria;
	}

	public Peliculas() {
		super();
	}

}
