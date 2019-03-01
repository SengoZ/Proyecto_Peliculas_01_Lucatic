package control;
import datos.Datos;
import datos.I_datos;
import excepciones.DAOException;
import model.Peliculas;
import model.Categoria;


public class Main {


	public static void main(String[] args) throws DAOException {
		Arranque menu = new Arranque();
		menu.menu();
		I_datos prueba = new Datos();
		Peliculas peli = new Peliculas(1,"Los vengadores",2018,1);
		prueba.altaPeliculas(peli);
	}
}