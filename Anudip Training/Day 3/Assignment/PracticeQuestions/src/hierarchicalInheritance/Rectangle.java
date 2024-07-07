package hierarchicalInheritance;

public class Rectangle extends Shape {
	
	double width;
	double height;
	
	Rectangle (double width, double height) {
		this.width = width;
		this.height = height;
	}
	
	double area() {
		return width*height;
	}

}
