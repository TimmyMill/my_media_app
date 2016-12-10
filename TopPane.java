package com.timmy;
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
        this.setCenter(ctrlPane);
    }
}
