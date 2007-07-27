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
 * A CodelReferenceCalculationStrategy provides a means of obtaining the next valid
 * codel reference number to be sent with a new CodelMark.
 */
public interface CodelReferenceCalculationStrategy
{

    String getReference(CodelHashSoapStub binding, String licensee) throws Exception;
}
