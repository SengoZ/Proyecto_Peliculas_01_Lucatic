package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBBDD {
	private static Connection con = null;
	private static String driverClassName = "com.mysql.jdbc.Driver";
	private static String driverUrl = "jdbc:mysql://localhost/project_peli";
	private static String user = "root";
	private static String pass = "root";

	public static Connection Conecta_BBDD() {
		try {
			Class.forName(driverClassName);
			con = DriverManager.getConnection(driverUrl, user, pass);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
}
