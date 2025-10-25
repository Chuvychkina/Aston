package org.example.lesson_4.interfacedemo;

public interface Shape {
    // Абстрактные методы для получения параметров (реализуются в классах)
    double getPerimeter();
    double getArea();
    String getFillColor();
    String getBorderColor();

    // Дефолтный метод для вывода информации о фигуре
    default void printInfo() {
        System.out.printf("Периметр: %s%n", getPerimeter());
        System.out.printf("Площадь: %s%n", getArea());
        System.out.printf("Цвет заливки: %s%n", getFillColor());
        System.out.printf("Цвет границы: %s%n", getBorderColor());
        System.out.println("---");
    }
}