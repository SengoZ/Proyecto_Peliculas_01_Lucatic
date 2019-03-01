package excepciones;

public class FueraDeRango extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */

	private int valor;

	public FueraDeRango(int valor) {
		super();
		this.valor = valor;
	}

	public FueraDeRango() {
		
	}

	@Override
	public String toString() {
		return "-----FueraDeRango [valor=" + valor + "]";
	}
	

}
