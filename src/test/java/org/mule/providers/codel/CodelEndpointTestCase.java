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

import org.mule.impl.endpoint.MuleEndpointURI;
import org.mule.tck.AbstractMuleTestCase;
import org.mule.umo.endpoint.UMOEndpointURI;


public class CodelEndpointTestCase extends AbstractMuleTestCase
{

    /* For general guidelines on writing transports see
       http://mule.mulesource.org/display/MULE/Writing+Transports */

    public void testValidEndpointURI() throws Exception
    {

        UMOEndpointURI url = new MuleEndpointURI("codel://add");
        assertEquals("codel", url.getScheme());
        assertEquals("codel://add", url.getAddress());
        assertEquals("add", url.getHost());


    }

}
