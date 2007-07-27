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

import org.mule.providers.AbstractMessageAdapter;
import org.mule.umo.MessagingException;
import org.mule.umo.provider.MessageTypeNotSupportedException;

/**
 * <code>CodelMessageAdapter</code>
 */
public class CodelMessageAdapter extends AbstractMessageAdapter
{
    private byte[] message;


    public CodelMessageAdapter(Object message) throws MessagingException
    {

        if (message instanceof byte[])
        {
            this.message = (byte[]) message;
        }
        else if (message instanceof String)
        {
            this.message = ((String) message).getBytes();
        }
        else
        {
            throw new MessageTypeNotSupportedException(message, getClass());
        }

    }

    public String getPayloadAsString(String encoding) throws Exception
    {
        return new String(message, encoding);
    }

    public byte[] getPayloadAsBytes() throws Exception
    {
        return message;
    }

    public Object getPayload()
    {
        return message;
    }

}
