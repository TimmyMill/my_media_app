package com.timmy;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;
import javafx.util.Duration;

public class AudioPlayer extends BorderPane
{
    private MediaPlayer player;
    LibraryPane libraryPane;
    TopPane topPane;
    Duration songDuration;


    public AudioPlayer(final MediaPlayer player)
    {
        this.player = player;
        libraryPane = new LibraryPane();
        // create an event handler for top pane
        topPane = new TopPane(event ->
        {
            // this will be used to get the player's current state
            Status status = player.getStatus();
            switch (((Button) event.getSource()).getId())
            {
                //back
                case "previous":
                {
                    break;
                }
                //rewind
                case "fast-rewind":
                {
                    break;
                }
                //play-pause
                case "play-pause":
                {
                    if (status == Status.UNKNOWN         // player status is unknown immediately after creation
                            || status == Status.HALTED)  // player status is halted when a critical error has occurred
                    {
                        return;
                    }

                    if (status == Status.READY            // player status is ready when it's prepared to play
                            || status == Status.PAUSED    // player status is paused when playback is paused
                            || status == Status.STOPPED)  // player status is stopped when playback is paused
                    {
                        //TODO: Add if statement to check if the song is over
                        // and if we're on repeat, shuffle, end of album
                        player.play();
                    }

                    else
                    {
                        player.pause();
                    }

                    break;
                }
                //stop
                case "stop":
                {
                    if (status == Status.PLAYING
                            || status == Status.PAUSED
                            || status == Status.STALLED)
                    {
                        player.stop();
                    }

                    break;
                }
                //forward
                case "next":
                {
                    break;
                }
                //fast fwd
                case "fast-forward":
                {
                    break;
                }
            }
        });

        //set nodes
        setTop(topPane);
        setLeft(libraryPane);
        setTheme();

        player.setOnReady(new Runnable() {
            @Override
            public void run() {
                songDuration = player.getMedia().getDuration();
            }
        });

        player.setOnPlaying(new Runnable() {
            @Override
            public void run() {
                topPane.controlsPane.playbackToolBar.updatePlayButton(player.getStatus());
            }
        });

        player.setOnPaused(new Runnable() {
            @Override
            public void run() {
                topPane.controlsPane.playbackToolBar.updatePlayButton(player.getStatus());
            }
        });

        player.setOnStopped(new Runnable() {
            @Override
            public void run() {

            }
        });
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


//Current\Next  READY       PAUSED      PLAYING             STALLED         STOPPED
//UNKNOWN       pre-roll
//READY                                 autoplay; play()
//PAUSED			                    play()		                        stop()
//PLAYING                   pause()	                        buffering data	stop()
//STALLED		            pause()	    data buffered		                stop()
//STOPPED		            pause()	    play()
