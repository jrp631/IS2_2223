package es.unican.is2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.unican.is2.practica5refactor.CuentaValores;
import es.unican.is2.practica5refactor.Valor;

public class CuentaValoresTest {
	
	private CuentaValores sut;
	
	@BeforeEach
	public void inicializa() {
		sut = new CuentaValores("794311");
	}
	
	@Test
	public void testConstructor() {
		assertTrue(sut.getNumCuenta().equals("794311"));
		assertTrue(sut.getValores().size()==0);
	}
	
	@Test
	public void testAnhadeValor() {
		// CASOS VALIDOS
		Valor v = new Valor("Telepizza", 25, 1.05);
		assertTrue(sut.anhadeValor(v));
		assertTrue(sut.getValores().size()==1);
		assertEquals(sut.getValores().get(0), v);
		
		v = new Valor("BancoSantander", 100, 200);
		assertTrue(sut.anhadeValor(v));
		assertTrue(sut.getValores().size()==2);
		assertEquals(sut.getValores().get(1), v);
		
		// CASOS NO VALIDOS
		assertFalse(sut.anhadeValor(new Valor("Telepizza", 10, 2.5)));
		
	}

	@Test
	public void testTotalCuenta() {

		try {
			Valor v = new Valor("Accion1", 0, 0);
			sut.anhadeValor(v);	
			assertEquals(sut.totalCuenta(), 0.0);
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			Valor v1 = new Valor("Entidad", 2, 2.0);
			Valor v2 = new Valor("Entidad2", 1, 4.0);
			sut.anhadeValor(v1);
			sut.anhadeValor(v2);
			assertEquals(sut.totalCuenta(),8.0);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
