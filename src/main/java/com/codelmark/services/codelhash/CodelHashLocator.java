/*
 * $Id: $
 * --------------------------------------------------------------------------------------
 * Copyright (c) MuleSource, Inc.  All rights reserved.  http://www.mulesource.com
 * The software in this package is published under the terms of the MuleSource MPL
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 *
 */

/**
 * CodelHashLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.codelmark.services.codelhash;

public class CodelHashLocator extends org.apache.axis.client.Service implements com.codelmark.services.codelhash.CodelHash
{

    public CodelHashLocator()
    {
    }


    public CodelHashLocator(org.apache.axis.EngineConfiguration config)
    {
        super(config);
    }

    public CodelHashLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException
    {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for CodelHashSoap
    private java.lang.String CodelHashSoap_address = "https://services.codelmark.com/WebService/CodelHash.asmx";

    public java.lang.String getCodelHashSoapAddress()
    {
        return CodelHashSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String CodelHashSoapWSDDServiceName = "CodelHashSoap";

    public java.lang.String getCodelHashSoapWSDDServiceName()
    {
        return CodelHashSoapWSDDServiceName;
    }

    public void setCodelHashSoapWSDDServiceName(java.lang.String name)
    {
        CodelHashSoapWSDDServiceName = name;
    }

    public com.codelmark.services.codelhash.CodelHashSoap getCodelHashSoap() throws javax.xml.rpc.ServiceException
    {
        java.net.URL endpoint;
        try
        {
            endpoint = new java.net.URL(CodelHashSoap_address);
        }
        catch (java.net.MalformedURLException e)
        {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getCodelHashSoap(endpoint);
    }

    public com.codelmark.services.codelhash.CodelHashSoap getCodelHashSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException
    {
        try
        {
            com.codelmark.services.codelhash.CodelHashSoapStub _stub = new com.codelmark.services.codelhash.CodelHashSoapStub(portAddress, this);
            _stub.setPortName(getCodelHashSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e)
        {
            return null;
        }
    }

    public void setCodelHashSoapEndpointAddress(java.lang.String address)
    {
        CodelHashSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException
    {
        try
        {
            if (com.codelmark.services.codelhash.CodelHashSoap.class.isAssignableFrom(serviceEndpointInterface))
            {
                com.codelmark.services.codelhash.CodelHashSoapStub _stub = new com.codelmark.services.codelhash.CodelHashSoapStub(new java.net.URL(CodelHashSoap_address), this);
                _stub.setPortName(getCodelHashSoapWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t)
        {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException
    {
        if (portName == null)
        {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("CodelHashSoap".equals(inputPortName))
        {
            return getCodelHashSoap();
        }
        else
        {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName()
    {
        return new javax.xml.namespace.QName("https://services.codelmark.com/codelhash", "CodelHash");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts()
    {
        if (ports == null)
        {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("https://services.codelmark.com/codelhash", "CodelHashSoap"));
        }
        return ports.iterator();
    }

    /**
     * Set the endpoint address for the specified port name.
     */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException
    {

        if ("CodelHashSoap".equals(portName))
        {
            setCodelHashSoapEndpointAddress(address);
        }
        else
        { // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
     * Set the endpoint address for the specified port name.
     */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException
    {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
