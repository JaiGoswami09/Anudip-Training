package Aggregation;

public class University {
	
		   String name,place;
		   Department department;
		   public University(String name,String place,Department department){
		       this.name = name;
		       this.place = place;
		       this.department = department;
		   }
		public void display(){
		    System.out.println("University name: "+name);
		    System.out.println("place: "+place);
		}
		//   Department d = new Department("Computer Science");


		}


