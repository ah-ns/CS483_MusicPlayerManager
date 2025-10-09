import java.util.ArrayList;

/**
 * The Playlist class stores a list of songs and performs functions such as adding a song, removing a song, and viewing all songs within the playlist.
 * @since 10-4-2025
 */

public class Playlist {
  String name;
  ArrayList<Song> songs = new ArrayList<Song>();

  public Playlist(String playlistName) {
    this.name = playlistName;
  }

  /**
   * Adds a new song to the playlist that includes the title, artist, and duration.
   * @param newSong The song that is added
   */
  public void addSong(Song newSong) {
    songs.add(newSong);
    System.out.println("Song added!");
  }

  /**
   * Removes a song from the playlist by asking for the song title and searching through the playlist to find and remove it.
   * @param songTitle The song title of the song the user wants to remove
   */
  public void removeSong(String songTitle) {
    boolean songFound = false;
    for (int i = 0; i <= songs.size(); i++) {
      String playlistName = songs.get(i).getTitle();
      if (playlistName == (songTitle)) {
        songFound = true;
        songs.remove(i);
        System.out.println("Song removed!");
      }
    }
    if (!songFound) System.out.println("Song not found in this playlist.");
  }

  /**
   * Views all songs and their details (title, artist, duration) by looping through the songs saved and displaying them.
   */
  public void viewSongs() {
    if (songs.isEmpty()) System.out.println("No songs in your playlist");
    else {
      System.out.println("Playlist:");

      int totalSongs = songs.size();
      System.out.println("Total Songs: " + totalSongs + "\n");
      
      for (Song song : songs) {
        System.out.println("Title- " + song.getTitle());
        System.out.println("Artist- " + song.getArtist());
        System.out.println("Duration- " + song.getDuration());
        System.out.println();
      }
    }
  }
}