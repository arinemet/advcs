import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Screen {
    private ArrayList<Pair<Student, Schedule>> students;

    public Screen() {
        Pair<Integer, String> s1_c1 = new Pair<>(1, "History");
        Pair<Integer, String> s1_c2 = new Pair<>(2, "Math");
        Pair<Integer, String> s1_c3 = new Pair<>(3, "Science");

        Pair<Integer, String> s2_c1 = new Pair<>(1, "Math");
        Pair<Integer, String> s2_c2 = new Pair<>(2, "Science");
        Pair<Integer, String> s2_c3 = new Pair<>(3, "History");

        Pair<Integer, String> s3_c1 = new Pair<>(1, "Science");
        Pair<Integer, String> s3_c2 = new Pair<>(2, "History");
        Pair<Integer, String> s3_c3 = new Pair<>(3, "Math");

        ArrayList<Pair<Integer, String>> s1 = new ArrayList<>();
        s1.add(s1_c1);
        s1.add(s1_c2);
        s1.add(s1_c3);

        ArrayList<Pair<Integer, String>> s2 = new ArrayList<>();
        s2.add(s2_c1);
        s2.add(s2_c2);
        s2.add(s2_c3);

        ArrayList<Pair<Integer, String>> s3 = new ArrayList<>();
        s3.add(s3_c1);
        s3.add(s3_c2);
        s3.add(s3_c3);

        students = new ArrayList<>();

        students.add(new Pair<>(new Student("Rishi"), new Schedule(s1)));
        students.add(new Pair<>(new Student("Ari"), new Schedule(s2)));
        students.add(new Pair<>(new Student("Charlie"), new Schedule(s3)));
    }

    public void displayStudents() {
        String result = "Students:\n";

        for (Pair<Student, Schedule> student : students) {
            result += student.getKey() + "\n";
        }

        JOptionPane.showMessageDialog(null, result);
    }

    public void displaySchedule(String name) {
        for (Pair<Student, Schedule> student : students) {
            if (student.getKey().getName().equalsIgnoreCase(name)) {

                JOptionPane.showMessageDialog(null, student.getKey() + "'s Schedule:\n\n" + student.getValue());

                return;
            }
        }

        JOptionPane.showMessageDialog(null, "Student name not found.");
    }
}