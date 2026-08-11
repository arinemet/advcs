import java.util.Scanner; //scanner

public class Runner {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    Animal a = null; // if no animal

    while (true) {
      System.out.println("Menu: ");
      System.out.println("1: Create animal");
      System.out.println("2: Print animal");
      System.out.println("3: Change name");
      System.out.println("4: Change age");
      System.out.println("5: Quit");
      int menu = s.nextInt();

      switch (menu) {
        case (1):
          // step 1
          s.nextLine();
          System.out.print("Name: ");
          String name = s.nextLine();
          System.out.print("Type: ");
          String type = s.nextLine();
          System.out.print("Age: ");
          int age = s.nextInt();

	          a = new Animal(type, name, age);
	          break;
	        case (2):
          // step 2
          if (a != null) {
	            System.out.println(a);
	          }
	          break;

	        case (3):
          // step 3
          if (a != null) {
            s.nextLine();
            System.out.print("Change the name to: ");
            name = s.nextLine();
	            a.setName(name);
	          }
	          break;

	        case (4):
          // step 4
          if (a != null) {
            System.out.print("Change the age to: ");
            age = s.nextInt();
	            a.setAge(age);
	          }
	          break;

	        case (5):
	          // step 5
	          s.close();
	          return;
      }
    }

    // s.close();
  }
}
