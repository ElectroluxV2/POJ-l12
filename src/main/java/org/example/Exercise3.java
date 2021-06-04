package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import static org.example.Exercise1.prepareTable;

public class Exercise3 extends Application {
    @Override
    public void start(Stage stage) {
        var table = prepareTable();

        var button = new Button("Print info about selected");
        button.setOnMouseClicked(mouseEvent -> {
            var sb = new StringBuilder();
            for(Person p: table.getSelectionModel().getSelectedItems()) {
                sb.append(p.toString());
                sb.append(System.lineSeparator());
            }

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("Selected data");
            alert.setContentText(sb.toString());

            alert.showAndWait();
        });

        var scene = new Scene(new StackPane(new VBox(button, table)), 640, 480);
        stage.setScene(scene);
        stage.show();
    }



    public static void main(String[] args) {
        launch();
    }
}
