/**
 * ExecutarComandoResponseExecutarComandoResult.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

import java.io.Serializable;
import java.lang.reflect.Array;

import javax.xml.namespace.QName;

import org.apache.axis.description.TypeDesc;
import org.apache.axis.encoding.AnyContentType;
import org.apache.axis.encoding.Deserializer;
import org.apache.axis.encoding.MixedContentType;
import org.apache.axis.encoding.Serializer;
import org.apache.axis.encoding.ser.BeanDeserializer;
import org.apache.axis.encoding.ser.BeanSerializer;
import org.apache.axis.message.MessageElement;

@SuppressWarnings("serial")
public class ExecutarComandoResponseExecutarComandoResult  implements Serializable, AnyContentType, MixedContentType {
    private MessageElement [] _any;

    public ExecutarComandoResponseExecutarComandoResult() {
    }

    public ExecutarComandoResponseExecutarComandoResult(
           MessageElement [] _any) {
           this._any = _any;
    }


    /**
     * Gets the _any value for this ExecutarComandoResponseExecutarComandoResult.
     * 
     * @return _any
     */
    public MessageElement [] get_any() {
        return _any;
    }


    /**
     * Sets the _any value for this ExecutarComandoResponseExecutarComandoResult.
     * 
     * @param _any
     */
    public void set_any(MessageElement [] _any) {
        this._any = _any;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
    	if (obj == null) {
    		return false;
    	}
    	
        if (!(obj instanceof ExecutarComandoResponseExecutarComandoResult)) {
        	return false;
        }
        
        ExecutarComandoResponseExecutarComandoResult other = (ExecutarComandoResponseExecutarComandoResult) obj;
        
        if (this == obj) {
        	return true;
        }
        
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        
        __equalsCalc = obj;
        
        boolean _equals;
        
        _equals = true && 
            ((this._any==null && other.get_any()==null) || 
             (this._any!=null &&
              java.util.Arrays.equals(this._any, other.get_any())));
        
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
        
        if (get_any() != null) {
            for (int i=0; i < Array.getLength(get_any()); i++) {
                Object obj = Array.get(get_any(), i);
                if (obj != null && !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        
        __hashCodeCalc = false;
        
        return _hashCode;
    }

    // Type metadata
    private static TypeDesc typeDesc =
        new TypeDesc(ExecutarComandoResponseExecutarComandoResult.class, true);

    static {
        typeDesc.setXmlType(new QName("http://tempuri.org/", ">>executarComandoResponse>executarComandoResult"));
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
