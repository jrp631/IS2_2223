package es.unican.is2.practica5refactor;

@SuppressWarnings("serial")
public class saldoInsuficienteException extends RuntimeException {

	public saldoInsuficienteException (String mensaje) { // WCM + 1 
		super(mensaje);
	}
}
