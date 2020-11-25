/**
 * EASWebService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

import java.net.URL;

import javax.xml.rpc.Service;
import javax.xml.rpc.ServiceException;

public interface EASWebService extends Service {
    public String getEASWebServiceSoapAddress();

    public EASWebServiceSoap getEASWebServiceSoap() throws ServiceException;

    public EASWebServiceSoap getEASWebServiceSoap(URL portAddress) throws ServiceException;
}
