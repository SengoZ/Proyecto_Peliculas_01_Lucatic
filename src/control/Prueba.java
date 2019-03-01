package control;
import control.Arranque;
import datos.Datos;
import excepciones.DAOException;
import model.Categoria;
import model.Peliculas;
public class Prueba {

	Arranque hola = new Arranque();
	public void prueba1() throws DAOException {
		new Datos().altaPeliculas(new Peliculas(1,"los vengadores",2018,1));
	}
}
