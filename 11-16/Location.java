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
}
