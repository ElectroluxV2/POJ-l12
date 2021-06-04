package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import static org.example.Exercise1.prepareTable;

public class Exercise2 extends Application {

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
            System.out.println(sb.toString());
        });

        return button;
    }
}
