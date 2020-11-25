/**
 * CreditAvaliationResponse.java
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
public class CreditAvaliationResponse  implements Serializable {
    private CreditAvaliationResponseCreditAvaliationResult creditAvaliationResult;

    public CreditAvaliationResponse() {
    }

    public CreditAvaliationResponse(
           CreditAvaliationResponseCreditAvaliationResult creditAvaliationResult) {
           this.creditAvaliationResult = creditAvaliationResult;
    }


    /**
     * Gets the creditAvaliationResult value for this CreditAvaliationResponse.
     * 
     * @return creditAvaliationResult
     */
    public CreditAvaliationResponseCreditAvaliationResult getCreditAvaliationResult() {
        return creditAvaliationResult;
    }


    /**
     * Sets the creditAvaliationResult value for this CreditAvaliationResponse.
     * 
     * @param creditAvaliationResult
     */
    public void setCreditAvaliationResult(CreditAvaliationResponseCreditAvaliationResult creditAvaliationResult) {
        this.creditAvaliationResult = creditAvaliationResult;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
    	if (obj == null) {
    		return false;
    	}
    	
        if (!(obj instanceof CreditAvaliationResponse)) {
        	return false;
        }
        
        CreditAvaliationResponse other = (CreditAvaliationResponse) obj;
        
        if (this == obj) {
        	return true;
        }
        
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        
        __equalsCalc = obj;
        boolean _equals;
        
        _equals = true && 
            ((this.creditAvaliationResult==null && other.getCreditAvaliationResult()==null) || 
             (this.creditAvaliationResult!=null &&
              this.creditAvaliationResult.equals(other.getCreditAvaliationResult())));
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
        
        if (getCreditAvaliationResult() != null) {
            _hashCode += getCreditAvaliationResult().hashCode();
        }
        
        __hashCodeCalc = false;
        
        return _hashCode;
    }

    // Type metadata
    private static TypeDesc typeDesc =
        new TypeDesc(CreditAvaliationResponse.class, true);

    static {
        typeDesc.setXmlType(new QName("http://tempuri.org/", ">CreditAvaliationResponse"));
        ElementDesc elemField = new ElementDesc();
        elemField.setFieldName("creditAvaliationResult");
        elemField.setXmlName(new QName("http://tempuri.org/", "CreditAvaliationResult"));
        elemField.setXmlType(new QName("http://tempuri.org/", ">>CreditAvaliationResponse>CreditAvaliationResult"));
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
        return 
          new BeanSerializer(_javaType, _xmlType, typeDesc);
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
