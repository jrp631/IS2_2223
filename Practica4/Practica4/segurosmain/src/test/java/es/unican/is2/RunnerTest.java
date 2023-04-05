package es.unican.is2;

import static org.junit.jupiter.api.Assertions.*;

import org.fest.swing.fixture.FrameFixture;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.unican.is2.segurosbusiness.GestionSeguros;
import es.unican.is2.seguroscommon.IClientesDAO;
import es.unican.is2.seguroscommon.IGestionClientes;
import es.unican.is2.seguroscommon.IGestionSeguros;
import es.unican.is2.seguroscommon.IInfoSeguros;
import es.unican.is2.seguroscommon.ISegurosDAO;
import es.unican.is2.segurosdao.ClientesDAO;
import es.unican.is2.segurosdao.SegurosDAO;
import es.unican.is2.segurosgui.VistaAgente;

/**
 * Unit test for simple App.
 */
public class RunnerTest {

    private FrameFixture demo;
    private IGestionClientes clientes;
    private IGestionSeguros seguros;
    private IInfoSeguros infoSeguros;
    
    private IClientesDAO daoContribuyentes = new ClientesDAO();
	private ISegurosDAO daoVehiculos = new SegurosDAO();
	private GestionSeguros negocio = new GestionSeguros(daoContribuyentes, daoVehiculos);

    @BeforeEach
    public void setUp() {
        VistaAgente vistaAgente = new VistaAgente(negocio,negocio,negocio);        //ceramos la ); 
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
     * @throws InterruptedException
     */
    @Test
    public void test(){ 
        // test primer cliente
        try {
            
            demo.button("btnBuscar").requireText("Buscar");
            demo.textBox("txtDNICliente").enterText("12345678S");
            demo.button("btnBuscar").click();   
            
            //Cliente

            //nombre del cliente
            demo.textBox("txtNombreCliente").requireText("Andrés Ortega");


            //lista de seguros 
            demo.list("listSeguros").requireItemCount(1); //FIXME -> averiguar cual es el numero requerido que toca            //4 -> numero de elementos del seguro que se muestran por pantalla
            String cobertura_matricla = demo.list("listSeguros").valueAt(0);//TODO -> ver como es la salida por consola que muestra la lista
            System.out.println(cobertura_matricla);
            assertTrue(comparaValores(cobertura_matricla , "PLL9597 TODORIESGO"));
        
            //precio total
            demo.textBox("txtTotalCliente").requireText("675.0");
        } catch (AssertionError e) {
            fail("Algo ha ido mal");
        }
    }
}
