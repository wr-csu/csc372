package coursework;

public class Triangle extends Shape {
	//attributes
	private double lengthOfSide1;
	private double lengthOfSide2;
	private double lengthOfSide3;	
	//constructor
	public Triangle(double lengthOfSide1, double lengthOfSide2, double lengthOfSide3) {
		this.lengthOfSide1 = lengthOfSide1;
		this.lengthOfSide2 = lengthOfSide2;
		this.lengthOfSide3 = lengthOfSide3;
	}	
	//toString
	public String toString() {
		return "Triangle:\n   Area: " + area() + "\n   Perimeter " + perimeter();
	}	
	//inherited methods
	@Override
	double area() {
		// heron's area formula:  Math.sqrt(s * (s - s1) * (s - s2) * (s - s3));
		double semiPerimeter =  (lengthOfSide1 + lengthOfSide2 + lengthOfSide3) / 2; 
		return  Math.sqrt(semiPerimeter * (semiPerimeter - lengthOfSide1) * (semiPerimeter - lengthOfSide2) * (semiPerimeter - lengthOfSide3));
	}	
	@Override
	double perimeter() {
		// P=a+b+c
		return lengthOfSide1 + lengthOfSide2 + lengthOfSide3;
	}
}
