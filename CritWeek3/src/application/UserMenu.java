package application;
//many many imports
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.io.FileWriter; 
import java.io.IOException;
import javafx.scene.paint.Color;
import java.util.Random;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Label;


public class UserMenu {
	public Stage stage;
	private BorderPane layout;
	private Scene scene;

	public UserMenu(Stage stage) {
		this.stage = stage;
		GUI();
	}
	//create orange color
	public Color makeOrange() {
    	Random rand = new Random();
    	int g = rand.nextInt(66, 157);
    	Color c = Color.rgb(255,g,0);
		return c;
	}
	//creates alerts	
	public Alert makeAlert(String title, String contentText, String text) {
	    Alert alert = new Alert(AlertType.INFORMATION);
	    alert.setTitle(title);
	    alert.setHeaderText(null);
	    alert.setContentText(contentText + text);
	    alert.showAndWait();
		return alert;	
	}	
	
	private void GUI() {
		//set layout and create menu
		MenuBar menuBar = new MenuBar();
		layout = new BorderPane();
		layout.setTop(menuBar);
		Menu fileMenu = new Menu("File");
		
		//adding all items to the menu
		MenuItem currDate = new MenuItem("Current Date");
		MenuItem logDate = new MenuItem("Log Date");
		MenuItem orange = new MenuItem("Orange is Great");
		MenuItem exit = new MenuItem("Exit");
		fileMenu.getItems().addAll(currDate, logDate, orange, exit);
		menuBar.getMenus().addAll(fileMenu);
		
		//date variables
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMM uuuu");
		LocalDate date = LocalDate.now();
		String text = date.format(formatter);
		
		
		//action event for current date
		currDate.setOnAction(event -> {			
			makeAlert("Current Date", "Today: ", text);			
		});	
		
		// action event for logging date				
		logDate.setOnAction(event -> {
            try {          	         	        
          	    try (FileWriter newDate = new FileWriter("log.txt",true)){
          	    	newDate.write(text);
          	    	newDate.write(System.getProperty( "line.separator" ));
          	    }  
          	    
          	    makeAlert("Info", "Logged today's date", text);
          	    	         	   
             } catch (IOException e) {
                System.out.println("File Not Found");
                e.printStackTrace();            	
         }});		
		//action event for orange color changer
		orange.setOnAction(event -> {
			//reset layout per event click
			layout.setCenter(null);
		    layout.setBottom(null);
		    
		    //new layout to handle orange color setting
			StackPane root = new StackPane();
			root.setBackground(new Background(new BackgroundFill(makeOrange(), CornerRadii.EMPTY, Insets.EMPTY)));
			layout.setCenter(root);
			
			//label to output orange color
			Label label = new Label("This Orange is: " + makeOrange()); 
        	BorderPane.setAlignment(label, javafx.geometry.Pos.BOTTOM_CENTER);
			layout.setBottom(label); 	
        });	
     	//action even to close out window
		exit.setOnAction(event -> {	System.exit(0);});

		
		//set scene
		scene = new Scene(layout, 400, 400);
		stage.setTitle("User Menu: Orange");
		stage.setScene(scene);
	}

	public void show() {
		this.stage.show();
	}
}

