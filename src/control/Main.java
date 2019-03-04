package control;
import datos.Datos;
import datos.DatosCat;
import datos.I_DatosCat;
import datos.I_datos;
import excepciones.DAOException;
import excepciones.LecturaException;
import model.Peliculas;
import model.Categoria;


public class Main {
 //// ultima version Amador y Sheila

	public static void main(String[] args) throws DAOException, LecturaException {

		Arranque menu = new Arranque();
		menu.menu();

	}
}