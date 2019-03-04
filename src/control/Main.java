package control;
import datos.Datos;
import datos.I_datos;
import excepciones.DAOException;
import excepciones.LecturaException;
import model.Peliculas;
import model.Categoria;


public class Main {


<<<<<<< HEAD
	public static void main(String[] args) throws DAOException, LecturaException {
		Arranque menu = new Arranque();
=======
	public static void main(String[] args) throws DAOException {

		/*Arranque menu = new Arranque();
>>>>>>> branch 'master' of https://github.com/SengoZ/Proyecto_Peliculas_01_Lucatic.git
		menu.menu();
		I_datos prueba = new Datos();
		Peliculas peli = new Peliculas(1,"Los vengadores",2018,1);
<<<<<<< HEAD
		prueba.altaPeliculas(peli);
=======
		prueba.altaPeliculas(peli);*/
		new Datos().listadoPeliculas();
>>>>>>> branch 'master' of https://github.com/SengoZ/Proyecto_Peliculas_01_Lucatic.git
	}
}