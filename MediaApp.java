package com.timmy;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

//import javafx.scene.media.MediaApp;

public class MediaApp extends Application
{
    Stage window;
    Scene scene;
    BorderPane root;
//    ControlsPane ctrlPane = new ControlsPane();
//    AppMenu menu = new AppMenu();
    TopPane topPane = new TopPane();

    public static void main(String[] args)
    { launch(args); }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Database db = new Database();
        window = primaryStage;
        window.setTitle("My Media App");
        root = new BorderPane();
        root.setTop(topPane);

        scene = new Scene(root, 400, 300);
        window.setScene(scene);
        window.show();
    }
}
