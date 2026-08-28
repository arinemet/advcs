import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

public class Screen extends JPanel {
    private ArrayList<Costume> costumes;

    public Screen() {
        costumes = new ArrayList<Costume>();
        costumes.add(new Cat(25, 25));
        costumes.add(new Dog(200, 25));
        costumes.add(new Bird(375, 25));
        costumes.add(new Pig(550, 25));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Costume costume : costumes) {
            costume.drawMe(g);
        }
    }
}
