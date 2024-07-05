
package com.example.studentmanagement;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Map<Integer, Student> studentMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Display Students");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addStudent(scanner);
                    break;
                case 2:
                    removeStudent(scanner);
                    break;
                case 3:
                    displayStudents();
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
        scanner.close();
    }

    private static void addStudent(Scanner scanner) {
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter student age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Student student = new Student(id, name, age);
        studentMap.put(id, student);
        System.out.println("Student added: " + student);
    }

    private static void removeStudent(Scanner scanner) {
        System.out.print("Enter student ID to remove: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (studentMap.containsKey(id)) {
            Student removedStudent = studentMap.remove(id);
            System.out.println("Student removed: " + removedStudent);
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    private static void displayStudents() {
        if (studentMap.isEmpty()) {
            System.out.println("No students to display.");
        } else {
            for (Student student : studentMap.values()) {
                System.out.println(student);
            }
        }
    }
}

