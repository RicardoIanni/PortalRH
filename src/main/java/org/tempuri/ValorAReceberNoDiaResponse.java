/**
 * ValorAReceberNoDiaResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

import java.io.Serializable;

import javax.xml.namespace.QName;

import org.apache.axis.description.ElementDesc;
import org.apache.axis.description.TypeDesc;

@SuppressWarnings("serial")
public class ValorAReceberNoDiaResponse  implements Serializable {
    private double valorAReceberNoDiaResult;

    public ValorAReceberNoDiaResponse() {
    }

    public ValorAReceberNoDiaResponse(
           double valorAReceberNoDiaResult) {
           this.valorAReceberNoDiaResult = valorAReceberNoDiaResult;
    }


    /**
     * Gets the valorAReceberNoDiaResult value for this ValorAReceberNoDiaResponse.
     * 
     * @return valorAReceberNoDiaResult
     */
    public double getValorAReceberNoDiaResult() {
        return valorAReceberNoDiaResult;
    }


    /**
     * Sets the valorAReceberNoDiaResult value for this ValorAReceberNoDiaResponse.
     * 
     * @param valorAReceberNoDiaResult
     */
    public void setValorAReceberNoDiaResult(double valorAReceberNoDiaResult) {
        this.valorAReceberNoDiaResult = valorAReceberNoDiaResult;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
    	if (obj == null) {
    		return false;
    	}
    	
        if (!(obj instanceof ValorAReceberNoDiaResponse)) {
        	return false;
        }
        
        ValorAReceberNoDiaResponse other = (ValorAReceberNoDiaResponse) obj;
        
        if (this == obj) {
        	return true;
        }
        
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        
        __equalsCalc = obj;
        boolean _equals;
        
        _equals = true && 
            this.valorAReceberNoDiaResult == other.getValorAReceberNoDiaResult();
        
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
        
        _hashCode += Double.valueOf(getValorAReceberNoDiaResult()).hashCode();
        __hashCodeCalc = false;
        
        return _hashCode;
    }

    // Type metadata
    private static TypeDesc typeDesc =
        new TypeDesc(ValorAReceberNoDiaResponse.class, true);

    static {
        typeDesc.setXmlType(new QName("http://tempuri.org/", ">ValorAReceberNoDiaResponse"));
        ElementDesc elemField = new ElementDesc();
        elemField.setFieldName("valorAReceberNoDiaResult");
        elemField.setXmlName(new QName("http://tempuri.org/", "ValorAReceberNoDiaResult"));
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
	public static org.apache.axis.encoding.Serializer getSerializer(
           String mechType, 
           Class _javaType,  
           QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    @SuppressWarnings("rawtypes")
	public static org.apache.axis.encoding.Deserializer getDeserializer(
           String mechType, 
           Class _javaType,  
           QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
