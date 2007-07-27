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

import org.mule.providers.AbstractConnector;
import org.mule.umo.lifecycle.InitialisationException;

/**
 * <code>CodelConnector</code>
 * <p/>
 * This class provides the configuration to be used for a specific instance of the Codel transport.
 */
public class CodelConnector extends AbstractConnector
{
    private static final int DEFAULT_TIMEOUT = 60000;

    private String licensee;

    private String licenseePassword;

    private String originator;

    //This calculation strategy is for testing purposes only, a user defined one should be defined.
    private CodelReferenceCalculationStrategy refCalcStrategy = new DefaultCodelReferenceCalculationStrategy();

    private int timeout = DEFAULT_TIMEOUT;


    /**
     * The name of the licensee, this is supplied by Codel and it should always be an integer.
     *
     * @return the licensee name.
     */
    public String getLicensee()
    {
        return licensee;
    }

    /**
     * @see #getLicensee()
     */
    public void setLicensee(String licensee)
    {
        this.licensee = licensee;
    }

    /**
     * The licensee's password, this is supplied by Codel and is free-text.
     *
     * @return the licensee password.
     */
    public String getLicenseePassword()
    {
        return licenseePassword;
    }

    /**
     * @param licenseePassword
     * @see #getLicenseePassword()
     */
    public void setLicenseePassword(String licenseePassword)
    {
        this.licenseePassword = licenseePassword;
    }

    /**
     * The originator reference, this is textual and can have any value at all.
     *
     * @return
     */
    public String getOriginator()
    {
        return originator;
    }


    public void setOriginator(String originator)
    {
        this.originator = originator;
    }


    public void doInitialise() throws InitialisationException
    {
    }

    public void doConnect() throws Exception
    {
        // Optional; does not need to be implemented. Delete if not required

        /* IMPLEMENTATION NOTE: Makes a connection to the underlying
           resource. When connections are managed at the receiver/dispatcher
           level, this method may do nothing */
    }

    public void doDisconnect() throws Exception
    {
        // Optional; does not need to be implemented. Delete if not required

        /* IMPLEMENTATION NOTE: Disconnects any connections made in the
           connect method If the connect method did not do anything then this
           method shouldn't do anything either. */
    }

    public void doStart() throws org.mule.umo.UMOException
    {
        // Optional; does not need to be implemented. Delete if not required

        /* IMPLEMENTATION NOTE: If there is a single server instance or
           connection associated with the connector i.e.  AxisServer or a Jms
           Connection or Jdbc Connection, this method should put the resource
           in a started state here. */
    }

    public void doStop() throws org.mule.umo.UMOException
    {
        // Optional; does not need to be implemented. Delete if not required

        /* IMPLEMENTATION NOTE: Should put any associated resources into a
           stopped state. Mule will automatically call the stop() method. */
    }

    public void doDispose()
    {
        // Optional; does not need to be implemented. Delete if not required

        /* IMPLEMENTATION NOTE: Should clean up any open resources associated
           with the connector. */
    }

    public String getProtocol()
    {
        return "codel";
    }

    public CodelReferenceCalculationStrategy getReferenceCalculationStrategy()
    {
        return refCalcStrategy;
    }


    public void setRefCalcStrategy(CodelReferenceCalculationStrategy refCalcStrategy)
    {
        this.refCalcStrategy = refCalcStrategy;
    }

    public int getTimeout()
    {
        return timeout;
    }
}
