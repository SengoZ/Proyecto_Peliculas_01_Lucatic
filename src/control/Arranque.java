package control;

import gui.MostrarMenu;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import excepciones.FueraDeRango;
import excepciones.LecturaException;

import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

import excepciones.DAOException;
import model.Categoria;
import model.Peliculas;
import servicios.Servicios;
import utilidades.LecturaDatos;

public class Arranque {

	public void menu() throws DAOException, LecturaException, ParseException {
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
					new Servicios().crearUsuario();
					break;
				case 4:
					System.out.println("Ha seleccionado BAJA USUARIO");
					new Servicios().bajaUsuario(LecturaDatos.leerInt("Introduzca Id: "));
					break;
				case 7:
					new Servicios().listarPeliculas();
					break;
				case 5:
					System.out.println("Ha seleccionado MODIFICACI�N USUARIO");
					new Servicios().modificar(LecturaDatos.leerInt("Introduzca Id: "));
					break;
				case 8:
					System.out.println("Ha seleccionado ALTA CATEGOR�A");
					Categoria cat = new Categoria();
					cat.crearCat();
					new Servicios().altaCategorias(cat);
					break;
				case 9:
					System.out.println("Ha seleccionado BAJA CATEGOR�A");
					new Servicios().bajaCategorias(LecturaDatos.leerInt("Introduzca un id de categor�a"));
					break;
				case 10:
					System.out.println("Ha seleccionado MODIFICACI�N CATEGOR�A");
					new Servicios().modificacionCategorias(0);
					break;
				case 13:
					System.out.println("              ----------Peliculas mas vistas----------"+"\n");
					new Servicios().masVistas();
					break;
				case 11:
					System.out.println("Ha seleccionado LISTAR POR CATEGOR�AS");
                    new Servicios().listadoCat();
                    int id=LecturaDatos.leerInt("\n"+"Introduzca la categor�a (n�mero)");
                    new Servicios().listadoPeliCat(id);
                    break;
				case 12:
					new Servicios().listadoUsuario();
					break;
				case 16:
					salir = true;
					break;
				default:
					if ((opcion < 1 || opcion > 16)) {
						System.out.println("Solo n�meros entre 1 y 16");
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
