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
			System.out.printf("Employee Name: %s, %s\n   Employee ID: %d\n   Salary: %.2f", lastName, firstName, employeeID, salary);
		}
	}


