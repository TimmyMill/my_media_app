package com.timmy;

import javafx.event.ActionEvent;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;

public class AppMenu extends MenuBar
{
    Menu fileMenu, ctrlMenu;
    MenuItem fileNew, fileOpen, fileAdd, fileExit;
    MenuItem ctrlPlay, ctrlPause, ctrlStop, ctrlPrevious, ctrlNext;

    AppMenu()
    {
        //File AppMenu
        fileMenu = new Menu("_File");
        //Controls AppMenu
        ctrlMenu = new Menu("_Controls");


        //Create menu items that each menu will hold

        //File menu items:
        fileNew = new MenuItem("New");
        fileOpen = new MenuItem("_Open...");
        fileOpen.setAccelerator(new KeyCodeCombination
                (KeyCode.O, KeyCombination.CONTROL_DOWN));
        fileAdd = new MenuItem("Add to Library...");
        fileAdd.setAccelerator(new KeyCodeCombination
                (KeyCode.O, KeyCombination.CONTROL_DOWN, KeyCombination.SHIFT_DOWN));
        fileExit = new MenuItem("E_xit");
        fileExit.setAccelerator(new KeyCodeCombination
                (KeyCode.Q, KeyCombination.CONTROL_DOWN));

        //Control menu items:
        ctrlPlay = new MenuItem("Play");
        ctrlPause = new MenuItem("Pause");
        ctrlStop = new MenuItem("Stop");
        ctrlPrevious = new MenuItem("Previous");
        ctrlNext = new MenuItem("Next");



        fileMenu.getItems().addAll(fileNew, fileOpen, fileAdd, new SeparatorMenuItem(), fileExit);
        ctrlMenu.getItems().addAll(ctrlPlay, ctrlPause, ctrlStop, ctrlPrevious, ctrlNext);
        this.getMenus().addAll(fileMenu, ctrlMenu);
    }

}
