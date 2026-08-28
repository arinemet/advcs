import java.awt.Color;
import java.awt.Graphics;

public class Cat extends Costume
{
    public Cat(int x, int y)
    {
        super(x, y);
    }

    public void drawNose(Graphics g)
    {
        int x = getX();
        int y = getY();

        g.setColor(Color.PINK);
        int[] noseX = {x + 70, x + 80, x + 75};
        int[] noseY = {y + 82, y + 82, y + 90};
        g.fillPolygon(noseX, noseY, 3);

        g.setColor(Color.BLACK);
        g.drawLine(x + 75, y + 90, x + 75, y + 98);
        g.drawLine(x + 68, y + 88, x + 35, y + 82);
        g.drawLine(x + 68, y + 93, x + 35, y + 96);
        g.drawLine(x + 82, y + 88, x + 115, y + 82);
        g.drawLine(x + 82, y + 93, x + 115, y + 96);
    }

    public void drawEars(Graphics g)
    {
        int x = getX();
        int y = getY();

        g.setColor(Color.GRAY);
        int[] leftX = {x + 28, x + 42, x + 58};
        int[] leftY = {y + 45, y, y + 30};
        g.fillPolygon(leftX, leftY, 3);

        int[] rightX = {x + 92, x + 108, x + 122};
        int[] rightY = {y + 30, y, y + 45};
        g.fillPolygon(rightX, rightY, 3);
    }
}
