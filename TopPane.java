package com.timmy;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;

public class TopPane extends BorderPane
{
    AppMenu menu;
    ControlsPane ctrlPane;

    TopPane()
    {
        menu = new AppMenu();
        this.setTop(menu);
        ctrlPane = new ControlsPane();
        ctrlPane.setAlignment(Pos.BASELINE_CENTER);
        this.setCenter(ctrlPane);
    }
}
