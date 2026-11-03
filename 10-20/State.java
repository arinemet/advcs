public class State {
  private String abbreviation;

  public State(String abbreviation) {
    this.abbreviation = abbreviation.toLowerCase();
  }

  public String getAbbreviation() {
    return abbreviation;
  }

  public int hashCode() {
    int first = (int) abbreviation.charAt(0) - 97;
    int second = (int) abbreviation.charAt(1) - 97;
    return first * 26 + second;
  }

  public boolean equals(Object other) {
    if (!(other instanceof State)) {
      return false;
    }
    State s = (State) other;
    return abbreviation.equals(s.abbreviation);
  }

  public String toString() {
    return abbreviation.toUpperCase();
  }
}
