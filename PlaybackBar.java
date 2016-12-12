package com.timmy;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;

import java.util.ArrayList;
import java.util.Arrays;

public class PlaybackBar extends ToolBar
{
    Button previousButton, fastRwdButton, playButton, stopButton, fastFwdButton, nextButton;
    ArrayList<Button> buttonList;

    PlaybackBar()
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

        buttonList = new ArrayList<>
                (Arrays.asList(
                        previousButton,
                        fastRwdButton,
                        playButton,
                        stopButton,
                        fastFwdButton,
                        nextButton));

        buttonList.forEach(button -> button.setPadding(Insets.EMPTY));  //remove padding from each button
        for (Button btn : buttonList) this.getItems().add(btn);         //add each button to toolbar
        this.setId("playback-bar");
    }

    void setTheme(String style)
    { this.getStylesheets().add(this.getClass().getResource("/com/timmy/styles/".concat(style)).toExternalForm()); }


}
