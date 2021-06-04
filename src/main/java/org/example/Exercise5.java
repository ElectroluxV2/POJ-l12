package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import static org.example.Exercise1.prepareTable;

public class Exercise5 extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        var table = prepareTable();
        var scene = new Scene(new StackPane(new VBox(prepareButton(table), table)), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    static Button prepareButton(TableView<Person> table) {
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

            TextArea textArea = new TextArea(sb.toString());
            textArea.setWrapText(true);
            textArea.setEditable(false);

            alert.getDialogPane().setContent(textArea);

            alert.showAndWait();
        });

        return button;
    }
}
