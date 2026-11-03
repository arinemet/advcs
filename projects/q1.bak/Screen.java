import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Screen extends JPanel implements ActionListener, MouseListener {

    private DLList<Item> items;
    private BufferedImage[] sprites;
    private String[] names = { "boat", "seagull", "cloud", "car", "buoy" };
    private JButton[] addBtns;
    private JButton[] removeBtns;
    private JButton randomBtn, clearBtn;

    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;

    public Screen() {
        items = new DLList<Item>();

        // load imagse
        sprites = new BufferedImage[names.length];
        for (int i = 0; i < names.length; i++) {
            try {
                sprites[i] = ImageIO.read(new File("images/" + names[i] + ".png"));
            } catch (IOException e) {
                // no image
            }
        }

        setLayout(null);
        addMouseListener(this);

        // make the buttons
        addBtns = new JButton[names.length];
        removeBtns = new JButton[names.length];
        for (int i = 0; i < names.length; i++) {
            addBtns[i] = new JButton("Add " + names[i]);
            addBtns[i].setBounds(10 + i * 155, HEIGHT + 10, 150, 30);
            addBtns[i].addActionListener(this);
            add(addBtns[i]);

            removeBtns[i] = new JButton("Remove " + names[i]);
            removeBtns[i].setBounds(10 + i * 155, HEIGHT + 45, 150, 30);
            removeBtns[i].addActionListener(this);
            add(removeBtns[i]);
        }

        randomBtn = new JButton("Randomize");
        randomBtn.setBounds(10, HEIGHT + 85, 160, 30);
        randomBtn.addActionListener(this);
        add(randomBtn);

        clearBtn = new JButton("Clear");
        clearBtn.setBounds(180, HEIGHT + 85, 160, 30);
        clearBtn.addActionListener(this);
        add(clearBtn);
    }

    public Dimension getPreferredSize() {
        // panel size
        return new Dimension(WIDTH, HEIGHT + 160);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBackground(g);

        // clouds go first
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getType() == Item.CLOUD) {
                drawItem(g, items.get(i));
            }
        }
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getType() != Item.CLOUD) {
                drawItem(g, items.get(i));
            }
        }

        // writting text
        Font font = new Font("Arial", Font.BOLD, 16);
        g.setFont(font);
        g.setColor(Color.WHITE);
        g.drawString("Click any item to delete it", 300, 22);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == randomBtn) {
            for (int i = 0; i < items.size(); i++) {
                items.get(i).randomize();
            }
        } else if (e.getSource() == clearBtn) {
            items.clear();
        }

        for (int i = 0; i < names.length; i++) {
            if (e.getSource() == addBtns[i]) {
                items.add(new Item(i));
            }
            if (e.getSource() == removeBtns[i]) {
                // remove the last one
                for (int j = items.size() - 1; j >= 0; j--) {
                    if (items.get(j).getType() == i) {
                        items.remove(j);
                        break;
                    }
                }
            }
        }

        repaint();
    }

    // mosue stuff
    public void mousePressed(MouseEvent e) {
        // delete the item
        for (int i = items.size() - 1; i >= 0; i--) {
            if (items.get(i).contains(e.getX(), e.getY())) {
                items.remove(i);
                break;
            }
        }

        repaint();
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void drawItem(Graphics g, Item item) {
        BufferedImage img = sprites[item.getType()];

        if (item.getType() == Item.CLOUD) {
            // cloud is ovals
            g.setColor(item.getColor());
            g.fillOval(item.getX(), item.getY() + 10, 70, 40);
            g.fillOval(item.getX() + 30, item.getY(), 70, 45);
            g.fillOval(item.getX() + 60, item.getY() + 10, 70, 40);
            g.fillOval(item.getX() + 20, item.getY() + 20, 70, 40);
            g.fillOval(item.getX() + 45, item.getY() + 25, 70, 40);
        } else if (img != null) {
            // draw the image
            g.drawImage(img, item.getX(), item.getY(), item.getWidth(), item.getHeight(), null);
        }
    }

    public void drawBackground(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        // sky
        g.setColor(new Color(159, 188, 255));
        g.fillRect(0, 0, WIDTH, HEIGHT);

        // sun
        g.setColor(new Color(255, 240, 0));
        g.fillOval(25, 25, 100, 100);

        // raod and pillars
        g.setColor(new Color(192, 54, 44));
        g.fillRect(0, 350, WIDTH, 10);
        g.fillRect(150, 100, 25, 400);
        g.fillRect(550, 100, 25, 400);

        // cables
        g2.setStroke(new BasicStroke(15));
        g2.drawArc(-237, 65, 400, 200, 180, 180);
        g2.drawArc(163, 65, 400, 200, 180, 180);
        g2.drawArc(563, 65, 400, 200, 180, 180);

        // mountian
        int[] mx = { -50, 0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140, -500 };
        int[] my = { 200, 210, 240, 250, 250, 270, 280, 290, 310, 350, 360, 400, 420, 450, 470, 500, 200 };
        g.setColor(new Color(45, 75, 45));
        g.fillPolygon(mx, my, mx.length);

        // ocean
        g.setColor(new Color(0, 123, 147));
        g.fillRect(0, 400, WIDTH, 200);
    }
}
