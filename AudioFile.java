package com.timmy;
import javafx.scene.media.Media;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.parser.mp3.Mp3Parser;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class AudioFile
{
    private String title;
    private String artist;
    private String album;
    private String genre;
    private String path;
    private File file;
    private ArrayList<String> songInfo;
    private Media media;

    AudioFile(File file)
    {
        this.file = file;
        this.path = formatPath(this.file);
        media = new Media(path);
        songInfo = new ArrayList<>();
        getSongData();
    }

    /* Method to parse metadata and retrieve useful information from an audio file
    * used this tutorial to help understand how to get metadata
    *   - https://www.youtube.com/watch?v=OrwO_Q4QJNc
    *
    * code is modified to function the way I want it to in my program
    */
    private void getSongData()
    {
        try (InputStream input = new FileInputStream(file))
        {
            DefaultHandler handler = new DefaultHandler();
            Metadata metadata = new Metadata();
            Parser parser = new Mp3Parser();
            ParseContext parseCon = new ParseContext();
            parser.parse(input, handler, metadata, parseCon);

            title = metadata.get("title");
            artist = metadata.get("xmpDM:artist");
            album = metadata.get("xmpDM:album");
            genre = metadata.get("xmpDM:genre");

            songInfo.add(title);
            songInfo.add(artist);
            songInfo.add(album);
            songInfo.add(genre);
        }

        catch (IOException | SAXException | TikaException e)
        {
            e.printStackTrace();
        }
    }

    private String formatPath(File file) { return String.format("file://%s", file.getAbsoluteFile()); }



    //Getters
    public String getTitle() {return title;}
    public String getArtist() {return artist;}
    public String getAlbum() {return album;}
    public String getGenre() {return genre;}
    public String getPath() {return path;}
    public Media getMedia() { return media; }
    public File getFile() {return file;}
    public ArrayList<String> getSongInfo() {return songInfo;}
}
