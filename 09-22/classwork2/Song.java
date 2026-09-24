// Song Class: This class will contain the artist's name and the name of the
// song.  It will have an equals(Object) method to compare with another object
// of its type.  It will return true if the artist name and song name match, and
// false otherwise.  There is a toString() method to return the name and artist
// with a new line at the end.  Add more instance variables and methods as
// needed.

public class Song {
  private String artist;
  private String name;

  public Song(String artist, String name) {
    this.artist = artist;
    this.name = name;
  }

  public String getArtist() {
    return artist;
  }

  public String getName() {
    return name;
  }

  public boolean equals(Object o) {
    if (!(o instanceof Song)) {
      return false;
    }
    Song other = (Song) o;
    return this.artist.equals(other.artist) && this.name.equals(other.name);
  }

  public String toString() {
    return artist + " - " + name + "\n";
  }

}
