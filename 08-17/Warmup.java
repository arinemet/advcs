public class Warmup {
  public static void main(String[] args) {
    int[] nums = new int[10];
    for (int i = 0; i < 10; i++) {
      int num = (int) (Math.random() * 99) + 1;
      nums[i] = num;
    }

    for (int element : nums) {
      System.out.print(element + " ");
    }

  }
}
