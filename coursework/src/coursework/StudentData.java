package coursework;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;
public class StudentData {
	//student data object
	double gpa;
	String name;
	String address;
	//constructor
	public StudentData(double gpa, String name, String address) {
		this.gpa = gpa;
		this.name = name;
		this.address = address;
	}
	//getters
	public double getGPA() {
		return gpa;
	}
	public String getName() { 
		return name;
	}
	public String getAddress() {
		return address;
	}

	//print formatting
	@Override
	   public String toString() { 
		return ("\nStudent Name: "+ this.getName()+
                "\n   Address: " + this.getAddress()) +              
                "\n   Grade Point Average: " + this.getGPA();
	}
	
	//method for writing linked list to a file
	public static void printToFile(LinkedList<StudentData> students, String fileName) {
		try (FileWriter newFile = new FileWriter(fileName,true)){
			for(StudentData student : students) {
				String temp = student.toString();
				newFile.write(temp);
				newFile.write(System.getProperty( "line.separator" ));
			};
			} catch (IOException e) {
			System.out.print("File not Found Error");
			e.printStackTrace();
		}
	}
	//valid gpa checker
	public static double validGPA(Scanner scnr) {
		double userInput = 0.0;
		while(true) {
			System.out.print("Enter Student's GPA: ");
			try {
				userInput = scnr.nextDouble();
				if(userInput < 0.0 || userInput > 4.0) {
					System.out.println("Invalid GPA! GPA Format is double between 0.0 and 4.0");
					continue;
				}
				break;
			} catch(InputMismatchException e) {	
				System.out.println("Invalid GPA! GPA Format is double between 0.0 and 4.0");
				scnr.next();
			}
		}
		return userInput;	
	}
	
	public static void main(String[] args) {
		Scanner scnr = new Scanner (System.in);
		LinkedList<StudentData> students = new LinkedList<StudentData>();
		
		char check = ' ';
		while (check != 'n') {
			//set name
			System.out.print("Enter Student's Name: ");
			String tempName = scnr.nextLine();
			//set address
			System.out.print("Enter Student's Address: ");
			String tempAddress = scnr.nextLine();
			//set gpa
			double tempGPA = validGPA(scnr); 
			//add new student
			students.add(new StudentData(tempGPA, tempName, tempAddress)); 
			//continue or break loop
			System.out.print("Continue? y/n ");
			check = scnr.next().charAt(0);
			scnr.nextLine();//prevent scanner skipping
		}
		//sort then print to file
		students.sort(Comparator.comparing(StudentData:: getName));
		printToFile(students, "CSC372 Student Data File");
		
		scnr.close();
	}
}






