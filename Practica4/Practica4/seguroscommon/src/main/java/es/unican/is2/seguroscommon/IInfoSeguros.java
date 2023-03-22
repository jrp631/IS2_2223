package es.unican.is2.seguroscommon;




/**
 * Interfaz con m�todos de consulta de informaci�n
 * de la empresa de seguros
 */
public interface IInfoSeguros {
	
	/**
	 * Retorna el cliente cuyo dni se pasa como par�metro
	 * @param dni DNI del cliente buscado
	 * @return El cliente cuyo dni coincide con el par�metro
	 * 		   null en caso de que no exista
	 */
	public Cliente cliente(String dni); 
	
	/**
	 * Retorna el seguro cuya matr�cula asociada se pasa como par�metro
	 * @param matricula Identificador del seguro
	 * @return El seguro indicado
	 * 	       null si no existe
	 */
	public Seguro seguro(String matricula); 	
	

}
