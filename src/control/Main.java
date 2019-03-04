package control;

import excepciones.DAOException;
import excepciones.LecturaException;



public class Main {


	public static void main(String[] args) throws DAOException, LecturaException {

		Arranque menu = new Arranque();
		menu.menu();

	}
}