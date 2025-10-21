/**
 * Playlist test cases.
 * @author  Hans van Lierop
 * @version 1
 */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class PlaylistTest {

    /*
     * Tests if a playlist can be created properly
     */
    @Test
    public void testCreatePlaylist() {
        String name = "abc";
        Playlist p = new Playlist(name);
        // check if playlist created correctly
        assertSame(name, p.name);
    }

    /*
     * Test if songs are added properly and
     * the attributes are preserved
     */
    @Test
    public void testAddSongs() {
        Playlist p = new Playlist("abc");
        Song s1 = new Song(new String("a"), new String("b"), (float)'c');
        Song s2 = new Song("e", "f", (float)'g');
        p.addSong(s1);
        p.addSong(s2);
        // check if the song is the 
        assertSame(s1, p.songs.get(0));
        assertSame(s2, p.songs.get(1));
    } 

    /*
     * Test removal of an existing song in
     * the playlist
     */
    @Test
    public void testRemoveValidSong() {
        Playlist p = new Playlist("abc");
        Song s1 = new Song(new String("a"), "b", (float)'c');
        Song s2 = new Song("e", "f", (float)'g');
        p.addSong(s1);
        p.addSong(s2);
        p.removeSong("a");
        assertSame(s2, p.songs.get(0));
    }

    /*
     * Test removal of a non-existent song
     * in the playlist
     */
    @Test
    public void testRemoveInvalidSong() {
        Playlist p = new Playlist("abc");
        Song s1 = new Song(new String("a"), new String("b"), (float)'c');
        p.addSong(s1);
        ArrayList<Song> originalList = (ArrayList<Song>)p.songs.clone();
        p.removeSong("e");
        // ensure the songs list is the same
        assertEquals(originalList, p.songs);
    }
}
