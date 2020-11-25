/**
 * SaldoDeContaCorrenteResponse.java
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
public class SaldoDeContaCorrenteResponse  implements Serializable {
    private double saldoDeContaCorrenteResult;

    public SaldoDeContaCorrenteResponse() {
    }

    public SaldoDeContaCorrenteResponse(
           double saldoDeContaCorrenteResult) {
           this.saldoDeContaCorrenteResult = saldoDeContaCorrenteResult;
    }


    /**
     * Gets the saldoDeContaCorrenteResult value for this SaldoDeContaCorrenteResponse.
     * 
     * @return saldoDeContaCorrenteResult
     */
    public double getSaldoDeContaCorrenteResult() {
        return saldoDeContaCorrenteResult;
    }


    /**
     * Sets the saldoDeContaCorrenteResult value for this SaldoDeContaCorrenteResponse.
     * 
     * @param saldoDeContaCorrenteResult
     */
    public void setSaldoDeContaCorrenteResult(double saldoDeContaCorrenteResult) {
        this.saldoDeContaCorrenteResult = saldoDeContaCorrenteResult;
    }

    private Object __equalsCalc = null;
    
    public synchronized boolean equals(Object obj) {
    	if (obj == null) {
    		return false;
    	}
    	
        if (!(obj instanceof SaldoDeContaCorrenteResponse)) {
        	return false;
        }
        
        SaldoDeContaCorrenteResponse other = (SaldoDeContaCorrenteResponse) obj;
        
        if (this == obj) {
        	return true;
        }
        
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        
        __equalsCalc = obj;
        boolean _equals;
        
        _equals = true && 
            this.saldoDeContaCorrenteResult == other.getSaldoDeContaCorrenteResult();
        
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
        _hashCode += Double.valueOf(getSaldoDeContaCorrenteResult()).hashCode();
        __hashCodeCalc = false;
        
        return _hashCode;
    }

    // Type metadata
    private static TypeDesc typeDesc =
        new TypeDesc(SaldoDeContaCorrenteResponse.class, true);

    static {
        typeDesc.setXmlType(new QName("http://tempuri.org/", ">SaldoDeContaCorrenteResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("saldoDeContaCorrenteResult");
        elemField.setXmlName(new QName("http://tempuri.org/", "SaldoDeContaCorrenteResult"));
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
