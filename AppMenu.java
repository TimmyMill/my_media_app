package com.timmy;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.MediaPlayer;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class AppMenu extends MenuBar //implements EventHandler
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
        fileOpen.setId("open");
        fileOpen.setAccelerator(new KeyCodeCombination
                (KeyCode.O, KeyCombination.CONTROL_DOWN));
        fileOpen.setOnAction(this::handleFiles);

        fileAdd = new MenuItem("Add to Library...");
        fileAdd.setId("add");
        fileAdd.setAccelerator(new KeyCodeCombination
                (KeyCode.O, KeyCombination.CONTROL_DOWN, KeyCombination.SHIFT_DOWN));
        fileAdd.setOnAction(this::handleFiles);

        fileExit = new MenuItem("E_xit");
        fileExit.setAccelerator(new KeyCodeCombination
                (KeyCode.Q, KeyCombination.CONTROL_DOWN));
        fileExit.setOnAction(event -> exit());

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

    void handleFiles(Event event)
    {
        FileChooser chooser = new FileChooser();
        File selectedFile;
        List<File> files;

        switch (((MenuItem)event.getSource()).getId())
        {
            case "open":
            {
                chooser.setTitle("Open");
                try
                {
                    chooser.setInitialDirectory(new File(System.getProperty("user.home") + "/Music"));
                    selectedFile = chooser.showOpenDialog(MediaApp.window);
                    if (selectedFile != null)
                        openFile(selectedFile);
                }

                catch (IllegalArgumentException e)
                {
                    chooser.setInitialDirectory(new File(System.getProperty("user.home")));
                    selectedFile = chooser.showOpenDialog(MediaApp.window);
                    if (selectedFile != null)
                         openFile(selectedFile);
                    System.out.println("Here");
                }

                break;

            }

            case "add":
            {
                //TODO Figure out how to add more than one file without dialog box closing
                chooser.setTitle("Add");
                try
                {
                    chooser.setInitialDirectory(new File(System.getProperty("user.home") + "/Music"));
                    files = chooser.showOpenMultipleDialog(MediaApp.window);
                    if (files != null)
                        addFile(files);
                    System.out.println("Add try");
                }

                catch (IllegalArgumentException e)
                {
                    chooser.setInitialDirectory(new File(System.getProperty("user.home")));
                    files = chooser.showOpenMultipleDialog(MediaApp.window);
                    if (files != null)
                        addFile(files);
                    System.out.println("Add caught");
                }

                break;

            }
        }

    }

    void openFile(File file)
    {
        AudioFile af = new AudioFile(file);
        MediaPlayer mp = new MediaPlayer(af.getMedia());
        mp.play();
    }

    void addFile(List<File> files)
    {
        files.forEach(file -> System.out.println(file.getAbsolutePath()));

        files.forEach(Database::addToLibrary);
//        Consumer<File> consumer = File::getPath;
//        files.forEach(consumer.andThen(System.out::println));
    }

    void exit() { System.exit(0); }

}
