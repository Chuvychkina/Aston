package org.example.lesson_7.testng;

import org.example.lesson_7.ArithmeticOperations;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;


public class ArithmeticOperationsTests {

    @Test
    public void testAdd() {
        assertEquals(ArithmeticOperations.add(10, 5), 15);
        assertEquals(ArithmeticOperations.add(-10, 5), -5);
    }

    @Test
    public void testSubtract() {
        assertEquals(ArithmeticOperations.subtract(10, 5), 5);
        assertEquals(ArithmeticOperations.subtract(-10, 5), -15);
    }

    @Test
    public void testMultiply() {
        assertEquals(ArithmeticOperations.multiply(10, 5), 50);
        assertEquals(ArithmeticOperations.multiply(-10, 5), -50);
    }

    @Test
    public void testDivide() {
        assertEquals(ArithmeticOperations.divide(10, 5), 2.0);
        assertEquals(ArithmeticOperations.divide(-10, 5), -2.0);
        assertEquals(ArithmeticOperations.divide(5, 10), 0.5);
    }

    @Test
    public void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> ArithmeticOperations.divide(10, 0));
    }
}

