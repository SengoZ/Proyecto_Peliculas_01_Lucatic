package utilidades;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import excepciones.LecturaException;
/**
 * Clase LecturaDatos
 * 
 * Contiene los m�todos para la introducci�n de datos a trav�s de la consola
 * 
 * @author Grupo 3
 * @verison 1.0
 *
 */
public class LecturaDatos {
    
    //ATRIBUTOS
    
    private static final Logger logger = LogManager.getLogger("Clase_Lectura_Datos");
    private static String valor;
    
    //M�TODOS P�BLICOS
    
    /**
     * M�todo para crear un objeto tipo BufferedReader para llevar a cabo la introducci�n de datos a trav�s de la consola
     * @return objeto tipo bufferedreader
     */
    public static BufferedReader leer_dato() {
        return new BufferedReader(new InputStreamReader(System.in));
    }
    
    /**
     * M�todo para lectura de datos tipo String
     * @return dato tipo String desde la consola
     * @throws LecturaException
     */
    public static String leerString() throws LecturaException {
        try {
            valor = leer_dato().readLine();
            return (String) valor;
        } catch (IOException e) {
            logger.error("Error tipo formato. Se debe introducir dato tipo String");
            throw new LecturaException(valor, e);
        }
    }
    
    /**
     * M�todo para establecer el texto en lectura de datos tipo String
     * @param msg (String)
     * @return dato String introducido con m�todo leerString()
     * @throws LecturaException
     */
    public static String leerString(String msg) throws LecturaException{
        System.out.print(msg);
        return leerString();
    }
    
    /**
     *M�todo para lectura de datos tipo int
     * @return dato tipo int desde la consola
     * @throws LecturaException
     */
    public static int leerInt() throws LecturaException {
        try {
            valor = leer_dato().readLine();
            return Integer.parseInt((String) valor);
        } catch (NumberFormatException | IOException e) {
            logger.error("Error tipo formato. Se debe introducir dato tipo int");
            throw new LecturaException(valor, e);
        }
    }
    
    /**
     * M�todo para establecer el texto en lectura de datos tipo int
     * @param msg (String)
     * @return dato String introducido con m�todo leerInt()
     * @throws LecturaException
     */
    public static int leerInt(String msg) throws LecturaException {
        System.out.print(msg);
        return leerInt();
    }
    
    /**
     * M�todo para lectura de datos tipo double
     * @return dato tipo double desde la consola
     * @throws LecturaException
     */
    public static double leerDouble() throws LecturaException {
        try {
            valor = leer_dato().readLine();
            return Double.parseDouble(valor);
        } catch (NumberFormatException | IOException e) {
            logger.error("Error tipo formato. Se debe introducir dato tipo double");
            throw new LecturaException(valor, e);
        }
    }
    
    /**
     * M�todo para establecer el texto en lectura de datos tipo double
     * @param msg (String)
     * @return dato String introducido con m�todo leerDouble()
     * @throws LecturaException
     */
    public static double leerDouble(String msg) throws LecturaException {
        System.out.print(msg);
        return leerDouble();
    }
    
    /**
     * M�todo para lectura de datos tipo float
     * @return dato tipo float desde la consola
     * @throws LecturaException
     */
    public static float leerFloat() throws LecturaException {
        try {
            valor = leer_dato().readLine();
            return Float.parseFloat(valor);
        } catch (NumberFormatException | IOException e) {
            logger.error("Error tipo formato. Se debe introducir dato tipo float");
            throw new LecturaException(valor, e);   
        }   
    }
    
    /**
     * M�todo para establecer el texto en lectura de datos tipo float
     * @param msg (String)
     * @return dato String introducido con m�todo leerFloat()
     * @throws LecturaException
     */
    public static float leerFloat(String msg) throws LecturaException {
        System.out.print(msg);
        return leerFloat();
    }
    
    /**
     * M�todo para lectura de datos tipo boolean
     * @return dato tipo boolean desde la consola
     */
    @SuppressWarnings("resource")
    public static boolean leerBoolean() {
        if(new Scanner(System.in).next().equalsIgnoreCase("Si")) {
            return true;
        }else if(new Scanner(System.in).next().equalsIgnoreCase("No")){
            return false;
        }else {
            System.err.println("Error, Intentelo de nuevo\n");
            return leerBoolean();
        }   
    }
    
    /**
     * M�todo para establecer el texto en lectura de datos tipo boolean
     * @param msg (String)
     * @return dato String introducido con m�todo leerBoolean()
     */
    public static boolean leerBoolean(String msg) {
        System.out.print(msg);
        return leerBoolean();
    }   
    
}
