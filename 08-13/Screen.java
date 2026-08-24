import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Screen extends JPanel implements ActionListener {

  private JTextField display;
  private double firstNumber;
  private String operation;

  public Screen() {
    setLayout(null);

    display = new JTextField();
    display.setFont(new Font("Arial", Font.PLAIN, 20));
    display.setBounds(204, 103, 200, 30);
    add(display);

    makeButton("/", 203, 138);
    makeButton("X", 203, 176);
    makeButton("-", 204, 213);
    makeButton("+", 204, 251);
    makeButton("=", 205, 290);
    makeButton("AC", 420, 210);
  }

  public void makeButton(String text, int x, int y) {
    JButton button = new JButton(text);
    button.setFont(new Font("Arial", Font.BOLD, 20));
    button.setBounds(x, y, 200, 30);
    button.addActionListener(this);
    add(button);
  }

  public void actionPerformed(ActionEvent e) {
    String button = e.getActionCommand();

    if (button.equals("AC")) {
      display.setText("");
      operation = null;
    } else if (button.equals("=")) {
      double secondNumber = Double.parseDouble(display.getText());
      double answer = 0;

      if (operation.equals("+")) {
        answer = firstNumber + secondNumber;
      } else if (operation.equals("-")) {
        answer = firstNumber - secondNumber;
      } else if (operation.equals("X")) {
        answer = firstNumber * secondNumber;
      } else if (operation.equals("/")) {
        answer = firstNumber / secondNumber;
      }

      display.setText("" + answer);
    } else {
      firstNumber = Double.parseDouble(display.getText());
      operation = button;
      display.setText("");
    }
  }

  public Dimension getPreferredSize() {
    return new Dimension(800, 400);
  }
}
