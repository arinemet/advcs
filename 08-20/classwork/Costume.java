import java.awt.Color;
import java.awt.Graphics;

public abstract class Costume {
    private int x;
    private int y;

    public Costume(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public abstract void drawNose(Graphics g);

    public abstract void drawEars(Graphics g);

    public void drawBody(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillRect(x + 25, y + 90, 100, 100);
    }

    public void drawHead(Graphics g) {
        // head
        g.setColor(Color.GRAY);
        g.fillOval(x + 25, y + 20, 100, 100);

        // eyes
        g.setColor(Color.WHITE);
        g.fillOval(x + 48, y + 48, 18, 25);
        g.fillOval(x + 84, y + 48, 18, 25);

        g.setColor(Color.BLACK);
        g.fillOval(x + 54, y + 57, 7, 10);
        g.fillOval(x + 90, y + 57, 7, 10);
    }

    public void drawMe(Graphics g) {
        drawBody(g);
        drawEars(g);
        drawHead(g);
        drawNose(g);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
