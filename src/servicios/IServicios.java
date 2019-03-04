package servicios;
import excepciones.DAOException;
import model.Categoria;
import model.Peliculas;
public interface IServicios {
	
	public void altaPeliculas(Peliculas peli) throws DAOException;
	public void bajaPeliculas(int id) throws DAOException;
	public void altaCategorias(Categoria cate) throws DAOException;
}
