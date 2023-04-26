package es.unican.is2.practica5;

import java.util.LinkedList;
import java.util.List;

public class Cliente {
	
	public String nombre;
	public String calle;
	public String zip;
	public String localidad;
	public String telefono;
	public String dni;
	
    private List<Cuenta> Cuentas = new LinkedList<Cuenta>();

 	public Cliente(String titular, String calle, String zip, String localidad, 
 			String telefono, String dni) {  // WCM + 1 
		this.nombre = titular;
		this.calle = calle;
		this.zip = zip;
		this.localidad = localidad;
		this.telefono = telefono;
		this.dni = dni;
	}
	
	public void cambiaDireccion(String calle, String zip, String localidad) {// WCM + 1 
		this.calle = calle;
		this.zip = zip;
		this.localidad = localidad;
	}
	
	public void anhadeCuenta(Cuenta c) { // WCM + 1 
		Cuentas.add(c);
	}
	
	public double getSaldoTotal() { // WCM + 1 
		double total = 0.0;
		for (Cuenta c: Cuentas) {   // WCM + 1 //Cog + 1
			if (c instanceof CuentaAhorro) { // WCM + 1  //Cog + 2
				total += ((CuentaAhorro) c).getSaldo();
			} else if (c instanceof CuentaValores)  { // WCM + 1  //Cog + 2
				for (Valor v: ((CuentaValores) c).getValores()) { // WCM + 1 //Cog + 3 
					total += v.getCotizacion()*v.getNumValores();
				}
			}
		}
		return total;
	}
	
	public String getNombre() { // WCM + 1 
		return nombre;
	}

	public String getCalle() { // WCM + 1 
		return calle;
	}

	public String getZip() { // WCM + 1 
		return zip;
	}

	public String getLocalidad() { // WCM + 1 
		return localidad;
	}

	public String getTelefono() { // WCM + 1 
		return telefono;
	}

	public String getDni() { // WCM + 1 
		return dni;
	}
	
	
	
}