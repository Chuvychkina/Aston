package org.example.lesson_7;

public class FactorialCalculator {
    /**
     * Вычисляет факториал числа n (n!).
     * @param n неотрицательное целое число
     * @return факториал n
     * @throws IllegalArgumentException если n < 0
     */
    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Факториал не определён для отрицательных чисел");
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
