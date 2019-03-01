package utilidades;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import excepciones.LecturaException;


public class LecturaDatos {
	
	private static final Logger logger = LogManager.getLogger("Clase_Lectura_Datos");
	private static String valor;
	
	public static BufferedReader leer_dato() {
		return new BufferedReader(new InputStreamReader(System.in));
	}
	
	public static String leerString() throws LecturaException {

		logger.info("Lectura String");
		try {
			valor = leer_dato().readLine();
			return (String) valor;
		} catch (IOException e) {
			throw new LecturaException(valor, e);
		}
	}
	
	public static String leerString(String msg) throws LecturaException{
		System.out.print(msg);
		return leerString();
	}
	
	public static int leerInt() throws LecturaException {
		logger.log(Level.INFO,"Lectura Int");
		try {
			valor = leer_dato().readLine();
			return Integer.parseInt((String) valor);
		} catch (NumberFormatException | IOException e) {
			throw new LecturaException(valor, e);
		}
	}
	
	public static int leerInt(String msg) throws LecturaException {
		System.out.print(msg);
		return leerInt();
	}
	
	public static double leerDouble() throws LecturaException {
		logger.info("Lectura Double");
		try {
			valor = leer_dato().readLine();
			return Double.parseDouble(valor);
		} catch (NumberFormatException | IOException e) {
			throw new LecturaException(valor, e);
		}
	}
	
	public static double leerDouble(String msg) throws LecturaException {
		System.out.print(msg);
		return leerDouble();
	}
	
	public static float leerFloat() throws LecturaException {
		logger.info("Lectura float");
		try {
			valor = leer_dato().readLine();
			return Float.parseFloat(valor);
		} catch (NumberFormatException | IOException e) {
			throw new LecturaException(valor, e);
			
		}
		
	}
	
	public static float leerFloat(String msg) throws LecturaException {
		System.out.print(msg);
		return leerFloat();
		
	}
	
	@SuppressWarnings("resource")
	public static boolean leerBoolean() {
		logger.info("Lectura Boolean");
		if(new Scanner(System.in).next().equalsIgnoreCase("Si")) {
			return true;
		}else if(new Scanner(System.in).next().equalsIgnoreCase("No")){
			return false;
		}else {
			System.err.println("Error, Intentelo de nuevo\n");
			return leerBoolean();
		}
		
	}
	
	public static boolean leerBoolean(String msg) {
		System.out.print(msg);
		return leerBoolean();
	}
	

	
	
	
	
	

}
