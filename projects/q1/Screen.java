import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Screen extends JFrame implements ActionListener {

    DLList<Item> items;
    Item hover;
    JPanel scene;
    Image[] sprites;
    String[] names = { "boat", "seagull", "cloud", "car", "buoy" };
    JButton[] addBtns;
    JButton[] removeBtns;
    JButton randomBtn, clearBtn;

    public Screen() {
        items = new DLList<Item>();
        hover = null;

        // load sprites, a missing file stays null and draws a grey box
        sprites = new Image[names.length];
        for (int i = 0; i < names.length; i++) {
            java.io.File f = new java.io.File("images/" + names[i] + ".png");
            if (f.exists()) {
                sprites[i] = new ImageIcon(f.getPath()).getImage();
            }
        }

        // window setup
        setTitle("Golden Gate Bridge");
        setSize(Item.WIDTH, Item.HEIGHT + 160);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // the scenery
        scene = new JPanel() {
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawScene(g);
            }
        };
        scene.setBounds(0, 0, Item.WIDTH, Item.HEIGHT);
        scene.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                deleteAt(e.getX(), e.getY());
            }
        });
        scene.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseMoved(MouseEvent e) {
                Item over = itemAt(e.getX(), e.getY());
                if (over != hover) {
                    hover = over;
                    if (over == null) {
                        scene.setCursor(Cursor.getDefaultCursor());
                    } else {
                        scene.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    }
                }
            }
        });
        add(scene);

        // add button for each item
        addBtns = new JButton[names.length];
        removeBtns = new JButton[names.length];
        for (int i = 0; i < names.length; i++) {
            addBtns[i] = new JButton("Add " + names[i]);
            addBtns[i].setBounds(10 + i * 155, Item.HEIGHT + 10, 150, 30);
            addBtns[i].addActionListener(this);
            add(addBtns[i]);

            removeBtns[i] = new JButton("Remove " + names[i]);
            removeBtns[i].setBounds(10 + i * 155, Item.HEIGHT + 45, 150, 30);
            removeBtns[i].addActionListener(this);
            add(removeBtns[i]);
        }

        randomBtn = new JButton("Randomize");
        randomBtn.setBounds(10, Item.HEIGHT + 85, 160, 30);
        randomBtn.addActionListener(this);
        add(randomBtn);

        clearBtn = new JButton("Clear");
        clearBtn.setBounds(180, Item.HEIGHT + 85, 160, 30);
        clearBtn.addActionListener(this);
        add(clearBtn);
    }

    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        if (src == randomBtn) {
            for (int i = 0; i < items.size(); i++) {
                items.get(i).randomize();
            }
        } else if (src == clearBtn) {
            items.clear();
            hover = null;
        } else {
            for (int i = 0; i < names.length; i++) {
                if (src == addBtns[i]) {
                    items.add(new Item(i));
                } else if (src == removeBtns[i]) {
                    removeRandom(i);
                }
            }
        }
        scene.repaint();
    }

    // removes a random item of the given type
    void removeRandom(int type) {
        int count = 0;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getType() == type) {
                count++;
            }
        }
        if (count == 0) {
            return;
        }
        int pick = (int) (Math.random() * count);
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getType() == type) {
                if (pick == 0) {
                    items.remove(i);
                    break;
                }
                pick--;
            }
        }
        hover = null;
    }

    // topmost (last drawn) item under the mouse
    public Item itemAt(int mx, int my) {
        for (int i = items.size() - 1; i >= 0; i--) {
            if (items.get(i).contains(mx, my)) {
                return items.get(i);
            }
        }
        return null;
    }

    public void deleteAt(int mx, int my) {
        for (int i = items.size() - 1; i >= 0; i--) {
            if (items.get(i).contains(mx, my)) {
                items.remove(i);
                break;
            }
        }
        hover = null;
        scene.repaint();
    }

    // draws the background, every item, and the hint text
    public void drawScene(Graphics g) {
        drawBackground(g, Item.WIDTH, Item.HEIGHT);

        // clouds first so they are always behind everything else
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
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 16));
        g.drawString("Click any item to delete it", 300, 22);
    }

    // draws the sprite, or a grey box if the image file isn't there yet
    public void drawItem(Graphics g, Item item) {
        Image img = sprites[item.getType()];
        if (item.getType() == item.CLOUD) {
            int x = item.getX();
            int y = item.getY();
            g.setColor(item.getColor());
            g.fillOval(x + 0, y + 10, 70, 40);
            g.fillOval(x + 30, y + 0, 70, 45);
            g.fillOval(x + 60, y + 10, 70, 40);
            g.fillOval(x + 20, y + 20, 70, 40);
            g.fillOval(x + 45, y + 25, 70, 40);
        } else if (img != null) {
            g.drawImage(img, item.getX(), item.getY(), item.getWidth(), item.getHeight(), null);
        } else {
            g.setColor(Color.GRAY);
            g.fillRect(item.getX(), item.getY(), item.getWidth(), item.getHeight());
            g.setColor(Color.BLACK);
            g.drawRect(item.getX(), item.getY(), item.getWidth(), item.getHeight());
            g.drawString(names[item.getType()], item.getX() + 3, item.getY() + 14);
        }
    }

    public void drawBackground(Graphics g, int w, int h) {
        Graphics2D g2 = (Graphics2D) g;

        // sky and sun
        g2.setColor(new Color(159, 188, 255));
        g2.fillRect(0, 0, w, h);
        g2.setColor(new Color(255, 240, 0));
        g2.fillOval(25, 25, 100, 100);

        // road
        g2.setColor(new Color(192, 54, 44));
        g2.fillRect(0, 350, w, 10);

        // pillars
        g2.fillRect(150, 100, 25, 400);
        g2.fillRect(550, 100, 25, 400);

        // three suspension cables, the middle one between the pillars
        for (int arcX = 163 - 400; arcX <= 563; arcX += 400) {
            int arcY = 65;
            int arcW = 400;
            int arcH = 200;
            g2.setStroke(new BasicStroke(15));
            g2.drawArc(arcX, arcY, arcW, arcH, 180, 180);

            // vertical cables, heights from the ellipse equation
            g2.setStroke(new BasicStroke(1));
            double centerX = arcX + arcW / 2.0;
            double centerY = arcY + arcH / 2.0;
            double a = arcW / 2.0;
            double b = arcH / 2.0;
            for (int i = arcX; i <= arcX + arcW; i += 10) {
                double dx = i - centerX;
                double dy = b * Math.sqrt(1.0 - (dx * dx) / (a * a)) * -1;
                int pillarTopY = (int) Math.round(centerY - dy);
                int pillarHeight = 350 - pillarTopY;
                if (pillarHeight < 0) {
                    pillarHeight = 0;
                }
                g2.fillRect(i, pillarTopY, 2, pillarHeight);
            }
        }

        // mountain
        int[] mx = { -50, 0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140, -500 };
        int[] my = { 200, 210, 240, 250, 250, 270, 280, 290, 310, 350, 360, 400, 420, 450, 470, 500, 200 };
        g2.setColor(new Color(45, 75, 45));
        g2.fillPolygon(mx, my, mx.length);

        // ocean
        g2.setColor(new Color(0, 123, 147));
        g2.fillRect(0, 400, w, 200);
    }
}
