package coursework;
import java.util.Scanner;

public class CritMod1Test {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		DerivedClassManager employ1 = new DerivedClassManager();
		String first = " ";
		String last = " ";
		int employID = 0;
		char quit = 'y';
		//loop for more employees info
		while (quit != 'n'){			
				System.out.print("Enter first name: ");
				first = scnr.next();
				System.out.print("Enter last name: ");
				last = scnr.next();
				System.out.print("Enter employee ID number: ");
				employID = scnr.nextInt();	
				//set info
				employ1.setFirstName(first);
				employ1.setLastName(last);
				employ1.setID(employID);
				employ1.employeeSummary();				
				System.out.print("\nContinue? y/n: ");
				quit = scnr.next().charAt(0);			
		}//close loop
		System.out.print("GoodBye!");	
		scnr.close();		
	} //close main args
} //close class
