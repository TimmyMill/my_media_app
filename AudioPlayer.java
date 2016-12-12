package com.timmy;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;

public class AudioPlayer extends BorderPane
{
    private MediaPlayer player;
    LibraryPane libraryPane;
    TopPane topPane;


    public AudioPlayer(final MediaPlayer player)
    {
        this.player = player;
        libraryPane = new LibraryPane();
        topPane = new TopPane(this::EventHandler);
        //set nodes
        setTop(topPane);
        setLeft(libraryPane);
        setTheme();
    }

    void EventHandler(ActionEvent event)
    {
        System.out.println(((Button)event.getSource()).getId());
    }

    void setTheme()
    {
        topPane.controlsPane.playbackToolBar.setTheme("red-orb.css");
        topPane.controlsPane.soundToolBar.setTheme("red-orb.css");
        topPane.controlsPane.setArtwork("/com/timmy/images/red_orb/48x48/music2.png");
        topPane.controlsPane.setNowPlaying("Now Playing");
        libraryPane.setTheme("red-orb.css");
    }
}
