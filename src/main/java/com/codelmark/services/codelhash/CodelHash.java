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
 * CodelHash.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.codelmark.services.codelhash;

public interface CodelHash extends javax.xml.rpc.Service
{
    public java.lang.String getCodelHashSoapAddress();

    public com.codelmark.services.codelhash.CodelHashSoap getCodelHashSoap() throws javax.xml.rpc.ServiceException;

    public com.codelmark.services.codelhash.CodelHashSoap getCodelHashSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
