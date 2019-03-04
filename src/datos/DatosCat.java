package datos;

import model.Categoria;
import utilidades.LecturaDatos;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.mysql.jdbc.Statement;
import excepciones.DAOException;
import excepciones.LecturaException;

public class DatosCat implements I_datosCat {

	private static final Logger log = LogManager.getLogger("Datos");

	public void altaCategorias(Categoria cat) throws DAOException {// es necesario actualizar este metodo.
		try (Statement stmt = (Statement) Conexion_BBDD_prueba.Conecta_BBDD().createStatement()) {
			String query = "INSERT INTO CATEGORIAS VALUES (" + cat.getIdCategorias() + ", " + "'" + cat.getNombreCat()
					+ "'" + ")";
			log.info("-----" + query);
			// da un error
			if (stmt.executeUpdate(query) != 1) {
				throw new DAOException("Error añadiendo categoría");
				// log.error("Ha ocurrido un error al incluir una película");
			}
		} catch (SQLException se) {
			se.printStackTrace();
			System.out.println("---" + se.getSQLState());
			System.out.println("---" + se.getErrorCode());
			System.out.println("---" + se.getMessage());
			throw new DAOException(" Error añadiendo categoría en DAO");
		}

	}

	public void bajaCategorias(int idCategorias) throws DAOException {

		Categoria cat = findById(idCategorias);

		log.info("----------------------------La ID la ha encontrado");
		if (cat == null) {
			log.info("----------------------------La ID que quieres eliminar no existe");
			throw new DAOException("Categoria id: " + idCategorias + " no existe para eliminarla.");
		}
		try (Statement stmt = (Statement) Conexion_BBDD_prueba.Conecta_BBDD().createStatement()) {
			log.info("-------------------------La conexion se ha realizado correctamente");
			String query = "DELETE FROM CATEGORIAS WHERE IDCATEGORIAS=" + idCategorias;
			log.info("-------------------------Query Creada");
			if (stmt.executeUpdate(query) != 1) {

				throw new DAOException("------------------Abre los ojos¡¡¡¡");
			}
		} catch (SQLException se) {
			// se.printStackTrace();
			se.printStackTrace();
			System.out.println("---" + se.getSQLState());
			System.out.println("---" + se.getErrorCode());
			System.out.println("---" + se.getMessage());
			throw new DAOException("Error borrando categoría in DAO", se);
		}
	}

	// Find an Employee record using this ID

	public Categoria findById(int idCategorias) throws DAOException {
		try (Statement stmt = (Statement) Conexion_BBDD_prueba.Conecta_BBDD().createStatement()) {
			String query = "SELECT * FROM CATEGORIAS WHERE IDCATEGORIAS=" + idCategorias;
			log.info("-----" + query);
			ResultSet rs = stmt.executeQuery(query);
			log.info("-----" + rs);
			if (!rs.next()) {

				return null;
			}
			return (new Categoria(rs.getInt("IDCATEGORIAS"), rs.getString("NOMBRECAT")));
		} catch (SQLException se) {
			se.printStackTrace();
			System.out.println("---" + se.getSQLState());
			System.out.println("---" + se.getErrorCode());
			System.out.println("---" + se.getMessage());
			throw new DAOException("Error finding employee in DAO", se);
		}
	}

	// Return an array of all of the Employee records
	// We are using a collection List object to store the results
	// This makes it easier to just add to the collection


		public void modificarCategorias(int idCategorias) throws LecturaException, DAOException {
			idCategorias = LecturaDatos.leerInt("Por favor, introduzca el ID de la categoría a modificar");
			try (Statement stmt = (Statement) Conexion_BBDD_prueba.Conecta_BBDD().createStatement()) {
				String query = null;
				 query = "UPDATE CATEGORIAS SET "
					+ "nombreCat = '"+LecturaDatos.leerString("Introduzca el nombre de la categoría: ")
					+ "' WHERE idCategorias="+idCategorias;
	            if (stmt.executeUpdate(query) != 1) {
	                  throw new DAOException("------------------Abre los ojos¡¡¡¡");
	              }
	 		  	//log.info("-----"+rs);
	        } catch (SQLException se) {
	 			se.printStackTrace();
	 			System.out.println("---"+se.getSQLState());
	 			System.out.println("---"+se.getErrorCode());
	 			System.out.println("---"+se.getMessage());
	            //throw new DAOException("Error finding employee in DAO", se);
	        }
}


		}
