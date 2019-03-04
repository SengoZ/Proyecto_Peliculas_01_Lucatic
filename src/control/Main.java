package control;

import java.text.ParseException;

import excepciones.DAOException;
import excepciones.LecturaException;



public class Main {


	public static void main(String[] args) throws DAOException, LecturaException, ParseException {

		Arranque menu = new Arranque();
		menu.menu();

	}
}