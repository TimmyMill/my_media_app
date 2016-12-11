package com.timmy;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

//import javafx.scene.media.MediaApp;

public class MediaApp extends Application
{
    Stage window;
    Scene scene;
    BorderPane root;
    TopPane topPane = new TopPane();
    LibraryPane libPane = new LibraryPane();

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Database db = new Database();
        window = primaryStage;
        window.setTitle("My Media App");
        root = new BorderPane();
        root.setTop(topPane);
        root.setLeft(libPane);

        scene = new Scene(root, 400, 300);
        scene.getStylesheets().add("/com/timmy/styles/red-orb.css");
        window.setScene(scene);
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        Double width = primaryScreenBounds.getWidth();
        Double height = primaryScreenBounds.getHeight();
        window.setWidth(width);
        window.setHeight(height);
        setTheme();
        window.show();
    }

    public static void main(String[] args)
    { launch(args); }

    void setTheme()
    {
        topPane.controlsPane.playbackToolBar.setTheme("red-orb.css");
        topPane.controlsPane.soundToolBar.setTheme("red-orb.css");
        topPane.controlsPane.setArtwork("/com/timmy/images/red_orb/48x48/music2.png");
        topPane.controlsPane.setNowPlaying("Now Playing");
        libPane.setTheme("red-orb.css");
    }
}
