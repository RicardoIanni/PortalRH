/**
 * FinancialHistory.java
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
public class FinancialHistory  implements Serializable {
    private int codigoCliente;

    private String dataInicial;

    private String dataFinal;

    private String moeda;

    private String costumerId;

    private String strUsername;

    private String strPassword;

    public FinancialHistory() {
    }

    public FinancialHistory(
           int codigoCliente,
           String dataInicial,
           String dataFinal,
           String moeda,
           String costumerId,
           String strUsername,
           String strPassword) {
           this.codigoCliente = codigoCliente;
           this.dataInicial = dataInicial;
           this.dataFinal = dataFinal;
           this.moeda = moeda;
           this.costumerId = costumerId;
           this.strUsername = strUsername;
           this.strPassword = strPassword;
    }


    /**
     * Gets the codigoCliente value for this FinancialHistory.
     * 
     * @return codigoCliente
     */
    public int getCodigoCliente() {
        return codigoCliente;
    }


    /**
     * Sets the codigoCliente value for this FinancialHistory.
     * 
     * @param codigoCliente
     */
    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }


    /**
     * Gets the dataInicial value for this FinancialHistory.
     * 
     * @return dataInicial
     */
    public String getDataInicial() {
        return dataInicial;
    }


    /**
     * Sets the dataInicial value for this FinancialHistory.
     * 
     * @param dataInicial
     */
    public void setDataInicial(String dataInicial) {
        this.dataInicial = dataInicial;
    }


    /**
     * Gets the dataFinal value for this FinancialHistory.
     * 
     * @return dataFinal
     */
    public String getDataFinal() {
        return dataFinal;
    }


    /**
     * Sets the dataFinal value for this FinancialHistory.
     * 
     * @param dataFinal
     */
    public void setDataFinal(String dataFinal) {
        this.dataFinal = dataFinal;
    }


    /**
     * Gets the moeda value for this FinancialHistory.
     * 
     * @return moeda
     */
    public String getMoeda() {
        return moeda;
    }


    /**
     * Sets the moeda value for this FinancialHistory.
     * 
     * @param moeda
     */
    public void setMoeda(String moeda) {
        this.moeda = moeda;
    }


    /**
     * Gets the costumerId value for this FinancialHistory.
     * 
     * @return costumerId
     */
    public String getCostumerId() {
        return costumerId;
    }


    /**
     * Sets the costumerId value for this FinancialHistory.
     * 
     * @param costumerId
     */
    public void setCostumerId(String costumerId) {
        this.costumerId = costumerId;
    }


    /**
     * Gets the strUsername value for this FinancialHistory.
     * 
     * @return strUsername
     */
    public String getStrUsername() {
        return strUsername;
    }


    /**
     * Sets the strUsername value for this FinancialHistory.
     * 
     * @param strUsername
     */
    public void setStrUsername(String strUsername) {
        this.strUsername = strUsername;
    }


    /**
     * Gets the strPassword value for this FinancialHistory.
     * 
     * @return strPassword
     */
    public String getStrPassword() {
        return strPassword;
    }


    /**
     * Sets the strPassword value for this FinancialHistory.
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
    	
        if (!(obj instanceof FinancialHistory)) {
        	return false;
        }
        
        FinancialHistory other = (FinancialHistory) obj;
        
        if (this == obj) {
        	return true;
        }
        
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        
        __equalsCalc = obj;
        boolean _equals;
        
        _equals = true && 
            this.codigoCliente == other.getCodigoCliente() &&
            ((this.dataInicial==null && other.getDataInicial()==null) || 
             (this.dataInicial!=null &&
              this.dataInicial.equals(other.getDataInicial()))) &&
            ((this.dataFinal==null && other.getDataFinal()==null) || 
             (this.dataFinal!=null &&
              this.dataFinal.equals(other.getDataFinal()))) &&
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
        _hashCode += getCodigoCliente();
        
        if (getDataInicial() != null) {
            _hashCode += getDataInicial().hashCode();
        }
        
        if (getDataFinal() != null) {
            _hashCode += getDataFinal().hashCode();
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
        new TypeDesc(FinancialHistory.class, true);

    static {
        typeDesc.setXmlType(new QName("http://tempuri.org/", ">FinancialHistory"));
        ElementDesc elemField = new ElementDesc();
        elemField.setFieldName("codigoCliente");
        elemField.setXmlName(new QName("http://tempuri.org/", "CodigoCliente"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("dataInicial");
        elemField.setXmlName(new QName("http://tempuri.org/", "DataInicial"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("dataFinal");
        elemField.setXmlName(new QName("http://tempuri.org/", "DataFinal"));
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
