package datos;
import excepciones.DAOException;
import excepciones.LecturaException;

public interface I_datos_usuarios {

	public void alta(Object obj); //interfaz creada

	public void baja(int id)throws DAOException;

	public void listado();
	
	public void modificar(int id)throws LecturaException, DAOException;

	
}
