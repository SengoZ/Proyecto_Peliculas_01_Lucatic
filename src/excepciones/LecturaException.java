package excepciones;

@SuppressWarnings("serial")
public class LecturaException extends Exception{
	


	public LecturaException() {

	}

	public LecturaException(String valor, Exception e) {
		super();
		System.out.println(e.getStackTrace());
	}


	@Override
	public String toString() {
		
		return "------------PROBLEMA: ";
	}
	

}
