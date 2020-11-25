/**
 * SaldoDeContaCorrente.java
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
import org.apache.axis.encoding.ser.BeanDeserializer;
import org.apache.axis.encoding.ser.BeanSerializer;

@SuppressWarnings("serial")
public class SaldoDeContaCorrente  implements Serializable {
    private String conta;

    private String data;

    private String costumerId;

    private String strUsername;

    private String strPassword;

    public SaldoDeContaCorrente() {
    }

    public SaldoDeContaCorrente(
           String conta,
           String data,
           String costumerId,
           String strUsername,
           String strPassword) {
           this.conta = conta;
           this.data = data;
           this.costumerId = costumerId;
           this.strUsername = strUsername;
           this.strPassword = strPassword;
    }


    /**
     * Gets the conta value for this SaldoDeContaCorrente.
     * 
     * @return conta
     */
    public String getConta() {
        return conta;
    }


    /**
     * Sets the conta value for this SaldoDeContaCorrente.
     * 
     * @param conta
     */
    public void setConta(String conta) {
        this.conta = conta;
    }


    /**
     * Gets the data value for this SaldoDeContaCorrente.
     * 
     * @return data
     */
    public String getData() {
        return data;
    }


    /**
     * Sets the data value for this SaldoDeContaCorrente.
     * 
     * @param data
     */
    public void setData(String data) {
        this.data = data;
    }


    /**
     * Gets the costumerId value for this SaldoDeContaCorrente.
     * 
     * @return costumerId
     */
    public String getCostumerId() {
        return costumerId;
    }


    /**
     * Sets the costumerId value for this SaldoDeContaCorrente.
     * 
     * @param costumerId
     */
    public void setCostumerId(String costumerId) {
        this.costumerId = costumerId;
    }


    /**
     * Gets the strUsername value for this SaldoDeContaCorrente.
     * 
     * @return strUsername
     */
    public String getStrUsername() {
        return strUsername;
    }


    /**
     * Sets the strUsername value for this SaldoDeContaCorrente.
     * 
     * @param strUsername
     */
    public void setStrUsername(String strUsername) {
        this.strUsername = strUsername;
    }


    /**
     * Gets the strPassword value for this SaldoDeContaCorrente.
     * 
     * @return strPassword
     */
    public String getStrPassword() {
        return strPassword;
    }


    /**
     * Sets the strPassword value for this SaldoDeContaCorrente.
     * 
     * @param strPassword
     */
    public void setStrPassword(String strPassword) {
        this.strPassword = strPassword;
    }

    private Object __equalsCalc = null;
    
    public synchronized boolean equals(Object obj) {
        if (obj == null) {
        	return false;
        }
        
        if (!(obj instanceof SaldoDeContaCorrente)) {
        	return false;
        }
        
        SaldoDeContaCorrente other = (SaldoDeContaCorrente) obj;
        
        if (this == obj) {
        	return true;
        }
        
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        
        __equalsCalc = obj;
        boolean _equals;
        
        _equals = true && 
            ((this.conta==null && other.getConta()==null) || 
             (this.conta!=null &&
              this.conta.equals(other.getConta()))) &&
            ((this.data==null && other.getData()==null) || 
             (this.data!=null &&
              this.data.equals(other.getData()))) &&
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
        
        if (getConta() != null) {
            _hashCode += getConta().hashCode();
        }
        
        if (getData() != null) {
            _hashCode += getData().hashCode();
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
        new TypeDesc(SaldoDeContaCorrente.class, true);

    static {
        typeDesc.setXmlType(new QName("http://tempuri.org/", ">SaldoDeContaCorrente"));
        ElementDesc elemField = new ElementDesc();
        elemField.setFieldName("conta");
        elemField.setXmlName(new QName("http://tempuri.org/", "Conta"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("data");
        elemField.setXmlName(new QName("http://tempuri.org/", "Data"));
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
	public static org.apache.axis.encoding.Serializer getSerializer(
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
