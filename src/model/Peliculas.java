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
	private int catUsuario;
	

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
	public int getVisualizaciones() {
		return visualizaciones;
	}

	public void setVisualizaciones(int visualizaciones) {
		this.visualizaciones = visualizaciones;
	}
	public int getCatUsuario() {
		return catUsuario;
	}

	public void setCatUsuario(int catUsuario) {
		this.catUsuario = catUsuario;
	}
	
	// Constructor
	public Peliculas() {
		super();
	}
	

	public Peliculas(int idPelicula, String nombre, int anioEstreno, int categoria, int visualizaciones, int catUsuario) {
		super();
		IdPelicula = idPelicula;
		this.nombre = nombre;
		this.anioEstreno = anioEstreno;
		this.categoria = categoria;
		this.visualizaciones=visualizaciones;
		this.catUsuario=catUsuario;
	}
	public Peliculas(int idPelicula, String nombre, int anioEstreno, int categoria) {
		super();
		IdPelicula = idPelicula;
		this.nombre = nombre;
		this.anioEstreno = anioEstreno;
		this.categoria = categoria;
		this.visualizaciones=0;
	}
	
	// M�todo toString
	@Override
	public String toString() {
		return "Peliculas [ID = " + IdPelicula + ", NOMBRE " + nombre + ", A�O ESTRENO " + anioEstreno
				+ ", CATEGORIA " + categoria + ", VISUALIZACIONES = " + visualizaciones + "CATEGORIA PARA USUARIO = "+ catUsuario+"]";
	}
	
	public void crearPelicula() {
		 try {
			 	this.nombre = LecturaDatos.leerString("Introduzca el nombre de la pel�cula");
			 	this.anioEstreno = LecturaDatos.leerInt("Introduzca el a�o de estreno de la pel�cula");
			 	this.categoria = LecturaDatos.leerInt("Introduzca la categor�a");

	        } catch (Exception e) {
	            e.getStackTrace();
	        }
	}
	public void imprimirPelicula() {
		System.out.println(this.toString());
	}

}
