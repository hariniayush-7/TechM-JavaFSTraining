package task_2;

public class Employee {
    private int empId;
    private String empName;
    private double sal;

    // Constructor
    public Employee(int empId, String empName, double sal) {
        this.empId = empId;
        this.empName = empName;
        this.sal = sal;
    }

    public Employee() {
		// TODO Auto-generated constructor stub
	}

	// Method to set employee details
    public void setEmployeeDetails(int empId, String empName, double sal,int yearsWorked) {
        this.empId = empId;
        this.empName = empName;
        this.sal = sal;
    }

    // Method to get employee details
    public String getEmployeeDetails() {
        return "Employee ID: " + empId + ", Name: " + empName + ", Salary: " + sal;
    }

    // Method to check loan eligibility
    public double getLoanEligibility(int yearsWorked) {
        if (yearsWorked > 5) {
            if (sal >= 1500000) {
                return 700000; // Eligible for 7 lakhs loan
            } else if (sal >= 1000000) {
                return 500000; // Eligible for 5 lakhs loan
            } else if (sal >= 600000) {
                return 200000; // Eligible for 2 lakhs loan
            }
        }
        return 0; // Not eligible for a loan
    }

}
