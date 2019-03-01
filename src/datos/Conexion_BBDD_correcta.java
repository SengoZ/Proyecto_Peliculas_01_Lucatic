package datos;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp.ConnectionFactory;
import org.apache.commons.dbcp.DriverManagerConnectionFactory;
import org.apache.commons.dbcp.PoolableConnectionFactory;
import org.apache.commons.dbcp.PoolingDataSource;
import org.apache.commons.pool.impl.GenericObjectPool;


public class Conexion_BBDD_correcta {

	private static GenericObjectPool gPool = null;
	// JDBC Driver Name & Database URL
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    private static final String JDBC_DB_URL = "jdbc:mysql://localhost/movie_flix"; // PON LA BASE DE DATOS LOCAL!!!!!!!!!!!!!
    //static final String JDBC_DB_URL = "jdbc:mysql://192.168.101.112:3306/movie_flix"; //-> -> Base de datos general, tocar lo menos posible
 
    // JDBC Database Credentials
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASS = "root";


	private static DataSource setUpPool() {
		try {
			Class.forName(JDBC_DRIVER);
	        // Creates an Instance of GenericObjectPool That Holds Our Pool of Connections Object!
	        gPool = new GenericObjectPool();
	        gPool.setMaxActive(5);
	        
	     // Creates a ConnectionFactory Object Which Will Be Use by the Pool to Create the Connection Object!
	        ConnectionFactory cf = new DriverManagerConnectionFactory(JDBC_DB_URL, JDBC_USER, JDBC_PASS);
	         
	        // Creates a PoolableConnectionFactory That Will Wraps the Connection Object Created by the ConnectionFactory to Add Object Pooling Functionality!
	        @SuppressWarnings("unused")
			PoolableConnectionFactory pcf = new PoolableConnectionFactory(cf, gPool, null, null, false, true);
	        
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return new PoolingDataSource(gPool);
	}
	
	public static Connection Conecta_BBDD() {
		try {
			return setUpPool().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static void cerrar_conexion(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}