package model;
import utilidades.LecturaDatos;

public class Categoria {

	// ATRIBUTO
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

	@Override
	public String toString() {
		return "Categoria [idCategorias=" + idCategorias + ", nombreCat=" + nombreCat + "]";
	}
	

	public void crearCat() {
		try {
			this.setIdCategorias(LecturaDatos.leerInt("Introduzca un ID"));
			this.setNombreCat(LecturaDatos.leerString("Introduzca el nombre de la categoría"));
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
	}

}

