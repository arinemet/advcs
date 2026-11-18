import lombok.*;

public class GridObject {

  @Getter
  private DLList<String> types;

  public GridObject(DLList<String> types) {
    this.types = types;
  }
}
