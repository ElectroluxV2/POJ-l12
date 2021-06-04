package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import static org.example.Exercise1.prepareTable;

public class Exercise4 extends Application {
    @Override
    public void start(Stage stage) {
        var table = prepareTable();

        final String labelText = "Warning %s total people under 30 selected!";
        Label label = new Label(labelText.formatted(0));

        table.setOnMouseClicked(mouseEvent -> {
            if (!mouseEvent.getButton().equals(MouseButton.PRIMARY)) return;

            final int wrongCount = ((int) table.getSelectionModel().getSelectedItems().stream().filter(person -> person.getAge() <= 30).count());
            label.setText(labelText.formatted(wrongCount));

        });

        var button = new Button("Print info about selected");
        button.setOnMouseClicked(mouseEvent -> {
            var sb = new StringBuilder();
            for(Person p: table.getSelectionModel().getSelectedItems()) {
                if (p.getAge() <= 30) continue;

                sb.append(p.toString());
                sb.append(System.lineSeparator());
            }

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("Selected data");
            alert.setContentText(sb.toString());

            alert.showAndWait();
        });

        var scene = new Scene(new StackPane(new VBox(button, table, label)), 640, 480);
        stage.setScene(scene);
        stage.show();
    }



    public static void main(String[] args) {
        launch();
    }
}
