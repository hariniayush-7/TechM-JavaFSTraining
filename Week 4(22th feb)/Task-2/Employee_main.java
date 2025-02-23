package task_2;

import java.util.Scanner;

public class Employee_main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Employee employee = new Employee();

        // Input employee details
        System.out.print("Enter Employee ID: ");
        int empId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Employee Name: ");
        String empName = scanner.nextLine();
        System.out.print("Enter Employee Salary: ");
        double sal = scanner.nextDouble();
        System.out.print("Enter Years Worked: ");
        int yearsWorked = scanner.nextInt();

        // Set employee details
        employee.setEmployeeDetails(empId, empName, sal, yearsWorked);

        // Display employee details
        System.out.println(employee.getEmployeeDetails());

        // Check loan eligibility
        double loanAmount = employee.getLoanEligibility(yearsWorked);
        if (loanAmount > 0) {
            System.out.println("Eligible for a loan of: " + loanAmount + " INR");
        } else {
            System.out.println("Not eligible for a loan.");
        }

        scanner.close();
    }

}
