package es.unican.is2.seguroscommon;




import java.time.LocalDate;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Clase que representa un seguro de coche.
 * Un seguro se identifica por la matr�cula
 * del coche para el que se contrata el seguro
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Seguro")
public class Seguro {
	
	private static final double PORCENTAJE_TRAMO_1 = 0.95;
	private static final double PORCENTAJE_TRAMO_2 = 0.80;
	private static final int INICIO_TRAMO_1= 90;
	private static final int FIN_TRAMO_1=110;
	private static final double DESCUENTO_PRIMER_ANHO = 0.8;
	private static final double DESCUENTO_SEGUNDO_ANHO = 0.9;
	
    
    @XmlAttribute(required = true)
    private int potencia;
    
    @XmlAttribute(required = true)
    private String matricula;
    
    @XmlAttribute(required = true)
    private Cobertura cobertura;
    
    @XmlAttribute(name="fecha", required=true)
    @XmlJavaTypeAdapter(value = LocalDateAdapter.class)
    private LocalDate fechaContratacion;
    
    public Seguro() {}

	/**
	 * Retorna la matr�cula del coche 
	 * asociado al seguro
	 */
	public String getMatricula() {
		return matricula;
	}

	/**
	 * Define el valor para la matr�cula
	 */
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	/**
	 * Retorna el tipo de cobertura del seguro
	 */
	public Cobertura getCobertura() {
		return cobertura;
	}

	/**
	 * Define el valor para la cobertura
	 */
	public void setCobertura(Cobertura cobertura) {
		this.cobertura = cobertura;
	}


	/**
     * Retorna la potencia del coche asociado 
     * al seguro. 
     */
    public int getPotencia() {
        return potencia;
    }

    /**
     * Define el valor de la potencia.
     */
    public void setPotencia(int value) {
        this.potencia = value;
    }
    
    /**
     * Retorna el precio del seguro
     * @return
     */
    public double precio() {
    	//1. Nivel de covertura contratado 
		//2. Potecia del coche 
		// Oferta
		double precio = 0;
		
		switch(getCobertura()) { //nivel de cobertura
			case TODORIESGO:
				precio = 1000;
			case TERCEROSLUNAS:
				precio = 600;
			case TERCEROS:
				precio = 400;
		}

		if (getPotencia() >= INICIO_TRAMO_1 && getPotencia() <= FIN_TRAMO_1) { //potenica del coche
			precio += precio*0.05;
		} else if (getPotencia() > 110){
			precio += precio*0.2;
		}

		LocalDate localDate = LocalDate.now();
		
		int anho = fechaContratacion.getYear() - localDate.getYear();

		if (anho < 1) {
			precio = precio*DESCUENTO_PRIMER_ANHO;
		} else if (anho == 1) {
			precio = precio*DESCUENTO_SEGUNDO_ANHO;
		}

		return precio;
    }

}
