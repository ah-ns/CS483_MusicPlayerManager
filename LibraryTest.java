/**
 * Library test cases.
 * @author  Hans van Lierop
 * @version 1
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class LibraryTest {

    private Library l;

    /**
     * Initializes a new library for every test case
     */
    @BeforeEach
    void init() {
        l = new Library();
    }

    /**
     * Tests if playlists are added properly to the library
     */
    @Test
    void testAddPlaylist() {
        Playlist p1 = new Playlist(new String("S"));
        Playlist p2 = new Playlist("J");
        l.addPlaylist(p1);
        l.addPlaylist(p2);
        assertSame(p1, l.playlists.get(0));
        assertSame(p2, l.playlists.get(1));
    }

    /**
     * Test if removing an existing playlist works
     */
    @Test
    void testRemoveValidPlaylist() {
        // Use new String to check for == comparing strings
        Playlist p1 = new Playlist(new String("Str"));
        Playlist p2 = new Playlist("J");
        Playlist p3 = new Playlist("r");
        l.addPlaylist(p1);
        l.addPlaylist(p2);
        l.addPlaylist(p3);
        l.removePlaylist("Str");
        l.removePlaylist("J");
        assertSame(p3, l.playlists.get(0));
    }

    /**
     * Test what happens when an invalid playlist is
     * attempted to be removed
     */
    @Test
    void testRemoveInvalidPlaylist() {
        Playlist p1 = new Playlist(new String("S"));
        Playlist p2 = new Playlist("J");
        Playlist p3 = new Playlist("r");
        l.addPlaylist(p1);
        l.addPlaylist(p2);
        l.addPlaylist(p3);
        ArrayList<Playlist> originalList = (ArrayList<Playlist>)l.playlists.clone();
        l.removePlaylist("s");
        // use assert equals because they aren't the same object
        assertEquals(originalList, l.playlists);
    }

    /**
     * Tests if a valid playlist's songs can be viewed
     */
    @Test
    void testViewValidEmptyPlaylist() {
        Playlist p1 = new Playlist(new String("S"));
        Playlist p2 = new Playlist("J");
        Playlist p3 = new Playlist("r");
        l.addPlaylist(p1);
        l.addPlaylist(p2);
        l.addPlaylist(p3);
        Playlist r = l.viewPlaylist("r");
        assertSame(l.playlists.get(2), r);
    }
    
    /**
     * Tests what happens if an invalid playlist's
     * songs are attempted to be viewed
     */
    @Test
    void testViewInvalidPlaylist() {
        Playlist p1 = new Playlist(new String("S"));
        Playlist p2 = new Playlist("J");
        Playlist p3 = new Playlist("r");
        l.addPlaylist(p1);
        l.addPlaylist(p2);
        l.addPlaylist(p3);
        Playlist g = l.viewPlaylist("G");
        assertEquals(null, g);
    }

    /**
     * Test what happens if a playlist somehow becomes null
     * and is attempted to be viewed
     */
    @Test
    void testViewNullPlaylist() {
        Playlist p = new Playlist(new String("a"));
        l.addPlaylist(p);
        Playlist ret = l.viewPlaylist(null);
        assertEquals(null, ret);
    }
    
    /**
     * Test view empty playlist in library
     */
    @Test
    void testViewNonEmptyPlaylist() {
    	Library l = new Library();
    	Playlist p = new Playlist("playlist");
    	p.addSong(new Song("A", "B", 2));
    	
    	l.addPlaylist(p);
    	
        // Set expected output
    	String expected = "Title: AArtist: BDuration: 2.0";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        l.viewPlaylist("playlist");
        
        String[] lines = baos.toString().split(System.lineSeparator());
        String actual = lines[lines.length-3] + lines[lines.length-2] + lines[lines.length-1];

        assertEquals(expected, actual);
    }
    
    /**
     * Test display playlists expected situation
     */
    @Test
    void testDisplayAllPlaylists() {
    	Library l = new Library();
    	l.addPlaylist(new Playlist("playlist"));
    	l.addPlaylist(new Playlist("p3"));
        
        // Set expected output
        String expected = "playlistp3";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        l.displayAllPlaylists();
        
        String[] lines = baos.toString().split(System.lineSeparator());
        String actual = lines[lines.length-2] + lines[lines.length-1];

        assertEquals(expected, actual);
    }
    
    /**
     * Test display playlists empty library
     */
    @Test
    void testDisplayEmptyLibrary() {
    	Library l = new Library();
        
        // Set expected output
        String expected = "There are no playlists.";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        l.displayAllPlaylists();
        
        String[] lines = baos.toString().split(System.lineSeparator());
        String actual = lines[lines.length-1];

        assertEquals(expected, actual);
    }
}
