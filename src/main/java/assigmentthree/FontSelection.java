//Yodahe Hunde
//Yodaheh1@umbc.edu
// a program that can dynamically change the font of a text in a
//label displayed on a stack pane . The text can be displayed in bold
//and italic at the same time. You can select the font name or font
//size from combo boxes.

package assigmentthree;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.List;

public class FontSelection extends Application {

    private Label label = new Label("Programming is fun!");
    private ComboBox<String> cboFontName = new ComboBox<>();
    private ComboBox<Integer> cboFontSize = new ComboBox<>();
    private CheckBox chkBold = new CheckBox("Bold");
    private CheckBox chkItalic = new CheckBox("Italic");

    private double paneWidth = 540;
    private double paneHeight = 250;
    @Override
    public void start(Stage stage) throws Exception {
        BorderPane pane = new BorderPane();
        pane.setCenter(label);

        //populate font names into combobox
        List<String> fontName = Font.getFontNames();
        cboFontName.getItems().addAll(fontName);
//        cboFontName.setValue(fontName.get(0));
        cboFontName.setValue(label.getFont().getName());
        cboFontSize.setValue((int)label.getFont().getSize());

        cboFontName.setOnAction(event -> {
            setFont();
        });
        cboFontSize.setOnAction(event -> {
            setFont();
        });
        chkBold.setOnAction(event -> {
            setFont();
        });
        chkItalic.setOnAction(event -> {
            setFont();
        });


        for (int i = 1; i < 100; i++) {
            cboFontSize.getItems().add(i);
        }

        //layout
        HBox hbox = new HBox(new Label("Font Name:"), cboFontName, new Label("Font Size:"), cboFontSize);
        hbox.setSpacing(10);
        hbox.setPadding(new Insets(10));
        hbox.setAlignment(Pos.CENTER);
        pane.setTop(hbox);

        HBox hbox2 = new HBox(10);
        hbox2.setPadding(new Insets(10));
        hbox2.getChildren().addAll(chkBold, chkItalic);
        pane.setBottom(hbox2);

        // the following line to set alignment
        hbox2.setAlignment(Pos.CENTER);

        pane.setBottom(hbox2);

        Scene scene = new Scene(pane, paneWidth, paneHeight);
        stage.setScene(scene);
        stage.setTitle("Font Selection"); // Set the stage title

        stage.show();

    }

    private void setFont(){
        FontWeight weight;
        FontPosture posture;

        //Check box bold
        if (chkBold.isSelected()){
            weight = FontWeight.BOLD;
        }else {
            weight = FontWeight.NORMAL;
        }

        //Check box italic
        if (chkItalic.isSelected()){
            posture = FontPosture.ITALIC;
        }else {
            posture = FontPosture.REGULAR;
        }

        label.setFont(Font.font(cboFontName.getValue(), weight, posture, cboFontSize.getValue()));
    }
}
