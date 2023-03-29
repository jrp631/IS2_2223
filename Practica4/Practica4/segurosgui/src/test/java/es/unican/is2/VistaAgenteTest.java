package es.unican.is2;

import static org.junit.jupiter.api.Assertions.*;

import org.fest.swing.fixture.FrameFixture;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.unican.is2.seguroscommon.IGestionClientes;
import es.unican.is2.seguroscommon.IGestionSeguros;
import es.unican.is2.seguroscommon.IInfoSeguros;
import es.unican.is2.segurosgui.VistaAgente;

/**
 * Unit test for simple App.
 */
public class VistaAgenteTest {

    private FrameFixture demo;
    private IGestionClientes clientes;
    private IGestionSeguros seguros;
    private IInfoSeguros infoSeguros;
    

    @BeforeEach
    public void setUp() {
        VistaAgente vistaAgente = new VistaAgente(clientes, seguros, infoSeguros);        //ceramos la ); 
        demo = new FrameFixture(vistaAgente);
        vistaAgente.setVisible(true);
    }

    @AfterEach
    public void tearDown(){
        demo.cleanUp();
    }

    private boolean comparaValores(String dato1, String dato2) {
        if (dato1.equals(dato2)) {
            return true;

        }
        return false;
    }
    /**
     * Rigorous Test :-)
     */
    @Test
    public void test(){
        // test primer cliente
        try {
            demo.button("btnBuscar").requireText("Buscar");
            demo.textBox("txtDNICliente").enterText("12345678S");
            demo.button("btnBuscar").click();   
            demo.list("listSeguros").requireItemCount(4);
            //4 -> numero de elementos del seguro que se muestran por pantalla
            String cobertura = demo.list("listSeguros").item(0).value();
            assertTrue(comparaValores(cobertura , "TODORIESGO"));


        } catch (AssertionError e) {
            fail("Numero de elementos del seguro retornado no correcto deberian ser 4");
        }
        assertTrue( true );
    }
}
