/**
 * ValorAPagarNoDia.java
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
public class ValorAPagarNoDia  implements Serializable {
    private int empresa;

    private String data;

    private String moeda;

    private String costumerId;

    private String strUsername;

    private String strPassword;

    public ValorAPagarNoDia() {
    }

    public ValorAPagarNoDia(
           int empresa,
           String data,
           String moeda,
           String costumerId,
           String strUsername,
           String strPassword) {
           this.empresa = empresa;
           this.data = data;
           this.moeda = moeda;
           this.costumerId = costumerId;
           this.strUsername = strUsername;
           this.strPassword = strPassword;
    }


    /**
     * Gets the empresa value for this ValorAPagarNoDia.
     * 
     * @return empresa
     */
    public int getEmpresa() {
        return empresa;
    }


    /**
     * Sets the empresa value for this ValorAPagarNoDia.
     * 
     * @param empresa
     */
    public void setEmpresa(int empresa) {
        this.empresa = empresa;
    }


    /**
     * Gets the data value for this ValorAPagarNoDia.
     * 
     * @return data
     */
    public String getData() {
        return data;
    }


    /**
     * Sets the data value for this ValorAPagarNoDia.
     * 
     * @param data
     */
    public void setData(String data) {
        this.data = data;
    }


    /**
     * Gets the moeda value for this ValorAPagarNoDia.
     * 
     * @return moeda
     */
    public String getMoeda() {
        return moeda;
    }


    /**
     * Sets the moeda value for this ValorAPagarNoDia.
     * 
     * @param moeda
     */
    public void setMoeda(String moeda) {
        this.moeda = moeda;
    }


    /**
     * Gets the costumerId value for this ValorAPagarNoDia.
     * 
     * @return costumerId
     */
    public String getCostumerId() {
        return costumerId;
    }


    /**
     * Sets the costumerId value for this ValorAPagarNoDia.
     * 
     * @param costumerId
     */
    public void setCostumerId(String costumerId) {
        this.costumerId = costumerId;
    }


    /**
     * Gets the strUsername value for this ValorAPagarNoDia.
     * 
     * @return strUsername
     */
    public String getStrUsername() {
        return strUsername;
    }


    /**
     * Sets the strUsername value for this ValorAPagarNoDia.
     * 
     * @param strUsername
     */
    public void setStrUsername(String strUsername) {
        this.strUsername = strUsername;
    }


    /**
     * Gets the strPassword value for this ValorAPagarNoDia.
     * 
     * @return strPassword
     */
    public String getStrPassword() {
        return strPassword;
    }


    /**
     * Sets the strPassword value for this ValorAPagarNoDia.
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
    	
        if (!(obj instanceof ValorAPagarNoDia)) {
        	return false;
        }
        
        ValorAPagarNoDia other = (ValorAPagarNoDia) obj;
        
        if (this == obj) {
        	return true;
        }
        
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        
        __equalsCalc = obj;
        boolean _equals;
        
        _equals = true && 
            this.empresa == other.getEmpresa() &&
            ((this.data==null && other.getData()==null) || 
             (this.data!=null &&
              this.data.equals(other.getData()))) &&
            ((this.moeda==null && other.getMoeda()==null) || 
             (this.moeda!=null &&
              this.moeda.equals(other.getMoeda()))) &&
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
        _hashCode += getEmpresa();
        
        if (getData() != null) {
            _hashCode += getData().hashCode();
        }
        
        if (getMoeda() != null) {
            _hashCode += getMoeda().hashCode();
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
        new TypeDesc(ValorAPagarNoDia.class, true);

    static {
        typeDesc.setXmlType(new QName("http://tempuri.org/", ">ValorAPagarNoDia"));
        ElementDesc elemField = new ElementDesc();
        elemField.setFieldName("empresa");
        elemField.setXmlName(new QName("http://tempuri.org/", "Empresa"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "int"));
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
        elemField.setFieldName("moeda");
        elemField.setXmlName(new QName("http://tempuri.org/", "Moeda"));
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
