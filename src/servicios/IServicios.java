package servicios;
import java.sql.SQLException;
import java.text.ParseException;

import excepciones.DAOException;
import excepciones.LecturaException;
import model.Categoria;
import model.Peliculas;
public interface IServicios {
	
	public void altaPeliculas(Peliculas peli) throws DAOException;
	public void bajaPeliculas(int id) throws DAOException;
	public void altaCategorias(Categoria cate) throws DAOException;
	public void bajaCategorias(int idCategorias) throws DAOException;
	public void modificacionCategorias(int idCategorias) throws DAOException, LecturaException;
	public void crearUsuario() throws LecturaException, ParseException;
	public void bajaUsuario(int id) throws DAOException;
	public void listadoUsuario();
	public void modificar(int id) throws LecturaException, DAOException;
	public void listadoCat() throws DAOException;
	public void listadoPeliCat(int id) throws DAOException;
	public void listaPusuarioCat(int id) throws DAOException, SQLException;
}
