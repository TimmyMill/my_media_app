package com.timmy;

import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;

public class PlaybackControls extends ToolBar
{
    Button previousButton, fastRwdButton, playButton, stopButton, fastFwdButton, nextButton;

    PlaybackControls()
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
        this.getItems().addAll(previousButton, fastRwdButton, playButton, stopButton, fastFwdButton, nextButton);
    }

    void setTheme(String style)
    {
        this.getStylesheets().add(this.getClass().getResource("/com/timmy/styles/".concat(style)).toExternalForm());
    }


}
