package servicios;

import java.text.ParseException;

import datos.Datos;
import excepciones.DAOException;
import excepciones.LecturaException;
import model.Peliculas;
import datos.DatosCat;
import datos.GestionUsuario;
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

	public void bajaCategorias(int idCategorias) throws DAOException {
		new DatosCat().bajaCategorias(idCategorias);
	}
	
	public void crearUsuario() throws LecturaException, ParseException{
		new GestionUsuario().crearUsuario();
	}
	
	public void bajaUsuario(int id) throws DAOException{
		new GestionUsuario().baja(id);
	}
	
	public void listadoUsuario() {
		new GestionUsuario().listado();
	} 
	
	public void modificar(int id) throws LecturaException, DAOException{
		new GestionUsuario().modificar(id);
	}

	public void modificacionCategorias(int idCategorias) throws DAOException, LecturaException {
		new DatosCat().modificarCategorias(idCategorias);
		
	}
	public void listadoCat() throws DAOException {
		new DatosCat().listadoCat();
}
	public void listadoPeliCat(int id) throws DAOException {
		new DatosCat().listadoPeliCat(id);
		
	}
	
}
