/**
 * CodelHashTestCase.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.codelmark.services.codelhash;

import org.mule.transformers.simple.ByteArrayToHexString;
import org.mule.umo.transformer.TransformerException;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CodelHashTestCase extends junit.framework.TestCase
{
    private static final int LICENSEE_NUMBER = 153786905;
    private static final String LICENSEE_STRING = String.valueOf(LICENSEE_NUMBER);

    private static final String LICENSEE_PASSWORD = "bhill-5760";

    public CodelHashTestCase(java.lang.String name)
    {
        super(name);
    }
//
//    public void testCodelHashSoapWSDL() throws Exception {
//        javax.xml.rpc.ServiceFactory serviceFactory = javax.xml.rpc.ServiceFactory.newInstance();
//        java.net.URL url = new java.net.URL(new com.codelmark.services.codelhash.CodelHashLocator().getCodelHashSoapAddress() + "?WSDL");
//        javax.xml.rpc.Service service = serviceFactory.createService(url, new com.codelmark.services.codelhash.CodelHashLocator().getServiceName());
//        assertTrue(service != null);
//    }

    public void test1CodelHashSoapAddHash() throws Exception
    {
        com.codelmark.services.codelhash.CodelHashSoapStub binding;
        try
        {
            binding = (com.codelmark.services.codelhash.CodelHashSoapStub)
                    new com.codelmark.services.codelhash.CodelHashLocator().getCodelHashSoap();
        }
        catch (javax.xml.rpc.ServiceException jre)
        {
            if (jre.getLinkedCause() != null)
            {
                jre.getLinkedCause().printStackTrace();
            }
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value;
        byte[] fileData = new byte[1000];
        int fileLength = getClass().getResourceAsStream("/testfile.txt").read(fileData);
        byte[] trimmedData = new byte[fileLength];
        getClass().getResourceAsStream("/testfile.txt").read(trimmedData);
        value = binding.addHash(calculateHash(trimmedData), "1000", "MuleTestCase", LICENSEE_STRING, LICENSEE_PASSWORD);
        System.err.println("value=" + value);
        // TBD - validate results
    }

    public void test2CodelHashSoapCompareCodelMark() throws Exception
    {
        com.codelmark.services.codelhash.CodelHashSoapStub binding;
        try
        {
            binding = (com.codelmark.services.codelhash.CodelHashSoapStub)
                    new com.codelmark.services.codelhash.CodelHashLocator().getCodelHashSoap();
        }
        catch (javax.xml.rpc.ServiceException jre)
        {
            if (jre.getLinkedCause() != null)
            {
                jre.getLinkedCause().printStackTrace();
            }
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.compareCodelMark("XXXX");
        System.err.println("value=" + value);
        // TBD - validate results
    }

    public void test3CodelHashSoapGetRef() throws Exception
    {
        com.codelmark.services.codelhash.CodelHashSoapStub binding;
        try
        {
            binding = (com.codelmark.services.codelhash.CodelHashSoapStub)
                    new com.codelmark.services.codelhash.CodelHashLocator().getCodelHashSoap();
        }
        catch (javax.xml.rpc.ServiceException jre)
        {
            if (jre.getLinkedCause() != null)
            {
                jre.getLinkedCause().printStackTrace();
            }
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.getRef(new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test4CodelHashSoapGetLastRef() throws Exception
    {
        com.codelmark.services.codelhash.CodelHashSoapStub binding;
        try
        {
            binding = (com.codelmark.services.codelhash.CodelHashSoapStub)
                    new com.codelmark.services.codelhash.CodelHashLocator().getCodelHashSoap();
        }
        catch (javax.xml.rpc.ServiceException jre)
        {
            if (jre.getLinkedCause() != null)
            {
                jre.getLinkedCause().printStackTrace();
            }
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.getLastRef(LICENSEE_STRING);
        // TBD - validate results
    }

    public void test5CodelHashSoapAuthenticate() throws Exception
    {
        com.codelmark.services.codelhash.CodelHashSoapStub binding;
        try
        {
            binding = (com.codelmark.services.codelhash.CodelHashSoapStub)
                    new com.codelmark.services.codelhash.CodelHashLocator().getCodelHashSoap();
        }
        catch (javax.xml.rpc.ServiceException jre)
        {
            if (jre.getLinkedCause() != null)
            {
                jre.getLinkedCause().printStackTrace();
            }
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.authenticate(new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test6CodelHashSoapGetLicName() throws Exception
    {
        com.codelmark.services.codelhash.CodelHashSoapStub binding;
        try
        {
            binding = (com.codelmark.services.codelhash.CodelHashSoapStub)
                    new com.codelmark.services.codelhash.CodelHashLocator().getCodelHashSoap();
        }
        catch (javax.xml.rpc.ServiceException jre)
        {
            if (jre.getLinkedCause() != null)
            {
                jre.getLinkedCause().printStackTrace();
            }
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.getLicName(LICENSEE_STRING, LICENSEE_PASSWORD);
        // TBD - validate results
    }

    public void test7CodelHashSoapGetLicExpiry() throws Exception
    {
        com.codelmark.services.codelhash.CodelHashSoapStub binding;
        try
        {
            binding = (com.codelmark.services.codelhash.CodelHashSoapStub)
                    new com.codelmark.services.codelhash.CodelHashLocator().getCodelHashSoap();
        }
        catch (javax.xml.rpc.ServiceException jre)
        {
            if (jre.getLinkedCause() != null)
            {
                jre.getLinkedCause().printStackTrace();
            }
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.getLicExpiry(LICENSEE_NUMBER);
        // TBD - validate results
    }

    public void test8CodelHashSoapLicenseeStatus() throws Exception
    {
        com.codelmark.services.codelhash.CodelHashSoapStub binding;
        try
        {
            binding = (com.codelmark.services.codelhash.CodelHashSoapStub)
                    new com.codelmark.services.codelhash.CodelHashLocator().getCodelHashSoap();
        }
        catch (javax.xml.rpc.ServiceException jre)
        {
            if (jre.getLinkedCause() != null)
            {
                jre.getLinkedCause().printStackTrace();
            }
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        int value = -3;
        value = binding.licenseeStatus(LICENSEE_NUMBER);
        // TBD - validate results
    }

    public void test9CodelHashSoapGetServerDateTime() throws Exception
    {
        com.codelmark.services.codelhash.CodelHashSoapStub binding;
        try
        {
            binding = (com.codelmark.services.codelhash.CodelHashSoapStub)
                    new com.codelmark.services.codelhash.CodelHashLocator().getCodelHashSoap();
        }
        catch (javax.xml.rpc.ServiceException jre)
        {
            if (jre.getLinkedCause() != null)
            {
                jre.getLinkedCause().printStackTrace();
            }
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.getServerDateTime();
        // TBD - validate results
    }

    public void test10CodelHashSoapLicenseeHashInfo() throws Exception
    {
        com.codelmark.services.codelhash.CodelHashSoapStub binding;
        try
        {
            binding = (com.codelmark.services.codelhash.CodelHashSoapStub)
                    new com.codelmark.services.codelhash.CodelHashLocator().getCodelHashSoap();
        }
        catch (javax.xml.rpc.ServiceException jre)
        {
            if (jre.getLinkedCause() != null)
            {
                jre.getLinkedCause().printStackTrace();
            }
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.licenseeHashInfo(LICENSEE_NUMBER, new java.lang.String());
        // TBD - validate results
    }

    private final ByteArrayToHexString byteArrayToHexString = new ByteArrayToHexString();

    public String calculateHash(byte[] data) throws NoSuchAlgorithmException, TransformerException
    {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        return (String) byteArrayToHexString.transform(md.digest(data));
    }

}
