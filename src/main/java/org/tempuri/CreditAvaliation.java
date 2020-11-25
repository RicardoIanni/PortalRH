/**
 * CreditAvaliation.java
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
import org.apache.axis.types.UnsignedByte;

@SuppressWarnings("serial")
public class CreditAvaliation  implements Serializable {
    private String CNPJ;

    private UnsignedByte tipoAnalise;

    private String costumerId;

    private String strUsername;

    private String strPassword;

    public CreditAvaliation() {
    }

    public CreditAvaliation(
           String CNPJ,
           UnsignedByte tipoAnalise,
           String costumerId,
           String strUsername,
           String strPassword) {
           this.CNPJ = CNPJ;
           this.tipoAnalise = tipoAnalise;
           this.costumerId = costumerId;
           this.strUsername = strUsername;
           this.strPassword = strPassword;
    }


    /**
     * Gets the CNPJ value for this CreditAvaliation.
     * 
     * @return CNPJ
     */
    public String getCNPJ() {
        return CNPJ;
    }


    /**
     * Sets the CNPJ value for this CreditAvaliation.
     * 
     * @param CNPJ
     */
    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }


    /**
     * Gets the tipoAnalise value for this CreditAvaliation.
     * 
     * @return tipoAnalise
     */
    public UnsignedByte getTipoAnalise() {
        return tipoAnalise;
    }


    /**
     * Sets the tipoAnalise value for this CreditAvaliation.
     * 
     * @param tipoAnalise
     */
    public void setTipoAnalise(UnsignedByte tipoAnalise) {
        this.tipoAnalise = tipoAnalise;
    }


    /**
     * Gets the costumerId value for this CreditAvaliation.
     * 
     * @return costumerId
     */
    public String getCostumerId() {
        return costumerId;
    }


    /**
     * Sets the costumerId value for this CreditAvaliation.
     * 
     * @param costumerId
     */
    public void setCostumerId(String costumerId) {
        this.costumerId = costumerId;
    }


    /**
     * Gets the strUsername value for this CreditAvaliation.
     * 
     * @return strUsername
     */
    public String getStrUsername() {
        return strUsername;
    }


    /**
     * Sets the strUsername value for this CreditAvaliation.
     * 
     * @param strUsername
     */
    public void setStrUsername(String strUsername) {
        this.strUsername = strUsername;
    }


    /**
     * Gets the strPassword value for this CreditAvaliation.
     * 
     * @return strPassword
     */
    public String getStrPassword() {
        return strPassword;
    }


    /**
     * Sets the strPassword value for this CreditAvaliation.
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
    	
        if (!(obj instanceof CreditAvaliation)) {
        	return false;
        }
        
        CreditAvaliation other = (CreditAvaliation) obj;
        
        if (this == obj) {
        	return true;
        }
        
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        
        __equalsCalc = obj;
        
        boolean _equals;
        
        _equals = true && 
            ((this.CNPJ==null && other.getCNPJ()==null) || 
             (this.CNPJ!=null &&
              this.CNPJ.equals(other.getCNPJ()))) &&
            ((this.tipoAnalise==null && other.getTipoAnalise()==null) || 
             (this.tipoAnalise!=null &&
              this.tipoAnalise.equals(other.getTipoAnalise()))) &&
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
        
        if (getCNPJ() != null) {
            _hashCode += getCNPJ().hashCode();
        }
        
        if (getTipoAnalise() != null) {
            _hashCode += getTipoAnalise().hashCode();
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
        new TypeDesc(CreditAvaliation.class, true);

    static {
        typeDesc.setXmlType(new QName("http://tempuri.org/", ">CreditAvaliation"));
        ElementDesc elemField = new ElementDesc();
        elemField.setFieldName("CNPJ");
        elemField.setXmlName(new QName("http://tempuri.org/", "CNPJ"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("tipoAnalise");
        elemField.setXmlName(new QName("http://tempuri.org/", "TipoAnalise"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "unsignedByte"));
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