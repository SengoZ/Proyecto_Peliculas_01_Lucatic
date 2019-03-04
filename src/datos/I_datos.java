package datos;

import excepciones.DAOException;
import model.Peliculas;

public interface I_datos {

	public void altaPeliculas(Peliculas peli) throws DAOException; //interfaz creada

	public void bajaPeliculas(int id) throws DAOException;

	
}
