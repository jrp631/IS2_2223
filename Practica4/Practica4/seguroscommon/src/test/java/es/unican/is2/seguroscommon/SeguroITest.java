package es.unican.is2.seguroscommon;

import static org.junit.jupiter.api.Assertions.*;


import java.time.LocalDate;
import org.junit.jupiter.api.*;;

public class SeguroITest { // - > ARREGLAR FECHAS 
    
    private static final int INICIO_TRAMO_1= 90;
	private static final int FIN_TRAMO_1=110;
	private static final int TRAMO_INTERMEDIO=95;
	private static final int TRAMO_MAYOR=115;
	private static final int TRAMO_MENOR=80;

	//private static final double DESCUENTO_PRIMER_ANHO = 0.8;
	//private static final double DESCUENTO_SEGUNDO_ANHO = 0.9;

    //METODOS DE PRUEBA

    /**
     * Compara que los precios sean iguales
     * @return true si son iguales, false si no
     */
    private Boolean precioCorrecto(Seguro seguro, Double precioEsperado) { 
        if (seguro.precio() == precioEsperado) {
            return true;
        }
        return false;
    }

    /**
     * 
     */
    @Test
    public void testPrecio() {

        //CASOS VALIDOS
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaUnAnhos = LocalDate.now().minusMonths(12);
        LocalDate fechaMenossUnDia = LocalDate.now().minusDays(1);
        LocalDate fechaMenosDosAnhos = LocalDate.now().minusMonths(24);


        Seguro seguro1 = new Seguro(TRAMO_INTERMEDIO, Cobertura.TODORIESGO, fechaActual);
        //Prueba 1 
        assertTrue(precioCorrecto(seguro1, 840.0));

        Seguro seguro2 = new Seguro(INICIO_TRAMO_1, Cobertura.TERCEROSLUNAS, fechaUnAnhos);
        assertTrue(precioCorrecto(seguro2, 567.0)); // -> arreglar precio 

        Seguro seguro3 = new Seguro(FIN_TRAMO_1, Cobertura.TERCEROS, fechaActual);
        assertTrue(precioCorrecto(seguro3, 336.0));

        Seguro seguro4 = new Seguro(TRAMO_MAYOR, Cobertura.TERCEROS, fechaMenossUnDia); 
        assertTrue(precioCorrecto(seguro4, 384.0));   // -> arreglar precio

        Seguro seguro5 = new Seguro(TRAMO_MENOR, Cobertura.TODORIESGO, fechaMenosDosAnhos);
        assertTrue(precioCorrecto(seguro5,1000.0 ));// -> arreglar precio
        

        
        // CASOS NO VALIDOS
        
          
        Seguro seguro6 = new Seguro(INICIO_TRAMO_1, null, fechaUnAnhos);
        try {
            assertThrows(NullPointerException.class, () -> precioCorrecto(seguro6, 567.0));
        } catch (AssertionError e) {
            fail("Expected NullPointerException but got: " + e);
        }
              
    }


    
}
