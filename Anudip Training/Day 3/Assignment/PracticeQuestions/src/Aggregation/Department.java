package Aggregation;

public class Department {
	
	    String departmentName;
	    Professor professor;
	    public Department(String departmentName,Professor professor){
	        this.departmentName = departmentName;
	        this.professor = professor;
	    }
	    public void display(){
	        System.out.println("Department Name: "+departmentName);
	        System.out.println("Professor Name: "+ professor.name);
	    }

	}


