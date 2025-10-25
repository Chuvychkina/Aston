package org.example.lesson_7;

public class TriangleAreaCalculator {
    /**
     * Вычисляет площадь треугольника по основанию и высоте.
     * @param base длина основания (должна быть > 0)
     * @param height высота (должна быть > 0)
     * @return площадь треугольника
     * @throws IllegalArgumentException если base <= 0 или height <= 0
     */
    public static double area(double base, double height) {
        if (base <= 0 || height <= 0) {
            throw new IllegalArgumentException("Основание и высота должны быть положительными");
        }
        return (base * height) / 2.0;
    }
}

