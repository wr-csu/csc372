package coursework;

public class Circle extends Shape{
	//attribute
	private double radius;	
	//constructor
	public Circle(double radius) {
		this.radius = radius;
	}	
	//toString
	public String toString() {
		return "Circle:\n   Area: " + area() + "\n   Perimeter " + perimeter();
	}	
	//inherited methods
	@Override
	double area() {
		// A=πr^2
		return Math.PI * Math.pow(radius, 2);
	}
	@Override
	double perimeter() {
		// Circumference (perimeter) = 2πr
		return 2 * Math.PI * radius;
	}
}
