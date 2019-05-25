package test;

import demo.calculator.Math;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class MathTest {

    private Math instance;

    @Before
    public void setUp()
    {
        instance = new Math();
    }

    @Test
    public void sum()
    {
        assertEquals(10, instance.sum(10, 0), 0.0);
    }

    @Test
    public void subst()
    {
        assertEquals(5, instance.subst(10, 5), 0.0);
    }

    @Test
    public void mult()
    {
        assertEquals(50, instance.mult(10, 5), 0.0);
    }

    @Test
    public void div()
    {
        assertEquals(2, instance.div(10, 5), 0.0);
    }

    @Test
    public void divException() throws IllegalArgumentException {
        try {
            instance.div(10, 0);
            fail("This should have thrown an exception.");
        } catch (IllegalArgumentException e) {
            assertEquals("exception test produced an unexpected message", Math.DIVISION_EXCEPTION, e.getMessage());
        }
    }
}