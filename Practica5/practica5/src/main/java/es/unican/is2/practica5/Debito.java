package es.unican.is2.practica5;

import java.time.LocalDate;

public class Debito extends Tarjeta {
	
	private double saldoDiarioDisponible;

	public Debito(String numero, String titular, CuentaAhorro c) { // WCM + 1 
		super(numero, titular, c);
	}
	
	@Override
	public void retirar(double x) throws saldoInsuficienteException, datoErroneoException {// WCM + 1 
		if (saldoDiarioDisponible<x) {// WCM + 1 //Cog + 1
			throw new saldoInsuficienteException("Saldo insuficiente");
		}
		this.mCuentaAsociada.retirar("Retirada en cajero autom�tico", x);
		saldoDiarioDisponible-=x;
	}
	
	@Override
	public void pagoEnEstablecimiento(String datos, double x) throws saldoInsuficienteException, datoErroneoException {// WCM + 1 
		if (saldoDiarioDisponible<x) {// WCM + 1  //Cog + 1
			throw new saldoInsuficienteException("Saldo insuficiente");
		}
		this.mCuentaAsociada.retirar("Compra en : " + datos, x);
		saldoDiarioDisponible-=x;
	}
	
	public LocalDate getCaducidadDebito() {// WCM + 1 
		return this.mCuentaAsociada.getCaducidadDebito();
	}
	
	/**
	 * M�todo invocado autom�ticamente a las 00:00 de cada d�a
	 */
	public void restableceSaldo() {// WCM + 1 
		saldoDiarioDisponible = mCuentaAsociada.getLimiteDebito();
	}
	
	public CuentaAhorro getCuentaAsociada() {// WCM + 1 
		return mCuentaAsociada;
	}

}