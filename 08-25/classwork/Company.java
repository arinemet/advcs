public class Company {
  private String name;
  private double stockPrice;

  public Company(String name, double stockPrice) {
    this.name = name;
    this.stockPrice = stockPrice;
  }

  public String toString() {
    return "Company name: " + name + " Stock Price: " + stockPrice;
  }

  public void updateStockPrice(double newPrice) {
    stockPrice = newPrice;
  }

  public String getName() {
    return name;
  }

}