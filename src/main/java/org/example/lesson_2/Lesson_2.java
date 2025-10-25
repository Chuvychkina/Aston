package org.example.lesson_2;

import java.util.Arrays;

public class Lesson_2 {
    public static void main(String[] args) {
        int[] array = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        int[] arrayLessThanSix = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        printThreeWords("Orange", "Banana", "Apple");
        checkSumSign(5, -3);
        printColor(1);
        compareNumbers(6, 53);
        System.out.println(isSumInRange(8, 10));
        System.out.println(isNegative(-9));
        checkNumberSign(-3);
        printStringMultipleTimes("Hi", 5);
        System.out.println(isLeapYear(2000));
        invertArray(array);
        createAndPrintSequence(100, 1);
        multiplyNumbersLessThanThreshold(arrayLessThanSix, 6);
        createAndPrintIdentityMatrix(5);
        System.out.println(Arrays.toString(createArray(2, 3)));
    }

    public static int[] createArray(int len, int initialValue) {
        int[] result = new int[len];
        Arrays.fill(result, initialValue);
        return result;
    }

    public static void checkSumSign(int a, int b) {

        int sum = a + b;

        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    public static boolean isLeapYear(int year) {
        // Год високосный, если делится на 4
        if (year % 4 == 0) {
            // Но если год делится на 100, он не високосный
            if (year % 100 == 0) {
                // Однако если год делится на 400, он всё равно високосный
                return year % 400 == 0;
            }
            return true;
        }
        return false;
    }

    public static boolean isNegative(int number) {
        return number < 0;
    }

    public static boolean isSumInRange(int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }

    public static void compareNumbers(int a, int b) {

        // Проверяем условие и выводим результат
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    public static void checkNumberSign(int number) {
        if (number >= 0) {
            System.out.println("Число положительное");
        } else {
            System.out.println("Число отрицательное");
        }
    }

    public static void printColor(int value) {


        if (value <= 0) {
            System.out.println("Красный");
        } else if (value <= 100) {
            System.out.println("Жёлтый");
        } else {
            System.out.println("Зелёный");
        }
    }

    public static void printThreeWords(String firstWord, String secondWord, String thirdWord) {
        System.out.println(firstWord);
        System.out.println(secondWord);
        System.out.println(thirdWord);
    }

    public static void printStringMultipleTimes(String text, int count) {
        if (count <= 0) {
            System.out.println("Количество повторений должно быть положительным числом");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println(text);
        }
    }

    public static void invertArray(int[] array) {
        if (array == null) {
            System.out.println("Массив не может быть null");
            return;
        }

        System.out.println("Исходный массив:");
        for (int j : array) {
            System.out.printf("%d ", j);
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = (array[i] == 0) ? 1 : 0;
        }
        System.out.println("\nИзмененный массив:");
        for (int j : array) {
            System.out.printf("%d ", j);
        }
    }

    public static void createAndPrintIdentityMatrix(int size) {
        if (size <= 0) {
            System.out.println("Размер матрицы должен быть положительным числом");
            return;
        }

        int[][] array = new int[size][size];

        for (int i = 0; i < size; i++) {
            array[i][i] = 1;
        }

        System.out.printf("Единичная матрица %dx%d:%n", size, size);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.printf("%d ", array[i][j]);
            }
            System.out.println();
        }
    }

    public static void multiplyNumbersLessThanThreshold(int[] numbers, int threshold) {
        if (numbers == null) {
            System.out.println("Массив не может быть null");
            return;
        }

        System.out.println("Исходный массив:");
        for (int number : numbers) {
            System.out.printf("%d ", number);
        }

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < threshold) {
                numbers[i] *= 2;
            }
        }

        System.out.printf("\nРезультат (числа < %d умножены на 2):%n", threshold);
        for (int number : numbers) {
            System.out.printf("%d ", number);
        }
    }

    public static void createAndPrintSequence(int length, int startFrom) {
        if (length <= 0) {
            System.out.println("Длина массива должна быть положительным числом");
            return;
        }

        int[] numbers = new int[length];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = startFrom + i;
        }

        System.out.printf("Последовательность чисел от %d до %d:%n", startFrom, startFrom + length - 1);
        for (int number : numbers) {
            System.out.printf("%d ", number);
        }
    }

}
