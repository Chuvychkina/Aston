package org.example.lesson_7.junit;



import org.example.lesson_7.FactorialCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;


public class FactorialCalculatorJunitTests {

    @Test
    public void testFactorialOfZero() {
        Assertions.assertEquals(1, FactorialCalculator.factorial(0));
    }

    @Test
    public void testFactorialOfOne() {
        Assertions.assertEquals(1, FactorialCalculator.factorial(1));
    }

    @Test
    public void testFactorialOfPositiveNumber() {
        Assertions.assertEquals(120, FactorialCalculator.factorial(5));
        Assertions.assertEquals(720, FactorialCalculator.factorial(6));
    }

    @Test
    public void testFactorialOfLargeNumber() {
        Assertions.assertEquals(2432902008176640000L, FactorialCalculator.factorial(20)); // Максимум для long
    }

    @Test
    public void testFactorialOfNegativeNumber() {
        assertThrows(IllegalArgumentException.class, () -> FactorialCalculator.factorial(-1));
    }
}


