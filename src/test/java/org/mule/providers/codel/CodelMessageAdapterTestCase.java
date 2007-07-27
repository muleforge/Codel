/*
 * $Id: MuleException.java 4350 2006-12-20 16:34:49Z neil $
 * --------------------------------------------------------------------------------------
 * Copyright (c) MuleSource, Inc.  All rights reserved.  http://www.mulesource.com
 * The software in this package is published under the terms of the MuleSource MPL
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 *
 */


package org.mule.providers.codel;

import org.mule.tck.providers.AbstractMessageAdapterTestCase;
import org.mule.umo.MessagingException;
import org.mule.umo.provider.UMOMessageAdapter;

public class CodelMessageAdapterTestCase extends AbstractMessageAdapterTestCase
{

    /* For general guidelines on writing transports see
       http://mule.mulesource.org/display/MULE/Writing+Transports */

    public Object getValidMessage() throws Exception
    {
        return "hello".getBytes();
    }

    public UMOMessageAdapter createAdapter(Object payload) throws MessagingException
    {
        return new CodelMessageAdapter(payload);
    }

}
