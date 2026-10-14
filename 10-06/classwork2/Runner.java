public class Runner {
  public static void main(String[] args) {
    String[] test = new String[7];
    test[0] = "(abc(*def)";
    test[1] = "[{}]";
    test[2] = "[{]}";
    test[3] = "[{<()>}]";
    test[4] = "{<html[value=4]*(12)>{$x}}";
    test[5] = "[one]<two>{three}(four)";
    test[6] = "car(cdr(a)(b)))";

    for (String s : test) {
      System.out.println(isBalanced(s));
    }
  }

  private static boolean isBalanced(String s) {
    String open = "{(<[";
    String close = "})>]";
    MyStack<Character> stack = new MyStack<Character>();

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (open.indexOf(c) >= 0) {
        stack.push(c);
      } else if (close.indexOf(c) >= 0) {
        if (stack.empty() || open.indexOf(stack.peek()) != close.indexOf(c)) {
          return false;
        }
        stack.pop();
      }
    }
    return stack.empty();
  }
}
