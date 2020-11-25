/**
 * ExecutarComando.java
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
public class ExecutarComando implements Serializable {
    private String comando;

    private String costumerId;

    private String strUsername;

    private String strPassword;

    public ExecutarComando() {
    }

    public ExecutarComando(
           String comando,
           String costumerId,
           String strUsername,
           String strPassword) {
           this.comando = comando;
           this.costumerId = costumerId;
           this.strUsername = strUsername;
           this.strPassword = strPassword;
    }


    /**
     * Gets the comando value for this ExecutarComando.
     * 
     * @return comando
     */
    public String getComando() {
        return comando;
    }


    /**
     * Sets the comando value for this ExecutarComando.
     * 
     * @param comando
     */
    public void setComando(String comando) {
        this.comando = comando;
    }


    /**
     * Gets the costumerId value for this ExecutarComando.
     * 
     * @return costumerId
     */
    public String getCostumerId() {
        return costumerId;
    }


    /**
     * Sets the costumerId value for this ExecutarComando.
     * 
     * @param costumerId
     */
    public void setCostumerId(String costumerId) {
        this.costumerId = costumerId;
    }


    /**
     * Gets the strUsername value for this ExecutarComando.
     * 
     * @return strUsername
     */
    public String getStrUsername() {
        return strUsername;
    }


    /**
     * Sets the strUsername value for this ExecutarComando.
     * 
     * @param strUsername
     */
    public void setStrUsername(String strUsername) {
        this.strUsername = strUsername;
    }


    /**
     * Gets the strPassword value for this ExecutarComando.
     * 
     * @return strPassword
     */
    public String getStrPassword() {
        return strPassword;
    }


    /**
     * Sets the strPassword value for this ExecutarComando.
     * 
     * @param strPassword
     */
    public void setStrPassword(String strPassword) {
        this.strPassword = strPassword;
    }

    private java.lang.Object __equalsCalc = null;

    public synchronized boolean equals(java.lang.Object obj) {
        if (obj == null) {
        	return false;
        }
        
        if (!(obj instanceof ExecutarComando)) {
        	return false;
        }
        
        ExecutarComando other = (ExecutarComando) obj;
        
        if (this == obj) {
        	return true;
        }
        
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        
        _equals = true && 
            ((this.comando==null && other.getComando()==null) || 
             (this.comando!=null &&
              this.comando.equals(other.getComando()))) &&
            ((this.costumerId==null && other.getCostumerId()==null) || 
             (this.costumerId!=null &&
              this.costumerId.equals(other.getCostumerId()))) &&
            ((this.strUsername==null && other.getStrUsername()==null) || 
             (this.strUsername!=null &&
              this.strUsername.equals(other.getStrUsername()))) &&
            ((this.strPassword==null && other.getStrPassword()==null) || 
             (this.strPassword!=null &&
              this.strPassword.equals(other.getStrPassword())));
        
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
        
        if (getComando() != null) {
            _hashCode += getComando().hashCode();
        }
        
        if (getCostumerId() != null) {
            _hashCode += getCostumerId().hashCode();
        }
        
        if (getStrUsername() != null) {
            _hashCode += getStrUsername().hashCode();
        }
        
        if (getStrPassword() != null) {
            _hashCode += getStrPassword().hashCode();
        }
        
        __hashCodeCalc = false;
        
        return _hashCode;
    }

    // Type metadata
    private static TypeDesc typeDesc =
        new TypeDesc(ExecutarComando.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">executarComando"));
        ElementDesc elemField = new ElementDesc();
        elemField.setFieldName("comando");
        elemField.setXmlName(new QName("http://tempuri.org/", "comando"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("costumerId");
        elemField.setXmlName(new QName("http://tempuri.org/", "CostumerId"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("strUsername");
        elemField.setXmlName(new QName("http://tempuri.org/", "strUsername"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("strPassword");
        elemField.setXmlName(new QName("http://tempuri.org/", "strPassword"));
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
