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


/**
 * An enumeration of possible Codel operations.
 */
public class OperationType
{
    /**
     * The operation to add a new CodelMark.
     */
    public static OperationType ADD = new OperationType("add");

    /**
     * The operation to compare a CodelMark against the users stored CodelMarks.
     */
    public static final OperationType COMPARE = new OperationType("compare");

    private String type;

    public OperationType(String type)
    {

        this.type = type;
    }

    /**
     * {@inheritDoc}
     */
    public String toString()
    {
        return type;
    }
}
