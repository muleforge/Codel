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

import junit.framework.TestCase;
import org.apache.commons.io.IOUtils;
import org.mule.config.builders.MuleXmlConfigurationBuilder;
import org.mule.umo.manager.UMOManager;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author <a href="mailto:neilellis@mac.com">neilellis@mac.com</a>
 */
public class CodelConnectorFunctionalTest extends TestCase
{

    public void test() throws Exception
    {
        MuleXmlConfigurationBuilder builder = new MuleXmlConfigurationBuilder();
        InputStream in = getClass().getResourceAsStream("/testfile.txt");
        File dir = new File(new File(System.getProperty("user.home")), "codeltestdir123");
        dir.mkdirs();
        OutputStream out = new FileOutputStream(new File(dir, "testfile.txt"));
        IOUtils.copy(in, out);
        out.close();
        UMOManager manager = builder.configure("mule-config.xml");
        int count = 0;
        while (count < 60 && CompareResultTestService.passed == null)
        {
            count++;
            Thread.sleep(1000);

        }
        assertNotNull("No result found, timed out.", CompareResultTestService.passed);
        assertFalse("Codel mark did not compare successfully.", CompareResultTestService.passed == Boolean.FALSE);
    }
}
