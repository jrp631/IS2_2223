package es.unican.is2.segurosbusiness;

import es.unican.is2.seguroscommon.Cliente;
import es.unican.is2.seguroscommon.IClientesDAO;
import es.unican.is2.seguroscommon.IGestionClientes;
import es.unican.is2.seguroscommon.IGestionSeguros;
import es.unican.is2.seguroscommon.IInfoSeguros;
import es.unican.is2.seguroscommon.ISegurosDAO;
import es.unican.is2.seguroscommon.OperacionNoValida;
import es.unican.is2.seguroscommon.Seguro;


public class GestionSeguros implements IGestionClientes, IInfoSeguros, IGestionSeguros{

    public GestionSeguros(IClientesDAO daoContribuyentes, ISegurosDAO daoVehiculos) {
        //constructor vacio que tenemos que terminar

    }
    	/**
	 * A�ade un nuevo cliente
	 * @param c Cliente que desea a�adir
	 * @return El cliente a�adido
	 * 		   null si no se a�ade porque ya existe
	 */
	public Cliente nuevoCliente(Cliente c) {
        Cliente cliente = new Cliente();
        return cliente;
    }
	
	/**
	 * Elimina el cliente cuyo dni se pasa como par�metro
	 * @param dni DNI del cliente que se quiere eliminar
	 * @return El cliente eliminado
	 * 		   null si no se elimina porque no se encuentra 
	 * @throws OperacionNoValida si el cliente existe 
	 *         pero tiene seguros a su nombre
	 */
	public Cliente bajaCliente(String dni) throws OperacionNoValida {
        Cliente c = new Cliente();
        return c;
    }

    /**
	 * Retorna el cliente cuyo dni se pasa como par�metro
	 * @param dni DNI del cliente buscado
	 * @return El cliente cuyo dni coincide con el par�metro
	 * 		   null en caso de que no exista
	 */
	public Cliente cliente(String dni) {
        Cliente c = new Cliente();
        return c;
    }
	
	/**
	 * Retorna el seguro cuya matr�cula asociada se pasa como par�metro
	 * @param matricula Identificador del seguro
	 * @return El seguro indicado
	 * 	       null si no existe
	 */
	public Seguro seguro(String matricula) {
        Seguro s = new Seguro();
        return s;
    }

/**
	 * A�ade un nuevo seguro al cliente cuyo dni se pasa
	 * como par�metro.
	 * @param s Seguro que desea a�adir
	 * @param dni DNI del cliente
	 * @return El seguro a�adido
	 * 		   null si no se a�ade porque no se encuentra el cliente
	 * @throws OperacionNoValida si el seguro ya existe
	 */
	public Seguro nuevoSeguro(Seguro s, String dni) throws OperacionNoValida {
        return s;
    }
	
	/**
	 * Elimina el seguro cuya matr�cula asociada se pasa como par�metro y 
	 * que pertenece al cliente cuyo dni se pasa como par�metro
	 * @param matr�cula Identificador del seguro a eliminar
	 * @param dni DNI del propietario del veh�culo
 	 * @return El seguro eliminado
 	 *         null si el seguro o el cliente no existen
 	 * @throws OperacionNoValida si el seguro no pertenece al dni indicado
	 */
	public Seguro bajaSeguro(String matricula, String dni) throws OperacionNoValida {
        Seguro s = new Seguro();
        return s;
    }

}
