import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

public class Screen extends JPanel implements ActionListener {

  private final int kWidth = 10;
  private final int kHeight = 10;
  private Grid grid;

  public Screen() {
    this.grid = new Grid();

    String[] backgrounds = { "water", "grass", "dirt", "sand" };
    for (int row = 0; row < kHeight; row++) {
      for (int col = 0; col < kWidth; col++) {
        DLList<String> types = new DLList<>();
        types.add(backgrounds[(row * kWidth + col) % backgrounds.length]);
        this.grid.getGrid().put(new Location(row, col), new GridObject(types));
      }
    }
  }

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

  public void drawBackground(Graphics g) {
    int x = (getWidth() - 600) / 2;
    int y = (getHeight() - 600) / 2;
    int cell = 600 / kWidth;
    for (int row = 0; row < kWidth; row++) {
      for (int col = 0; col < kHeight; col++) {
        Location key = new Location(row, col);
        GridObject obj = grid.getGrid().get(key);
        DLList<String> types = obj.getTypes();

        String background = types.get(0);
        switch (background) {
          case "water":
            g.setColor(Color.BLUE);
            break;
          case "grass":
            g.setColor(Color.GREEN);
            break;
          case "dirt":
            g.setColor(new Color(165, 42, 42));
            break;
          case "sand":
            g.setColor(Color.YELLOW);
            break;
          default:
            g.setColor(Color.WHITE);
            break;
        }

        g.fillRect(x + col * cell, y + row * cell, cell, cell);
      }
    }
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    drawBackground(g);
    drawGrid(g);
  }

  @Override
  public void actionPerformed(ActionEvent e) {}
}
