import java.util.Scanner;

public class Runner {

  public static int partition(SLList<Integer> list, int low, int high) {
    int pivot = list.get(high);
    int i = low - 1;

    for (int j = low; j < high; j++) {
      if (list.get(j) <= pivot) {
        i++;

        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
      }
    }

    int temp = list.get(i + 1);
    list.set(i + 1, list.get(high));
    list.set(high, temp);

    return i + 1;
  }

  public static void quickSort(SLList<Integer> list, int low, int high) {
    if (low < high) {
      int pivotIndex = partition(list, low, high);

      quickSort(list, low, pivotIndex - 1);
      quickSort(list, pivotIndex + 1, high);
    }
  }

  public static void main(String[] args) {
    SLList<Integer> a = new SLList<>();
    Scanner s = new Scanner(System.in);

    for (int i = 0; i < 5000; i++) {
      a.add((int) (Math.random() * 9999) + 1);
    }

    while (true) {
      System.out.println("\n\n\n\n1: Display the list\n" + //
          "2: Scramble\n" + //
          "3: Sort \n" + //
          "4: Clear list\n" + //
          "5: Quit\n");

      int d = s.nextInt();

      switch (d) {
        case 1:
          System.out.println(a);
          break;
        case 2:
          for (int i = 0; i < a.size(); i++) {
            a.set(i, (int) (Math.random() * a.size()));
          }
          break;

        case 3:
          quickSort(a, 0, a.size() - 1);
          break;

        case 4:
          while (a.size() > 0) {
            a.remove((int) (Math.random() * a.size()));
          }
          break;

        case 5:
          return;
      }

    }
  }

}
