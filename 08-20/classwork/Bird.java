import java.awt.Color;
import java.awt.Graphics;

public class Bird extends Costume {
    public Bird(int x, int y) {
        super(x, y);
    }

    public void drawNose(Graphics g) {
        g.setColor(Color.ORANGE);
        int[] beakX = { getX() + 65, getX() + 85, getX() + 75 };
        int[] beakY = { getY() + 80, getY() + 80, getY() + 102 };
        g.fillPolygon(beakX, beakY, 3);
    }

    public void drawEars(Graphics g) {
        // no ears for the bird
    }
}
