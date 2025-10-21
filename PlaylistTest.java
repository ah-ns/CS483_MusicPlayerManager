/**
 * Playlist test cases.
 * @author  Hans van Lierop
 * @version 1
 */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class PlaylistTest {

    /**
     * Tests if a playlist can be created properly
     */
    @Test
    void testCreatePlaylist() {
        String name = "abc";
        Playlist p = new Playlist(name);
        // check if playlist created correctly
        assertSame(name, p.name);
    }

    /**
     * Test if songs are added properly and
     * the attributes are preserved
     */
    @Test
    void testAddSongs() {
        Playlist p = new Playlist("abc");
        Song s1 = new Song(new String("a"), new String("b"), (float)'c');
        Song s2 = new Song("e", "f", (float)'g');
        p.addSong(s1);
        p.addSong(s2);
        // check if the song is the 
        assertSame(s1, p.songs.get(0));
        assertSame(s2, p.songs.get(1));
    } 

    /**
     * Test removal of an existing song in
     * the playlist
     */
    @Test
    void testRemoveValidSong() {
        Playlist p = new Playlist("abc");
        Song s1 = new Song(new String("a"), "b", (float)'c');
        Song s2 = new Song("e", "f", (float)'g');
        p.addSong(s1);
        p.addSong(s2);
        p.removeSong("a");
        assertSame(s2, p.songs.get(0));
    }

    /**
     * Test removal of a non-existent song
     * in the playlist
     */
    @Test
    void testRemoveInvalidSong() {
        Playlist p = new Playlist("abc");
        Song s1 = new Song(new String("a"), new String("b"), (float)'c');
        p.addSong(s1);
        ArrayList<Song> originalList = (ArrayList<Song>)p.songs.clone();
        p.removeSong("e");
        // ensure the songs list is the same
        assertEquals(originalList, p.songs);
    }
    
    /**
     * Test view songs properly
     */
    @Test
    void testViewSongs() {
    	Playlist p = new Playlist("playlist");
        Song s = new Song("A", "B", 2);
        p.addSong(s);
        
        // Set expected output
        String expected = "Title- AArtist- BDuration- 2.0";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        p.viewSongs();
        
        String[] lines = baos.toString().split(System.lineSeparator());
        String actual = lines[lines.length-3] + lines[lines.length-2] + lines[lines.length-1];

        assertEquals(expected, actual);
    }
    
    /**
     * Test empty playlist view
     */
    @Test
    void testViewEmptyPlaylist() {
    	Playlist p = new Playlist("playlist");
        
        // Set expected output
        String expected = "No songs in your playlist";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        p.viewSongs();
        
        String[] lines = baos.toString().split(System.lineSeparator());
        String actual = lines[lines.length-1];

        assertEquals(expected, actual);
    }
}
