package es.unican.is2.seguroscommon;



import java.util.List;

/**
 * Interfaz DAO para los veh�culos
 */
public interface IClientesDAO  {
	
	/** 
	 * Persite un nuevo Cliente
	 * @param c Cliente a a�adir
	 * @return El cliente una vez a�adido
	 *         null si no se puede a�adir
	 */
	public Cliente creaCliente(Cliente c);
	
	/**
	 * Retorna el cliente cuyo dni se pasa 
	 * como par�metro
	 * @param dni
	 * @return El cliente
	 * 		   null si no se encuentra
	 */
	public Cliente cliente(String dni);
	
	/**
	 * Actualiza el estado del cliente que se pasa
	 * como par�metro
	 * @param nuevo Nuevo estado del cliente
	 * @return El cliente actualizado
	 */
	public Cliente actualizaCliente(Cliente nuevo);
	
	/**
	 * Elimina el cliente cuyo dni se pasa
	 * como par�metro
	 * @param dni
	 * @return El cliente eliminado
	 *         null si no se encuentra el cliente
	 */
	public Cliente eliminaCliente(String dni);
	
	/**
	 * Retorna la lista completa de clientes
	 * @return La lista de clientes
	 *         Lista vac�a si no hay ninguno
	 */
	public List<Cliente> clientes();
	
}
