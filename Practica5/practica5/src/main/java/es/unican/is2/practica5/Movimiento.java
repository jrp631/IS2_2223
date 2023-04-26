package es.unican.is2.practica5;

import java.time.LocalDateTime;

public class Movimiento {
	private String mConcepto;
	private LocalDateTime mFecha;
	private double mImporte;

	public double getI() { // WCM + 1 
		return mImporte;
	}

	public void setI(double newMImporte) { // WCM + 1 
		mImporte = newMImporte;
	}
	
	public String getC() { // WCM + 1 
		return mConcepto;
	}

	public void setC(String newMConcepto) { // WCM + 1 
		mConcepto = newMConcepto;
	}

	public LocalDateTime getF() { // WCM + 1 
		return mFecha;
	}

	public void setF(LocalDateTime newMFecha) { // WCM + 1 
		mFecha = newMFecha;
	}
	
}