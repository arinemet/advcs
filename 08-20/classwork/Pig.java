import java.awt.Color;
import java.awt.Graphics;

public class Pig extends Costume
{
    public Pig(int x, int y)
    {
        super(x, y);
    }

    public void drawNose(Graphics g)
    {
        g.setColor(Color.PINK);
        g.fillOval(getX() + 60, getY() + 76, 30, 23);

        g.setColor(Color.BLACK);
        g.fillOval(getX() + 67, getY() + 83, 5, 8);
        g.fillOval(getX() + 78, getY() + 83, 5, 8);
    }

    public void drawEars(Graphics g)
    {
        g.setColor(Color.PINK);
        g.fillOval(getX() + 25, getY() + 12, 30, 35);
        g.fillOval(getX() + 95, getY() + 12, 30, 35);
    }
}
