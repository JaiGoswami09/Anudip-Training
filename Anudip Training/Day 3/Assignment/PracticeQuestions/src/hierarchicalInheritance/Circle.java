package hierarchicalInheritance;

public class Circle extends Shape {
	
	double radius;
	
	Circle(double radius) {
		this.radius = radius;
	}
	
	double area() {
		return Math.PI*radius*radius;
	}

}
