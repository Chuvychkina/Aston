package org.example.lesson_7;

public class ArithmeticOperations {
    /**
     * Сложение двух целых чисел.
     * @param a первое число
     * @param b второе число
     * @return сумма a + b
     */
    public static int add(int a, int b) {
        return a + b;
    }

    /**
     * Вычитание двух целых чисел (a - b).
     * @param a первое число
     * @param b второе число
     * @return разность a - b
     */
    public static int subtract(int a, int b) {
        return a - b;
    }

    /**
     * Умножение двух целых чисел.
     * @param a первое число
     * @param b второе число
     * @return произведение a * b
     */
    public static int multiply(int a, int b) {
        return a * b;
    }

    /**
     * Деление двух целых чисел (a / b), возвращает double.
     * @param a первое число (делимое)
     * @param b второе число (делитель)
     * @return частное a / b
     * @throws ArithmeticException если b == 0
     */
    public static double divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Деление на ноль невозможно");
        }
        return (double) a / b;
    }
}


