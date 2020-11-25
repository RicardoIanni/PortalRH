/**
 * EASWebServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.Remote;
import java.util.HashSet;
import java.util.Iterator;

import javax.xml.namespace.QName;
import javax.xml.rpc.ServiceException;

import org.apache.axis.EngineConfiguration;
import org.apache.axis.client.Service;
import org.apache.axis.client.Stub;

@SuppressWarnings("serial")
public class EASWebServiceLocator extends Service implements EASWebService {

    public EASWebServiceLocator() {
    	
    }

    public EASWebServiceLocator(EngineConfiguration config) {
    	super(config);
    }

    public EASWebServiceLocator(String wsdlLoc, QName sName) throws ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for EASWebServiceSoap
    private String EASWebServiceSoap_address = "http://desenv.pdcore.com.br/NewAgeWebServiceSetup/EASWebService.asmx";

    public String getEASWebServiceSoapAddress() {
        return EASWebServiceSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private String EASWebServiceSoapWSDDServiceName = "EASWebServiceSoap";

    public String getEASWebServiceSoapWSDDServiceName() {
        return EASWebServiceSoapWSDDServiceName;
    }

    public void setEASWebServiceSoapWSDDServiceName(String name) {
        EASWebServiceSoapWSDDServiceName = name;
    }

    public EASWebServiceSoap getEASWebServiceSoap() throws ServiceException {
    	URL endpoint;
        
    	try {
            endpoint = new URL(EASWebServiceSoap_address);
        } catch (MalformedURLException e) {
            throw new ServiceException(e);
        }
    	
        return getEASWebServiceSoap(endpoint);
    }

    public EASWebServiceSoap getEASWebServiceSoap(URL portAddress) throws ServiceException {
        try {
            EASWebServiceSoapStub _stub = new EASWebServiceSoapStub(portAddress, this);
            _stub.setPortName(getEASWebServiceSoapWSDDServiceName());
            return _stub;
        } catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setEASWebServiceSoapEndpointAddress(String address) {
        EASWebServiceSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    @SuppressWarnings("rawtypes")
	public Remote getPort(Class serviceEndpointInterface) throws ServiceException {
        try {
            if (EASWebServiceSoap.class.isAssignableFrom(serviceEndpointInterface)) {
            	EASWebServiceSoapStub _stub = new EASWebServiceSoapStub(new URL(EASWebServiceSoap_address), this);
                _stub.setPortName(getEASWebServiceSoapWSDDServiceName());
                return _stub;
            }
        } catch (java.lang.Throwable t) {
            throw new ServiceException(t);
        }
        
        throw new ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    @SuppressWarnings("rawtypes")
	public Remote getPort(QName portName, Class serviceEndpointInterface) throws ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        
        String inputPortName = portName.getLocalPart();
        
        if ("EASWebServiceSoap".equals(inputPortName)) {
            return getEASWebServiceSoap();
        } else  {
            Remote _stub = getPort(serviceEndpointInterface);
            ((Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public QName getServiceName() {
        return new QName("http://tempuri.org/", "EASWebService");
    }

    private HashSet<Object> ports = null;

    public Iterator<Object> getPorts() {
        if (ports == null) {
            ports = new HashSet<>();
            ports.add(new QName("http://tempuri.org/", "EASWebServiceSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(String portName, String address) throws ServiceException {
    	if ("EASWebServiceSoap".equals(portName)) {
            setEASWebServiceSoapEndpointAddress(address);
        } else { // Unknown Port Name
            throw new ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(QName portName, String address) throws ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}