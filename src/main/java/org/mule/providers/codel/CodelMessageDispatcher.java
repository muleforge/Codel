/*
 * $Id: $
 * --------------------------------------------------------------------------------------
 * Copyright (c) MuleSource, Inc.  All rights reserved.  http://www.mulesource.com
 * The software in this package is published under the terms of the MuleSource MPL
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 *
 */

package org.mule.providers.codel;

import com.codelmark.services.codelhash.CodelHashLocator;
import com.codelmark.services.codelhash.CodelHashSoapStub;
import org.mule.MuleException;
import org.mule.config.ConfigurationException;
import org.mule.impl.MuleMessage;
import org.mule.providers.AbstractMessageDispatcher;
import org.mule.transformers.simple.ByteArrayToHexString;
import org.mule.umo.UMOEvent;
import org.mule.umo.UMOMessage;
import org.mule.umo.endpoint.UMOImmutableEndpoint;
import org.mule.umo.transformer.TransformerException;

import javax.xml.rpc.ServiceException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * <code>CodelMessageDispatcher</code>
 * <p/>
 * The codel message dispatcher provides the means to communicate with the Codel server
 * to either add a new CodelMark or compare against an existing CodelMark.
 */
public class CodelMessageDispatcher extends AbstractMessageDispatcher
{

    private final ByteArrayToHexString byteArrayToHexString = new ByteArrayToHexString();

    private CodelHashSoapStub binding;
    private CodelConnector codelConnector;
    private OperationType operationType;
    private String originator;
    private String licensee;
    private String licenseePassword;

    public CodelMessageDispatcher(UMOImmutableEndpoint endpoint) throws ConfigurationException
    {

        super(endpoint);

        codelConnector = (CodelConnector) endpoint.getConnector();
        String endpointType = getEndpoint().getEndpointURI().getHost();
        if (endpointType.equals("add"))
        {
            operationType = OperationType.ADD;
        }
        else
        {
            if (endpointType.equals("compare"))
            {
                operationType = OperationType.COMPARE;
            }
            else
            {
                throw new ConfigurationException(CodelErrorMessageFactory.noSuchEndpointType(endpointType));
            }
        }

        //Configure the core parameters used in communication with Codel.
        originator = (String) getEndpoint().getProperties().get("originator");
        if (originator == null)
        {
            originator = codelConnector.getOriginator();
        }
        if (originator == null)
        {
            throw new ConfigurationException(CodelErrorMessageFactory.noOriginator());
        }

        licensee = (String) getEndpoint().getProperties().get("licensee");
        if (licensee == null)
        {
            licensee = codelConnector.getLicensee();
        }
        if (licensee == null)
        {
            throw new ConfigurationException(CodelErrorMessageFactory.noLicensee());
        }

        licenseePassword = (String) getEndpoint().getProperties().get("licenseePassword");
        if (licenseePassword == null)
        {
            licenseePassword = codelConnector.getLicenseePassword();
        }
        if (licenseePassword == null)
        {
            throw new ConfigurationException(CodelErrorMessageFactory.noLicenseePassword());
        }

    }

    public void doConnect() throws Exception
    {
        try
        {
            this.binding = (CodelHashSoapStub)
                    new CodelHashLocator().getCodelHashSoap();
        }
        catch (ServiceException jre)
        {
            if (jre.getLinkedCause() != null)
            {
                jre.getLinkedCause().printStackTrace();
            }
            throw new MuleException(jre);
        }
        binding.setTimeout(((CodelConnector) connector).getTimeout());

    }

    public void doDisconnect() throws Exception
    {

    }

    public void doDispatch(UMOEvent event) throws Exception
    {
        //Synchronous only.
        throw new UnsupportedOperationException("doDispatch");
    }

    public UMOMessage doSend(UMOEvent event) throws Exception
    {
        if (binding == null)
        {
            throw new IllegalStateException("Binding should have been set by now.");
        }

        String result = null;

        //Obtaining the numerical reference number to give this mark using a strategy associated with
        //the connector.
        String ref = codelConnector.getReferenceCalculationStrategy().getReference(binding, licensee);

        //calculate the Codel Mark hash using SHA-256 base64 encoded (same as the codel client).
        final String hash = calculateHash(event.getMessageAsBytes());

        //add or compare depending on the endpoint's type.
        if (operationType == OperationType.ADD)
        {
            result = binding.addHash(hash, ref
                    , originator
                    , licensee
                    , licenseePassword);
        }
        else if (operationType == OperationType.COMPARE)
        {
            result = binding.compareCodelMark(hash);
        }
        else
        {
            throw new IllegalStateException("This should have been checked in the constructor.");
        }

        if (result == null)
        {
            return new MuleMessage(Boolean.FALSE);
        }
//        else if (result.equals(hash))
//        {
//            return new MuleMessage(Boolean.TRUE);
//        }
        else
        {
            return new MuleMessage(Boolean.TRUE);
            //            throw new MuleException("Result does not equal hash (result listed first then hash):\n"+result+"\n"+hash);
        }

    }


    public UMOMessage doReceive(long timeout) throws Exception
    {
        throw new UnsupportedOperationException("receive");
    }

    public void doDispose()
    {

    }

    public String calculateHash(byte[] data) throws NoSuchAlgorithmException, TransformerException
    {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        return (String) byteArrayToHexString.transform(md.digest(data));
    }

}

