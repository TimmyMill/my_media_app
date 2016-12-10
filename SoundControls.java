package com.timmy;
import javafx.geometry.Orientation;
import javafx.geometry.Side;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.CustomMenuItem;
import javafx.scene.control.MenuButton;
import javafx.scene.control.Slider;


public class SoundControls extends MenuButton
{
    CustomMenuItem volumeSlider;

    SoundControls()
    {
        this.setId("sound-on");
        volumeSlider = new CustomMenuItem(new VolumeSlider());
        volumeSlider.setHideOnClick(false);
        this.getItems().add(volumeSlider);
        this.setPopupSide(Side.TOP);
    }

    class VolumeSlider extends Slider
    {
        VolumeSlider()
        {
            setOrientation(Orientation.VERTICAL);
        }

    }



    class Volume extends ContextMenu {
        Volume()
        {

        }
    }

    void setTheme(String style)
    { this.getStylesheets().add("/com/timmy/styles/".concat(style)); }
}

//public class SoundControls extends MenuBar
//{
//    MenuButton soundButton;
//    CustomMenuItem volumeSlider;
//
//    SoundControls()
//    {
//        soundButton = new MenuButton();
//        soundButton.setId("sound-on");
//        volumeSlider = new CustomMenuItem(new Slider());
//
//    }
//
//
//
//    class Volume extends ContextMenu {
//        Volume()
//        {
//
//        }
//    }
//}
//public class SoundControls extends ToolBar
//{
//    Button soundButton;
//    Slider volumeSlider;
//
//    SoundControls()
//    {
//        soundButton = new Button();
//        soundButton.setId("sound-on");
//        volumeSlider = new Slider();
//        this.getItems().addAll(soundButton);
//    }
//
//    void volumeMenuItem()
//    {
//        volumeSlider.setOrientation(Orientation.VERTICAL);
//        volumeSlider.setShowTickMarks(false);
//        volumeSlider.setSnapToTicks(false);
//    }
//
//    void setTheme(String style)
//    { this.getStylesheets().add("/com/timmy/styles/".concat(style)); }
//}
