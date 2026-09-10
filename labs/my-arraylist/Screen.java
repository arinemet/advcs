import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Screen extends JFrame implements ActionListener {

    MyArrayList<Song> list;
    JTextArea box;
    JButton btn1, btn2, btn3, btn4;
    JButton btnArtist;
    JButton btnAlbum;
    JButton shuffleBtn;

    public Screen() {

        // starter songs
        list = new MyArrayList<Song>();
        list.add(new Song("Party In The U.S.A.", "Miley Cyrus", "The Time of Our Lives"));
        list.add(new Song("A Thousand Miles", "Vanessa Carlton", "Be Not Nobody"));
        list.add(new Song("Call Me Maybe", "Carly Rae Jepsen", "Kiss"));
        list.add(new Song("TiK ToK", "Kesha", "Animal"));
        list.add(new Song("Unwritten", "Natasha Bedingfield", "Unwritten"));

        // window setup
        setTitle("Playlist Manager");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // text box that shows the list
        box = new JTextArea();
        box.setEditable(false);
        box.setBounds(10, 10, 400, 460);
        add(box);

        // buttons
        btn1 = new JButton("Add Song");
        btn1.setBounds(420, 10, 160, 30);
        btn1.addActionListener(this);
        add(btn1);

        btn2 = new JButton("Delete by Location");
        btn2.setBounds(420, 50, 160, 30);
        btn2.addActionListener(this);
        add(btn2);

        btn3 = new JButton("Delete by Info");
        btn3.setBounds(420, 90, 160, 30);
        btn3.addActionListener(this);
        add(btn3);

        btn4 = new JButton("Sort by Name");
        btn4.setBounds(420, 130, 160, 30);
        btn4.addActionListener(this);
        add(btn4);

        btnArtist = new JButton("Sort by Artist");
        btnArtist.setBounds(420, 170, 160, 30);
        btnArtist.addActionListener(this);
        add(btnArtist);

        btnAlbum = new JButton("Sort by Album");
        btnAlbum.setBounds(420, 210, 160, 30);
        btnAlbum.addActionListener(this);
        add(btnAlbum);

        shuffleBtn = new JButton("Randomize");
        shuffleBtn.setBounds(420, 250, 160, 30);
        shuffleBtn.addActionListener(this);
        add(shuffleBtn);

        update();
    }

    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        // add song
        if (src == btn1) {
            String n = JOptionPane.showInputDialog(this, "Song name:");
            if (n == null)
                return;
            String a = JOptionPane.showInputDialog(this, "Artist:");
            if (a == null)
                return;
            String al = JOptionPane.showInputDialog(this, "Album:");
            if (al == null)
                return;
            String loc = JOptionPane.showInputDialog(this, "Location (blank for end):");
            if (loc == null)
                return;

            Song s = new Song(n, a, al);
            if (loc.equals(""))
                list.add(s);
            else {
                int i = Integer.parseInt(loc);
                list.add(i - 1, s);
            }
            update();
        }

        // delete by location number
        else if (src == btn2) {
            String loc = JOptionPane.showInputDialog(this, "Location number to delete:");
            if (loc == null)
                return;
            int i = Integer.parseInt(loc);
            Song gone = list.remove(i - 1);
            JOptionPane.showMessageDialog(this, "Removed " + gone);
            update();
        }

        // delete by matching song info
        else if (src == btn3) {
            String n = JOptionPane.showInputDialog(this, "Song name:");
            if (n == null)
                return;
            String a = JOptionPane.showInputDialog(this, "Artist:");
            if (a == null)
                return;
            String al = JOptionPane.showInputDialog(this, "Album:");
            if (al == null)
                return;

            boolean worked = list.remove(new Song(n, a, al));
            if (worked)
                JOptionPane.showMessageDialog(this, "song removd");
            else
                JOptionPane.showMessageDialog(this, "couldnt find song");
            update();
        }

        // sort by name, bubble sort
        else if (src == btn4) {
            for (int i = 0; i < list.size(); i++) {
                for (int j = 0; j < list.size() - 1; j++) {
                    Song s1 = list.get(j);
                    Song s2 = list.get(j + 1);
                    if (s1.getName().compareToIgnoreCase(s2.getName()) > 0) {
                        list.set(j, s2);
                        list.set(j + 1, s1);
                    }
                }
            }
            update();
        }

        // sort by artist
        else if (src == btnArtist) {
            for (int i = 0; i < list.size(); i++) {
                for (int j = 0; j < list.size() - 1; j++) {
                    if (list.get(j).getArtist().compareToIgnoreCase(list.get(j + 1).getArtist()) > 0) {
                        Song temp = list.get(j);
                        list.set(j, list.get(j + 1));
                        list.set(j + 1, temp);
                    }
                }
            }
            update();
        }

        // sort by album, bubble sort
        else if (src == btnAlbum) {
            for (int i = 0; i < list.size(); i++) {
                for (int j = 0; j < list.size() - 1; j++) {
                    if (list.get(j).getAlbum().compareToIgnoreCase(list.get(j + 1).getAlbum()) > 0) {
                        Song temp = list.get(j);
                        list.set(j, list.get(j + 1));
                        list.set(j + 1, temp);
                    }
                }
            }
            update();
        }

        // shuffle the list randomly
        else if (src == shuffleBtn) {
            int n = list.size();
            for (int i = 0; i < n; i++) {
                int r = (int) (Math.random() * n);
                Song temp = list.get(i);
                list.set(i, list.get(r));
                list.set(r, temp);
            }
            update();
        }
    }

    // rebuilds the numbered list text so it looks good on screen
    void update() {
        String txt = "";
        int count = 1;
        for (int i = 0; i < list.size(); i++) {
            txt += count + ". " + list.get(i) + "\n";
            count++;
        }
        box.setText(txt);
    }
}
