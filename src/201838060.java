package sample;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;


public class Main extends Application {

    public int CurrentI = 0;
    //the index we are going to use for the array

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Hello World");


        ImageView iv[] = new ImageView[4];

        for (int i = 0; i < 4; i++) {
            iv[i] = new ImageView("file:C:\\Users\\abdlr\\IdeaProjects\\Lab16_201\\src\\sample\\cat" + i + ".jpeg");


            iv[i].setFitHeight(600);
            iv[i].setFitWidth(600);
            iv[i].setPreserveRatio(true);
        }
        //For loop to assign the images for the array of objects imageView


        Button button1 = new Button("Previous");
        button1.setAlignment(Pos.BOTTOM_LEFT);

        Button button2 = new Button("Next");
        button1.setAlignment(Pos.BOTTOM_RIGHT);
        //Defining the previous and next button


        HBox hBox = new HBox(20);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(button1, button2);
        //Grouping the two button in Hbox


        StackPane stack = new StackPane();
        stack.getChildren().add(iv[0]);
        //Using stackpane so I can update the pictures


        BorderPane borderPane = new BorderPane();
        borderPane.setBottom(hBox);
        //The buttons are on the bottom of the borderPane
        borderPane.setCenter(stack);
        //The ImageViewer which is assigned to stackPane are in the center


        Scene scene = new Scene(borderPane, 460, 700);
        //the dimensions of the app


        primaryStage.setScene(scene);
        //assigning the scene to primary stage so it's ready to be shown

        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stack.getChildren().clear();
                //Removing the picture so I can assign a new one
                stack.getChildren().add(iv[del()]);
                //calling the method del so it returns the array array index-1 and show the previous picture

            }
        });

        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stack.getChildren().clear();
                //Removing the picture so I can assign a new one
                stack.getChildren().add(iv[add()]);
                //calling the method add so it returns the array index+1 and show the next picture


            }
        });

        primaryStage.show();
        //it shows the scene we assigned to the primaryStage
    }

    public int add() {
        //if statement that going to check the index is not going out of bound if we add 1
        // in our case 4 out of bound
        if (this.CurrentI + 1 > 3) {
            CurrentI = 0;
            //if it is going out of bound it'll assign the index to 0
            return 0;
        } else return ++CurrentI;
        //if the index is not going out of bound it will return index+1
    }

    public int del() {
        //if statement that going to check the index is not going out of bound after we reduce it by 1
        // in our case -1 is out of bound
        if (this.CurrentI - 1 < 0) {
            CurrentI = 3;
            //if it is going out of bound it'll assign the index to 0
            return 3;
        } else return --CurrentI;
        //if the index is not going out of bound it will return index+1
    }
    

    public static void main(String[] args) {
        launch(args);
    }
}