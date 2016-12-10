package com.timmy;
import java.io.File;
import java.io.FileInputStream;
import org.sqlite.util.OSInfo;
import java.sql.*;
import java.util.ArrayList;


public class Database
{
    private final static String JDBC_DRIVER = "org.sqlite.JDBC";
    private final static String DB_URL = "jdbc:sqlite:my_library.db";
    ResultSet rs = null;
    private static ArrayList<Object> libraryList;

    public Database()
    {
        libraryList = new ArrayList<>();
        this.initDB();
    }

    void loadDriver()
    {
        try
        {
            Class.forName(JDBC_DRIVER);
        }

        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    void initDB()
    {
        loadDriver();
        try (Connection dbConnection = DriverManager.getConnection(DB_URL);
             Statement statement = dbConnection.createStatement())
        {
            //Create songs table in the database if it doesn't exist
            String createTableSQL =
                    "CREATE TABLE songs " +
                    "(paneTitle TEXT NOT NULL," +
                    " artist TEXT NOT NULL," +
                    " album TEXT NOT NULL," +
                    " path TEXT NOT NULL)";
            statement.executeUpdate(createTableSQL);
            this.loadMusicLibrary(statement);
        }

        catch (SQLException sqlE)
        {
            System.out.println();
        }
    }

    void loadMusicLibrary(Statement statement)
    {
        try
        {
            String fetchAllSongs = "SELECT * FROM songs ";
            rs = statement.executeQuery(fetchAllSongs);
            while (rs.next())
            {
                String path = rs.getString("path");
                File file = new File(path);
                libraryList.add(file);
            }
        }

        catch (SQLException sqlE)
        {
            System.out.println();
        }
    }
}
