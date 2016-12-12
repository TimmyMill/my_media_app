package com.timmy;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Screen;

public class LibraryPane extends VBox
{
    Label paneTitle;
    ToolBar libraryToolBar;
    ToggleButton artists, albums, songs, genres;
    ToggleGroup libraryGroup;
    Rectangle2D screenDimensions;

    LibraryPane()
    {
        paneTitle = new Label("My Music");
        setMargin(paneTitle, new Insets(8, 10, 2, 8));

        artists = new ToggleButton("Artists");
        artists.setId("artists");
        artists.setAlignment(Pos.TOP_LEFT);
        artists.setMaxWidth(Double.MAX_VALUE);

        albums = new ToggleButton("Albums");
        albums.setId("albums");
        albums.setMaxWidth(Double.MAX_VALUE);
        albums.setAlignment(Pos.TOP_LEFT);

        songs = new ToggleButton("Songs");
        songs.setId("songs");
        songs.setMaxWidth(Double.MAX_VALUE);
        songs.setAlignment(Pos.TOP_LEFT);

        genres = new ToggleButton("Genres");
        genres.setId("genres");
        genres.setMaxWidth(Double.MAX_VALUE);
        genres.setAlignment(Pos.TOP_LEFT);

        libraryGroup = new ToggleGroup();
        artists.setToggleGroup(libraryGroup);
        albums.setToggleGroup(libraryGroup);
        songs.setToggleGroup(libraryGroup);
        genres.setToggleGroup(libraryGroup);

        libraryToolBar = new ToolBar(artists, albums, songs, genres);
        libraryToolBar.setId("library-tool-bar");
        libraryToolBar.setOrientation(Orientation.VERTICAL);
        libraryToolBar.setMaxWidth(Double.MAX_VALUE);
        libraryToolBar.setPrefWidth(Double.MAX_VALUE);

//        setMargin(libraryToolBar, new Insets(8, 10, 6, 2));  //top, right, bottom, left
//        this.setPadding(new Insets(8, 10, 6, 2));
//        this.setSpacing(10);
        screenDimensions = Screen.getPrimary().getVisualBounds();
        Double width = screenDimensions.getWidth();
        this.setPrefWidth(width * .15);  //set the preferred width to 15% of the screen's width
        setVgrow(libraryToolBar, Priority.ALWAYS);
        this.setId("library");
        this.getChildren().addAll(paneTitle, libraryToolBar);
    }

    void setTheme(String style)
    { this.getStylesheets().add("/com/timmy/styles/".concat(style)); }
}
