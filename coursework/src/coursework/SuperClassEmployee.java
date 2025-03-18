package coursework;

public class SuperClassEmployee {
		//fields v
		protected String firstName;
		protected String lastName;
		protected int employeeID;
		protected double salary;
		
		//constructor method v
		public SuperClassEmployee() {
			salary = 0;	
		}
		
		//setters v
		public void setFirstName(String first) {
			firstName = first;
		}
		public void setLastName(String last) {
			lastName = last;
		}
		public void setID(int id) {
			employeeID = id;
		}
		
		//getters v
		public String getFirstName() {
			return firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public int getEmployeeID() {
			return employeeID;
		}
		
		//printAll method v
		public void employeeSummary() {
			System.out.println("Employee Name: " + lastName + ", " + firstName);
			System.out.println("	Employee ID: " + employeeID);
			System.out.println("	Salary: " + salary);
		}
	}


