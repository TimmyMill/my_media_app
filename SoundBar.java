package com.timmy;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.Arrays;


public class SoundBar extends ToolBar
{
    CustomMenuItem volumeSlider;
    Button repeatButton, shuffleButton;
    SoundButton soundButton;
    ArrayList<Node> itemList;

    SoundBar()
    {
        this.repeatButton = new Button();
        this.repeatButton.setId("repeat");

        this.shuffleButton = new Button();
        this.shuffleButton.setId("shuffle");

        this.soundButton = new SoundButton();

        itemList = new ArrayList<>(Arrays.asList(repeatButton, shuffleButton, soundButton));
        itemList.forEach(Node -> setPadding(Insets.EMPTY));
        for (Node item : itemList) this.getItems().add(item);
        this.setId("sound-bar");
    }

    class SoundButton extends MenuButton
    {
        SoundButton()
        {
            volumeSlider = new CustomMenuItem(new VolumeSlider());
            volumeSlider.setHideOnClick(false);
            this.setPopupSide(Side.TOP);
            this.getItems().add(volumeSlider);
            this.setId("sound-on");
        }
    }

    class VolumeSlider extends Slider
    {
        VolumeSlider()
        {
            setOrientation(Orientation.VERTICAL);
            setPrefWidth(32);
        }
    }

    void setTheme(String style)
    { this.getStylesheets().add("/com/timmy/styles/".concat(style)); }
}
