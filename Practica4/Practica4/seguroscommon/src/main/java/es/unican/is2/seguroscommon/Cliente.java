package es.unican.is2.seguroscommon;



import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Clase que representa un cliente de la empresa de seguros
 * Un cliente se identifica por su dni
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="Cliente")
public class Cliente {

	@XmlElement(required=true, name="seguro")
    private List<Seguro> seguros = new LinkedList<Seguro>();
    
    @XmlAttribute(required = true)
    private String nombre;
    
    @XmlAttribute(required = true)
    private String dni;
    
    @XmlAttribute(required = true)
    private boolean minusvalia;
    
    private static int DESCUENTO = 25;
    
    public Cliente(){}  

    
    public Cliente(String nombre, String dni, boolean minusvalia) {
        this.dni = dni;
        this.nombre = nombre;
        this.minusvalia = minusvalia;
    }

	/**
     * Retorna los seguros del cliente 
     */
    public List<Seguro> getSeguros() {
        if (seguros == null) {
        	seguros = new LinkedList<Seguro>();
        }
        return seguros;
    }
    
    /**
     * Define el valor de la propiedad seguros
     */
    public void setSeguros(List<Seguro> value) {
		this.seguros = value;
		
	}

    /**
     * Retorna el nombre del cliente.   
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Define el valor de la propiedad nombre.  
     */
    public void setNombre(String value) {
        this.nombre = value;
    }

    /**
     * Retorna el dni del cliente.
     */
    public String getDni() {
        return dni;
    }

    /**
     * Define el valor de la propiedad dni.
     */
    public void setDni(String value) {
        this.dni = value;
    }
    
    /**
     * Indica si el cliente es minusv�lido
     */
    public boolean getMinusvalia() {
    	return minusvalia;
    }
    
    public void setMinusvalia(boolean minus)  {
    	minusvalia = minus;
    }
    

    /**
     * Calcula el total a pagar por el cliente por 
     * todos los seguros a su nombre
     */
    public double totalSeguros() {
        double importe = 0;
        for (Seguro seguro : seguros) {
            if (this.minusvalia){
                System.out.println("Calculando para minusvalido");
                Double precio = seguro.precio();
                importe += ((100-DESCUENTO)*precio)/100;
                
            } else{
                importe += seguro.precio() ;
            }
        }
        System.out.println("Importe Seguro -> " + importe);
    	return importe;
    }

}
