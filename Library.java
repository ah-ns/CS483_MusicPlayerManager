import java.util.ArrayList;

/**
 * The Library class stores a list of playlists and performs functions such as adding a new playlist, deleting a playlist, viewing a specific playlist & its songs, and viewing the titles of each playlist.
 * @since 10-4-2025
 */

public class Library {
  ArrayList<Playlist> playlists = new ArrayList<Playlist>();

  /**
   * Adds a new playlist to the music library.
   * @param newPlaylist The new playlist the user wants to add
   */
  public void addPlaylist(Playlist newPlaylist) {
    playlists.add(newPlaylist);
  }

  /**
   * Removes a playlist by name.
   * @param name The name of the playlist the user wants to remove
   */
  public void removePlaylist(String name) {
    boolean playlistFound = false;
    for (int i = 1; i < playlists.size(); i++) {
      if (playlists.get(i).name == (name)) {
        playlistFound = true;
        playlists.remove(i);
      }
    }
    if (!playlistFound) System.out.println("No playlist found of that name.");
  }

  /**
   * Finds the playlist within the library by name and lists out all the songs within it.
   * @param name The name of the playlist the user wants to view
   * @return The current playlist being viewed
   */
  public Playlist viewPlaylist(String name) {
    boolean playlistFound = false;

    for (int i = 0; i < playlists.size(); i++) {
      Playlist currentPlaylist = playlists.get(i);

      if (currentPlaylist.name.equals(name)) {
        playlistFound = true;

        if (currentPlaylist.songs.isEmpty()) {
          System.out.println("Playlist found! No songs in this playlist.");
        } else {
          System.out.println("Playlist found! Songs in the playlist include: \n");

          for (int j = 0; j < currentPlaylist.songs.size(); j++) {
            Song currentSong = currentPlaylist.songs.get(j);
            System.out.println("Title: " + currentSong.getTitle());
            System.out.println("Artist: " + currentSong.getArtist());
            System.out.println("Duration: " + currentSong.getDuration());
            System.out.println();
          }
        }
        return currentPlaylist;
      }
    }
    if (!playlistFound || playlists.isEmpty()) System.out.println("No playlist found of that name.");
    return null;
  }

  /**
   * Displays the titles of all the playlists in the library.
   */
  public void displayAllPlaylists() {
    System.out.println("All Playlist Names: ");
    int totalPlaylists = playlists.size();
    System.out.println("Total Playlists: " + totalPlaylists);

    for (Playlist playlist: playlists) {
      System.out.println(playlist.name);
    }
    if (playlists.isEmpty()) System.out.println("There are no playlists.");
  }
}