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
import java.time.ZoneId;
import java.util.Date;

public class bdayGUI extends JFrame implements ActionListener{
	//many many traits
	private JPanel panels;
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
	
	GridBagLayout gridLT;
	GridBagConstraints c;
		
	//constructor
	public bdayGUI() {
		//initialize button, panels, fields, labels
		button = new JButton("Calculate Current Age");
		button.addActionListener(this);
		
		
		month = new JLabel("Enter Birth Month(mm):");
		monthField = new JTextField();
		day = new JLabel("Enter Birth Day(dd):");
		dayField = new JTextField();
		year = new JLabel("Enter Birth Year (yyyy):");
		yearField = new JTextField();

		ageField = new JTextField();
		
		//set text fields to editable with exception of output age field
		monthField = new JTextField(10);
	    monthField.setEditable(true);
	    monthField.setText("");

	    
	    dayField = new JTextField(10);
	    dayField.setEditable(true);
	    dayField.setText("");

	    
	    yearField = new JTextField(10);
	    yearField.setEditable(true);
	    yearField.setText("");
	    
	    ageField = new JTextField(25);    
	    ageField.setEditable(false);				
		
	    gridLT = new GridBagLayout();
		c = new GridBagConstraints();
		
		//panel set up
		panels = new JPanel();
		panels.setLayout(gridLT);
		
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
		panels.add(panelA, c);	
		c.gridx = 0;
		c.gridy = 1;
		c.fill = GridBagConstraints.BOTH;		
		panels.add(panelB, c);
		c.gridx = 0;
		c.gridy = 2;
		c.fill = GridBagConstraints.BOTH;
		panels.add(panelC, c);
		c.gridx = 0;
		c.gridy = 3;
		c.fill = GridBagConstraints.BOTH;
		panels.add(panelD, c);
		
		//frame set up
		getContentPane().add(panels);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	    setTitle("Age Checker");
	    setSize(700,200);
	    setVisible(true);
		} //close constructor


	@Override
	public void actionPerformed(ActionEvent event) {
		//get action listener to respond to user input from button
		String userInput;
		int calcMonth, calcDay, calcYear, day, month, year;
		//find accurate age with date month and year
		Date date = new Date();
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		year  = localDate.getYear();
		month = localDate.getMonthValue();
		day   = localDate.getDayOfMonth();
		
		userInput = monthField.getText();
		calcMonth = Math.abs(month - Integer.parseInt(userInput));
		userInput = dayField.getText();
		calcDay = Math.abs(day - Integer.parseInt(userInput));		
		userInput = yearField.getText();
		calcYear = Math.abs(year - Integer.parseInt(userInput));
		
		ageField.setText(calcDay + " Days, " + calcMonth + " Months, and " + calcYear + " Years"); //warning not good enough edit after frame is good to go	
	} //close action event

	
	public static void main(String[] args) {
		bdayGUI testing = new bdayGUI();
	}//main
}//close class














