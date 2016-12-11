package com.timmy;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;

public class TopPane extends BorderPane
{
    AppMenu menu;
    ControlsPane controlsPane;

    TopPane()
    {
        menu = new AppMenu();
        this.setTop(menu);
        controlsPane = new ControlsPane();
        this.setCenter(controlsPane);
    }
}
//public class TopPane extends BorderPane
//{
//    AppMenu menu;
//    PlaybackControls playbackToolBar;
//    SoundControls soundToolBar;
//
//    TopPane()
//    {
//        menu = new AppMenu();
//        this.setTop(menu);
//        playbackToolBar = new PlaybackControls();
//        soundToolBar = new SoundControls();
//
//        this.setCenter(playbackToolBar);
//        this.setRight(soundToolBar);
//    }
//}
