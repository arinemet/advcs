public class Runner {
  public static void main(String[] args) {
    String[] lists = {
      "one two three two one",
      "1 2 3 4 5 one two three four five",
      "1 2 3 a b c c b a 3 2 1"
    };

    for (String list : lists) {
      String[] words = list.split(" ");
      MyStack<String> stack = new MyStack<String>();
      MyQueue<String> queue = new MyQueue<String>();

      for (String w : words) {
        stack.push(w);
        queue.add(w);
      }

      boolean palin = true;
      while (!stack.empty()) {
        if (!stack.pop().equals(queue.poll())) {
          palin = false;
        }
      }
      System.out.println(palin);
    }
  }
}
