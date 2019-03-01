package servicios;
import excepciones.DAOException;
import model.Peliculas;
public interface IServicios {
	
	public void altaPeliculas(Peliculas peli) throws DAOException;
	public void bajaPeliculas(int id) throws DAOException; 
}
