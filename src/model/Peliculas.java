package model;

/**
 * Clase Peliculas
 *
 * Contiene informacion de las pel�culas
 *
 * @author Sheila
 * @version 1.0
 * @date 01/03/2019
 */
public class Peliculas {

	// ATRIBUTOS
	/**
	 * Se definen los atributos nombre, anioEstreno y categor�a de las pel�culas
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
	// Constructores. Con par�metros y vac�o

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
