package com.medicineCenter.util.codeGenerator;

import junit.framework.TestCase;

import java.util.Properties;

public class SSMGeneratorTest extends TestCase {
    SSMGenerator ssm = new SSMGenerator();
    Properties properties = new Properties();


    public void testInit() throws Exception {
        properties.setProperty("projectName", "medicineCenter");
        properties.setProperty("simpleClassName", "User");
        ssm.init(properties);
    }

    public void testSetIdType() throws Exception {
        testInit();
        ssm.setIdType();
    }

    public void testGenerateAll() throws Exception {
        testInit();
        ssm.generateAll();
    }


}