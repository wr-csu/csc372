package coursework;
import java.util.Scanner;

public class critMod1Test {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		DerivedClassManager employ1 = new DerivedClassManager();

		String first = "emma";
		String last = "last";
		int employID = 1111;
		
		employ1.setFirstName(first);
		employ1.setLastName(last);
		employ1.setID(employID);
		employ1.employeeSummary();
		
		System.out.print("Enter first name: ");
		first = scnr.next();
		System.out.print("Enter last name: ");
		last = scnr.next();
		System.out.print("Enter employee ID number: ");
		employID = scnr.nextInt();
		
		employ1.setFirstName(first);
		employ1.setLastName(last);
		employ1.setID(employID);
		employ1.employeeSummary();
		

	}

}
