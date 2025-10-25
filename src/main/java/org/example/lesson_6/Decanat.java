package org.example.lesson_6;

import java.util.Collection;
import java.util.Set;

public class Decanat {
    // Метод для удаления студентов со средним баллом < 3
    public static void removeLowGradeStudents(Collection<Student> students) {
        students.removeIf(student -> student.getAverageGrade() < 3.0);
    }

    // Метод для перевода студентов на следующий курс, если средний балл >= 3
    public static void promoteStudents(Collection<Student> students) {
        for (Student student : students) {
            if (student.getAverageGrade() >= 3.0) {
                student.setCourse(student.getCourse() + 1);
            }
        }
    }

    // Метод для печати студентов по курсу
    public static void printStudents(Set<Student> students, int course) {
        System.out.printf("Студенты на курсе %d:%n", course);
        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println(student.getName());
            }
        }
    }
}