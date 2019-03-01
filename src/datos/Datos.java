package datos;

import java.sql.SQLException;

import com.mysql.jdbc.Statement;
import excepciones.DAOException;
import model.Peliculas;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Datos implements I_datos {
	
	private static final Logger log = LogManager.getLogger("Datos");
	
	@Override
	public void altaPeliculas(Peliculas peli) throws DAOException {//es necesario actualizar este metodo.
		try (Statement stmt = (Statement) ConexionBBDD.Conecta_BBDD().createStatement()){
			String query = "INSERT INTO PELICULAS VALUES ("+peli.getIdPelicula()+", '" + peli.getNombre()+"' ,"+peli.getAnioEstreno()+ " ,"+peli.getCategoria()+")";
			log.info("-----"+query);
			//da un error
			if(stmt.executeUpdate(query) != 1) {
				throw new DAOException("Error añadiendo pelicula");
				//log.error("Ha ocurrido un error al incluir una película");
			}
		}catch(SQLException se) {
			se.printStackTrace();
			System.out.println("---"+se.getSQLState());
			System.out.println("---"+se.getErrorCode());
			System.out.println("---"+se.getMessage());
			throw new DAOException(" Error añadiendo pelicula en DAO");
		}
	}
}
