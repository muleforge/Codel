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

import org.mule.config.i18n.Message;
import org.mule.config.i18n.MessageFactory;

/**
 * A Factory for internationalized error messages for the Codel transport.
 */
public class CodelErrorMessageFactory extends MessageFactory
{

    private static final String BUNDLE_PATH = getBundlePath("codel");

    public static Message noLicensee()
    {
        return createMessage(BUNDLE_PATH, 1);
    }

    public static Message noLicenseePassword()
    {
        return createMessage(BUNDLE_PATH, 2);
    }

    public static Message noOriginator()
    {
        return createMessage(BUNDLE_PATH, 3);
    }

    public static Message noSuchEndpointType(String endpointType)
    {
        return createMessage(BUNDLE_PATH, 4, endpointType);
    }
}
