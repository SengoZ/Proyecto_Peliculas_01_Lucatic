package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionBBDD {
	Connection con = null;
	Statement st = null;
	ConexionBBDD(){
		String driverClassName = "com.mysql.jdbc.Diver";
		String driverUrl = "jdbc:mysql://192.168.101.111/proyect_peli";
		String user = "root";
		String pass = "root";
		try {
			Class.forName(driverClassName);
			con = DriverManager.getConnection(driverUrl, user, pass);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
