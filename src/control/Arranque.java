package control;

import gui.MostrarMenu;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import excepciones.FueraDeRango;
import excepciones.LecturaException;

import java.util.InputMismatchException;
import java.util.Scanner;

import excepciones.DAOException;
import model.Peliculas;
import servicios.Servicios;
import utilidades.LecturaDatos;
import model.Categoria;
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
				System.out.println("\n" + "Por favor,seleccione una de las opciones del men�.");
				opcion = sn.nextInt();

				switch (opcion) {
				case 1:
					System.out.println("Ha seleccionado ALTA NUEVA PEL�CULA");
					Peliculas peli = new Peliculas();
					peli.crearPelicula();
					new Servicios().altaPeliculas(peli);
					break;
				case 2:
					System.out.println("Ha seleccionado BAJA PEL�CULA");
					new Servicios().bajaPeliculas(LecturaDatos.leerInt("Introduzca una id pelicula a borrar"));
					break;
				case 3:
					System.out.println("Ha seleccionado ALTA USUARIO PEL�CULA");
					break;
				case 4:
					System.out.println("Ha seleccionado BAJA USUARIO");
					break;
				case 8:
					System.out.println("Ha seleccionado ALTA NUEVA CATEGOR�A");
					Categoria cate = new Categoria();
					cate.crearCat();
					new Servicios().altaCategorias(cate);
					break;
				case 10:
					salir = true;
					break;
				default:
					if ((opcion < 1 || opcion > 10)) {
						System.out.println("Solo n�meros entre 1 y 10");
						throw new FueraDeRango(opcion);
					}
				}
			} catch (InputMismatchException e) {
				System.out.println("Debes insertar un n�mero");
				log.error("--->" +"Error al insertar el tipo de dato");
				sn.next();
			} catch (FueraDeRango e) {
				System.out.println(e);
				log.error("--->" +"N�mero introducido fuera de rango");
			}
		}

	}
}
