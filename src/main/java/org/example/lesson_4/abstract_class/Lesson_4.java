package org.example.lesson_4.abstract_class;

public class Lesson_4 {
    public static void main(String[] args) {
        System.out.println("=== ДЕМОНСТРАЦИЯ РАБОТЫ КЛАССОВ ЖИВОТНЫХ ===\n");

        // Часть 1: Демонстрация бега и плавания
        System.out.println("1. ТЕСТИРОВАНИЕ БЕГА И ПЛАВАНИЯ:");

        Dog dog1 = new Dog("Бобик");
        Dog dog2 = new Dog("Шарик");
        Cat cat1 = new Cat("Мурзик");
        Cat cat2 = new Cat("Барсик");

        // Тестируем бег
        dog1.run(400);
        dog2.run(600); // превышение лимита
        cat1.run(150);
        cat2.run(250); // превышение лимита

        System.out.println();

        // Тестируем плавание
        dog1.swim(8);
        dog2.swim(15); // превышение лимита
        cat1.swim(5);  // кот не умеет плавать
        cat2.swim(10); // кот не умеет плавать

        System.out.println();

        // Часть 2: Демонстрация питания котов
        System.out.println("2. ТЕСТИРОВАНИЕ ПИТАНИЯ КОТОВ:");

        // Создаем миску с едой
        Bowl bowl = new Bowl(25);
        bowl.displayInfo();

        // Создаем массив котов
        Cat[] cats = {
                new Cat("Васька"),
                new Cat("Рыжик"),
                new Cat("Пушок"),
                new Cat("Черныш")
        };

        System.out.println("\nПытаемся накормить котов:");
        // Пытаемся накормить всех котов
        for (Cat cat : cats) {
            cat.eat(bowl, 10); // каждый кот хочет съесть 10 еды
        }

        System.out.println("\nСтатус сытости котов:");
        // Проверяем сытость котов
        for (Cat cat : cats) {
            System.out.printf("%s: %s%n", cat.getName(), cat.isFull() ? "сыт" : "голоден");
        }

        // Добавляем еды в миску
        System.out.println("\nДобавляем еду в миску:");
        bowl.addFood(30);
        bowl.displayInfo();

        // Снова пытаемся накормить голодных котов
        System.out.println("\nПытаемся накормить оставшихся голодных котов:");
        for (Cat cat : cats) {
            if (!cat.isFull()) {
                cat.eat(bowl, 10);
            }
        }

        System.out.println("\nФинальный статус сытости котов:");
        for (Cat cat : cats) {
            System.out.printf("%s: %s%n", cat.getName(), cat.isFull() ? "сыт" : "голоден");
        }

        // Часть 3: Статистика
        System.out.println("\n3. СТАТИСТИКА:");
        System.out.printf("Всего животных создано: %d%n", Animal.getAnimalCount());
        System.out.printf("Собак создано: %d%n", Dog.getDogCount());
        System.out.printf("Котов создано: %d%n", Cat.getCatCount());
        System.out.printf("Еды осталось в миске: %d%n", bowl.getFoodAmount());

        // Дополнительные тесты
        System.out.println("\n4. ДОПОЛНИТЕЛЬНЫЕ ТЕСТЫ:");

        // Тест с отрицательными значениями
        System.out.println("\nТест с некорректными значениями:");
        Dog testDog = new Dog("Тестовый");
        testDog.run(-50);
        testDog.swim(0);

        // Тест с пустой миской
        System.out.println("\nТест с пустой миской:");
        Bowl emptyBowl = new Bowl(5);
        Cat testCat = new Cat("Тестовый кот");
        testCat.eat(emptyBowl, 10); // попытка съесть больше чем есть
        emptyBowl.addFood(-5); // попытка добавить отрицательное количество
    }
}
