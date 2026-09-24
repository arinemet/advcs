// Runner Class
// Create a Song List Manager using the DLList object you created.  The program will start with 5 songs of your choice with at least 2 songs having the same artists.  It will repeat indefinitely until the user quits and will ask the user for the following choice.

// Add a new song.
// Display song List.  The list will be numbered and displayed in the following format starting at 1.
// 1. artist name - song name
// 2. artist name - song name
// ….
// Delete a song given an artist name and song name. You should create a new song given the artist's name and song name.  Then pass it into your remove(Object) method.
// Delete a song by number on the playlist.
// Delete songs by artist.  This will delete all occurrences.
// Delete songs by name. This will delete all occurrences.
// Sort by artist name.
// Sort by song name.
// Search by artist.  Display songs with only that artist. The order does not matter. The song list will be numbered and displayed in the following format starting at 1.
// 1. artist name - song name
// 2. artist name - song name
// Clear the list.
// Quit

import java.util.Scanner;

public class Runner {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    DLList<Song> songs = new DLList<Song>();

    songs.add(new Song("Queen", "Bohemian Rhapsody"));
    songs.add(new Song("Queen", "Don't Stop Me Now"));
    songs.add(new Song("The Beatles", "Hey Jude"));
    songs.add(new Song("Fleetwood Mac", "Dreams"));
    songs.add(new Song("Daft Punk", "Get Lucky"));

    boolean running = true;

    while (running) {
      System.out.println("\nSong List Manager");
      System.out.println("1. Add a new song");
      System.out.println("2. Display song list");
      System.out.println("3. Delete a song by artist and name");
      System.out.println("4. Delete a song by number");
      System.out.println("5. Delete songs by artist");
      System.out.println("6. Delete songs by name");
      System.out.println("7. Sort by artist name");
      System.out.println("8. Sort by song name");
      System.out.println("9. Search by artist");
      System.out.println("10. Clear the list");
      System.out.println("11. Quit");
      System.out.print("Enter your choice: ");

      String choice = scan.nextLine().trim();

      switch (choice) {
        case "1":
          System.out.print("Enter artist name: ");
          String addArtist = scan.nextLine();
          System.out.print("Enter song name: ");
          String addName = scan.nextLine();
          songs.add(new Song(addArtist, addName));
          System.out.println("Song added.");
          break;

        case "2":
          displaySongs(songs);
          break;

        case "3":
          System.out.print("Enter artist name: ");
          String delArtist = scan.nextLine();
          System.out.print("Enter song name: ");
          String delName = scan.nextLine();
          boolean removed = songs.remove(new Song(delArtist, delName));
          if (removed) {
            System.out.println("Song removed.");
          } else {
            System.out.println("Song not found.");
          }
          break;

        case "4":
          displaySongs(songs);
          System.out.print("Enter the number of the song to delete: ");
          int num = Integer.parseInt(scan.nextLine());
          if (num >= 1 && num <= songs.size()) {
            songs.remove(num - 1);
            System.out.println("Song removed.");
          } else {
            System.out.println("Invalid number.");
          }
          break;

        case "5":
          System.out.print("Enter artist name: ");
          String artistToDelete = scan.nextLine();
          int removedCount = 0;
          for (int i = songs.size() - 1; i >= 0; i--) {
            if (songs.get(i).getArtist().equals(artistToDelete)) {
              songs.remove(i);
              removedCount++;
            }
          }
          System.out.println(removedCount + " song(s) removed.");
          break;

        case "6":
          System.out.print("Enter song name: ");
          String nameToDelete = scan.nextLine();
          int removedCount2 = 0;
          for (int i = songs.size() - 1; i >= 0; i--) {
            if (songs.get(i).getName().equals(nameToDelete)) {
              songs.remove(i);
              removedCount2++;
            }
          }
          System.out.println(removedCount2 + " song(s) removed.");
          break;

        case "7":
          songs.sort((a, b) -> a.getArtist().compareTo(b.getArtist()));
          System.out.println("Sorted by artist name.");
          break;

        case "8":
          songs.sort((a, b) -> a.getName().compareTo(b.getName()));
          System.out.println("Sorted by song name.");
          break;

        case "9":
          System.out.print("Enter artist name: ");
          String searchArtist = scan.nextLine();
          int count = 1;
          for (int i = 0; i < songs.size(); i++) {
            Song s = songs.get(i);
            if (s.getArtist().equals(searchArtist)) {
              System.out.print(count + ". " + s);
              count++;
            }
          }
          if (count == 1) {
            System.out.println("No songs found for that artist.");
          }
          break;

        case "10":
          songs.clear();
          System.out.println("List cleared.");
          break;

        case "11":
          running = false;
          System.out.println("Goodbye!");
          break;

        default:
          System.out.println("Invalid choice. Try again.");
      }
    }

    scan.close();
  }

  private static void displaySongs(DLList<Song> songs) {
    if (songs.size() == 0) {
      System.out.println("The song list is empty.");
      return;
    }
    for (int i = 0; i < songs.size(); i++) {
      System.out.print((i + 1) + ". " + songs.get(i));
    }
  }

}
