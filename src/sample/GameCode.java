package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GameCode extends Application {
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;


    @Override
    public void start(Stage primaryStage) throws Exception{
        GridPane root = new GridPane();
        Scene scene = new Scene(root,500,400);

        root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(10);

        button1 = new Button("1");
        button2 = new Button("2");
        button3 = new Button("3");
        button4 = new Button("4");
        final TextField uname = new TextField();
        uname.setPromptText("test");
        uname.setPrefColumnCount(6);
        uname.getText();

        button1.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        button2.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        button3.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        button4.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        root.add(button1, 0, 0);
        root.add(button2, 2, 0);
        root.add(button3, 0, 2);
        root.add(button4, 2, 2);

        root.add(uname,1,1);

        root.setHgrow(button1, Priority.ALWAYS);
        root.setHgrow(button2, Priority.ALWAYS);
        root.setHgrow(button3, Priority.ALWAYS);
        root.setHgrow(button4, Priority.ALWAYS);

        scene.getStylesheets().add(this.getClass().getResource("display.css").toExternalForm());

        primaryStage.setTitle("Button Game");
        primaryStage.setScene(scene);
        primaryStage.show();

        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                System.out.println("A key was pressed");
                button1.setVisible(false);
            }
        });
    }


    public static void main(String[] args) {
        launch(args);
    }
}
