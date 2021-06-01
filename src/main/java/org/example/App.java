package org.example;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("TextArea Experiment 1");

        TextArea textArea = new TextArea();

        Button button = new Button("Click to get text");
        button.setMinWidth(50);

        button.setOnAction(action -> {
            System.out.println(textArea.getText());

            textArea.setText("Clicked!");
        });

        //VBox vbox = new VBox(textArea, button);

        Scene scene = new Scene(textArea, 200, 100, Color.BLACK);
        scene.getStylesheets().addAll("test.css", "scrollbar.css");

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}