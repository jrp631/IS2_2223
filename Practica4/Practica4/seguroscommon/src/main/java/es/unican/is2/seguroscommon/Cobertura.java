package es.unican.is2.seguroscommon;

import javax.xml.bind.annotation.XmlEnum;

/**
 * Tipo de cobertura proporcionada por un seguro
 */
@XmlEnum
public enum Cobertura {
	
	TERCEROS, TODORIESGO, TERCEROSLUNAS;
    

}
