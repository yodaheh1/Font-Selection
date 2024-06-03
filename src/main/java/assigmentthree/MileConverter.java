//Yodahe Hunde
//Yodaheh1@umbc.edu
//A program that converts miles and kilometers. If you
//enter a value in the Mile text field, and press Enter Key,
//the corresponding kilometer measurement is displayed in the
//kilometer text field and press the Enter key, the corresponding
// miles is displayed in the Mile text field.

package assigmentthree;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.geometry.Pos;
import javafx.scene.input.KeyCode;

public class MileConverter extends Application {
    final double KILOMETERS_PER_MILE = 1.602307322544464;
    protected TextField txtMile = new TextField();
    protected TextField txtKiloMeter = new TextField();

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
// Set text fields alignment
        txtMile.setAlignment(Pos.BOTTOM_RIGHT);
        txtKiloMeter.setAlignment(Pos.BOTTOM_RIGHT);

// Create a gridpane and place nodes into it
        GridPane pane = new GridPane();
        pane.setVgap(10);
        pane.setHgap(10);
        pane.setAlignment(Pos.CENTER);
        pane.add(new Label("Mile "), 0, 0);
        pane.add(txtMile, 1, 0);
        pane.add(new Label("Kilometer "), 0, 1);
        pane.add(txtKiloMeter, 1, 1);


        pane.setPadding(new Insets(10,10,10,50));


// Create and register the handlers
        txtMile.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER &&
                    txtMile.getText().length() > 0) {
                double miles = Double.parseDouble(txtMile.getText());
                txtKiloMeter.setText(String.valueOf(miles * KILOMETERS_PER_MILE));
            }
        });

        txtKiloMeter.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER &&
                    txtKiloMeter.getText().length() > 0) {
                double kilometers = Double.parseDouble(txtKiloMeter.getText());
                txtMile.setText(String.valueOf(kilometers / KILOMETERS_PER_MILE));
            }
        });

// Create a scene and place it in the stage
        Scene scene = new Scene(pane, 500, 200);
        primaryStage.setTitle("Simple Conversion"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }
}
