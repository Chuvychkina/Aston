package org.example.lesson_7.junit;

import org.example.lesson_7.TriangleAreaCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TriangleAreaCalculatorJunitTests {
    @Test
    public void testAreaWithPositiveValues() {
        Assertions.assertEquals(25.0, TriangleAreaCalculator.area(10, 5));
        assertEquals(12.5, TriangleAreaCalculator.area(5, 5));
    }

    @Test
    public void testAreaWithZeroBase() {
        assertThrows(IllegalArgumentException.class, () -> TriangleAreaCalculator.area(0, 5));
    }

    @Test
    public void testAreaWithZeroHeight() {
        assertThrows(IllegalArgumentException.class, () -> TriangleAreaCalculator.area(10, 0));
    }

    @Test
    public void testAreaWithNegativeBase() {
        assertThrows(IllegalArgumentException.class, () -> TriangleAreaCalculator.area(-10, 5));
    }

    @Test
    public void testAreaWithNegativeHeight() {
        assertThrows(IllegalArgumentException.class, () -> TriangleAreaCalculator.area(10, -5));
    }
}
