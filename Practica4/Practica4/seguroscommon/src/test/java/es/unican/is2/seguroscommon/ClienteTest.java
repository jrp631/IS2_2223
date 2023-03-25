package es.unican.is2.seguroscommon;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.*;


public class ClienteTest {

    private static final int INICIO_TRAMO_1= 90;
	private static final int FIN_TRAMO_1=110;
	private static final int TRAMO_INTERMEDIO=95;
	private static final int TRAMO_MAYOR=115;
	private static final int TRAMO_MENOR=80;

    
    private static Cliente clienteNoMinusvalido;
    private static Cliente clienteMinusvalido; 
    private static Seguro seguro1;
    private static Seguro seguro2;
    private static Seguro seguro3;


    //declaracion de fechas
    private static LocalDate fechaActual = LocalDate.now();
    private static LocalDate fechaMenosUnAnhos = LocalDate.now().minusMonths(12);
    private static LocalDate fechaMenossUnDia = LocalDate.now().minusDays(1);
    private static LocalDate fechaMenosDosAnhos = LocalDate.now().minusMonths(24);


    @BeforeAll
    public static void setUp() throws Exception{
        clienteMinusvalido = new Cliente("ClienteMinusvalido", "12456789x", true);
        clienteNoMinusvalido = new Cliente("ClienteNoMinusvalido", "987654321z", false);        
        
        seguro1 = new Seguro(TRAMO_INTERMEDIO, Cobertura.TODORIESGO, fechaActual);
        seguro2 = new Seguro(INICIO_TRAMO_1, Cobertura.TERCEROSLUNAS, fechaMenosUnAnhos);
        seguro3 = new Seguro(FIN_TRAMO_1, Cobertura.TERCEROS, fechaActual);
    }

    private Boolean precioCorrecto(Cliente cliente, Double precioEsperado) {
        if (cliente.totalSeguros() == precioEsperado) {
            return true;   
        }
        return false;
    }



    /**
     * Mertodo para provar los casos validos
     */
    @Test
    public void testTotalSegurosMinusvalido() {
        List<Seguro> seguros = new ArrayList<Seguro>();
        //con un solo seguro en la lista
        seguros.add(seguro1);
        clienteMinusvalido.setSeguros(seguros);        
        assertTrue(precioCorrecto(clienteNoMinusvalido, 630.0));//FIXME -> CAMBIAR EL PRECIO
        
        //con mas de un elemento en la lista 
        seguros.add(seguro2);
        clienteMinusvalido.setSeguros(seguros); 
        assertTrue(precioCorrecto(clienteMinusvalido, 1055.25)); //FIXME -> CAMBIAR EL PRECIO

        seguros.add(seguro3);
        clienteMinusvalido.setSeguros(seguros); 
        assertTrue(precioCorrecto(clienteMinusvalido, 1307.25)); //FIXME -> CAMBIAR EL PRECIO
        
    }

    @Test
    public void testTotalSegurosNoMinusvalido() {
        List<Seguro> seguros = new  ArrayList<Seguro>();
        
        //con un solo seguro en la lista 
        seguros.add(seguro1);
        clienteNoMinusvalido.setSeguros(seguros);
        assertTrue(precioCorrecto(clienteNoMinusvalido, 840.0));
        
        // con mas de un elemento en la lista
        seguros.add(seguro2);
        clienteNoMinusvalido.setSeguros(seguros);
        assertTrue(precioCorrecto(clienteNoMinusvalido, 1407.0));

        seguros.add(seguro3);
        clienteNoMinusvalido.setSeguros(seguros);
        assertTrue(precioCorrecto(clienteNoMinusvalido, 1743.0));
    }
    /**
     * Metodo para probar los casos no validos 
     */
    @Test
    public void testTotalSegurosNoValido(){
        List<Seguro> seguros = null;
        clienteMinusvalido.setSeguros(seguros);
        clienteNoMinusvalido.setSeguros(seguros);
        try{
            assertThrows(NullPointerException.class, () -> precioCorrecto(clienteMinusvalido, 412.0));
        } catch(AssertionError e) {
            fail("PLACEHOLDER");
        }
    }
}
