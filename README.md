# Music Player Manager
## Usage
1. Compile Program: javac Manager.java
2. Run the Program: java Manager
3. Follow on-screen menu options:
  * View a playlist
  * Create a new playlist
  * Remove a playlist
  * View all playlists
  * Exit Program
4. When viewing a playlist, you can:
  * Add a song
  * Remove a song
  * View all songs
  * Go back to original menu

## Assumptions
1. Inputs are entered correctly (durations are numeric, names are valid strings, choices are valid).
2. Song details don't need to be unique (different playlist can contain same song).
3. Each playlist has a unique name.

## Examples
Example 1: Creating a new playlist (Choice 2)
```
Enter Playlist Name:
Chill Vibes
```
Example 2: Viewing a playlist (Choice 1)
```
Enter the playlist's name:
Chill Vibes

Playlist found! No songs in this playlist.
Now viewing the playlist, Chill Vibes, choose from the following:

1- Add song
2- Remove song
3- View all songs
0- Go Back
```
Example 3: Add a song
```
Enter the details of the song.
Title: Summertime
Artist: Ella 
Duration: 3.5
Song added!
```
Example 4: Remove a song
```
Enter title to remove:
Summertime
Song removed!
```