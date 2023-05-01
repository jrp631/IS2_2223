package es.unican.is2.practica5refactor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

public class CuentaAhorro extends Cuenta {

	private List<Movimiento> mMovimientos;
	private LocalDate mFechaDeCaducidadTarjetaDebito;
	private LocalDate mFechaDeCaducidadTarjetaCredito;
	private double limiteDebito;

	public CuentaAhorro(String numCuenta, LocalDate date, LocalDate date2) throws datoErroneoException {// WCM + 1 
		super(numCuenta);
		this.mFechaDeCaducidadTarjetaDebito = date;
		this.mFechaDeCaducidadTarjetaCredito = date2;
		mMovimientos = new LinkedList<Movimiento>();
		limiteDebito = 1000;
	}

	public void ingresar(double x) throws datoErroneoException { // WCM + 1 
		cantidadNoNegativa(x, "No se puede ingresar una cantidad negativa");
		Movimiento m = new Movimiento();
		LocalDateTime now = LocalDateTime.now();
		m.setMovimiento("Ingreso en efectivo", x, now);
		this.mMovimientos.add(m);
	}

	public void retirar(double x) throws saldoInsuficienteException, datoErroneoException {// WCM + 1 
		cantidadNoNegativa(x, "No se puede retirar una cantidad negativa");
		saldoSuficiente(x);
		Movimiento m = new Movimiento();
		LocalDateTime now = LocalDateTime.now();
		m.setMovimiento("Retirada de efectivo", -x, now);
		this.mMovimientos.add(m);

	}

	public void ingresar(String concepto, double x) throws datoErroneoException {// WCM + 1 
		cantidadNoNegativa(x, "No se puede ingresar una cantidad negativa");
		Movimiento m = new Movimiento();
		LocalDateTime now = LocalDateTime.now();
		m.setMovimiento(concepto, x, now);
		this.mMovimientos.add(m);
	}
 
	public void retirar(String concepto, double x) throws saldoInsuficienteException, datoErroneoException {// WCM + 1 
		saldoSuficiente(x);
		cantidadNoNegativa(x, "No se puede retirar una cantidad negativa");
		Movimiento m = new Movimiento();
		LocalDateTime now = LocalDateTime.now();
		m.setMovimiento(concepto, -x, now);
		this.mMovimientos.add(m);
	}

	public double getSaldo() { // WCM + 1 
		double r = 0.0;
		for (int i = 0; i < this.mMovimientos.size(); i++) {// WCM + 1 //Cog + 1
			Movimiento m = (Movimiento) mMovimientos.get(i);
			r += m.getImporte();
		}
		return r;
	}

	public void cantidadNoNegativa(double x, String mensaje) {
		if (x <= 0) // WCM + 1 //Cog + 1
			throw new datoErroneoException(mensaje);
	}

	public void saldoSuficiente(double x) {
		if (getSaldo() < x)// WCM + 1 //Cog + 1
			throw new saldoInsuficienteException("Saldo insuficiente");
	}

	public void addMovimiento(Movimiento m) { // WCM + 1 
		mMovimientos.add(m);
	}

	public List<Movimiento> getMovimientos() { // WCM + 1 
		return mMovimientos;
	}

	public LocalDate getCaducidadDebito() { // WCM + 1 
		return this.mFechaDeCaducidadTarjetaDebito;
	}

	public LocalDate getCaducidadCredito() {// WCM + 1 
		return this.mFechaDeCaducidadTarjetaCredito;
	}

	public double getLimiteDebito() { // WCM + 1 
		return limiteDebito;
	}

	@Override
	public double totalCuenta() {

		return getSaldo();

		// TODO Auto-generated method stub
	}

}