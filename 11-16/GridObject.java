import lombok.*;

public class GridObject {

  @Getter
  private MyArrayList<String> types;

  public GridObject(MyArrayList<String> types) {
    this.types = types;
  }
}
