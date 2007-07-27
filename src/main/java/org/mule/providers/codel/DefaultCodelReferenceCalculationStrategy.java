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

import com.codelmark.services.codelhash.CodelHashSoapStub;


/**
 * This should only be used for testing purposes, it uses a simplistic strategy of finding the last
 * reference used and adding 1 to this.
 */
public class DefaultCodelReferenceCalculationStrategy implements CodelReferenceCalculationStrategy
{

    public String getNewReference(String lastRef)
    {
        return String.valueOf(Integer.parseInt(lastRef) + 1);
    }

    public synchronized String getReference(CodelHashSoapStub binding, String licensee) throws Exception
    {
        return getNewReference(binding.getLastRef(licensee));
    }

}
