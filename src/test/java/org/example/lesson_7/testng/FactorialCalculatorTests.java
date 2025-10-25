package org.example.lesson_7.testng;



import org.example.lesson_7.FactorialCalculator;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;

public class FactorialCalculatorTests {

    @Test
    public void testFactorialOfZero() {
        assertEquals(FactorialCalculator.factorial(0), 1);
    }

    @Test
    public void testFactorialOfOne() {
        assertEquals(FactorialCalculator.factorial(1), 1);
    }

    @Test
    public void testFactorialOfPositiveNumber() {
        assertEquals(FactorialCalculator.factorial(5), 120);
        assertEquals(FactorialCalculator.factorial(6), 720);
    }

    @Test
    public void testFactorialOfLargeNumber() {
        assertEquals(FactorialCalculator.factorial(20), 2432902008176640000L); // Максимум для long
    }

    @Test
    public void testFactorialOfNegativeNumber() {
        assertThrows(IllegalArgumentException.class, () -> FactorialCalculator.factorial(-1));
    }
}


