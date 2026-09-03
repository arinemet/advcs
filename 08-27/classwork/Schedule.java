import java.util.ArrayList;

public class Schedule {
    private ArrayList<Pair<Integer, String>> mySchedule;

    public Schedule(ArrayList<Pair<Integer, String>> mySchedule) {
        this.mySchedule = mySchedule;
    }

    @Override
    public String toString() {
        String result = "";

        for (Pair<Integer, String> p : mySchedule) {
            result += p + "\n";
        }

        return result;
    }

}
