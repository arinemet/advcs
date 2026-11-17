import lombok.Getter;

public class Grid {

  @Getter
  private MyHashTable<Location, GridObject> grid;

  public Grid() {
    this.grid = new MyHashTable<>();
  }
}
