package application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.scene.shape.Rectangle; 
import java.util.Random;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Label;


public class UserMenu {
	
	
	public Stage stage;
	private BorderPane layout;
	private Scene scene;


	public UserMenu(Stage stage) {
		this.stage = stage;
		GUI();

	}

	private void GUI() {
		//set layout and create menu
		MenuBar menuBar = new MenuBar();
		BorderPane layout = new BorderPane();
		layout.setTop(menuBar);
		Menu fileMenu = new Menu("File");
		//adding all items to the menu
		MenuItem currDate = new MenuItem("Current Date");
		MenuItem logDate = new MenuItem("Log Date");
		MenuItem orange = new MenuItem("Orange is Great");
		MenuItem exit = new MenuItem("Exit");
		fileMenu.getItems().addAll(currDate, logDate, orange, exit);
		menuBar.getMenus().addAll(fileMenu);
		
		//action event for current date
		currDate.setOnAction(new EventHandler<ActionEvent>()    {
            @Override
            public void handle(ActionEvent event) {
            	LocalDate date = LocalDate.now();
            	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMM uuuu");
            	String text = date.format(formatter);
            	LocalDate parsedDate = LocalDate.parse(text, formatter);
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Current Date");
                alert.setHeaderText(null);
                alert.setContentText("Today: " + text);
                alert.showAndWait();
                }
        });		
		// action event for logging date
		logDate.setOnAction(new EventHandler<ActionEvent>()    {
            @Override
            public void handle(ActionEvent event) {
                try {
                	LocalDate date = LocalDate.now();
                	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMM uuuu");
                	String text = date.format(formatter);
                	LocalDate parsedDate = LocalDate.parse(text, formatter);
                    FileWriter newDate = new FileWriter("log.txt");
                    newDate.write(text);
                    newDate.close();
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Info");
                    alert.setHeaderText(null);
                    alert.setContentText("Logged today's date");
                    alert.showAndWait();
                  } catch (IOException e) {
                    System.out.println("ERROR");
                    e.printStackTrace();            	
            }}});
		//action event for orange color changer
		orange.setOnAction(new EventHandler<ActionEvent>()    {
            @Override
            public void handle(ActionEvent event) {
            	Random rand = new Random();
            	int g = rand.nextInt(66, 157);
            	Color c = Color.rgb(255,g,0);

            	Rectangle rect = new Rectangle(350,350, c);
            	BorderPane.setAlignment(rect, javafx.geometry.Pos.CENTER);
            	layout.setCenter(rect);
            	Label label = new Label("This Orange is: " + c);  
            	BorderPane.setAlignment(label, javafx.geometry.Pos.BOTTOM_CENTER);
            	layout.setBottom(label);      	
            }});

		//action even to close out window
		exit.setOnAction(new EventHandler<ActionEvent>()    {
            @Override
            public void handle(ActionEvent event) {		
            	System.exit(0);
		}});

		//set scene
		scene = new Scene(layout, 400, 400);
		stage.setTitle("User Menu: Orange");
		stage.setScene(scene);
	}

	public void show() {
		this.stage.show();
	}
}

