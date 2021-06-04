package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Exercise2 extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        var table = new TableView<Person>();
        table.getItems().addAll(
                new Person("Jacek", 31, Person.Gender.MALE),
                new Person("Marek", 22, Person.Gender.MALE),
                new Person("Ania", 43, Person.Gender.FEMALE)
        );
        var nameColumn = new TableColumn<Person, String>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        var ageColumn = new TableColumn<Person, Integer>("Age");
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
        var genderColumn = new TableColumn<Person, Person.Gender>("Gender");
        genderColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));
        table.getColumns().addAll(nameColumn, ageColumn, genderColumn);

        table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        var button = new Button("Print info about selected");
        button.setOnMouseClicked(mouseEvent -> {
            var sb = new StringBuilder();
            for(Person p: table.getSelectionModel().getSelectedItems()) {
                sb.append(p.toString());
                sb.append(System.lineSeparator());
            }
            System.out.println(sb);
        });

        var scene = new Scene(new StackPane(new VBox(button, table)), 640, 480);
        stage.setScene(scene);
        stage.show();
    }
}
