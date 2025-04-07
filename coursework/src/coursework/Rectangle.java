package coursework;

public class Rectangle extends Shape {
	//attributes
	private double length;
	private double width;
	//constructor
	public Rectangle(double length, double width) {
		this.length = length;
		this.width = width;
	}	
	//toString
	public String toString() {
		return "Rectangle:\n   Area: " + area() + "\n   Perimeter " + perimeter();
	}	
	//inherited from Shape class
	@Override
	double area() {
		//area = l * w
		return length * width;
	}
	@Override
	double perimeter() {
		// perimeter = 2(l + w)
		return 2 * (length + width);
	}
}
