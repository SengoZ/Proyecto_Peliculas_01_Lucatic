package control;
import control.Arranque;
import datos.Datos;
import excepciones.DAOException;
import model.Categoria;
import model.Peliculas;
import datos.DatosCat;
public class Prueba {

	Arranque hola = new Arranque();
	public void prueba1() throws DAOException {
		new Datos().altaPeliculas(new Peliculas(1,"los vengadores",2018,1));
	}
	
	public void prueba2() throws DAOException {
		new DatosCat().altaCategorias(new Categoria());
	}
}
