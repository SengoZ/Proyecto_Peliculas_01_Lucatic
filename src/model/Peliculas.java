package model;
import utilidades.LecturaDatos;

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
	private int IdPelicula;
	private String nombre;
	private int anioEstreno;
	private int categoria;

	

	// Getter y Setter
	public int getIdPelicula() {
		return IdPelicula;
	}
	public void setIdPelicula(int idPelicula) {
		IdPelicula = idPelicula;
	}
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
	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
	
	// Constructor
	public Peliculas() {
		super();
	}
	

	public Peliculas(int idPelicula, String nombre, int anioEstreno, int categoria) {
		super();
		IdPelicula = idPelicula;
		this.nombre = nombre;
		this.anioEstreno = anioEstreno;
		this.categoria = categoria;
	}
	
	// Método toString
	@Override
	public String toString() {
		return "Peliculas [IdPelicula=" + IdPelicula + ", nombre=" + nombre + ", anioEstreno=" + anioEstreno
				+ ", categoria=" + categoria + "]";
	}
	
	public void crearPelicula() {
		 try {
	            this.IdPelicula = LecturaDatos.leerInt("Introduzca un ID");
			 	this.nombre = LecturaDatos.leerString("Introduzca el nombre de la película");
			 	this.anioEstreno = LecturaDatos.leerInt("Introduzca el año de estreno de la película");
			 	this.categoria = LecturaDatos.leerInt("Introduzca la categoría");

	        } catch (Exception e) {
	            e.getStackTrace();
	        }
	}

}
