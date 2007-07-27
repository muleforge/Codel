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
 * CodelHashSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.codelmark.services.codelhash;

public interface CodelHashSoap extends java.rmi.Remote
{

    /**
     * Add a single hash to Codel
     */
    public java.lang.String addHash(java.lang.String psHash, java.lang.String piRef, java.lang.String psOriginator, java.lang.String piLicensee, java.lang.String psPassword) throws java.rmi.RemoteException;

    /**
     * Determine whether a hash has been registered with Codel
     */
    public java.lang.String compareCodelMark(java.lang.String hash) throws java.rmi.RemoteException;

    /**
     * Determine whether a hash has been registered with Codel
     */
    public java.lang.String getRef(java.lang.String psCode, java.lang.String piLicensee) throws java.rmi.RemoteException;

    /**
     * Return the last ref number
     */
    public java.lang.String getLastRef(java.lang.String piLicensee) throws java.rmi.RemoteException;

    /**
     * Authenticate a Licensee
     */
    public java.lang.String authenticate(java.lang.String piLicNo, java.lang.String psPassword) throws java.rmi.RemoteException;

    /**
     * Get the Licensee's name
     */
    public java.lang.String getLicName(java.lang.String piLicNo, java.lang.String psPassword) throws java.rmi.RemoteException;

    /**
     * Get the expiry date of the current licensee
     */
    public java.lang.String getLicExpiry(int piLicNo) throws java.rmi.RemoteException;

    /**
     * Status of the current Licensee
     */
    public int licenseeStatus(int piLicNo) throws java.rmi.RemoteException;

    /**
     * Current date and time from server
     */
    public java.lang.String getServerDateTime() throws java.rmi.RemoteException;

    /**
     * Supply a list of all the hashes submitted by the current licensee.
     */
    public java.lang.String licenseeHashInfo(int piLicNo, java.lang.String psPassword) throws java.rmi.RemoteException;
}
