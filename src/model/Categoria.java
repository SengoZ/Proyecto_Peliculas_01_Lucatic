package model;

import utilidades.LecturaDatos;

/**
 * Clase Categoria
 *
 * Contiene informacion de las categorías
 *
 * @author Grupo 3
 * @version 1.0
 * 
 */

public class Categoria {
	
	//ATRIBUTOS
	
	private int idCategorias;
	private String nombreCat;

	//CONSTRUCTORES
	
	public Categoria() {
		super();
	}
	
	public Categoria(int idCategorias, String nombreCat) {
		super();
		this.idCategorias = idCategorias;
		this.nombreCat = nombreCat;
	}
	
	//GETTERS & SETTERS
	
	public int getIdCategorias() {
		return idCategorias;
	}

	public void setIdCategorias(int idCategorias) {
		this.idCategorias = idCategorias;
	}

	public String getNombreCat() {
		return nombreCat;
	}

	public void setNombreCat(String nombreCat) {
		this.nombreCat = nombreCat;
	}

	//TO STRING
	
	@Override
	public String toString() {
		return "Categoria [idCategorias=" + idCategorias + ", nombreCat=" + nombreCat + "]";
	}

	//MÉTODOS PÚBLICOS

	/**
	 * Método para crear un objeto tipo Categoría
	 * Se introduce el nombre de la categoría (String) usando Scanner
	 */
	public void crearCat() {
		try {
			
			this.setNombreCat(LecturaDatos.leerString("Introduzca el nombre de la categoría"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * Método para imprimir un objeto tipo Categoría a través del to Strings
	 */
	public void imprimirCat() {
		System.out.println(this.toString());
	}
}
