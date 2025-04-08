package coursework;
//many many imports
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class BirthdayGUI extends JFrame implements ActionListener{
	//many many traits
	private JPanel panels;
	private JPanel panel0;
	private JPanel panelA;
	private JPanel panelB;
	private JPanel panelC;
	private JPanel panelD; 
	private JTextField monthField;
	private JTextField dayField;
	private JTextField yearField;
	private JTextField ageField;
	private JLabel month;
	private JLabel day;
	private JLabel year;
	private JButton button;
	private JButton newButton;
	private JTextField newButtonField;
	
	GridBagLayout gridLT;
	GridBagConstraints c;
	
	//text field helper method 
	private JTextField createTextField(int columns, boolean editable) {
	    JTextField textField = new JTextField(columns);
	    textField.setEditable(editable);
	    return textField;
	}
		
	//constructor
	public BirthdayGUI() {
		//initialize button, panels, fields, labels
		button = new JButton("Calculate Current Age");
		button.addActionListener(e -> calculateAge()); 
		
		newButton = new JButton("Find Today's Date");
		newButton.addActionListener(e -> newButtonField.setText("Current Date is: " + LocalDate.now())); 
		
		//text fields
		monthField = createTextField(10, true);
		dayField = createTextField(10, true);
		yearField = createTextField(10, true);
		ageField = createTextField(25, false);
		newButtonField = createTextField(25, false);
		
		//labels
		month = new JLabel("Enter Birth Month(mm):");
		day = new JLabel("Enter Birth Day(dd):");
		year = new JLabel("Enter Birth Year (yyyy):");
		
		
	    gridLT = new GridBagLayout();
		c = new GridBagConstraints();
		
		//panel set up
		panels = new JPanel();
		panels.setLayout(gridLT);
		
		panel0 = new JPanel();
		panel0.setBackground(Color.white);
		panel0.add(newButton);
		panel0.add(newButtonField);
		panelA = new JPanel();
		panelA.setBackground(Color.red);
		panelA.add(month);
		panelA.add(monthField);
		panelB = new JPanel();
		panelB.setBackground(Color.orange);
		panelB.add(day);
		panelB.add(dayField);
		panelC = new JPanel();
		panelC.setBackground(Color.yellow);
		panelC.add(year);
		panelC.add(yearField);
		panelD = new JPanel();
		panelD.setBackground(Color.green);
		panelD.add(button);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 2;
		c.gridy = 0;
		panelD.add(ageField);
	
		//grid layout		
		c.gridx = 0;
		c.gridy = 0;
		c.fill = GridBagConstraints.BOTH;
		panels.add(panel0, c);
		
		c.gridx = 0;
		c.gridy = 1;
		c.fill = GridBagConstraints.BOTH;
		panels.add(panelA, c);	
		c.gridx = 0;
		c.gridy = 2;
		c.fill = GridBagConstraints.BOTH;		
		panels.add(panelB, c);
		c.gridx = 0;
		c.gridy = 3;
		c.fill = GridBagConstraints.BOTH;
		panels.add(panelC, c);
		c.gridx = 0;
		c.gridy = 4;
		c.fill = GridBagConstraints.BOTH;
		panels.add(panelD, c);
		
		//frame set up
		getContentPane().add(panels);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	    setTitle("Age Checker");
	    setSize(700,200);
	    setVisible(true);
		} //close constructor


	private void calculateAge() {
		try {
			
			//get user birthday and current date	
			String userInput = monthField.getText() + " " + dayField.getText() + " " + yearField.getText();
			LocalDate currentDate = LocalDate.now();
			
			DateTimeFormatter format = DateTimeFormatter.ofPattern("MM dd yyyy");
			LocalDate birthDate = LocalDate.parse(userInput, format);		
		
			if (birthDate.isAfter(currentDate)){
	            ageField.setText("Error: Invalid BirthDay.");
	            return;
	         }
			//calculating age
			Period period = Period.between(birthDate, currentDate);
			int years = period.getYears(), months = period.getMonths(), days = period.getDays();
			
			//output without errors
			ageField.setText(days + " Days, " + months + " Months, and " + years + " Years"); 	
	      				
		} catch (Exception e) {
		       
			ageField.setText("Please enter a valid date (MM DD YYYY).");

		} //close try-catch
	}// calculate age method

	@Override
	public void actionPerformed(ActionEvent event) {
		//left empty for additional buttons
	} //close action event

	
	public static void main(String[] args) {
		BirthdayGUI testing = new BirthdayGUI();
	}// close main
}//close class














