package model;

import modelo.Categorias;
import utilidades.Datos;
import utilidades.LecturaDatos;

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
	private int IdPelicula;
	private String nombre;
	private int anioEstreno;
	private String categoria;
	

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
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	// Constructor
	public Peliculas() {
		super();
	}
	
	public Peliculas(int idPelicula, String nombre, int anioEstreno, String categoria) {
		super();
		IdPelicula = idPelicula;
		this.nombre = nombre;
		this.anioEstreno = anioEstreno;
		this.categoria = categoria;
	}
	
	// M�todo toString
	@Override
	public String toString() {
		return "Peliculas [IdPelicula=" + IdPelicula + ", nombre=" + nombre + ", anioEstreno=" + anioEstreno
				+ ", categoria=" + categoria + "]";
	}
	
	public void crearPelicula() {
		 try {
	            this.IdPelicula = LecturaDatos.leerInt("Introduzca un ID");
			 	this.nombre = LecturaDatos.leerString("Introduzca el nombre de la pel�cula");
			 	this.anioEstreno = LecturaDatos.leerInt("Introduzca el a�o de estreno de la pel�cula");
			 	this.categoria = LecturaDatos.leerString("Introduzca la categor�a");

	        } catch (Exception e) {
	            e.getStackTrace();
	        }
	}
}
