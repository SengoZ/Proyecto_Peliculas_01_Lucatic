package control;
import datos.Datos;
import datos.I_datos;
import excepciones.DAOException;
import model.Peliculas;
import model.Categoria;

public class Main {


	public static void main(String[] args) throws DAOException {
		I_datos prueba = new Datos();
		Categoria drama = new Categoria("animacion");
		Peliculas peli = new Peliculas(1,"Los vengadores",2018,drama);
		prueba.altaPeliculas(peli);
}

}
