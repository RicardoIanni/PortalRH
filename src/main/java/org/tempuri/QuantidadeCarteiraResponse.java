/**
 * QuantidadeCarteiraResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

import java.io.Serializable;

import javax.xml.namespace.QName;

import org.apache.axis.description.ElementDesc;
import org.apache.axis.description.TypeDesc;
import org.apache.axis.encoding.Serializer;

@SuppressWarnings("serial")
public class QuantidadeCarteiraResponse  implements Serializable {
    private double quantidadeCarteiraResult;

    public QuantidadeCarteiraResponse() {
    }

    public QuantidadeCarteiraResponse(
           double quantidadeCarteiraResult) {
           this.quantidadeCarteiraResult = quantidadeCarteiraResult;
    }


    /**
     * Gets the quantidadeCarteiraResult value for this QuantidadeCarteiraResponse.
     * 
     * @return quantidadeCarteiraResult
     */
    public double getQuantidadeCarteiraResult() {
        return quantidadeCarteiraResult;
    }


    /**
     * Sets the quantidadeCarteiraResult value for this QuantidadeCarteiraResponse.
     * 
     * @param quantidadeCarteiraResult
     */
    public void setQuantidadeCarteiraResult(double quantidadeCarteiraResult) {
        this.quantidadeCarteiraResult = quantidadeCarteiraResult;
    }

    private Object __equalsCalc = null;
    
    public synchronized boolean equals(Object obj) {
        if (obj == null) {
        	return false;
        }
        
        if (!(obj instanceof QuantidadeCarteiraResponse)) {
        	return false;
        }
        
        QuantidadeCarteiraResponse other = (QuantidadeCarteiraResponse) obj;
        
        if (this == obj) {
        	return true;
        }
        
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        
        __equalsCalc = obj;
        boolean _equals;
        
        _equals = true && 
            this.quantidadeCarteiraResult == other.getQuantidadeCarteiraResult();
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
        _hashCode += Double.valueOf(getQuantidadeCarteiraResult()).hashCode();
        
        __hashCodeCalc = false;
        
        return _hashCode;
    }

    // Type metadata
    private static TypeDesc typeDesc =
        new TypeDesc(QuantidadeCarteiraResponse.class, true);

    static {
        typeDesc.setXmlType(new QName("http://tempuri.org/", ">QuantidadeCarteiraResponse"));
        ElementDesc elemField = new ElementDesc();
        elemField.setFieldName("quantidadeCarteiraResult");
        elemField.setXmlName(new QName("http://tempuri.org/", "QuantidadeCarteiraResult"));
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
