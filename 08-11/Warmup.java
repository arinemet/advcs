import java.util.Scanner;

public class Warmup {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    System.out.print("Enter partner's name: ");
    String name = s.nextLine();
    System.out.println("Hello " + name);
    s.close();
  }
}
