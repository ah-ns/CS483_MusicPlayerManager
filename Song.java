/**
 * The Song class stores and returns the details of a song, including the song title, artist/singer, and the duration of the song.
 * @since 10-4-2025
 */

public class Song {
  private String title;
  private String artist;
  private float duration;

  public Song(String title, String artist, float duration) {
    this.title = title;
    this.artist = artist;
    this.duration = duration;
  }

  /**
   * Returns the title of the song.
   * @return the title of the song
   */
  public String getTitle() {
    return title;
  }

  /**
   * Returns the artist/singer of the song.
   * @return the artist/singer of the song
   */
  public String getArtist() {
    return artist;
  }

  /**
   * Returns the duration of the song.
   * @return the duration of the song
   */
  public float getDuration() {
    return duration;
  }
}