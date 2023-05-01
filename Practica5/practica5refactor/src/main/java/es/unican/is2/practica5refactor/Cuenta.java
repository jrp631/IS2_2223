package es.unican.is2.practica5refactor;

public abstract class Cuenta { 
	
	private String numCuenta;
	
	public Cuenta(String numCuenta) {  // WCM + 1 
		this.numCuenta = numCuenta;
	}
	
	public String getNumCuenta() { // WCM + 1 
		return numCuenta;
	}
	
	public abstract double totalCuenta(); // WCM + 1 
	
}
