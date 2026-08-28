import javax.swing.JFrame;

public class Runner
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Animal Costumes");
        Screen screen = new Screen();

        frame.add(screen);
        frame.setSize(750, 280);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
