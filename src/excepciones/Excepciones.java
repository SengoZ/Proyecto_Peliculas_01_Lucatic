package excepciones;

public class Excepciones {
	package excepciones;

	import java.util.logging.Level;
	import java.util.logging.Logger;

	public class PeliculasException extends Exception {

			private static final long serialVersionUID = 1L;

			private Level level;

			public PeliculasException() {
			}

			public PeliculasException(String message) {
				super(message);
			}

			public PeliculasException(Throwable cause) {
				super(cause);
			}

			public PeliculasException(String message, Throwable cause) {
				super(message, cause);
			}
			
			// 1: ERROR
			// 2: WARNING
			// 3: INFO
			public PeliculasException(String message, int tipo) {
				super(message);
				setLevel(tipo);
			}	

			public void setLevel(int tipo) {

				switch (tipo) {
				case 1:
					level = Level.SEVERE;
					break;
				case 2:
					level = Level.WARNING;
					break;
				case 3:
					level = Level.INFO;
					break;
				default:
					level = Level.INFO;
					break;
				}
			}

			@Override
			public String toString() {
				Logger.getLogger(PeliculasException.class.getName()).log(level, null, super.getMessage());
				return super.getMessage();
			}

		}


}
