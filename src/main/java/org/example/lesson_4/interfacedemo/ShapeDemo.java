package org.example.lesson_4.interfacedemo;

public class ShapeDemo {
    public static void main(String[] args) {
        // Создаем фигуры с разными параметрами и цветами
        Shape circle = new Circle(5.0, "Красный", "Черный");
        Shape rectangle = new Rectangle(4.0, 6.0, "Синий", "Зеленый");
        Shape triangle = new Triangle(3.0, 4.0, 5.0, "Желтый", "Фиолетовый");

        // Выводим информацию о каждой фигуре
        System.out.println("Информация о круге:");
        circle.printInfo();

        System.out.println("Информация о прямоугольнике:");
        rectangle.printInfo();

        System.out.println("Информация о треугольнике:");
        triangle.printInfo();
    }
}