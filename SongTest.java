import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SongTest {
    @Test
    public void testCreateSong() {
        String title = "a";
        String artist = "b";
        float duration = (float)'c';
        Song s = new Song(title, artist, duration);
        // Check that each attribute is as expected
        assertEquals(title, s.getTitle());
        assertEquals(artist, s.getArtist());
        // Add delta value at end for comparing floats
        assertEquals(duration, s.getDuration(), .0001);
    }
}
