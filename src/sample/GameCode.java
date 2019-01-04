package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.util.Timer;
import java.util.TimerTask;

public class GameCode extends Application {
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private TextField uname;
    private int x;
    private boolean gameOn;

    @Override
    public void start(Stage primaryStage) throws Exception{
        GridPane root = new GridPane();
        Scene scene = new Scene(root,500,400);

        root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(10);


        Text text = new Text(0, 0, "Enter a username to start the game. The game will " + System.lineSeparator() + " get progressively harder as the game goes on.");
        uname = new TextField();
        uname.setPromptText("Enter your username here");

        //makes buttons that do things and makes them disappear
        button1 = new Button("1");
        button2 = new Button("2");
        button3 = new Button("3");
        button4 = new Button("4");
        button1.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        button2.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        button3.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        button4.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        button1.setVisible(false);
        button2.setVisible(false);
        button3.setVisible(false);
        button4.setVisible(false);

        //adds things to the scene
        root.add(button1, 0, 0);
        root.add(button2, 2, 0);
        root.add(button3, 0, 2);
        root.add(button4, 2, 2);

        root.add(uname,1,1);
        root.add(text,0,1);

        //makes the button resize; don't really understand but don't touch :D
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
                //opens the game
                button1.setVisible(true);
                button2.setVisible(true);
                button3.setVisible(true);
                button4.setVisible(true);
                root.getChildren().remove(uname);
                root.getChildren().remove(text);
                
                System.out.println(uname.getText());

                gameOn = true;
                while(gameOn){
                    blink(x);
                    x++;
                }
            }
        });
        
    }

    public void blink(int count){
        button1.setStyle("-fx-background-color: #40ff00");
        Timeline timeline = new Timeline(new KeyFrame(
                Duration.millis(200),
                ae -> System.out.println("ping")));
        timeline.setCycleCount(2);
        timeline.play();
        button1.setStyle("-fx-background-color: #33cc00");

        gameOn = false;
    }
    public static void main(String[] args) {
        launch(args);
    }
}
