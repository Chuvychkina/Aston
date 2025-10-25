package org.example.lesson_4.abstract_class;

public class Cat extends Animal {
    private static final int MAX_RUN_DISTANCE = 200;
    private static int catCount = 0;
    private boolean isFull; // сытость

    public Cat(String name) {
        super(name);
        this.isFull = false; // при создании кот голоден
        catCount++;
    }

    @Override
    public void run(int distance) {
        if (distance <= MAX_RUN_DISTANCE && distance > 0) {
            System.out.printf("%s пробежал %d м.%n", name, distance);
        } else if (distance > MAX_RUN_DISTANCE) {
            System.out.printf("%s не может пробежать больше %d м.%n", name, MAX_RUN_DISTANCE);
        } else {
            System.out.println("Дистанция должна быть положительной");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.printf("%s не умеет плавать!%n", name);
    }

    // Метод для питания из миски
    public void eat(Bowl bowl, int foodAmount) {
        if (bowl.decreaseFood(foodAmount)) {
            this.isFull = true;
            System.out.printf("%s покушал и теперь сыт%n", name);
        } else {
            System.out.printf("%s не смог покушать, в миске недостаточно еды%n", name);
        }
    }

    // Метод для проверки сытости
    public boolean isFull() {
        return isFull;
    }

    // Метод, чтобы сделать кота голодным (для тестирования)
    public void setHungry() {
        this.isFull = false;
    }

    public static int getCatCount() {
        return catCount;
    }}