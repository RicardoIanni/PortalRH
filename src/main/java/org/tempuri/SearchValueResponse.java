/**
 * SearchValueResponse.java
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
public class SearchValueResponse  implements Serializable {
    private SearchValueResponseSearchValueResult searchValueResult;

    public SearchValueResponse() {
    }

    public SearchValueResponse(
           SearchValueResponseSearchValueResult searchValueResult) {
           this.searchValueResult = searchValueResult;
    }


    /**
     * Gets the searchValueResult value for this SearchValueResponse.
     * 
     * @return searchValueResult
     */
    public SearchValueResponseSearchValueResult getSearchValueResult() {
        return searchValueResult;
    }


    /**
     * Sets the searchValueResult value for this SearchValueResponse.
     * 
     * @param searchValueResult
     */
    public void setSearchValueResult(SearchValueResponseSearchValueResult searchValueResult) {
        this.searchValueResult = searchValueResult;
    }

    private Object __equalsCalc = null;
    
    public synchronized boolean equals(Object obj) {
    	if (obj == null) {
    		return false;
    	}
    	
        if (!(obj instanceof SearchValueResponse)) {
        	return false;
        }
        
        SearchValueResponse other = (SearchValueResponse) obj;
        
        if (this == obj) {
        	return true;
        }
        
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        
        __equalsCalc = obj;
        boolean _equals;
        
        _equals = true && 
            ((this.searchValueResult==null && other.getSearchValueResult()==null) || 
             (this.searchValueResult!=null &&
              this.searchValueResult.equals(other.getSearchValueResult())));
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
        
        if (getSearchValueResult() != null) {
            _hashCode += getSearchValueResult().hashCode();
        }
        
        __hashCodeCalc = false;
    
        return _hashCode;
    }

    // Type metadata
    private static TypeDesc typeDesc =
        new TypeDesc(SearchValueResponse.class, true);

    static {
        typeDesc.setXmlType(new QName("http://tempuri.org/", ">SearchValueResponse"));
        ElementDesc elemField = new ElementDesc();
        elemField.setFieldName("searchValueResult");
        elemField.setXmlName(new QName("http://tempuri.org/", "SearchValueResult"));
        elemField.setXmlType(new QName("http://tempuri.org/", ">>SearchValueResponse>SearchValueResult"));
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
