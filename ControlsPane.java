package com.timmy;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.HBox;

public class ControlsPane extends HBox
{
    ToolBar playbackToolBar, soundToolBar;
    Button previousButton, fastRwdButton, playButton, stopButton, fastFwdButton, nextButton;
    Button soundButton;

    public ControlsPane()
    {
        previousButton = new Button();
        previousButton.setId("previous");
        fastRwdButton = new Button();
        fastRwdButton.setId("fast-rewind");
        playButton = new Button();
        playButton.setId("play");
        stopButton = new Button();
        stopButton.setId("stop");
        fastFwdButton = new Button();
        fastFwdButton.setId("fast-forward");
        nextButton = new Button();
        nextButton.setId("next");

        playbackToolBar = new ToolBar(previousButton, fastRwdButton, playButton, stopButton, fastFwdButton, nextButton);
        playbackToolBar.getStylesheets().addAll
                (this.getClass().getResource("/com/timmy/styles/red-orb.css").toExternalForm());

        soundButton = new Button();
        soundButton.setId("sound-on");
        soundToolBar = new ToolBar(soundButton);
        soundToolBar.getStylesheets().addAll
                (this.getClass().getResource("/com/timmy/styles/red-orb.css").toExternalForm());

        this.getChildren().addAll(playbackToolBar, soundToolBar);
    }
}
