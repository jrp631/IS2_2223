package es.unican.is2.seguroscommon;

import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import javax.swing.event.TreeExpansionEvent;

import org.junit.Test;

public class SeguroTest { //FIXME - > ARREGLAR FECHAS 
    //TODO 
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
        LocalDate año = LocalDate.now(); 
        Seguro seguro1 = new Seguro(90, Cobertura.TODORIESGO, año);
        //Prueba 1 
        assertTrue("¿Precio correcto?", precioCorrecto(seguro1, 945.0));

        Seguro seguro2 = new Seguro(110, Cobertura.TERCEROSLUNAS, año);
        assertTrue(precioCorrecto(seguro2, -100.0)); //FIXME -> arreglar precio 

        Seguro seguro3 = new Seguro(95, Cobertura.TERCEROS, año);
        assertTrue(precioCorrecto(seguro3, -100.0));

        Seguro seguro4 = new Seguro(95, Cobertura.TERCEROS, año); 
        assertTrue(precioCorrecto(seguro4, -100.0));   //FIXME -> arreglar precio

        Seguro seguro5 = new Seguro(115, Cobertura.TODORIESGO, año);
        assertTrue(precioCorrecto(seguro5, -100.0));//FIXME -> arreglar precio
        
        // CASOS NO VALIDOS
    }
}
