package com.timmy;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class ControlsPane extends GridPane
{
    Label artwork;
    Label nowPlaying;
    PlaybackControls playbackToolBar;
    SoundControls soundToolBar;

    public ControlsPane()
    {
        artwork = new Label();
        artwork.setId("artwork");
        // column=0, row=2, colSpan=3, rowSpan=3
        setConstraints(artwork, 0, 2, 3, 3, HPos.CENTER, VPos.BOTTOM);

        nowPlaying = new Label();
        nowPlaying.setId("now-playing");
        // column=3, row=0, colSpan=3, rowSpan=1
        setConstraints(nowPlaying, 3, 0, 3, 1, HPos.CENTER, VPos.TOP);

        playbackToolBar = new PlaybackControls();
        // column=3, row=2, colSpan=3, rowSpan=2
        setConstraints(playbackToolBar, 3, 2, 3, 2, HPos.CENTER, VPos.BOTTOM);

        soundToolBar = new SoundControls();
        // column=6, row=2, colSpan=3, rowSpan=2
        setConstraints(soundToolBar, 6, 2, 3, 2, HPos.RIGHT, VPos.BOTTOM);

        this.getChildren().addAll(artwork, nowPlaying, playbackToolBar, soundToolBar);
        this.setAlignment(Pos.BASELINE_CENTER);
        this.setGridLinesVisible(true); // uncomment for testing
    }

    public void setArtwork(String artwork)
    {
        this.artwork.setGraphic(new ImageView(artwork));
    }

    public void setNowPlaying(String text)
    {
        this.nowPlaying.setText(text);
    }
}
