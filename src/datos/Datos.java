package datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import excepciones.DAOException;
import model.Peliculas;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Datos implements I_datos {
	
	private static final Logger log = LogManager.getLogger("Datos");
	
	//@Override
	public void altaPeliculas(Peliculas peli) throws DAOException {//es necesario actualizar este metodo.
		try (Statement stmt = (Statement) Conexion_BBDD_prueba.Conecta_BBDD().createStatement()){
			System.out.println("-------------------------------------------Errorrrrrrr");
			String query = "INSERT INTO PELICULAS(NOMBRE, ANIOESTRENO, CATEGORIA) VALUES ('" + peli.getNombre()+"' ,"+peli.getAnioEstreno()+ " ,"+peli.getCategoria()+")";
			if(stmt.executeUpdate(query) != 1) {
				System.out.println("Errorrrrrrr");
				//throw new DAOException("Error añadiendo pelicula");
			}
		}catch(SQLException se) {
			se.printStackTrace();
			System.out.println("---"+se.getSQLState());
			System.out.println("---"+se.getErrorCode());
			System.out.println("---"+se.getMessage());
			log.error("----------------Error SQL en alta peliculas");
		}/*catch(DAOException se2) {
			log.error("----------------Error DAO en alta peliculas");
		}*/
		
	}@Override
    public void bajaPeliculas(int id) throws DAOException {
        try (Statement stmt = (Statement) Conexion_BBDD_prueba.Conecta_BBDD().createStatement()) {
            Peliculas peli = findById(id);
             if (peli == null) {
                 log.error("----------------No se ha encontrado pelicula con dicha ID en baja pelicula");
                 throw new DAOException("Pelicula id: " + id + " no existe para eliminarla.");
             }
            String query = "DELETE FROM PELICULAS WHERE ID=" + id;
            if (stmt.executeUpdate(query) != 1) {
                log.error("----------------Problema al introducir la QUERY en baja peliculas");
                throw new DAOException("Excepcion DAO, en baja peliculas");
            }
        } catch (SQLException se) {
			se.printStackTrace();
			System.out.println("---"+se.getSQLState());
			System.out.println("---"+se.getErrorCode());
			System.out.println("---"+se.getMessage());
            throw new DAOException("Error borrando película in DAO", se);
        }catch(DAOException se2) {
		log.error("----------------Error DAO en baja peliculas");
        }
	}
 
 // Find an Employee record using this ID

     public Peliculas findById(int id) throws DAOException {
         try (Statement stmt = (Statement) Conexion_BBDD_prueba.Conecta_BBDD().createStatement()) {
             String query = "SELECT * FROM PELICULAS WHERE ID=" + id;
             ResultSet rs = stmt.executeQuery(query);
             if (!rs.next()) {
            	 log.error("----------------No existe ID");
                 return null;
             }
             return (new Peliculas(rs.getInt("ID"), rs.getString("NOMBRE"), rs.getInt("ANIOESTRENO"), rs.getInt("CATEGORIA")));
         } catch (SQLException se) {
 			se.printStackTrace();
 			System.out.println("---"+se.getSQLState());
 			System.out.println("---"+se.getErrorCode());
 			System.out.println("---"+se.getMessage());
 			log.error("----------------Error SQL en alta peliculas");
 			return null;
         }
     }
     
 	//
 	// Método "listadoPeliculas()" sin parámetros de entrada, 
 	// 
 	//
     
     public void listadoPeliculas() throws DAOException {
 		try (Statement stmt = (Statement) Conexion_BBDD_prueba.Conecta_BBDD().createStatement()) {
 			String query = "SELECT * FROM PELICULAS";
 			ResultSet rs = stmt.executeQuery(query);

 			while (rs.next()) {
 				Peliculas peli = new Peliculas(rs.getInt("ID"), rs.getString("NOMBRE"), rs.getInt("ANIOESTRENO"), rs.getInt("CATEGORIA"));
 				peli.imprimirPelicula();
 			}
         } catch (SQLException se) {
 			se.printStackTrace();
 			System.out.println("---"+se.getSQLState());
 			System.out.println("---"+se.getErrorCode());
 			System.out.println("---"+se.getMessage());
 			log.error("----------------Error SQL en alta peliculas");
 		}
 	}
 	
 	//
 	// Método MASVISTAS: sin parámentros de entrada, devuelve por pantalla un listado de las peliculas
 	// más vistas por un usuario.
 	//
 	
 	public void masVistas() {
 		try (Statement stmt = (Statement) ConexionBBDD.Conecta_BBDD().createStatement()) {
 			String query = "SELECT * FROM PELICULAS ORDER BY VISUALIZACIONES DESC"; 
 			ResultSet rs = stmt.executeQuery(query);
 			while (rs.next()) {
 				new Peliculas(rs.getInt("ID"), rs.getString("NOMBRE"), rs.getInt("ANIOESTRENO"), rs.getInt("CATEGORIA"), rs.getInt("VISUALIZACIONES")).imprimirPelicula();
 			}
         } catch (SQLException se) {
 			se.printStackTrace();
 			System.out.println("---"+se.getSQLState());
 			System.out.println("---"+se.getErrorCode());
 			System.out.println("---"+se.getMessage());
 			log.error("----------------Error SQL en alta peliculas");
         }
 	}
 }
