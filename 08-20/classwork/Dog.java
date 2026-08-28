import java.awt.Color;
import java.awt.Graphics;

public class Dog extends Costume
{
    public Dog(int x, int y)
    {
        super(x, y);
    }

    public void drawNose(Graphics g)
    {
        g.setColor(Color.BLACK);
        g.fillOval(getX() + 65, getY() + 78, 20, 18);
    }

    public void drawEars(Graphics g)
    {
        g.setColor(new Color(120, 75, 35));
        g.fillOval(getX() + 5, getY() + 30, 35, 80);
        g.fillOval(getX() + 110, getY() + 30, 35, 80);
    }
}
