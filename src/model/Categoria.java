package model;

/**
 * Clase Categorias
 *
 * Contiene informacion de las categorias
 *
 * @author Sheila
 * @version 1.0
 * @date 01/03/2019
 */
public class Categoria {

	// ATRIBUTO
	/**
	 * Se define el atributo nombreCategoría
	 */
	private String nombreCategoria;
	// GETTER Y SETTER

	public String getNombreCategoria() {
		return nombreCategoria;
	}

	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}

	// ToString
	@Override
	public String toString() {
		return "Categoria [nombreCategoria=" + nombreCategoria + "]";
	}

	//CONSTRUCTORES
	
	public Categoria(String nombreCategoria) {
		super();
		this.nombreCategoria = nombreCategoria;
	}

	public Categoria() {
		super();
	}

}
