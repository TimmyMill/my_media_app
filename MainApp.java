package com.timmy;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.stage.Screen;
import javafx.stage.Stage;

import javafx.scene.media.MediaPlayer;

public class MainApp extends Application
{
    static Stage window;
    Scene scene;
//    BorderPane root;
    AudioPlayer root;
//    TopPane topPane = new TopPane(event -> {
//
//    });
    LibraryPane libPane; //= new LibraryPane();
    static Media media;

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Database db = new Database();
        primaryStage.setTitle("My Media App");
        media = new Media("http://download.oracle.com/otndocs/products/javafx/oow2010-2.flv");
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        root = new AudioPlayer(mediaPlayer);

        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        Double width = primaryScreenBounds.getWidth();
        Double height = primaryScreenBounds.getHeight();
        scene = new Scene(root, width, height);
        scene.getStylesheets().add("/com/timmy/styles/red-orb.css");
        primaryStage.setScene(scene);
//        setTheme();
        primaryStage.show();
    }

//    @Override
//    public void start(Stage primaryStage) throws Exception
//    {
//        Database db = new Database();
//        libPane = new LibraryPane();
//        window = primaryStage;
//        window.setTitle("My Media App");
//        root = new BorderPane();
//        root.setLeft(libPane);
//        root.setTop(topPane);
//
//        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
//        Double width = primaryScreenBounds.getWidth();
//        Double height = primaryScreenBounds.getHeight();
//        scene = new Scene(root, width, height);
//        scene.getStylesheets().add("/com/timmy/styles/red-orb.css");
//        window.setScene(scene);
////        setTheme();
//        window.show();
//    }

    public static void main(String[] args)
    { launch(args); }

//    void setTheme()
//    {
//        topPane.controlsPane.playbackToolBar.setTheme("red-orb.css");
//        topPane.controlsPane.soundToolBar.setTheme("red-orb.css");
//        topPane.controlsPane.setArtwork("/com/timmy/images/red_orb/48x48/music2.png");
//        topPane.controlsPane.setNowPlaying("Now Playing");
//        libPane.setTheme("red-orb.css");
//    }
}
