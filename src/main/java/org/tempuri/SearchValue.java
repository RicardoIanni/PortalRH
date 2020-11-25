/**
 * SearchValue.java
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
public class SearchValue  implements Serializable {
    private UnsignedByte tipoPesquisa;

    private String stringBusca;

    private String costumerId;

    private String strUsername;

    private String strPassword;

    public SearchValue() {
    }

    public SearchValue(
           UnsignedByte tipoPesquisa,
           String stringBusca,
           String costumerId,
           String strUsername,
           String strPassword) {
           this.tipoPesquisa = tipoPesquisa;
           this.stringBusca = stringBusca;
           this.costumerId = costumerId;
           this.strUsername = strUsername;
           this.strPassword = strPassword;
    }


    /**
     * Gets the tipoPesquisa value for this SearchValue.
     * 
     * @return tipoPesquisa
     */
    public UnsignedByte getTipoPesquisa() {
        return tipoPesquisa;
    }


    /**
     * Sets the tipoPesquisa value for this SearchValue.
     * 
     * @param tipoPesquisa
     */
    public void setTipoPesquisa(UnsignedByte tipoPesquisa) {
        this.tipoPesquisa = tipoPesquisa;
    }


    /**
     * Gets the stringBusca value for this SearchValue.
     * 
     * @return stringBusca
     */
    public String getStringBusca() {
        return stringBusca;
    }


    /**
     * Sets the stringBusca value for this SearchValue.
     * 
     * @param stringBusca
     */
    public void setStringBusca(String stringBusca) {
        this.stringBusca = stringBusca;
    }


    /**
     * Gets the costumerId value for this SearchValue.
     * 
     * @return costumerId
     */
    public String getCostumerId() {
        return costumerId;
    }


    /**
     * Sets the costumerId value for this SearchValue.
     * 
     * @param costumerId
     */
    public void setCostumerId(String costumerId) {
        this.costumerId = costumerId;
    }


    /**
     * Gets the strUsername value for this SearchValue.
     * 
     * @return strUsername
     */
    public String getStrUsername() {
        return strUsername;
    }


    /**
     * Sets the strUsername value for this SearchValue.
     * 
     * @param strUsername
     */
    public void setStrUsername(String strUsername) {
        this.strUsername = strUsername;
    }


    /**
     * Gets the strPassword value for this SearchValue.
     * 
     * @return strPassword
     */
    public String getStrPassword() {
        return strPassword;
    }


    /**
     * Sets the strPassword value for this SearchValue.
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
    	
        if (!(obj instanceof SearchValue)) {
        	return false;
        }
        
        SearchValue other = (SearchValue) obj;
        
        if (this == obj) {
        	return true;
        }
        
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        
        __equalsCalc = obj;
        boolean _equals;
        
        _equals = true && 
            ((this.tipoPesquisa==null && other.getTipoPesquisa()==null) || 
             (this.tipoPesquisa!=null &&
              this.tipoPesquisa.equals(other.getTipoPesquisa()))) &&
            ((this.stringBusca==null && other.getStringBusca()==null) || 
             (this.stringBusca!=null &&
              this.stringBusca.equals(other.getStringBusca()))) &&
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
        
        if (getTipoPesquisa() != null) {
            _hashCode += getTipoPesquisa().hashCode();
        }
        
        if (getStringBusca() != null) {
            _hashCode += getStringBusca().hashCode();
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
        new TypeDesc(SearchValue.class, true);

    static {
        typeDesc.setXmlType(new QName("http://tempuri.org/", ">SearchValue"));
        ElementDesc elemField = new ElementDesc();
        elemField.setFieldName("tipoPesquisa");
        elemField.setXmlName(new QName("http://tempuri.org/", "TipoPesquisa"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "unsignedByte"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("stringBusca");
        elemField.setXmlName(new QName("http://tempuri.org/", "StringBusca"));
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
