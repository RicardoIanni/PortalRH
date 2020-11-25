/**
 * QuantidadeReservaResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

import java.io.Serializable;

import javax.xml.namespace.QName;

import org.apache.axis.description.ElementDesc;
import org.apache.axis.description.TypeDesc;
import org.apache.axis.encoding.Deserializer;
import org.apache.axis.encoding.Serializer;
import org.apache.axis.encoding.ser.BeanDeserializer;
import org.apache.axis.encoding.ser.BeanSerializer;

@SuppressWarnings("serial")
public class QuantidadeReservaResponse  implements Serializable {
    private double quantidadeReservaResult;

    public QuantidadeReservaResponse() {
    }

    public QuantidadeReservaResponse(
           double quantidadeReservaResult) {
           this.quantidadeReservaResult = quantidadeReservaResult;
    }


    /**
     * Gets the quantidadeReservaResult value for this QuantidadeReservaResponse.
     * 
     * @return quantidadeReservaResult
     */
    public double getQuantidadeReservaResult() {
        return quantidadeReservaResult;
    }


    /**
     * Sets the quantidadeReservaResult value for this QuantidadeReservaResponse.
     * 
     * @param quantidadeReservaResult
     */
    public void setQuantidadeReservaResult(double quantidadeReservaResult) {
        this.quantidadeReservaResult = quantidadeReservaResult;
    }

    private Object __equalsCalc = null;
    
    public synchronized boolean equals(Object obj) {
    	if (obj == null) {
    		return false;
    	}
    	
        if (!(obj instanceof QuantidadeReservaResponse)) {
        	return false;
        }
        
        QuantidadeReservaResponse other = (QuantidadeReservaResponse) obj;
        
        if (this == obj) {
        	return true;
        }
        
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        
        __equalsCalc = obj;
        boolean _equals;
        
        _equals = true && 
            this.quantidadeReservaResult == other.getQuantidadeReservaResult();
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
        
        _hashCode += Double.valueOf(getQuantidadeReservaResult()).hashCode();
        
        __hashCodeCalc = false;
        
        return _hashCode;
    }

    // Type metadata
    private static TypeDesc typeDesc =
        new TypeDesc(QuantidadeReservaResponse.class, true);

    static {
        typeDesc.setXmlType(new QName("http://tempuri.org/", ">QuantidadeReservaResponse"));
        ElementDesc elemField = new ElementDesc();
        elemField.setFieldName("quantidadeReservaResult");
        elemField.setXmlName(new QName("http://tempuri.org/", "QuantidadeReservaResult"));
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
