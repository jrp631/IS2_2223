package es.unican.is2.practica5refactor;

import java.time.LocalDateTime;

public class Movimiento {
	private String mConcepto;
	private LocalDateTime mFecha;
	private double mImporte;

	public double getImporte() { // WCM + 1 
		return mImporte;
	}

	public void setImporte(double newMImporte) { // WCM + 1 
		mImporte = newMImporte;
	}
	
	public String getConcepto() { // WCM + 1 
		return mConcepto;
	}

	public void setConcepto(String newMConcepto) { // WCM + 1 
		mConcepto = newMConcepto;
	}

	public LocalDateTime getFecha() { // WCM + 1 
		return mFecha;
	}

	public void setFecha(LocalDateTime newMFecha) { // WCM + 1 
		mFecha = newMFecha;
	}

	public void setMovimiento (String concepto, double x,LocalDateTime now) { // WCM + 1 
		setConcepto(concepto);
		setImporte(x);
		setFecha(now);
	}
	
}