/**
 * Tests the Manager class
 * @author  Hans van Lierop
 * @version 1
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class ManagerTest {
    private Manager m;

    @BeforeEach
    void init() {
        m = new Manager();
    }

    /**
     * Testing for invalid duration, 
     * the duration on songs must be a float
     * 
     * Initially resulted in an infinite scanner.hasNextLine loop
     */
    //@Test
    @Timeout(1)
    void testAddSongInvalidDuration() {
        Playlist p = new Playlist("playlist");
        
        String userInput = String.join(System.lineSeparator(),
            "A", "B", "C",
            "6" // Valid input on reprompt
        );
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);
        m.handleAddSongChoice(new Scanner(System.in), p);
        assertEquals((float)6, p.songs.get(0).getDuration());
    }

    /**
     * Test removal of song from a playlist 
     * through the handler function
     */
    @Test
    void testRemoveSong() {
        Playlist p = new Playlist("playlist");
        Song s = new Song("A", "B", 5);
        p.addSong(s);
        ByteArrayInputStream bais = new ByteArrayInputStream("A".getBytes());
        System.setIn(bais);
        m.handleRemoveSongChoice(new Scanner(System.in), p);
        assertEquals(0, p.songs.size());
    }

    /**
     * Tests invalid view playlist menu option
     * The menu should only accept options 0-3
     */
    @Test
    void testInvalidMenuSelection() {
        Library l = new Library();
        l.addPlaylist(new Playlist("playlist"));
        String userInput = String.join(System.lineSeparator(),
            "playlist", "4", ""
        );
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);
        
        // Set expected output
        String expected = "Invalid choice. Please enter a number between 0 and 3.";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        m.handleViewPlaylistChoice(new Scanner(System.in), l);
        
        String[] lines = baos.toString().split(System.lineSeparator());
        String actual = lines[lines.length-1];

        assertEquals(expected, actual);
    }

    /**
     * Tests exit functionality of the
     * view playlist function
     */
    @Test
    void testExitViewPlaylist() {
        Library l = new Library();
        l.addPlaylist(new Playlist("playlist"));
        String userInput = String.join(System.lineSeparator(),
            "playlist", "0", ""
        );
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);
        
        // Set expected output
        String expected = "\n1- View a Playlist\n2- New Playlist\n3- Remove Playlist\n4- View all playlists\n0- Exit";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        m.handleViewPlaylistChoice(new Scanner(System.in), l);
        
        String[] lines = baos.toString().split(System.lineSeparator());
        String actual = lines[lines.length-1];

        assertEquals(expected, actual);
    }


}
