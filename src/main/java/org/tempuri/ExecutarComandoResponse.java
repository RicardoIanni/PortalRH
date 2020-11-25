/**
 * ExecutarComandoResponse.java
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
public class ExecutarComandoResponse  implements Serializable {
    private ExecutarComandoResponseExecutarComandoResult executarComandoResult;

    public ExecutarComandoResponse() {
    }

    public ExecutarComandoResponse(
           ExecutarComandoResponseExecutarComandoResult executarComandoResult) {
           this.executarComandoResult = executarComandoResult;
    }


    /**
     * Gets the executarComandoResult value for this ExecutarComandoResponse.
     * 
     * @return executarComandoResult
     */
    public ExecutarComandoResponseExecutarComandoResult getExecutarComandoResult() {
        return executarComandoResult;
    }


    /**
     * Sets the executarComandoResult value for this ExecutarComandoResponse.
     * 
     * @param executarComandoResult
     */
    public void setExecutarComandoResult(ExecutarComandoResponseExecutarComandoResult executarComandoResult) {
        this.executarComandoResult = executarComandoResult;
    }

    private Object __equalsCalc = null;
    
    public synchronized boolean equals(Object obj) {
    	if (obj == null) return false;
        if (!(obj instanceof ExecutarComandoResponse)) return false;
        ExecutarComandoResponse other = (ExecutarComandoResponse) obj;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.executarComandoResult==null && other.getExecutarComandoResult()==null) || 
             (this.executarComandoResult!=null &&
              this.executarComandoResult.equals(other.getExecutarComandoResult())));
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
        if (getExecutarComandoResult() != null) {
            _hashCode += getExecutarComandoResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static TypeDesc typeDesc =
        new TypeDesc(ExecutarComandoResponse.class, true);

    static {
        typeDesc.setXmlType(new QName("http://tempuri.org/", ">executarComandoResponse"));
        ElementDesc elemField = new ElementDesc();
        elemField.setFieldName("executarComandoResult");
        elemField.setXmlName(new QName("http://tempuri.org/", "executarComandoResult"));
        elemField.setXmlType(new QName("http://tempuri.org/", ">>executarComandoResponse>executarComandoResult"));
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
