package coursework;
public class ShapeArray {
	public static void main(String[] args) {
		//instantiate triangle, circle, square
		Triangle triangle = new Triangle(1,2,3);
		Circle circle = new Circle(4);
		Rectangle square = new Rectangle(5,5);	
		//store them into array
		Shape shapeArray[] = new Shape[3];
		shapeArray[0] = triangle;
		shapeArray[1] = circle;
		shapeArray[2] = square;		
		//loop and print all info
		for(int i = 0; i < shapeArray.length; i++) {
			System.out.println(shapeArray[i].toString());
			System.out.println();
		}						
	}
}
