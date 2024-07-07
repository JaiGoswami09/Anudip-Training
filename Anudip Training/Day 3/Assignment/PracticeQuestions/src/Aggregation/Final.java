package Aggregation;

public class Final {
	
	    Department department;
	    public void display(){
	        System.out.println("Display"+department.departmentName);
	    }
	  public static void main(String[] args) {

	      Professor p = new Professor("Jai Goswami");
	      Department d = new Department("Programming World",p);
	      University u = new University("SIRT","Bpl",d);
	      u.display();
	      d.display();

	    }
	}

