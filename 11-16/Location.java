import lombok.*;

public class Location {

  @Getter
  @Setter
  private int row;

  @Getter
  @Setter
  private int col;

  public Location(int row, int col) {
    this.row = row;
    this.col = col;
  }

  @Override
  public int hashCode() {
    return row * 26 + col;
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof Location)) return false;
    Location other = (Location) o;
    return row == other.row && col == other.col;
  }
}
