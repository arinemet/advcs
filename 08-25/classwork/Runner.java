import java.util.ArrayList;
import java.util.Scanner;

public class Runner {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    ArrayList<Company> companies = new ArrayList<Company>();
    Company microsoft = new Company("Microsoft", 110.47);
    Company google = new Company("Google", 1172.10);
    Company apple = new Company("Apple", 219.89);

    companies.add(microsoft);
    companies.add(google);
    companies.add(apple);

    ArrayList<Pair<Employee, Company>> myList = new ArrayList<Pair<Employee, Company>>();

    myList.add(new Pair<Employee, Company>(new Employee("Rishi"), microsoft));
    myList.add(new Pair<Employee, Company>(new Employee("Jose"), google));
    myList.add(new Pair<Employee, Company>(new Employee("Jennifer"), google));
    myList.add(new Pair<Employee, Company>(new Employee("Heather"), apple));
    myList.add(new Pair<Employee, Company>(new Employee("Maria"), apple));

    while (true) {
      System.out.println("\n1. Display employees and companies");
      System.out.println("2. Change a company's stock price");
      System.out.println("3. Add a new company");
      System.out.println("4. Change an employee's company");
      System.out.println("5. Quit");
      System.out.print("Choose an option: ");
      int choice = input.nextInt();
      input.nextLine();

      if (choice == 1) {
        for (Pair<Employee, Company> pair : myList) {
          System.out.println(pair);
        }
      } else if (choice == 2) {
        System.out.print("Enter the company name: ");
        String companyName = input.nextLine();
        System.out.print("Enter the new stock price: ");
        double newPrice = input.nextDouble();
        input.nextLine();

        for (Company company : companies) {
          if (company.getName().equals(companyName)) {
            company.updateStockPrice(newPrice);
          }
        }
      } else if (choice == 3) {
        System.out.print("Enter the new company name: ");
        String companyName = input.nextLine();
        System.out.print("Enter its stock price: ");
        double stockPrice = input.nextDouble();
        input.nextLine();
        companies.add(new Company(companyName, stockPrice));
      } else if (choice == 4) {
        System.out.print("Enter the employee name: ");
        String employeeName = input.nextLine();
        System.out.print("Enter the new company name: ");
        String companyName = input.nextLine();

        Company newCompany = null;
        for (Company company : companies) {
          if (company.getName().equals(companyName)) {
            newCompany = company;
          }
        }

        for (Pair<Employee, Company> pair : myList) {
          if (pair.getFirst().getName().equals(employeeName)) {
            pair.setSecond(newCompany);
          }
        }
      } else if (choice == 5) {
        break;
      }
    }

    input.close();
  }
}
