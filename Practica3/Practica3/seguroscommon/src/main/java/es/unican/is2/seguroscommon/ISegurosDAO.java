package es.unican.is2.seguroscommon;



import java.util.List;

/**
 * Interfaz DAO para los seguros
 */
public interface ISegurosDAO  {
	
	/** 
	 * Persite un nuevo seguro
	 * @param v Seguro a a�adir
	 * @return El seguro una vez a�adido
	 *         null si no se a�ade el seguro
	 */
	public Seguro creaSeguro(Seguro v);
	
	/**
	 * Elimina el seguro cuya matr�cula se pasa
	 * como par�metro
	 * @param matricula
	 * @return El seguro eliminado
	 *         null si no se encuentra el seguro
	 */
	public Seguro eliminaSeguro(String matricula);
	
	/**
	 * Actualiza el estado del seguro que se pasa
	 * como par�metro
	 * @param nuevo Nuevo estado del seguro
	 * @return El seguro actualizado
	 */
	public Seguro actualizaSeguro(Seguro nuevo);
	
	/**
	 * Retorna el seguro cuya matr�cula asociada
	 * se pasa como par�metro
	 * @param matricula
	 * @return El seguro
	 * 		   null si no se encuentra
	 */
	public Seguro seguro(String matricula);
	
	/**
	 * Retorna la lista completa de seguros
	 * @return La lista de seguros
	 *         Lista vac�a si no hay ninguno
	 */
	public List<Seguro> seguros();
}
