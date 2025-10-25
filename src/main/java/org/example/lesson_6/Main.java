package org.example.lesson_6;

import java.util.*;

import static org.example.lesson_6.Decanat.*;


public class Main {
    public static void main(String[] args) {
        // Создаем коллекцию студентов
        List<Student> students = new ArrayList<>();

        // Пример студентов
        Map<String, Integer> grades1 = new HashMap<>();
        grades1.put("Математика", 4);
        grades1.put("Физика", 5);
        grades1.put("Программирование", 3);
        students.add(new Student("Иван Иванов", "Группа A", 2, grades1));

        Map<String, Integer> grades2 = new HashMap<>();
        grades2.put("Математика", 2);
        grades2.put("Физика", 2);
        students.add(new Student("Петр Петров", "Группа B", 2, grades2));

        Map<String, Integer> grades3 = new HashMap<>();
        grades3.put("Математика", 5);
        grades3.put("Физика", 4);
        students.add(new Student("Анна Сидорова", "Группа A", 3, grades3));

        System.out.println("Исходная коллекция:");
        for (Student s : students) {
            System.out.println(s);
        }

        // Удаляем студентов со средним < 3
        removeLowGradeStudents(students);
        System.out.println("\nПосле удаления студентов со средним < 3:");
        for (Student s : students) {
            System.out.println(s);
        }

        // Переводим на следующий курс
        promoteStudents(students);
        System.out.println("\nПосле перевода на следующий курс:");
        for (Student s : students) {
            System.out.println(s);
        }

        // Преобразуем в Set для демонстрации printStudents
        Set<Student> studentSet = new HashSet<>(students);

        // Печатаем студентов по курсу
        printStudents(studentSet, 3); // Иван перешел на 3
        printStudents(studentSet, 4); // Анна перешла на 4


        // Пример использования PhoneBook

        PhoneBook phoneBook = new PhoneBook();

        // Добавляем записи
        phoneBook.add("Иванов", "+7-123-456-78-90");
        phoneBook.add("Иванов", "+7-987-654-32-10");
        phoneBook.add("Петров", "+7-555-123-45-67");
        phoneBook.add("Сидоров", "+7-999-888-77-66");

        // Ищем номера
        System.out.printf("Номера Ивановых: %s%n", phoneBook.get("Иванов"));
        System.out.printf("Номера Петровых: %s%n", phoneBook.get("Петров"));
        System.out.printf("Номера Сидоровых: %s%n", phoneBook.get("Сидоров"));
        System.out.printf("Номера для несуществующей фамилии: %s%n", phoneBook.get("Неизвестный"));
    }
}