package coursework;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Student{
	//build student object
	int rollno;
	String name;
	String address;
	//constructor
	public Student(int rollno, String name, String address) {
		this.rollno = rollno;
		this.name = name;
		this.address = address;
	}
	//getters
	public int getRollNo() {
		return rollno;
	}
	public String getName() { 
		return name;
	}
	public String getAddress() {
		return address;
	}
	//for printing
	@Override
	   public String toString() { 
		return ("\n~~~~~~~~~\nStudent Name: "+ this.getName()+
                "\n   Roll Number: "+ this.getRollNo() +              
                "\n   Address: " + this.getAddress());
	}
	
	
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);		
		ArrayList<Student> students = new ArrayList<>();
		//fill students array with 10 students 
		for(int i = 0; i < 10; i++) {
			boolean numberCheck = false;
			//set name
			System.out.printf("Enter Student #%d's Last Name: ", i+1);
			String tempName = scnr.next().toUpperCase();
			System.out.printf("Enter Student #%d's First Name: ", i+1);
			tempName = tempName +", " + scnr.next().toUpperCase();
			scnr.nextLine();//prevent scnr skipping
			
			//try-catch for setting roll number as an integer
			//set roll number
			System.out.printf("Enter %s's Roll Number: ", tempName.substring(tempName.indexOf(" "), tempName.length()));
			int tempRollNo = 0; 
			while(!numberCheck) {
				try {
					tempRollNo = scnr.nextInt();
					numberCheck = true;
				} catch(InputMismatchException e) {
					System.out.print("Invalid Roll Number. Please Try Again: ");
					scnr.next();
				}
			}
			scnr.nextLine();//prevent scnr skipping
			
			//set address
			System.out.printf("Enter %s's Address: ", tempName.substring(tempName.indexOf(" "), tempName.length()));
			String tempAddress = scnr.nextLine();
			//add student
			students.add(new Student(tempRollNo, tempName, tempAddress));

		}
	
		//call method
		MergeSort.mergeSort(students);
		
		//print sorted list
		System.out.println("Sorted");
		System.out.println(students.toString());
	
		scnr.close();
	}
}
	
