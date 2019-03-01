package control;
import gui.MostrarMenu;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Arranque {
	
	public void menu() {
	@SuppressWarnings("resource")
	Scanner sn = new Scanner(System.in);
	boolean salir = false;
	int opcion;
	
	
	while(!salir){
		MostrarMenu.mostrarMenu();
        
        try {
        	System.out.println("\n" + "Por favor,seleccione una de las opciones del menú.");
        	opcion = sn.nextInt();
        	
        	switch (opcion) {
            case 1:
                System.out.println("Ha seleccionado ALTA NUEVA PELÍCULA");
                break;
            case 2:
                salir = true;
                break;
            default:
                System.out.println("Solo números entre 1 y 2");
        }
    } catch (InputMismatchException e) {
        System.out.println("Debes insertar un número");
        sn.next();
    }
}

}
}



	

