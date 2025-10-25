package org.example.lesson_7.junit;



import org.example.lesson_7.ArithmeticOperations;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class ArithmeticOperationsJunitTests {

    @Test
    public void testAdd() {
        Assertions.assertEquals(15, ArithmeticOperations.add(10, 5));
        assertEquals(-5, ArithmeticOperations.add(-10, 5));
    }

    @Test
    public void testSubtract() {
        assertEquals(5, ArithmeticOperations.subtract(10, 5));
        assertEquals(-15, ArithmeticOperations.subtract(-10, 5));
    }

    @Test
    public void testMultiply() {
        assertEquals(50, ArithmeticOperations.multiply(10, 5));
        assertEquals(-50, ArithmeticOperations.multiply(-10, 5));
    }

    @Test
    public void testDivide() {
        assertEquals(2.0, ArithmeticOperations.divide(10, 5));
        assertEquals(-2.0, ArithmeticOperations.divide(-10, 5));
        assertEquals(0.5, ArithmeticOperations.divide(5, 10));
    }

    @Test
    public void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> ArithmeticOperations.divide(10, 0));
    }
}

