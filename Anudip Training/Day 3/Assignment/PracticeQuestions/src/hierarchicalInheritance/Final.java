package hierarchicalInheritance;

public class Final {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Circle c = new Circle(5);
		Rectangle r = new Rectangle(5,5);
		
		System.out.println("The Final Area Of Circle is: " + c.area());
		System.out.println("The Final Area Of Rectangle is: " + r.area());

	}

}
