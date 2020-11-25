/**
 * FinancialHistoryResponse.java
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
public class FinancialHistoryResponse  implements Serializable {
    private FinancialHistoryResponseFinancialHistoryResult financialHistoryResult;

    public FinancialHistoryResponse() {
    }

    public FinancialHistoryResponse(
           FinancialHistoryResponseFinancialHistoryResult financialHistoryResult) {
           this.financialHistoryResult = financialHistoryResult;
    }


    /**
     * Gets the financialHistoryResult value for this FinancialHistoryResponse.
     * 
     * @return financialHistoryResult
     */
    public FinancialHistoryResponseFinancialHistoryResult getFinancialHistoryResult() {
        return financialHistoryResult;
    }


    /**
     * Sets the financialHistoryResult value for this FinancialHistoryResponse.
     * 
     * @param financialHistoryResult
     */
    public void setFinancialHistoryResult(FinancialHistoryResponseFinancialHistoryResult financialHistoryResult) {
        this.financialHistoryResult = financialHistoryResult;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
    	if (obj == null) {
    		return false;
    	}
    	
        if (!(obj instanceof FinancialHistoryResponse)) {
        	return false;
        }
        
        FinancialHistoryResponse other = (FinancialHistoryResponse) obj;
        
        if (this == obj) {
        	return true;
        }
        
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        
        __equalsCalc = obj;
        boolean _equals;
        
        _equals = true && 
            ((this.financialHistoryResult==null && other.getFinancialHistoryResult()==null) || 
             (this.financialHistoryResult!=null &&
              this.financialHistoryResult.equals(other.getFinancialHistoryResult())));
        
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
        
        if (getFinancialHistoryResult() != null) {
            _hashCode += getFinancialHistoryResult().hashCode();
        }
        
        __hashCodeCalc = false;
        
        return _hashCode;
    }

    // Type metadata
    private static TypeDesc typeDesc =
        new TypeDesc(FinancialHistoryResponse.class, true);

    static {
        typeDesc.setXmlType(new QName("http://tempuri.org/", ">FinancialHistoryResponse"));
        ElementDesc elemField = new ElementDesc();
        elemField.setFieldName("financialHistoryResult");
        elemField.setXmlName(new QName("http://tempuri.org/", "FinancialHistoryResult"));
        elemField.setXmlType(new QName("http://tempuri.org/", ">>FinancialHistoryResponse>FinancialHistoryResult"));
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
