package datos;

import model.Categoria;
import model.Peliculas;
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
	
	/*
     * Método para realizar el alta de una nueva categoría
     * @param (objeto del tipo categoría: id (int) y nombre (String))
     */
	
	public void altaCategorias(Categoria cat) throws DAOException {// es necesario actualizar este metodo.
		try (Statement stmt = (Statement) ConexionBBDD.Conecta_BBDD().createStatement()) {
			String query = "INSERT INTO CATEGORIAS(NOMBRECAT) VALUES ('" + cat.getNombreCat()+"')";
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
		try (Statement stmt = (Statement) ConexionBBDD.Conecta_BBDD().createStatement()) {
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


	public Categoria findById(int idCategorias) throws DAOException {
		try (Statement stmt = (Statement) ConexionBBDD.Conecta_BBDD().createStatement()) {
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

	public void modificarCategorias(int idCategorias) throws LecturaException, DAOException {
		idCategorias = LecturaDatos.leerInt("Por favor, introduzca el ID de la categoría a modificar");
		try (Statement stmt = (Statement) ConexionBBDD.Conecta_BBDD().createStatement()) {
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
		/*
		 * Método para llevar a cabo el listado de todas las categorías
		 */
		public void listadoCat() throws DAOException {
	        try (Statement stmt = (Statement) ConexionBBDD.Conecta_BBDD().createStatement()) {
	            String query = "SELECT * FROM CATEGORIAS";
	            ResultSet rs = stmt.executeQuery(query);

	            while (rs.next()) {
	                Categoria cate = new Categoria(rs.getInt("IDCATEGORIAS"), rs.getString("NOMBRECAT"));
	                cate.imprimirCat();
	            }
	        } catch (SQLException se) {
	            // se.printStackTrace();
	            throw new DAOException("Error para obtener el listado de las categorías" + se.getMessage(), se);
	        }
	    }
		
		/*
		 * Método para realizar el listado de las películas por la categoría
		 * @param (id (int) que indica el numero de la categoría para filtrar
		 */ 
		public void listadoPeliCat(int id) throws DAOException {
	         try (Statement stmt = (Statement) ConexionBBDD.Conecta_BBDD().createStatement()) {
	             String query = "SELECT * FROM PELICULAS";
	             ResultSet rs = stmt.executeQuery(query);

	             while (rs.next()) {
	                 if(id==rs.getInt("CATEGORIA")) {
	                     Peliculas peli = new Peliculas(rs.getInt("ID"), rs.getString("NOMBRE"), rs.getInt("ANIOESTRENO"), rs.getInt("CATEGORIA"), rs.getInt("VISUALIZACIONES"));
	                     peli.imprimirPelicula();
	                 }
	          //log.info("Comprobando listado");
	             }
	         } catch (SQLException se) {
	             // se.printStackTrace();
	             throw new DAOException("Error para obtener el listado de las películas por la categoría" + id + ": " + se.getMessage(), se);
	         }
	     }
	}

		
