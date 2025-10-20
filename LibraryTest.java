/**
 * Library test cases.
 * @author  Hans van Lierop
 * @version 1
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class LibraryTest {

    private Library l;

    /**
     * Initializes a new library for every test case
     */
    @BeforeEach
    public void init() {
        l = new Library();
    }

    /**
     * Tests if playlists are added properly to the library
     */
    @Test
    public void testAddPlaylist() {
        Playlist p1 = new Playlist("S");
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
    public void testRemoveValidPlaylist() {
        Playlist p1 = new Playlist("S");
        Playlist p2 = new Playlist("J");
        Playlist p3 = new Playlist("r");
        l.addPlaylist(p1);
        l.addPlaylist(p2);
        l.addPlaylist(p3);
        l.removePlaylist("S");
        l.removePlaylist("J");
        assertSame(p3, l.playlists.get(0));
    }

    /**
     * Test what happens when an invalid playlist is
     * attempted to be removed
     */
    @Test
    public void testRemoveInvalidPlaylist() {
        Playlist p1 = new Playlist("S");
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
    public void testViewValidPlaylist() {
        Playlist p1 = new Playlist("S");
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
    public void testViewInvalidPlaylist() {
        Playlist p1 = new Playlist("S");
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
    public void testViewNullPlaylist() {
        Playlist p = new Playlist("a");
        l.addPlaylist(p);
        Playlist ret = l.viewPlaylist(null);
        assertEquals(null, ret);
    }
}
