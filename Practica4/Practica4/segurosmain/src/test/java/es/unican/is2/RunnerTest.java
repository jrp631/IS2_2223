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
     * Test para casos no validos
     * @throws InterruptedException
     */
    @Test
    public void  casosValidos(){ 
        // test primer cliente
            
        demo.button("btnBuscar").requireText("Buscar");
        demo.textBox("txtDNICliente").enterText("12345678S");
        demo.button("btnBuscar").click();   
        
        //Cliente

        //nombre del cliente
        demo.textBox("txtNombreCliente").requireText("Andrés Ortega");

        //lista de seguros //cliente con un solo seguro a su nombre
        demo.list("listSeguros").requireItemCount(1); //FIXME -> averiguar cual es el numero requerido que toca            //4 -> numero de elementos del seguro que se muestran por pantalla
        String cobertura_matriculaA = demo.list("listSeguros").valueAt(0);//TODO -> ver como es la salida por consola que muestra la lista
        System.out.println(cobertura_matriculaA);
        assertTrue(comparaValores(cobertura_matriculaA , "PLL9597 TODORIESGO"));
    
        //precio total
        demo.textBox("txtTotalCliente").requireText("675.0");
	
        try {
    			Thread.sleep(2000);
    		} catch (InterruptedException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
        
        demo.textBox("txtDNICliente").setText("");
        //segundo cliente
        demo.button("btnBuscar").requireText("Buscar");
        demo.textBox("txtDNICliente").enterText("12345678F");
        demo.button("btnBuscar").click();

        //nombre del cliente
        demo.textBox("txtNombreCliente").requireText("Pablo López");

        //lista de seguros, cliente con mas de un seguro a su nombre
        demo.list("listSeguros").requireItemCount(2); 
        String[] cobertura_matriculaP = new String[2];
        cobertura_matriculaP[0] = demo.list("listSeguros").valueAt(0);
        cobertura_matriculaP[1] = demo.list("listSeguros").valueAt(1);

        assertTrue(comparaValores(cobertura_matriculaP[0], "PLX9597 TODORIESGO"));
        assertTrue(comparaValores(cobertura_matriculaP[1], "PLX9797 TERCEROS"));
        
        demo.textBox("txtTotalCliente").requireText("1450.0"); //Calcular total de los seguros
        try {
    			Thread.sleep(2000);
    		} catch (InterruptedException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
        
        demo.textBox("txtDNICliente").setText("");
        //tercer cliente
        demo.button("btnBuscar").requireText("Buscar");
        demo.textBox("txtDNICliente").enterText("12345678V");
        demo.button("btnBuscar").click();
        
        //nombre del cliente
        demo.textBox("txtNombreCliente").requireText("Lucía Rodriguez");

        //lista de seguros //cliente con un solo seguro a su nombre
        demo.list("listSeguros").requireItemCount(1); //FIXME -> averiguar cual es el numero requerido que toca            //4 -> numero de elementos del seguro que se muestran por pantalla
        String cobertura_matriclaL = demo.list("listSeguros").valueAt(0);//TODO -> ver como es la salida por consola que muestra la lista
        System.out.println(cobertura_matriclaL);
        assertTrue(comparaValores(cobertura_matriclaL , "JLL9551 TERCEROSLUNAS"));
    
        //precio total
        demo.textBox("txtTotalCliente").requireText("720.0");
	

        demo.textBox("txtDNICliente").setText("");

        try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }


    /**
     * 
     */
    @Test
     public void casosNoValidos() { //TODO
        //Caso -> introducimos el dni de un cliente no existente
        demo.button("btnBuscar").requireText("Buscar");

        demo.textBox("txtDNICliente").setText("");//borramos el texto anterior
        demo.textBox("txtDNICliente").enterText("AAAAA"); //DNI que no se encuentra en el xml
        demo.button("btnBuscar").click();  

        demo.textBox("txtNombreCliente").requireText(""); //nombre vacio

        //lista de seguros //cliente con un solo seguro a su nombre
        demo.list("listSeguros").requireItemCount(0); //
                
        demo.textBox("txtTotalCliente").requireText("");
        try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
}
