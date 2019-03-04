package servicios;

import datos.Datos;
import excepciones.DAOException;
import model.Peliculas;
import datos.DatosCat;
import model.Categoria;

public class Servicios implements IServicios{

	@Override
	public void altaPeliculas(Peliculas peli) throws DAOException {
		new Datos().altaPeliculas(peli);
	}
	public void bajaPeliculas(int id) throws DAOException {
		new Datos().bajaPeliculas(id);
	}
	public void altaCategorias(Categoria cate) throws DAOException {
		new DatosCat().altaCategorias(cate);
	}

	
}
