package es.unican.is2.seguroscommon;



/**
 * Interfaz de negocio para gestionar los 
 * clientes de la empresa de seguros
 */
public interface IGestionClientes {
	
	/**
	 * A�ade un nuevo cliente
	 * @param c Cliente que desea a�adir
	 * @return El cliente a�adido
	 * 		   null si no se a�ade porque ya existe
	 */
	public Cliente nuevoCliente(Cliente c);
	
	/**
	 * Elimina el cliente cuyo dni se pasa como par�metro
	 * @param dni DNI del cliente que se quiere eliminar
	 * @return El cliente eliminado
	 * 		   null si no se elimina porque no se encuentra 
	 * @throws OperacionNoValida si el cliente existe 
	 *         pero tiene seguros a su nombre
	 */
	public Cliente bajaCliente(String dni) throws OperacionNoValida;
		
	
}
