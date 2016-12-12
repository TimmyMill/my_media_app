package com.timmy;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;

public class TopPane extends BorderPane
{
    AppMenu menu;
    ControlsPane controlsPane;

    TopPane(EventHandler<ActionEvent> playbackHandler)
    {
        menu = new AppMenu();
        this.setTop(menu);
        controlsPane = new ControlsPane(playbackHandler);
        this.setCenter(controlsPane);
    }
}
//public class TopPane extends BorderPane
//{
//    AppMenu menu;
//    PlaybackBar playbackToolBar;
//    SoundBar soundToolBar;
//
//    TopPane()
//    {
//        menu = new AppMenu();
//        this.setTop(menu);
//        playbackToolBar = new PlaybackBar();
//        soundToolBar = new SoundBar();
//
//        this.setCenter(playbackToolBar);
//        this.setRight(soundToolBar);
//    }
//}
