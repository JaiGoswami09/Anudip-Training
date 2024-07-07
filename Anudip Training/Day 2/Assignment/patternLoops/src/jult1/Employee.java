package jult1;

public class Employee {
	
	String emp_Name;
	int emp_Id;
	int emp_Sal;
	String emp_Dept;
	
	public Employee(String emp_Name,int emp_Id,int emp_Sal, String emp_Dept) {
		this.emp_Name = emp_Name;
		this.emp_Id = emp_Id;
		this.emp_Sal = emp_Sal;
		this.emp_Dept  = emp_Dept;
		
	}
	
	void display() {
		System.out.println("Employee Details: " + "\n" +
	                         "Employee Name: " + emp_Name + "\n" +
	                         "Employee Id: " + emp_Id + "\n" +
	                         "Employee Salary: " + emp_Sal + "\n" +
	                         "Employee Department: " + emp_Dept); 
	}
	
	public static void main(String[]args) {
		Employee emp1 = new Employee("Jai Goswami",123456, 460000, "ASE");
		emp1.display();
	}
	

}
