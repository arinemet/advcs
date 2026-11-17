import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Screen extends JPanel implements ActionListener {

  private final int kWidth = 10;
  private final int kHeight = 10;
  private Grid grid;

  public Screen() {}

  public Dimension getPreferredSize() {
    return new Dimension(800, 800);
  }

  private void drawGrid(Graphics g) {
    g.setColor(Color.BLACK);
    int w = 600;
    int h = 600;
    int x = (getWidth() - w) / 2;
    int y = (getHeight() - h) / 2;
    g.drawRect(x, y, w, h);
    for (int i = x; i <= getWidth() - x; i += (getWidth() - 2 * x) / kWidth) {
      g.drawLine(i, y, i, getHeight() - y);
    }
    for (
      int i = y;
      i <= getHeight() - y;
      i += (getHeight() - 2 * y) / kHeight
    ) {
      g.drawLine(x, i, getWidth() - x, i);
    }
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    drawGrid(g);
  }

  @Override
  public void actionPerformed(ActionEvent e) {}
}
