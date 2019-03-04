package datos;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.GregorianCalendar;

import excepciones.DAOException;
import excepciones.LecturaException;
import model.Usuario;
import utilidades.LecturaDatos;


public class GestionUsuario implements I_datos_usuarios{
	
	 ResultSet rsObj = null;
     Statement pstmtObj = null;
     String query;

     public void crearUsuario() throws LecturaException, ParseException {
    	 Usuario user = new Usuario();
    	 user.setNombre_completo(LecturaDatos.leerString("Introduzca nombre completo: "));
    	 user.setDate(fecha_nacimiento());
    	 user.setCiudad(LecturaDatos.leerString("Introduzca ciudad: "));
    	 user.setCategoria(0);
    	 alta(user);
     }
	public void alta(Object obj) {
	
		try (Statement stmt = (Statement) Conexion_BBDD_prueba.Conecta_BBDD().createStatement()){
			String query = "INSERT INTO CLIENTES(NOMBRE_COMPLETO_USUARIO, FECHA_NACIMIENTO, CIUDAD, CATEGORIA) VALUES ('" + ((Usuario)obj).getNombre_completo()+"' ,'"+((Usuario)obj).getDate()+ "' ,'" + ((Usuario)obj).getCiudad()+"', "+((Usuario)obj).getCategoria()+")";
			if(stmt.executeUpdate(query) != 1) {
				System.out.println("Error al introducir usuario");
				//log.error("Ha ocurrido un error al incluir una película");
			}
		}catch(SQLException se) {
			se.printStackTrace();
			System.out.println("---"+se.getSQLState());
			System.out.println("---"+se.getErrorCode());
			System.out.println("---"+se.getMessage());
		}
	}

	@Override
	public void baja(int id) throws DAOException {
		Usuario user = findById(id);
        //log.info("----------------------------La ID la ha encontrado");
         if (user == null) {
        	 System.out.println("Usuario no encontrado");
        	 //log.info("----------------------------La ID que quieres eliminar no existe");
             throw new DAOException("Usuario id: " + id + " no existe.");
         }
         try (Statement stmt = (Statement) Conexion_BBDD_prueba.Conecta_BBDD().createStatement()) {
        	 //log.info("-------------------------La conexion se ha realizado correctamente");
             String query = "DELETE FROM CLIENTES WHERE IDCLIENTES=" + id;
        	 //log.info("-------------------------Query Creada");
             if (stmt.executeUpdate(query) != 1) {

                 //  throw new DAOException("------------------Abre los ojos¡¡¡¡");
               }
         } catch (SQLException se) {
             //se.printStackTrace();
 			se.printStackTrace();
 			System.out.println("---"+se.getSQLState());
 			System.out.println("---"+se.getErrorCode());
 			System.out.println("---"+se.getMessage());
             //throw new DAOException("Error borrando película in DAO", se);
         }
	}

	@Override
	public void listado() {
		try (Statement stmt = (Statement) Conexion_BBDD_prueba.Conecta_BBDD().createStatement()) {
            String query = "SELECT * FROM CLIENTES";
		  	//log.info("-----"+query);
            ResultSet rs = stmt.executeQuery(query);
 		  	//log.info("-----"+rs);
            while(rs.next()) {
            	Usuario user = new Usuario();
                user.setIdcliente(rs.getInt("idClientes"));
                user.setNombre_completo(rs.getString("nombre_completo_usuario"));
                user.setDate(rs.getDate("fecha_nacimiento"));
                user.setCiudad(rs.getString("ciudad"));
                user.setCategoria(rs.getInt("categoria"));
                System.out.println(user);
            }
        } catch (SQLException se) {
 			se.printStackTrace();
 			System.out.println("---"+se.getSQLState());
 			System.out.println("---"+se.getErrorCode());
 			System.out.println("---"+se.getMessage());
            //throw new DAOException("Error finding employee in DAO", se);
        }
	}
	
	public Date fecha_nacimiento() throws LecturaException {
		System.out.println("Introduzca Fecha de nacimiento: ");
		int dia = LecturaDatos.leerInt("Introduzca dia: ");
		int mes = LecturaDatos.leerInt("Introduzca mes: ");
		int year = LecturaDatos.leerInt("Introduzca año: ");
   	 	
   	 	return new Date(new GregorianCalendar(year, mes-1, dia).getTimeInMillis());
   	 	
	}

	@Override
	public void modificar(int id) throws LecturaException, DAOException {
		try (Statement stmt = (Statement) Conexion_BBDD_prueba.Conecta_BBDD().createStatement()) {
			String query = null;
			switch (opc_modificar()) {
			case 1:
				 query = "UPDATE CLIENTES SET "
						+ "nombre_completo_usuario = '"+LecturaDatos.leerString("Introduzca nombre: ")
						+ "' WHERE idclientes="+id;
				break;
			case 2:
				query = "UPDATE CLIENTES SET "
						+ "fecha_nacimiento = "+fecha_nacimiento()
						+ "WHERE idclientes="+id;
				break;
			case 3:
				query = "UPDATE CLIENTES SET "
						+ "ciudad = '"+LecturaDatos.leerString("Introduzca Ciudad: ")
						+ "' WHERE idclientes="+id;
				break;
			}
		  	//log.info("-----"+query);
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
	
	public int opc_modificar() throws LecturaException {
		System.out.println("Indique lo que desea modificar ");
		System.out.println("1-. Nombre");
		System.out.println("2-. Fecha de Nacimiento");
		System.out.println("3-. Ciudad");
		//System.out.println("4-. Categoria");
		return LecturaDatos.leerInt("Introduzca opción: ");
	}
	
	public Usuario findById(int id) {
		try (Statement stmt = (Statement) Conexion_BBDD_prueba.Conecta_BBDD().createStatement()) {
            String query = "SELECT * FROM CLIENTES WHERE IDCLIENTES=" + id;
		  	//log.info("-----"+query);
            ResultSet rs = stmt.executeQuery(query);
 		  	//log.info("-----"+rs);
            if (!rs.next()) {

                return null;
            }
            return new Usuario(rs.getInt("idClientes"), rs.getString("nombre_completo_usuario"), rs.getDate("fecha_nacimiento"), rs.getString("ciudad"), rs.getInt("categoria"));
        } catch (SQLException se) {
 			se.printStackTrace();
 			System.out.println("---"+se.getSQLState());
 			System.out.println("---"+se.getErrorCode());
 			System.out.println("---"+se.getMessage());
            //throw new DAOException("Error finding employee in DAO", se);
        }
		return null;
	}
	

}
