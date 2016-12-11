package com.timmy;
import javafx.geometry.Orientation;
import javafx.geometry.Side;
import javafx.scene.control.*;


public class SoundControls extends ToolBar
{
    CustomMenuItem volumeSlider;
    Button repeatButton, shuffleButton;
    SoundButton soundButton;

    SoundControls()
    {
        this.repeatButton = new Button();
        this.repeatButton.setId("repeat");
        this.shuffleButton = new Button();
        this.shuffleButton.setId("shuffle");
        this.soundButton = new SoundButton();
        this.getItems().addAll(repeatButton, shuffleButton, soundButton);
    }

    class SoundButton extends MenuButton
    {
        SoundButton()
        {
            this.setId("sound-on");
            volumeSlider = new CustomMenuItem(new VolumeSlider());
            volumeSlider.setHideOnClick(false);
            this.getItems().add(volumeSlider);
            this.setPopupSide(Side.TOP);
        }
    }

    class VolumeSlider extends Slider
    {
        VolumeSlider()
        {
            setOrientation(Orientation.VERTICAL);
        }
    }

    void setTheme(String style)
    { this.getStylesheets().add("/com/timmy/styles/".concat(style)); }
}
