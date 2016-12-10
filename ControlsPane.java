package com.timmy;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.HBox;

public class ControlsPane extends HBox
{
    ToolBar playbackToolBar;
    Button previousButton;
    Button playButton;
    Button nextButton;

    public ControlsPane()
    {
        previousButton = new Button();
        previousButton.setId("previous");
        playButton = new Button();
        playButton.setId("play");
        nextButton = new Button();
        nextButton.setId("next");
        playbackToolBar = new ToolBar(previousButton, playButton, nextButton);
        playbackToolBar.getStylesheets().addAll
                (this.getClass().getResource("/com/timmy/styles/main.css").toExternalForm());

        this.getChildren().addAll(playbackToolBar);
    }

}
