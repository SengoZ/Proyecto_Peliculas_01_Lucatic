package control;

import gui.MostrarMenu;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import datos.Datos;
import excepciones.FueraDeRango;
import excepciones.LecturaException;

import java.util.InputMismatchException;
import java.util.Scanner;

import excepciones.DAOException;
import model.Peliculas;
import servicios.Servicios;
import utilidades.LecturaDatos;

public class Arranque {

	public void menu() throws DAOException, LecturaException {
		final Logger log = LogManager.getLogger("Arranque");
		@SuppressWarnings("resource")
		Scanner sn = new Scanner(System.in);
		boolean salir = false;
		int opcion;

		while (!salir) {
			MostrarMenu.mostrarMenu();

			try {
				System.out.println("\n" + "Por favor,seleccione una de las opciones del menú.");
				opcion = sn.nextInt();

				switch (opcion) {
				case 1:
					System.out.println("Ha seleccionado ALTA NUEVA PELÍCULA");
					Peliculas peli = new Peliculas();
					peli.crearPelicula();
					new Servicios().altaPeliculas(peli);
					break;
				case 2:
					System.out.println("Ha seleccionado BAJA PELÍCULA");
					new Servicios().bajaPeliculas(LecturaDatos.leerInt("Introduzca una id pelicula a borrar"));
					break;
				case 3:
					System.out.println("Ha seleccionado ALTA USUARIO PELÍCULA");
					peli.crearPelicula();
					new Servicios().altaPeliculas(peli);
					break;
				case 4:
					System.out.println("Ha seleccionado BAJA USUARIO");
					peli.crearPelicula();
					new Servicios().altaPeliculas(peli);
					break;
				case 5:
					salir = true;
					break;
				default:
					if ((opcion < 1 || opcion > 5)) {
						System.out.println("Solo números entre 1 y 5");
						throw new FueraDeRango(opcion);
					}
				}
			} catch (InputMismatchException e) {
				System.out.println("Debes insertar un número");
				log.error("--->" +"Error al insertar el tipo de dato");
				sn.next();
			} catch (FueraDeRango e) {
				System.out.println(e);
				log.error("--->" +"Número introducido fuera de rango");
			}
		}

	}
}
