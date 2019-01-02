package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.awt.*;
import java.awt.event.ActionEvent;

public class GameCode extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        GridPane root = new GridPane();
        Scene scene = new Scene(root,500,400);

        root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(10);
        for(int i = 0 ; i < 4 ; i++) {
            root.add(new Button(), i, 0);
        }

        scene.getStylesheets().add(this.getClass().getResource("display.css").toExternalForm());
        primaryStage.setTitle("Button Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
