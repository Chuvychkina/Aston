package org.example.lesson_4.abstract_class;

public class Dog extends Animal {
    private static final int MAX_RUN_DISTANCE = 500;
    private static final int MAX_SWIM_DISTANCE = 10;
    private static int dogCount = 0;

    public Dog(String name) {
        super(name);
        dogCount++;
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
        if (distance <= MAX_SWIM_DISTANCE && distance > 0) {
            System.out.printf("%s проплыл %d м.%n", name, distance);
        } else if (distance > MAX_SWIM_DISTANCE) {
            System.out.printf("%s не может проплыть больше %d м.%n", name, MAX_SWIM_DISTANCE);
        } else {
            System.out.println("Дистанция должна быть положительной");
        }
    }

    public static int getDogCount() {
        return dogCount;
    }
}