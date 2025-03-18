package coursework;

public class DerivedClassManager extends SuperClassEmployee {
	
	//field v
	protected String department = "a";
	
	//print all method with both super class and subclass fields
	@Override
	public void employeeSummary() {
		super.employeeSummary();
		System.out.println("	Department: " + department);
	}
	

}
