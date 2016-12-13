package com.timmy;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.image.ImageView;
import javafx.scene.media.MediaPlayer.Status;
import java.util.ArrayList;
import java.util.Arrays;

public class PlaybackBar extends ToolBar
{
    final Button previousButton, fastRwdButton, playButton, stopButton, fastFwdButton, nextButton;
    final EventHandler<ActionEvent> playbackHandler;
    ArrayList<Button> buttonList;
    final ImageView playerPlayImg, playerPauseImg;

    PlaybackBar(EventHandler<ActionEvent> playbackHandler)
    {
        playerPlayImg = new ImageView("/com/timmy/images/red_orb/32x32/playerPlay.png");
        playerPauseImg = new ImageView("/com/timmy/images/red_orb/32x32/playerPause.png");

        previousButton = new Button();
        previousButton.setId("previous");

        fastRwdButton = new Button();
        fastRwdButton.setId("fast-rewind");

        playButton = new Button();
        playButton.setId("play-pause");
        // set this by default when the player is created since the other ones are controlled in CSS
        playButton.setGraphic(playerPlayImg);

        stopButton = new Button();
        stopButton.setId("stop");

        fastFwdButton = new Button();
        fastFwdButton.setId("fast-forward");

        nextButton = new Button();
        nextButton.setId("next");

        this.playbackHandler = playbackHandler;

        buttonList = new ArrayList<>
                (Arrays.asList(                        previousButton,
                        fastRwdButton,
                        playButton,
                        stopButton,
                        fastFwdButton,
                        nextButton));

        buttonList.forEach(button1 -> button1.setOnAction(playbackHandler));  // add event handler for each button
        buttonList.forEach(button -> button.setPadding(Insets.EMPTY));        // remove padding from each button
        for (Button btn : buttonList) this.getItems().add(btn);               // add each button to toolbar
        this.setId("playback-bar");

    }

    void updatePlayButton(Status audioStatus)
    {
        if (audioStatus == Status.READY
                || audioStatus == Status.PAUSED
                || audioStatus == Status.STOPPED)
        {
            playButton.setGraphic(playerPlayImg);
        }

        if (audioStatus == Status.PAUSED)
        {
            playButton.setGraphic(playerPauseImg);
        }
    }


    void setTheme(String style)
    { this.getStylesheets().add(this.getClass().getResource("/com/timmy/styles/".concat(style)).toExternalForm()); }


}
