package org.example;

import javafx.application.Application;
import javafx.stage.Stage;

import static org.example.Exercise1.prepareTable;

public class Exercise3 extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        var table = prepareTable();
    }



    public static void main(String[] args) {
        launch();
    }
}
