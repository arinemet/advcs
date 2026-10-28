import javax.swing.*;

public class Runner {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Golden Gate Bridge");
        Screen screen = new Screen();

        frame.add(screen);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);

        frame.pack();

        screen.animate();
    }
}
