/**
 * ValorAPagarNoDiaResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

import java.io.Serializable;

import javax.xml.namespace.QName;

import org.apache.axis.description.TypeDesc;
import org.apache.axis.encoding.Deserializer;
import org.apache.axis.encoding.Serializer;
import org.apache.axis.encoding.ser.BeanDeserializer;
import org.apache.axis.encoding.ser.BeanSerializer;

@SuppressWarnings("serial")
public class ValorAPagarNoDiaResponse  implements Serializable {
    private double valorAPagarNoDiaResult;

    public ValorAPagarNoDiaResponse() {
    }

    public ValorAPagarNoDiaResponse(
           double valorAPagarNoDiaResult) {
           this.valorAPagarNoDiaResult = valorAPagarNoDiaResult;
    }


    /**
     * Gets the valorAPagarNoDiaResult value for this ValorAPagarNoDiaResponse.
     * 
     * @return valorAPagarNoDiaResult
     */
    public double getValorAPagarNoDiaResult() {
        return valorAPagarNoDiaResult;
    }


    /**
     * Sets the valorAPagarNoDiaResult value for this ValorAPagarNoDiaResponse.
     * 
     * @param valorAPagarNoDiaResult
     */
    public void setValorAPagarNoDiaResult(double valorAPagarNoDiaResult) {
        this.valorAPagarNoDiaResult = valorAPagarNoDiaResult;
    }

    private Object __equalsCalc = null;
    
    public synchronized boolean equals(Object obj) {
    	if (obj == null) {
    		return false;
    	}
    	
        if (!(obj instanceof ValorAPagarNoDiaResponse)) {
        	return false;
        }
        
        ValorAPagarNoDiaResponse other = (ValorAPagarNoDiaResponse) obj;
        
        if (this == obj) {
        	return true;
        }
        
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        
        __equalsCalc = obj;
        boolean _equals;
        
        _equals = true && 
            this.valorAPagarNoDiaResult == other.getValorAPagarNoDiaResult();
        __equalsCalc = null;
        
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
    
        __hashCodeCalc = true;
        int _hashCode = 1;
        
        _hashCode += Double.valueOf(getValorAPagarNoDiaResult()).hashCode();
        __hashCodeCalc = false;
        
        return _hashCode;
    }

    // Type metadata
    private static TypeDesc typeDesc =
        new TypeDesc(ValorAPagarNoDiaResponse.class, true);

    static {
        typeDesc.setXmlType(new QName("http://tempuri.org/", ">ValorAPagarNoDiaResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("valorAPagarNoDiaResult");
        elemField.setXmlName(new QName("http://tempuri.org/", "ValorAPagarNoDiaResult"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    @SuppressWarnings("rawtypes")
	public static Serializer getSerializer(
           String mechType, 
           Class _javaType,  
           QName _xmlType) {
        return new BeanSerializer(_javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    @SuppressWarnings("rawtypes")
	public static Deserializer getDeserializer(
           String mechType, 
           Class _javaType,  
           QName _xmlType) {
        return new BeanDeserializer(_javaType, _xmlType, typeDesc);
    }

}
