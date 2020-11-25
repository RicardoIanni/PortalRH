/**
 * QuantidadeCarteira.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

import java.io.Serializable;

import javax.xml.namespace.QName;

import org.apache.axis.description.ElementDesc;
import org.apache.axis.description.TypeDesc;

@SuppressWarnings("serial")
public class QuantidadeCarteira  implements Serializable {
    private String codigo;

    private int empresa;

    private String local;

    private String costumerId;

    private String strUsername;

    private String strPassword;

    public QuantidadeCarteira() {
    }

    public QuantidadeCarteira(
           String codigo,
           int empresa,
           String local,
           String costumerId,
           String strUsername,
           String strPassword) {
           this.codigo = codigo;
           this.empresa = empresa;
           this.local = local;
           this.costumerId = costumerId;
           this.strUsername = strUsername;
           this.strPassword = strPassword;
    }


    /**
     * Gets the codigo value for this QuantidadeCarteira.
     * 
     * @return codigo
     */
    public String getCodigo() {
        return codigo;
    }


    /**
     * Sets the codigo value for this QuantidadeCarteira.
     * 
     * @param codigo
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }


    /**
     * Gets the empresa value for this QuantidadeCarteira.
     * 
     * @return empresa
     */
    public int getEmpresa() {
        return empresa;
    }


    /**
     * Sets the empresa value for this QuantidadeCarteira.
     * 
     * @param empresa
     */
    public void setEmpresa(int empresa) {
        this.empresa = empresa;
    }


    /**
     * Gets the local value for this QuantidadeCarteira.
     * 
     * @return local
     */
    public String getLocal() {
        return local;
    }


    /**
     * Sets the local value for this QuantidadeCarteira.
     * 
     * @param local
     */
    public void setLocal(String local) {
        this.local = local;
    }


    /**
     * Gets the costumerId value for this QuantidadeCarteira.
     * 
     * @return costumerId
     */
    public String getCostumerId() {
        return costumerId;
    }


    /**
     * Sets the costumerId value for this QuantidadeCarteira.
     * 
     * @param costumerId
     */
    public void setCostumerId(String costumerId) {
        this.costumerId = costumerId;
    }


    /**
     * Gets the strUsername value for this QuantidadeCarteira.
     * 
     * @return strUsername
     */
    public String getStrUsername() {
        return strUsername;
    }


    /**
     * Sets the strUsername value for this QuantidadeCarteira.
     * 
     * @param strUsername
     */
    public void setStrUsername(String strUsername) {
        this.strUsername = strUsername;
    }


    /**
     * Gets the strPassword value for this QuantidadeCarteira.
     * 
     * @return strPassword
     */
    public String getStrPassword() {
        return strPassword;
    }


    /**
     * Sets the strPassword value for this QuantidadeCarteira.
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
    	
        if (!(obj instanceof QuantidadeCarteira)) {
        	return false;
        }
        
        QuantidadeCarteira other = (QuantidadeCarteira) obj;
        
        if (this == obj) {
        	return true;
        }
        
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        
        __equalsCalc = obj;
        boolean _equals;
        
        _equals = true && 
            ((this.codigo==null && other.getCodigo()==null) || 
             (this.codigo!=null &&
              this.codigo.equals(other.getCodigo()))) &&
            this.empresa == other.getEmpresa() &&
            ((this.local==null && other.getLocal()==null) || 
             (this.local!=null &&
              this.local.equals(other.getLocal()))) &&
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
        
        if (getCodigo() != null) {
            _hashCode += getCodigo().hashCode();
        }
        
        _hashCode += getEmpresa();
        
        if (getLocal() != null) {
            _hashCode += getLocal().hashCode();
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
        new TypeDesc(QuantidadeCarteira.class, true);

    static {
        typeDesc.setXmlType(new QName("http://tempuri.org/", ">QuantidadeCarteira"));
        ElementDesc elemField = new ElementDesc();
        elemField.setFieldName("codigo");
        elemField.setXmlName(new QName("http://tempuri.org/", "Codigo"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("empresa");
        elemField.setXmlName(new QName("http://tempuri.org/", "Empresa"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("local");
        elemField.setXmlName(new QName("http://tempuri.org/", "Local"));
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
