package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Exercise1 extends Application {
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
        var scene = new Scene(new StackPane(new VBox(table)), 640, 480);
        stage.setScene(scene);
        stage.show();
    }
}
