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

import org.mule.tck.providers.AbstractConnectorTestCase;
import org.mule.umo.provider.UMOConnector;

public class CodelConnectorTestCase extends AbstractConnectorTestCase
{

    /* For general guidelines on writing transports see
       http://mule.mulesource.org/display/MULE/Writing+Transports */

    public UMOConnector getConnector() throws Exception
    {

        /* IMPLEMENTATION NOTE: Create and initialise an instance of your
connector here. Do not actually call the connect method. */

        CodelConnector c = new CodelConnector();
        c.setName("Test-Codel");
        c.initialise();
        c.setEnableMessageEvents(false);
        return c;
    }

    public String getTestEndpointURI()
    {
        return "codel://add";
    }

    public Object getValidMessage() throws Exception
    {
        return "Hello".getBytes();
    }


    public void testProperties() throws Exception
    {
        // TODO test setting and retrieving any custom properties on the
        // Connector as necessary
    }

    public void testConnectorListenerSupport() throws Exception
    {

    }
}
