package day1_test.test;

import day1_test.junit.Calculator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

    @Before
    public void init() {
        System.out.println("init...");
    }

    @After
    public void close() {
        System.out.println("close...");
    }

    @Test
    public void testAdd() {
        Calculator c = new Calculator();
        System.out.println("testAdd...");
        int result = c.add(1, 2);
        Assert.assertEquals(3, result);
    }

    @Test
    public void testSub() {
        Calculator c = new Calculator();
        System.out.println("testSub...");
        int result = c.sub(1, 2);
        Assert.assertEquals(-1, result);
    }
}
