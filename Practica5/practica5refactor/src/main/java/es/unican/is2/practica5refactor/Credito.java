package es.unican.is2.practica5refactor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;


public class Credito extends Tarjeta {
	
	/**
	 *
	 */
	private static final double COMISION = 0.05;
	private double mCredito;
	private List<Movimiento> mMovimientosMensuales;
	private List<Movimiento> mhistoricoMovimientos;
	
	
	public Credito(String numero, String titular, CuentaAhorro c, double credito) { // WCM + 1 
		super(numero, titular, c);
		mCredito = credito;
		mMovimientosMensuales = new LinkedList<Movimiento>();
		mhistoricoMovimientos = new LinkedList<Movimiento>();
	}

	/**
	 * Retirada de dinero en cajero con la tarjeta
	 * @param x Cantidad a retirar. Se aplica una comisi�n del 5%.
	 * @throws saldoInsuficienteException
	 * @throws datoErroneoException
	 */
	@Override
	public void retirar(double x) throws saldoInsuficienteException, datoErroneoException { // WCM + 1 
		datoValido(x);
		
		Movimiento m = new Movimiento();
		LocalDateTime now = LocalDateTime.now();
		//m.setFecha(now);
		//m.setConcepto("Retirada en cajero autom�tico");
		x += x * COMISION; // A�adimos una comisi�n de un 5%
		//m.setImporte(-x);
		m.setMovimiento("Retirada en cajero autom�tico", -x, now);
		
		if (getGastosAcumulados()+x > mCredito) // WCM + 1 //Cog + 1
			throw new saldoInsuficienteException("Cr�dito insuficiente");
		else { //Cog + 1
			mMovimientosMensuales.add(m);
		}
	}

	private void datoValido(double x) {
		if (x<0) // WCM + 1 //Cog + 1
			throw new datoErroneoException("No se puede retirar una cantidad negativa");
	}

	@Override
	public void pagoEnEstablecimiento(String datos, double x) throws saldoInsuficienteException, datoErroneoException { // WCM + 1 
		datoValido(x);
		
		if (getGastosAcumulados() + x > mCredito) // WCM + 1 //Cog + 1
			throw new saldoInsuficienteException("Saldo insuficiente");
		
		Movimiento m = new Movimiento();
		LocalDateTime now = LocalDateTime.now();
		m.setMovimiento("Compra a cr�dito en: " + datos, x, now);
		mMovimientosMensuales.add(m);

	}
	
    public double getGastosAcumulados() { // WCM + 1 
		double r = 0.0;
		r = importeTotal(r);
		return -r;
	}
	
	
	public LocalDate getCaducidadCredito() { // WCM + 1 
		return this.mCuentaAsociada.getCaducidadCredito();
	}

	/**
	 * M�todo que se invoca autom�ticamente el d�a 1 de cada mes
	 */
	public void liquidar() { // WCM + 1 
		Movimiento liq = new Movimiento();
		LocalDateTime now = LocalDateTime.now();
		//liq.setFecha(now);
		//liq.setConcepto("Liquidaci�n de operaciones tarjeta cr�dito");
		double r = 0.0;
		r = importeTotal(r);
		//liq.setImporte(r);
		liq.setMovimiento(mNumero, r, now);
	
		if (r != 0) // WCM + 1  //Cog + 1
			mCuentaAsociada.addMovimiento(liq);
		
		mhistoricoMovimientos.addAll(mMovimientosMensuales);
		mMovimientosMensuales.clear();
	}

	private double importeTotal(double r) {
		for (int i = 0; i < this.mMovimientosMensuales.size(); i++) { // WCM + 1 //Cog + 1
			Movimiento m = (Movimiento) mMovimientosMensuales.get(i);
			r += m.getImporte();
		}
		return r;
	}

	public List<Movimiento> getMovimientosUltimoMes() {// WCM + 1 
		return mMovimientosMensuales;
	}
	
	public Cuenta getCuentaAsociada() { // WCM + 1 
		return mCuentaAsociada;
	}
	
	public List<Movimiento> getMovimientos() { // WCM + 1 
		return mhistoricoMovimientos;
	}

}