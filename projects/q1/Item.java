import java.awt.Color;

public class Item {
    public static final int BOAT = 0;
    public static final int SEAGULL = 1;
    public static final int CLOUD = 2;
    public static final int CAR = 3;
    public static final int BUOY = 4;

    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;

    private int type;
    private int x;
    private int y;
    private Color color;

    public Item(int type) {
        this.type = type;
        randomize();
    }

    public int getType() {

        return type;

    }

    // picks a new random spot (and color) that fits the item's type
    public void randomize() {
        x = (int) (Math.random() * (WIDTH - 140)) + 20;
        if (type == BOAT) {
            y = (int) (Math.random() * 90) + 440;
            color = new Color((int) (Math.random() * 200), (int) (Math.random() * 200), (int) (Math.random() * 200));
        } else if (type == SEAGULL) {
            y = (int) (Math.random() * 150) + 40;
            color = Color.LIGHT_GRAY;
        } else if (type == CLOUD) {
            y = (int) (Math.random() * 120) + 30;
            color = new Color(224, 224, 224);
        } else if (type == CAR) {
            // on the bridge
            y = 350 - getHeight();
            color = new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));
        } else {
            y = (int) (Math.random() * 90) + 440;
            color = Color.RED;
        }
    }

    public int getX() {

        return x;

    }

    public int getY() {
        return y;
    }

    public Color getColor() {
        return color;
    }

    public int getWidth() {
        if (type == BOAT) {
            return 75;
        }
        if (type == SEAGULL) {
            return 60;
        }
        if (type == CLOUD) {
            return 130;
        }
        if (type == CAR) {
            return 90;
        }
        return 28;
    }

    public int getHeight() {
        if (type == BOAT) {
            return 100;
        }
        if (type == SEAGULL) {
            return 34;
        }
        if (type == CLOUD) {
            return 65;
        }
        if (type == CAR) {
            return 35;
        }
        return 80;
    }

    public boolean contains(int mx, int my) {
        return mx >= x && mx <= x + getWidth() && my >= y && my <= y + getHeight();
    }
}
