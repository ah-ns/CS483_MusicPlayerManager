import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class LibraryTest {

    private Library l;

    @BeforeEach
    public void init() {
        l = new Library();
    }

    @Test
    public void testAddPlaylist() {
        Playlist p1 = new Playlist("S");
        Playlist p2 = new Playlist("J");
        l.addPlaylist(p1);
        l.addPlaylist(p2);
        assertSame(p1, l.playlists.get(0));
        assertSame(p2, l.playlists.get(1));
    }

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
}
