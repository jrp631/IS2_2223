package es.unican.is2.practica5refactor;

import java.util.LinkedList;
import java.util.List;


public class CuentaValores extends Cuenta {

	private List<Valor> valores;
	
	public CuentaValores(String numCuenta) { // WCM + 1 
		super(numCuenta);
		valores = new LinkedList<Valor>();
	}
	
	public List<Valor> getValores() { // WCM + 1 
		return valores;
	}
	
	public boolean anhadeValor(Valor valor) { // WCM + 1 
		for (Valor v:valores) { // WCM + 1 // Cog + 1
			if (v.getEntidad().equals(valor.getEntidad())) // WCM + 1 //Cog + 2 
				return false;
		}
		valores.add(valor); 
		return true;
	}

	@Override
	public double totalCuenta() { // WCM + 1 
		// TODO Auto-generated method stub
		double total = 0.0;
		for (Valor v: valores) { // WCM + 1 //Cog + 1
			total += v.getCotizacion()*v.getNumValores();
		}
		return total;
	}
	
}	
