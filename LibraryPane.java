package com.timmy;
import javafx.geometry.Orientation;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.VBox;

public class LibraryPane extends VBox
{
    Label paneTitle;
    ToolBar libraryToolBar;
    ToggleButton artists, albums, songs, genres;
    ToggleGroup libraryGroup;

    LibraryPane()
    {
        paneTitle = new Label("My Music");
        artists = new ToggleButton("Artists");
        artists.setId("artists");
        albums = new ToggleButton("Albums");
        albums.setId("albums");
        songs = new ToggleButton("Songs");
        songs.setId("songs");
        genres = new ToggleButton("Genres");
        genres.setId("genres");

        libraryGroup = new ToggleGroup();
        artists.setToggleGroup(libraryGroup);
        albums.setToggleGroup(libraryGroup);
        songs.setToggleGroup(libraryGroup);
        genres.setToggleGroup(libraryGroup);

        libraryToolBar = new ToolBar(artists, albums, songs, genres);
        libraryToolBar.setId("library-tool-bar");
        libraryToolBar.setOrientation(Orientation.VERTICAL);
//        libraryToolBar.getStylesheets().addAll(
//                this.getClass().getResource("/com/timmy/styles/red-orb.css").toExternalForm());
        this.getChildren().addAll(paneTitle, libraryToolBar);
    }

    void setTheme(String style)
    { this.getStylesheets().add("/com/timmy/styles/".concat(style)); }
}
