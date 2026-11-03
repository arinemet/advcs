public class Info {
  private String name;
  private String capital;
  private int population;

  public Info(String name, String capital, int population) {
    this.name = name;
    this.capital = capital;
    this.population = population;
  }

  public String toString() {
    return name + " - Capital: " + capital + ", Population: " + population;
  }
}
