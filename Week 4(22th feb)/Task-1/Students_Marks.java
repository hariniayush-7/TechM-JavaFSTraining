package task_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Student {
	    String name;
	    int marks;

	    Student(String name, int marks) {
	        this.name = name;
	        this.marks = marks;
	    }
	}

public class Students_Marks {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        List<Student> students = new ArrayList<>();

	        System.out.print("Enter the number of students: ");
	        int numberOfStudents = scanner.nextInt();
	        scanner.nextLine(); // Consume newline

	        for (int i = 0; i < numberOfStudents; i++) {
	            System.out.print("Enter name of student " + (i + 1) + ": ");
	            String name = scanner.nextLine();
	            System.out.print("Enter marks of student " + (i + 1) + ": ");
	            int marks = scanner.nextInt();
	            scanner.nextLine(); // Consume newline
	            students.add(new Student(name, marks));
	        }

	        int totalMarks = 0;
	        for (Student student : students) {
	            totalMarks += student.marks;
	        }
	        double averageMarks = (double) totalMarks / numberOfStudents;

	        Collections.sort(students, Comparator.comparingInt(s -> s.marks));

	        System.out.println("\nTotal Marks: " + totalMarks);
	        System.out.println("Average Marks: " + averageMarks);
	        System.out.println("\nStudents sorted by marks: ");
	        for (Student student : students) {
	            System.out.println(student.name + ": " + student.marks);
	        }

	        scanner.close();
	    }
	}



