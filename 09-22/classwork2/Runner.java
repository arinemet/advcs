// Runner Class
// Song List Manager using DLList

import java.util.Scanner;

public class Runner {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    DLList<Song> songs = new DLList<Song>();

    songs.add(new Song("Miley Cyrus", "Party In The U.S.A."));
    songs.add(new Song("Miley Cyrus", "Wrecking Ball"));
    songs.add(new Song("Vanessa Carlton", "A Thousand Miles"));
    songs.add(new Song("Carly Rae Jepsen", "Call Me Maybe"));
    songs.add(new Song("Kesha", "TiK ToK"));

    boolean running = true;

    while (running) {
      System.out.println();
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

      String choice = scan.nextLine();

      if (choice.equals("1")) {
        System.out.print("Enter artist name: ");
        String artist = scan.nextLine();
        System.out.print("Enter song name: ");
        String name = scan.nextLine();
        songs.add(new Song(artist, name));
        System.out.println("Song added.");
      } else if (choice.equals("2")) {
        displaySongs(songs);
      } else if (choice.equals("3")) {
        System.out.print("Enter artist name: ");
        String artist = scan.nextLine();
        System.out.print("Enter song name: ");
        String name = scan.nextLine();
        Song target = new Song(artist, name);
        if (songs.remove(target)) {
          System.out.println("Song removed.");
        } else {
          System.out.println("Song not found.");
        }
      } else if (choice.equals("4")) {
        displaySongs(songs);
        System.out.print("Enter the number of the song to delete: ");
        int num = Integer.parseInt(scan.nextLine());
        if (num >= 1 && num <= songs.size()) {
          songs.remove(num - 1);
          System.out.println("Song removed.");
        } else {
          System.out.println("Invalid number.");
        }
      } else if (choice.equals("5")) {
        System.out.print("Enter artist name: ");
        String artist = scan.nextLine();
        int count = 0;
        for (int i = songs.size() - 1; i >= 0; i--) {
          if (songs.get(i).getArtist().equals(artist)) {
            songs.remove(i);
            count++;
          }
        }
        System.out.println(count + " songs removed.");
      } else if (choice.equals("6")) {
        System.out.print("Enter song name: ");
        String name = scan.nextLine();
        int count = 0;
        for (int i = songs.size() - 1; i >= 0; i--) {
          if (songs.get(i).getName().equals(name)) {
            songs.remove(i);
            count++;
          }
        }
        System.out.println(count + " songs removed.");
      } else if (choice.equals("7")) {
        sortByArtist(songs);
        System.out.println("Sorted by artist.");
      } else if (choice.equals("8")) {
        sortByName(songs);
        System.out.println("Sorted by song name.");
      } else if (choice.equals("9")) {
        System.out.print("Enter artist name: ");
        String artist = scan.nextLine();
        int count = 1;
        for (int i = 0; i < songs.size(); i++) {
          Song s = songs.get(i);
          if (s.getArtist().equals(artist)) {
            System.out.print(count + ". " + s);
            count++;
          }
        }
        if (count == 1) {
          System.out.println("No songs found.");
        }
      } else if (choice.equals("10")) {
        songs.clear();
        System.out.println("List cleared.");
      } else if (choice.equals("11")) {
        running = false;
      } else {
        System.out.println("bad choice");
      }
    }

    scan.close();
  }

  // prints the numbered song list
  public static void displaySongs(DLList<Song> songs) {
    if (songs.size() == 0) {
      System.out.println("The song list is empty.");
    }
    for (int i = 0; i < songs.size(); i++) {
      System.out.print((i + 1) + ". " + songs.get(i));
    }
  }

  // bubble sort by artist
  public static void sortByArtist(DLList<Song> songs) {
    for (int i = 0; i < songs.size() - 1; i++) {
      for (int j = 0; j < songs.size() - 1 - i; j++) {
        Song a = songs.get(j);
        Song b = songs.get(j + 1);
        if (a.getArtist().compareTo(b.getArtist()) > 0) {
          songs.set(j, b);
          songs.set(j + 1, a);
        }
      }
    }
  }

  // bubble sort by song name
  public static void sortByName(DLList<Song> songs) {
    for (int i = 0; i < songs.size() - 1; i++) {
      for (int j = 0; j < songs.size() - 1 - i; j++) {
        Song a = songs.get(j);
        Song b = songs.get(j + 1);
        if (a.getName().compareTo(b.getName()) > 0) {
          songs.set(j, b);
          songs.set(j + 1, a);
        }
      }
    }
  }

}
