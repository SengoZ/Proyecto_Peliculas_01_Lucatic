package servicios;

import datos.Datos;
import excepciones.DAOException;
import model.Peliculas;

public class Servicios implements IServicios{

	@Override
	public void altaPeliculas(Peliculas peli) throws DAOException {
		new Datos().altaPeliculas(peli);
	}


	
}
