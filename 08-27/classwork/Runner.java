import javax.swing.JOptionPane;

public class Runner {

    public static void main(String[] args) {

        Screen screen = new Screen();

        screen.displayStudents();

        String name = JOptionPane.showInputDialog(
                null,
                "Enter a student's name:");

        screen.displaySchedule(name);
    }
}
