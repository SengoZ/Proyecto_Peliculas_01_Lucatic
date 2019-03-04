package datos;

import java.sql.ResultSet;
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
		try (Statement stmt = (Statement) Conexion_BBDD_prueba.Conecta_BBDD().createStatement()){
			String query = "INSERT INTO PELICULAS(NOMBRE, anioEstreno, categoria) VALUES ('" + peli.getNombre()+"' ,"+peli.getAnioEstreno()+ " ,"+peli.getCategoria()+")";
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
		
	}@Override
    public void bajaPeliculas(int id) throws DAOException {
		
        Peliculas peli = findById(id);
        log.info("----------------------------La ID la ha encontrado");
         if (peli == null) {
        	 log.info("----------------------------La ID que quieres eliminar no existe");
             throw new DAOException("Pelicula id: " + id + " no existe para eliminarla.");
         }
         try (Statement stmt = (Statement) Conexion_BBDD_prueba.Conecta_BBDD().createStatement()) {
        	 log.info("-------------------------La conexion se ha realizado correctamente");
             String query = "DELETE FROM PELICULAS WHERE ID=" + id;
        	 log.info("-------------------------Query Creada");
             if (stmt.executeUpdate(query) != 1) {

                 throw new DAOException("------------------Abre los ojos¡¡¡¡");
             }
         } catch (SQLException se) {
             //se.printStackTrace();
 			se.printStackTrace();
 			System.out.println("---"+se.getSQLState());
 			System.out.println("---"+se.getErrorCode());
 			System.out.println("---"+se.getMessage());
             throw new DAOException("Error borrando película in DAO", se);
         }
     }
 
 // Find an Employee record using this ID

     public Peliculas findById(int id) throws DAOException {
         try (Statement stmt = (Statement) Conexion_BBDD_prueba.Conecta_BBDD().createStatement()) {
             String query = "SELECT * FROM PELICULAS WHERE ID=" + id;
 		  	log.info("-----"+query);
             ResultSet rs = stmt.executeQuery(query);
  		  	log.info("-----"+rs);
             if (!rs.next()) {

                 return null;
             }
             return (new Peliculas(rs.getInt("ID"), rs.getString("NOMBRE"), rs.getInt("ANIOESTRENO"), rs.getInt("CATEGORIA")));
         } catch (SQLException se) {
  			se.printStackTrace();
  			System.out.println("---"+se.getSQLState());
  			System.out.println("---"+se.getErrorCode());
  			System.out.println("---"+se.getMessage());
             throw new DAOException("Error finding employee in DAO", se);
         }
     }

     // Return an array of all of the Employee records
     // We are using a collection List object to store the results
     // This makes it easier to just add to the collection
}
