/**
 * CallXmlProcessResponse.java
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
public class CallXmlProcessResponse  implements Serializable {
    private String callXmlProcessResult;

    public CallXmlProcessResponse() {
    }

    public CallXmlProcessResponse(
           String callXmlProcessResult) {
           this.callXmlProcessResult = callXmlProcessResult;
    }


    /**
     * Gets the callXmlProcessResult value for this CallXmlProcessResponse.
     * 
     * @return callXmlProcessResult
     */
    public String getCallXmlProcessResult() {
        return callXmlProcessResult;
    }


    /**
     * Sets the callXmlProcessResult value for this CallXmlProcessResponse.
     * 
     * @param callXmlProcessResult
     */
    public void setCallXmlProcessResult(String callXmlProcessResult) {
        this.callXmlProcessResult = callXmlProcessResult;
    }

    private java.lang.Object __equalsCalc = null;
    
    public synchronized boolean equals(java.lang.Object obj) {
    	if (obj == null) {
        	return false;
        }
        
    	if (!(obj instanceof CallXmlProcessResponse)) {
        	return false;
        }
        
        CallXmlProcessResponse other = (CallXmlProcessResponse) obj;
        
        if (this == obj) {
        	return true;
        }
        
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        
        __equalsCalc = obj;
        
        boolean _equals;
        
        _equals = true && 
            ((this.callXmlProcessResult==null && other.getCallXmlProcessResult()==null) || 
             (this.callXmlProcessResult!=null &&
              this.callXmlProcessResult.equals(other.getCallXmlProcessResult())));
        
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
        
        if (getCallXmlProcessResult() != null) {
            _hashCode += getCallXmlProcessResult().hashCode();
        }
        
        __hashCodeCalc = false;
        
        return _hashCode;
    }

    // Type metadata
    private static TypeDesc typeDesc =
        new TypeDesc(CallXmlProcessResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">callXmlProcessResponse"));
        ElementDesc elemField = new ElementDesc();
        elemField.setFieldName("callXmlProcessResult");
        elemField.setXmlName(new QName("http://tempuri.org/", "callXmlProcessResult"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
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