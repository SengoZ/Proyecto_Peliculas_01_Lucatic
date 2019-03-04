package model;
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
	private int categoria;
	private int visualizaciones;
		

	// Getter y Setter
	
	public int getIdPelicula() {
		return IdPelicula;
	}
	public int getVisualizaciones() {
		return visualizaciones;
	}
	public void setVisualizaciones(int visualizaciones) {
		this.visualizaciones = visualizaciones;
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
	

	public Peliculas(int idPelicula, String nombre, int anioEstreno, int categoria, int visualizaciones) {
		super();
		IdPelicula = idPelicula;
		this.nombre = nombre;
		this.anioEstreno = anioEstreno;
		this.categoria = categoria;
		this.visualizaciones = visualizaciones;
		
	}
	
	// M�todo toString

	
	@Override
	public String toString() {
		return "Peliculas [IdPelicula=" + IdPelicula + ", nombre=" + nombre + ", anioEstreno=" + anioEstreno
				+ ", categoria=" + categoria + ", visualizaciones=" + visualizaciones + "]";
	}

	
	public void crearPelicula() {
		 try {
	            this.IdPelicula = IdPelicula;
			 	this.nombre = LecturaDatos.leerString("Introduzca el nombre de la pel�cula");
			 	this.anioEstreno = LecturaDatos.leerInt("Introduzca el a�o de estreno de la pel�cula");
			 	this.categoria = LecturaDatos.leerInt("Introduzca la categor�a");
			 	this.visualizaciones = 0;
	        } catch (Exception e) {
	            e.getStackTrace();
	        }
	}
	public void imprimirPelicula() {
		System.out.println(this.toString());
	}
}

