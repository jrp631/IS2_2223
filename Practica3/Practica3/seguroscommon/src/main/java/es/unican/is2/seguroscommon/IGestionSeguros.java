package es.unican.is2.seguroscommon;



/**
 * Interfaz de negocio para gestionar los
 * seguros de la empresa de seguros
 */
public interface IGestionSeguros {
	
	/**
	 * A�ade un nuevo seguro al cliente cuyo dni se pasa
	 * como par�metro.
	 * @param s Seguro que desea a�adir
	 * @param dni DNI del cliente
	 * @return El seguro a�adido
	 * 		   null si no se a�ade porque no se encuentra el cliente
	 * @throws OperacionNoValida si el seguro ya existe
	 */
	public Seguro nuevoSeguro(Seguro s, String dni) throws OperacionNoValida;
	
	/**
	 * Elimina el seguro cuya matr�cula asociada se pasa como par�metro y 
	 * que pertenece al cliente cuyo dni se pasa como par�metro
	 * @param matr�cula Identificador del seguro a eliminar
	 * @param dni DNI del propietario del veh�culo
 	 * @return El seguro eliminado
 	 *         null si el seguro o el cliente no existen
 	 * @throws OperacionNoValida si el seguro no pertenece al dni indicado
	 */
	public Seguro bajaSeguro(String matricula, String dni) throws OperacionNoValida;

}
