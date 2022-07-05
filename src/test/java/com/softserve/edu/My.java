package com.softserve.edu;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class My {
    public static final Logger logger = LoggerFactory.getLogger(My.class);
    private String testName;
    private boolean isOk;

    @After
    public void tearDown() throws Exception {
        //System.out.println("\t@After tearDown()");
        logger.info(testName + " DONE");
        if (!isOk) {
            logger.info("\t***" + testName + " FAILED ***");
        }
    }

    @Test
    public void testMy() {
        isOk = false;
        testName = "My testMy()";
        logger.info(testName + " START");
        //
        // From Maven
        System.out.println("My testMy1()");
        //
        Assert.assertEquals(9, 4 + 5);
        isOk = true;
    }

    @Test
    public void testMy2() {
        isOk = false;
        testName = "My testMy2()";
        logger.info(testName + " START");
        //
        System.out.println("My testMy2()");
        //
        int i = 0;
        i = 10 / i;
        System.out.println(" i = " + i);
        isOk = true;
    }

    @Test
    public void testMy3() {
        isOk = false;
        testName = "My testMy3()";
        logger.info(testName + " START");
        //
        System.out.println("My testMy3()");
        //
        double i = 0;
        i = 10 / i;
        System.out.println(" i = " + i);
        isOk = true;
    }

    @Test
    public void testMy4() {
        isOk = false;
        testName = "My testMy4()";
        logger.info(testName + " START");
        //
        System.out.println("My testMy3()");
        //
        if (!isOk) {
            throw new RuntimeException("ha-ha-ha");
        }
        isOk = true;
    }

    @Test(expected = ArithmeticException.class)//(expectedExceptions = ArithmeticException.class)
    public void divisionWithException() {
        isOk = false;
        testName = "My divisionWithException()";
        logger.info(testName + " START");
        //
//        if (!isOk) {
//            throw new RuntimeException("ha-ha-ha");
//        }
        //
        System.out.println("\t\t\t@Test divisionWithException()");
        isOk = true;
        int i = 1 / 0;
    }

}
