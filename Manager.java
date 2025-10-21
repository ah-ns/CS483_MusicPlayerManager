import java.util.Scanner;

/**
 * The Manager class asks the user for the necessary input and runs the program. It allows the user to choose between different functions of the Music Player Manager program.
 * @since 10-4-2025
 */

public class Manager {
  /**
   * Asks the user to choose which functions to perform and performs it.
   */
  public static void main(String[] args) {
    Library library = new Library();
    Scanner scanner = new Scanner(System.in);

    int choice = 0;
  
    do {
      System.out.println("\n1- View a Playlist\n2- New Playlist\n3- Remove Playlist\n4- View all playlists\n0- Exit");

      while (scanner.hasNextLine()) {
        if (scanner.hasNextInt()) {
          choice = scanner.nextInt();
          scanner.nextLine();
          if (choice >= 0 && choice <= 4) break;
          else System.out.println("Invalid choice. Please enter a number between 0 and 4.");
        } else {
          System.out.println("Invalid input. Please enter a number.");
          scanner.nextLine();
        }
      }

      switch (choice) {
        case 1:
          handleViewPlaylistChoice(scanner, library);
          break;
        case 2:
          handleNewPlaylistChoice(scanner, library);
          break;
        case 3:
          handleRemovePlaylistChoice(scanner, library);
          break;
        case 4:
          library.displayAllPlaylists();
          break;
        default:
          break;
      }
    } while (choice != 0);
    scanner.close();
  }

  /**
   * Handles the option to view a specific playlist.
   * After the songs of the specific playlist are displayed, new options to add, remove, or view the songs within the playlist are presented.
   * @param scanner Whatever input the user enters
   * @param library The library where all the playlists are in
   */
  public static void handleViewPlaylistChoice(Scanner scanner, Library library) {
    Playlist currentPlaylist;
    String playlistName = "";

    if (library.playlists.isEmpty()) System.out.println("There are no playlists to view.");
    else {
      System.out.println("Enter the playlist's name: ");
      playlistName = scanner.nextLine();
      currentPlaylist = library.viewPlaylist(playlistName);

      int choice2 = 0;
      do {
        System.out.println("Now viewing the playlist, " + currentPlaylist.name + ", choose from the following: ");
        System.out.println("\n1- Add song\n2- Remove song\n3- View all songs\n0- Go Back");

        while (scanner.hasNextLine()) {
          if (scanner.hasNextInt()) {
            choice2 = scanner.nextInt();
            if (scanner.hasNextLine())
              scanner.nextLine();
            if (choice2 >= 0 && choice2 <= 3) break;
            else System.out.println("Invalid choice. Please enter a number between 0 and 3.");
          } else {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine();
          }
        }

        switch (choice2) {
          case 1:
            handleAddSongChoice(scanner, currentPlaylist);
            break;
          case 2:
            handleRemoveSongChoice(scanner, currentPlaylist);
            break;
          case 3:
            currentPlaylist.viewSongs();
            break;
          default:
            break;
        }
      } while (choice2 != 0);
    }
  }

  /**
   * Handles the option to remove a specific playlist by name.
   * @param scanner Whatever input the user enters
   * @param library The library where all the playlists are in
   */
  public static void handleRemovePlaylistChoice(Scanner scanner, Library library) {
    if (library.playlists.isEmpty()) System.out.println("There are no playlists to remove.");
    else {
      System.out.println("Enter the playlist's name to remove: ");
      String playlistName = scanner.nextLine();
      library.removePlaylist(playlistName);
    }
  }

  /**
   * Handles the option to create a new playlist.
   * @param scanner Whatever input the user enters
   * @param library The library where all the playlists are in
   */
  public static void handleNewPlaylistChoice(Scanner scanner, Library library) {
    System.out.println("Enter Playlist Name: ");
    String name = scanner.nextLine();

    Playlist playlist = new Playlist(name);
    library.addPlaylist(playlist);
  }

  /**
   * Handles the option to add a new song and its details (title, artist, duration) to a specific playlist.
   * @param scanner Whatever input the user enters
   * @param playlist The current playlist the user is viewing (after choosing to view a specific playlist)
   */
  public static void handleAddSongChoice(Scanner scanner, Playlist playlist) {
    System.out.println("Enter the details of the song.");

    System.out.print("Title: ");
    String title = scanner.nextLine();
    
    System.out.print("Artist: ");
    String artist = scanner.nextLine();

    System.out.print("Duration: ");
    float duration = 0;

    while (scanner.hasNextLine()) {
      if (scanner.hasNextFloat()) {
        duration = scanner.nextFloat();
        break;
      } else {
        System.out.println("Invalid Duration. Please enter a number: ");
        scanner.nextLine();
      }
    }
    
    Song newSong = new Song(title, artist, duration);
    playlist.addSong(newSong);
  }

  /**
   * Handles the option to remove a song from a specific playlist.
   * @param scanner Whatever input the user enters
   * @param playlist The current playlist the user is viewing (after choosing to view a specific playlist)
   */
  public static void handleRemoveSongChoice(Scanner scanner, Playlist playlist) {
    System.out.println("Enter title to remove: ");
    String title = scanner.nextLine();
    playlist.removeSong(title);
  }
}